from django.db import models

class Subject(models.Model):
    code = models.CharField(max_length=10, unique=True)   
    name = models.CharField(max_length=50)
    description = models.TextField(blank=True)
    credits = models.PositiveIntegerField()               

    def __str__(self):
        return f"{self.code} - {self.name}"