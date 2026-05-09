from django.urls import path
from . import views

app_name = 'subjects'

urlpatterns = [
    path('', views.home, name='home'),
    path('register/', views.register, name='register'),
    path('delete/<int:id>/', views.delete, name='delete'),
]