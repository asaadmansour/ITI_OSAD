from django.shortcuts import render, redirect
from .models import Feedback

def send(request):
    if request.method == 'POST':
        email = request.POST.get('email')
        message = request.POST.get('message')
        Feedback.objects.create(email=email, message=message)
        return redirect('/feedback/') 
    return render(request, "feedback/feedback.html")