from django.shortcuts import get_object_or_404, render, redirect
from .models import Student

def register(request):
    if request.method == 'GET':
        return render(request, "students/register.html")
    elif request.method == 'POST':
        name = request.POST.get('name')
        age = int(request.POST.get('age'))         
        email = request.POST.get('email')
        image = request.FILES.get('image')

        Student.objects.create(name=name, age=age, email=email, image=image)
        return redirect("/students/")  

def home(request):
    students = Student.objects.all()
    return render(request, "students/students.html", {"students": students})

def delete(request,id):
    student = get_object_or_404(Student, id=id)
    if request.method == 'POST':
        student.delete()
    return redirect('students:home')