from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
from rest_framework.permissions import IsAuthenticated
from .models import Subject
from .serializers import SubjectSerializer


class SubjectsView(APIView):
    permission_classes = [IsAuthenticated]

    def get(self, request):
        subjects = Subject.objects.all()
        serializer = SubjectSerializer(subjects, many=True)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def post(self, request):
        serializer = SubjectSerializer(data=request.data)
        if serializer.is_valid():          
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


class SubjectDetails(APIView):
    permission_classes = [IsAuthenticated]

    def get_subject(self, id):            
        try:
            return Subject.objects.get(id=id)
        except Subject.DoesNotExist:
            return None

    def get(self, request, id):
        subject = self.get_subject(id)
        if subject is None:
            return Response({'error': 'Subject not found'}, status=status.HTTP_404_NOT_FOUND)
        serializer = SubjectSerializer(subject)
        return Response(serializer.data, status=status.HTTP_200_OK)

    def delete(self, request, id):
        subject = self.get_subject(id)
        if subject is None:
            return Response({'error': 'Subject not found'}, status=status.HTTP_404_NOT_FOUND)
        subject.delete()                   
        return Response(status=status.HTTP_204_NO_CONTENT)

    def patch(self, request, id):
        subject = self.get_subject(id)
        if subject is None:
            return Response({'error': 'Subject not found'}, status=status.HTTP_404_NOT_FOUND)
        serializer = SubjectSerializer(subject, data=request.data, partial=True)
        if serializer.is_valid():          
            serializer.save()              
            return Response(serializer.data, status=status.HTTP_200_OK)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)