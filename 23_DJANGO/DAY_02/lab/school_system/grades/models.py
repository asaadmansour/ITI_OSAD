from django.db import models
from django.contrib.auth import get_user_model
from django.core.validators import MaxValueValidator
from subjects.models import Subject 
from students.models import Student


class Grade(models.Model): 
    grade = models.IntegerField(validators=[MaxValueValidator(100)])
    student = models.ForeignKey(Student, on_delete=models.CASCADE)
    subject = models.ForeignKey(Subject, on_delete=models.CASCADE)