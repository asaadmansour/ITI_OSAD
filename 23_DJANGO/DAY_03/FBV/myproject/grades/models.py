from django.db import models
from students.models import Student
from subjects.models import Subject

# Create your models here.
class Grades(models.Model):
    student = models.ForeignKey(Student, on_delete=models.CASCADE, related_name='grades')
    subject = models.ForeignKey(Subject, on_delete=models.CASCADE, related_name='grades')
    grade = models.IntegerField()

    def __str__(self):
        return f"{self.student.name} - {self.subject.name}: {self.grade}"