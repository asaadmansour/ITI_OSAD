import csv
import os
from dotenv import load_dotenv
from tavily import TavilyClient
from langchain.tools import tool

load_dotenv("/home/asaad/ITI-OSAD/27_RAG/notes/DAY_02/.env")
tavily_api = os.getenv("TAVILY_API")
@tool
def save_case_to_csv(patient_name: str = "Unknown", age: int = 0, condition: str = "Unknown", location: str = "Unknown") -> list:
    """Stores structured case data to a CSV file."""
    file_path = "/home/asaad/ITI-OSAD/27_RAG/notes/DAY_02/myproject/my_medical_cases.csv"
    case_data = {
        "patient_name": patient_name,
        "age": age,
        "condition": condition,
        "location": location
    }
    file_exists = os.path.isfile(file_path)
    with open(file_path, mode="a", newline="", encoding="utf-8") as f:
        writer = csv.DictWriter(f, fieldnames=case_data.keys())
        if not file_exists:
            writer.writeheader()
        writer.writerow(case_data)
    
    with open(file_path, mode="r", encoding="utf-8") as f:
        reader = csv.DictReader(f)
        rows = list(reader)

    return rows


client = TavilyClient(api_key=tavily_api)

@tool
def search_hospitals(condition: str, location: str) -> dict:
    """Searches the web for the nearest hospital based on a medical condition and location."""
    query = f"nearest hospital for {condition} near {location}"
    results = client.search(query)
    return results

if __name__ == "__main__":
    print("Testing hospital search...")
    results = search_hospitals.invoke({"condition": "orthopedic", "location": "Cairo"})
    print("Search successful!\n")
    
    print("Testing CSV saving...")    
    rows = save_case_to_csv.invoke({
        "patient_name": "John Doe",
        "age": 30,
        "condition": "orthopedic",
        "location": "Cairo"
    })
    print(f"CSV operation successful! 'test_cases.csv' now contains {len(rows)} row(s).")
    print("Current CSV contents:")
    for row in rows:
        print(row)