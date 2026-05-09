from django.urls import path
from . import views

urlpatterns = [
    path('chat_api/', views.chat_api, name='chat_api'),
    path('download_csv/', views.download_csv_api, name='download_csv_api'),
]
