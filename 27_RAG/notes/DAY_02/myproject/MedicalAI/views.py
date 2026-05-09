from django.http import JsonResponse, FileResponse
from django.views.decorators.csrf import csrf_exempt
import json
import os
from .agent import run_agent

@csrf_exempt
def chat_api(request):
    if request.method == "POST":
        try:
            data = json.loads(request.body)
            user_message = data.get("message", "")
            image_data = data.get("image", None)
            response_text = run_agent(user_message, image_base64=image_data, session_id="web_session")
            return JsonResponse({"response": response_text})
        except Exception as e:
            return JsonResponse({"error": str(e)}, status=400)
    return JsonResponse({"error": "Invalid request method"}, status=405)

def download_csv_api(request):
    file_path = "/home/asaad/ITI-OSAD/27_RAG/notes/DAY_02/myproject/my_medical_cases.csv"
    if os.path.exists(file_path):
        return FileResponse(open(file_path, "rb"), as_attachment=True, filename="my_medical_cases.csv")
    return JsonResponse({"error": "No cases recorded yet."}, status=404)
