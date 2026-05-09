from django.urls import path
from . import views

app_name = 'grades'

urlpatterns = [
    path('', views.home, name='grades'),
    path('register/', views.register, name='register'),
    path('search/', views.search, name='search'),
]