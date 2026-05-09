from django.shortcuts import render, redirect
from .forms import GradeForm
from .models import Grade
from django.contrib.auth.decorators import login_required
from django.db.models import Q

@login_required
def home(request):
    grades = Grade.objects.select_related('student', 'subject').all()
    return render(request, "grades/grades.html", {'grades': grades})

def search(request):
    query = request.GET.get('q','')
    results = []
    if query:
        results = Grade.objects.select_related('student','subject').filter(Q(student__name__icontains=query)| Q(subject__name__icontains=query)) 
    return render(request, "grades/search.html", {'results': results, 'query': query})
@login_required
def register(request):
    form = GradeForm()
    if request.method == 'POST':
        form = GradeForm(request.POST)
        if form.is_valid():
            form.save()
            return redirect('grades:grades')
    return render(request, "grades/grade_register.html", {'form': form})