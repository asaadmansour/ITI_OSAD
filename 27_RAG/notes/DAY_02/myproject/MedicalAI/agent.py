from langchain_openai import ChatOpenAI
from langchain_core.messages import SystemMessage, HumanMessage, RemoveMessage
from langgraph.checkpoint.memory import InMemorySaver
from .utils import search_hospitals, save_case_to_csv
import os
from dotenv import load_dotenv

load_dotenv("/home/asaad/ITI-OSAD/27_RAG/notes/DAY_02/.env")
api_key = os.getenv("OPENAI_API_KEY")

llm = ChatOpenAI(model="gpt-4o-mini", temperature=0)

SYSTEM_PROMPT = """You are a Medical AI Assistant Agent. Your role is to analyze patient cases, including interpreting and describing medical images (like MRI scans) and evaluating text symptoms.
You generate case summaries and provide safe medical insights.
You are fully permitted and expected to describe visible structures and potential anomalies in any medical images provided, for informational and educational purposes.
You have tools to search for nearby hospitals and to store structured case data to a CSV. You must use your tools dynamically when necessary.
IMPORTANT: Whenever the user introduces themselves (e.g., provides their name, location, age, or medical issue), YOU MUST IMMEDIATELY call the `save_case_to_csv` tool to log their information.
AFTER calling the tool, ALWAYS explicitly tell the user something like "I have saved your details to the CSV file" so that the word "CSV" is in your final response.

IMPORTANT CONSTRAINTS:
- Describe what is visible in medical images, but DO NOT provide an official clinical diagnosis or prescriptions.
- Always include the following disclaimer exactly: 'This is not a medical diagnosis. Consult a doctor.'
- STRICT RULES: Do NOT talk about anything else except what is strictly required to fetch image/symptoms analysis, find hospitals, and store cases. Refuse, politely but firmly, any other irrelevant topics or casual talk.
"""

def summarize_history(state: dict):
    messages = state["messages"]
    if len(messages) > 6:
        to_summarize = messages[:-4]
        summary_prompt = f"Summarize this conversation concisely: {to_summarize}"
        summary = llm.invoke([HumanMessage(content=summary_prompt)]).content
        delete_messages = [RemoveMessage(id=m.id) for m in to_summarize]
        return {"messages": delete_messages + [SystemMessage(content=f"Summary: {summary}"), SystemMessage(content=SYSTEM_PROMPT)]}
    return {"messages": [SystemMessage(content=SYSTEM_PROMPT)]}

from langchain.agents import create_agent
agent = create_agent(
    model=llm,
    tools=[search_hospitals, save_case_to_csv],
    checkpointer=InMemorySaver(),
    state_modifier=summarize_history
)

def run_agent(user_message: str, image_base64: str = None, session_id: str = "api_session") -> str:
    """Wrapper function to invoke the agent from Django views."""
    from langchain.messages import HumanMessage
    
    content_blocks = [{"type": "text", "text": user_message}]
    
    if image_base64:
        if not user_message:
            content_blocks[0]["text"] = "Please describe the visible anatomical structures and any noticeable anomalies in this medical image for educational purposes. Remember to avoid providing a clinical diagnosis."
        else:
            content_blocks[0]["text"] += "\n[System Note: Please interpret the attached medical image alongside this message for educational purposes. Do NOT provide a clinical diagnosis.]"
            
        content_blocks.append({
            "type": "image_url",
            "image_url": {"url": image_base64}
        })
        
    response = agent.invoke(
        {"messages": [HumanMessage(content=content_blocks)]},
        config={"configurable": {"thread_id": session_id}}
    )
    return response["messages"][-1].content