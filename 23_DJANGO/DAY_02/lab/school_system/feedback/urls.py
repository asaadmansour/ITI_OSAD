from django.urls import path,include

from . import views
app_name = 'feedback'

urlpatterns = [
    path('',views.send,name='send_feedback')
]