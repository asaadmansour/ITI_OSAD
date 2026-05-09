from django.db import models
from django.core.validators import MaxValueValidator
# Create your models here.
class Subject(models.Model):
    name = models.CharField(max_length=100)
    max_grade = models.IntegerField(validators=[MaxValueValidator(100)])
    def __str__(self):
        return self.name