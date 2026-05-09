# api/views.py
from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
from AIBot.main import get_chef_response



class AIResponse(APIView):
    def post(self, request):
        try:
            user_message = request.data.get('message', '').strip()
            if not user_message:
                return Response(
                    {'error': 'Message field is required'},
                    status=status.HTTP_400_BAD_REQUEST
                )
            ai_response = get_chef_response(user_message)
            return Response(
                {
                    'success': True,
                    'response': ai_response
                },
                status=status.HTTP_200_OK
            )
        
        except Exception as e:
            return Response(status=status.HTTP_500_INTERNAL_SERVER_ERROR)