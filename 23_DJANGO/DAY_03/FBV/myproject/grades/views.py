from rest_framework import viewsets
from rest_framework.permissions import IsAuthenticated
from .models import Grades
from .serializers import GradeSerializer

class GradeViewSet(viewsets.ModelViewSet):
    queryset = Grades.objects.all()
    serializer_class = GradeSerializer
    permission_classes = [IsAuthenticated]