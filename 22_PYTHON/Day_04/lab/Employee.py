import re
import smtplib 
from email.message import EmailMessage
from Person import Person

class Employee(Person):
    def __init__(self, name, money, mood, healthRate, id, email,app_password, salary,car, distanceToWork):
        super().__init__(name, money, mood, healthRate)  
        self.car = car
        self.id = id
        self.app_password = app_password
        email_pattern = r"^[\w\.-]+@[\w\.-]+\.\w+$"
        if re.match(email_pattern, email):
            self.email = email
        else:
            raise ValueError("Invalid email format")

        if salary < 1000:
            raise ValueError("salary must be 1000 or more")
        else:
            self.salary = salary
        self.distanceToWork = distanceToWork

    def work(self, hours):
        if hours == 8:
            self.mood = "happy"
        elif hours < 8:
            self.mood = "lazy"
        else:
            self.mood = "tired"

    def drive(self, distance,velocity):
        self.car.run(distance,velocity)

    def refuel(self, amount = 100):
        self.car.setFuelRate(amount)

    def send_mail(self, to, subject, body):
        msg = EmailMessage()
        msg['From'] = self.email
        msg['To'] = to
        msg['Subject'] = subject
        msg.set_content(body)
        with smtplib.SMTP_SSL('smtp.gmail.com', 465) as smtp:
            smtp.login(self.email,self.app_password)
            smtp.send_message(msg)