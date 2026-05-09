from rest_framework import serializers
from rest_framework.authtoken.models import Token
from .models import Student
from django.contrib.auth.models import User

class StudentSerializer(serializers.ModelSerializer):
    username = serializers.CharField(write_only=True)
    password = serializers.CharField(write_only=True)
    token = serializers.SerializerMethodField(read_only=True)

    class Meta:
        model = Student
        fields = [
            'username',
            'password',
            'token',
            'name',
            'email',
            'age',
            'date_of_birth',
            'gpa',
            'is_active',
            'created_at',
            'updated_at',
        ]
        read_only_fields = ['created_at', 'updated_at']

    def get_token(self, obj):
        token = Token.objects.get(user=obj.user) 
        return token.key


    def update(self, instance, validated_data):
        username = validated_data.pop('username', None)
        password = validated_data.pop('password', None)

        if username:
            instance.user.username = username
        if password:
            instance.user.set_password(password)
        if username or password:
            instance.user.save()

        return super().update(instance, validated_data)

    def create(self, validated_data):
        username = validated_data.pop('username')
        password = validated_data.pop('password')
        user = User.objects.create_user(username=username, password=password)
        token = Token.objects.create(user=user)  
        student = Student.objects.create(user=user, **validated_data)
        return student
