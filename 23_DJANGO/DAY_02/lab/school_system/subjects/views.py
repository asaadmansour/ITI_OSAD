from django.shortcuts import render,redirect, get_object_or_404
from .models import Subject
from django.contrib.auth.decorators import login_required
# Create your views here.
@login_required
def home(request):
    subjects = Subject.objects.all()
    return render(request,'subjects/subjects.html', {'subjects': subjects})

@login_required
def register(request):
    if request.method == 'GET':
        return render(request, 'subjects/subject_form.html')
    name = request.POST.get('name')
    max_grade = request.POST.get('max_grade')
    Subject.objects.create(name=name, max_grade=max_grade)
    return redirect('/subjects/')

@login_required
def delete(request, id):
    subject = get_object_or_404(Subject, id=id)
    if request.method == 'POST':
        subject.delete()
    return redirect('subjects:home')
