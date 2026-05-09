from django.db import models

# Create your models here.
class Feedback(models.Model):
    email = models.EmailField()
    message = models.CharField()
    date = models.DateField(auto_now_add=True)
    
    def __str__(self):
        return self.email