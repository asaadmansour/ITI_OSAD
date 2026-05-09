from django.urls import path
from .views import SubjectsView, SubjectDetails

urlpatterns = [
    path('', SubjectsView.as_view(), name='subjects-list'),
    path('<int:id>/', SubjectDetails.as_view(), name='subject-detail'),
]
