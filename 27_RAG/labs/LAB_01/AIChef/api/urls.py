from django.contrib import admin
from django.urls import path,include
from .views import AIResponse
urlpatterns = [
    path("chat",AIResponse.as_view())
]
