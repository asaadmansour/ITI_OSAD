# src/main.py
from dotenv import load_dotenv
from langchain_openai import ChatOpenAI
from langchain_core.prompts import ChatPromptTemplate
from langchain_classic.memory import ConversationBufferMemory
from langchain_classic.chains import LLMChain
from dotenv import load_dotenv
import os
load_dotenv()
api_key = os.getenv("OPENAI_API_KEY")
llm = ChatOpenAI(
    model="gpt-4o-mini",
    temperature=0.3
)

prompt = ChatPromptTemplate.from_messages([
    ("system",
     "You are a chef 👨‍🍳.\n"
     "You ONLY know about food, ingredients, cooking, and meals.\n"
     "If the user asks anything outside food or cooking, respond with: "
     "'I only know cooking and food.'\n"
     "You guide step-by-step to meal decisions.\n"
     "Never skip steps.\n"
     "Respond concisely."),
    ("user", "{input}")
])

def get_chef_response(user_input):
    """
    Get AI Chef response
    
    Args:
        user_input (str): User's message
    
    Returns:
        str: AI response
    """
    memory = ConversationBufferMemory(
        return_messages=True,
        memory_key="history"
    )
    
    chain = LLMChain(
        llm=llm,
        prompt=prompt,
        memory=memory
    )

    response = chain.invoke({
        "input": user_input
    })
    
    return response["text"]