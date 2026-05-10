import os
import pathlib
import shutil
from dotenv import load_dotenv

# ========== 1) Load environment variables ==========
load_dotenv()
os.environ["OPENAI_API_KEY"] = os.getenv("OPEN_AI_KEY")

# ========== 2) Imports ==========
from langchain_openai import OpenAIEmbeddings
from langchain_community.document_loaders import PyPDFLoader
from langchain_text_splitters import RecursiveCharacterTextSplitter
from langchain_community.vectorstores import Chroma
from langchain.chat_models import init_chat_model
from langchain_core.prompts import PromptTemplate
import gradio as gr


# ========== 3) Setup Embeddings ==========
embeddings = OpenAIEmbeddings(model="text-embedding-3-small")


# ========== 4) Load PDFs from data/ folder ==========
def load_documents():
    paths = list(pathlib.Path('./data').glob('**/*.pdf'))
    if not paths:
        print("No PDFs found in data/ folder. Please add PDF files.")
        return []
    load_docs = []
    for path in paths:
        loader = PyPDFLoader(str(path))
        load_docs.extend(loader.load())
    print(f"Loaded {len(load_docs)} pages from {len(paths)} PDF(s)")
    return load_docs


# ========== 5) Split documents into chunks ==========
def split_documents(docs):
    splitter = RecursiveCharacterTextSplitter(
        chunk_size=400,
        chunk_overlap=80,
        separators=['\n\n', '\n', ' ', '']
    )
    chunks = splitter.split_documents(docs)
    print(f"Created {len(chunks)} chunks")
    return chunks


# ========== 6) Create vector store (Chroma) ==========
def create_vector_store(chunks):
    # Remove old database to avoid duplicates on restart
    if os.path.exists('./chroma_db'):
        shutil.rmtree('./chroma_db')

    db = Chroma.from_documents(
        chunks,
        embeddings,
        collection_name='product_collection',
        persist_directory='./chroma_db'
    )
    print("Vector store created!")
    return db


# ========== 7) Setup LLM ==========
llm = init_chat_model("gpt-4o-mini", temperature=0.2)


# ========== 8) Prompt Templates ==========

# Classifies if the question is about our products or not
classifier_template = PromptTemplate(
    template="""You are a classifier. Decide if the question is related to products, items, shopping, or anything a product assistant would handle.

Answer ONLY with one word:
- "related" if it's about products, items, features, specs, prices, shopping, returns, warranty.
- "unrelated" if it's completely off-topic (politics, math, history, personal questions, coding, etc.)

Question: {question}
Answer:""",
    input_variables=['question']
)

# Answers the question using RAG context
rag_template = PromptTemplate(
    template="""You are a helpful product assistant. Use the context below to answer the user's question.
If the context does not contain the answer, say "I don't have information about that in my database."

Context: {context}

Question: {question}

Answer:""",
    input_variables=['context', 'question']
)

# Introduction message when question is off-topic
INTRO_MESSAGE = """Hi! I'm your **Product Assistant** 🛍️

I specialize in answering questions about the products in my database.

**Here's what I can help with:**
- Product features, specs, and details
- Prices and availability
- Return policy and warranty info

Please ask me something about our products!"""


# ========== 9) Build the RAG database ==========
print("=" * 50)
print("Starting Product Assistant RAG...")
print("=" * 50)

docs = load_documents()

if docs:
    chunks = split_documents(docs)
    db = create_vector_store(chunks)
else:
    db = None
    print("WARNING: No documents loaded. Add PDFs to the data/ folder and restart.")

print("=" * 50)
print("Ready! Launching UI...")
print("=" * 50)


# ========== 10) Main chat function ==========
def chat(user_message, history):
    if not user_message.strip():
        return "Please type a question!"

    if db is None:
        return "No products loaded yet. Please add PDF files to the `data/` folder and restart the app."

    # Step 1: Classify the question
    classification = llm.invoke(
        classifier_template.format(question=user_message)
    ).content.strip().lower()

    # Step 2: If OFF-TOPIC → introduce yourself
    if "unrelated" in classification:
        return INTRO_MESSAGE

    # Step 3: If ON-TOPIC → search the RAG database
    results = db.similarity_search_with_score(user_message, k=3)

    # Filter by relevance score (lower = better in Chroma)
    relevant_chunks = [doc for doc, score in results if score < 1.2]

    # Step 4: If nothing relevant found → say I don't know
    if not relevant_chunks:
        return "I searched my database but couldn't find information about that. Sorry, I don't know the answer to this one!"

    # Step 5: If found → answer using context
    context = "\n".join([chunk.page_content for chunk in relevant_chunks])
    response = llm.invoke(
        rag_template.format(context=context, question=user_message)
    )

    return response.content


# ========== 11) Gradio UI ==========
demo = gr.ChatInterface(
    fn=chat,
    title="Product Assistant (RAG)",
    description="Ask me anything about the products in my database! I can answer product questions, tell you about features & specs, and help with return/warranty info.",
    examples=["What products do you have?", "What is the capital of France?", "How much does the smartwatch cost?"],
)

if __name__ == "__main__":
    demo.launch(server_port=7860)
