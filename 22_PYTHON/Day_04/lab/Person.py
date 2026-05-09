class Person:
    moods = ("happy", "tired", "lazy")
    
    def __init__(self, name, money, mood, healthRate):
        self.name = name
        self.money = money
        self.mood = mood    
        if 0 <= healthRate <= 100:
            self.healthRate = healthRate
        else:
            raise ValueError("healthRate must be between 0 and 100")

    def sleep(self, hours):
        if hours == 7:
            self.mood = "happy"
        elif hours < 7:
            self.mood = "tired"
        else:
            self.mood = "lazy"

    def eat(self, meals):
        if (meals == 3):
            self.healthRate = 100
        elif (meals == 2):
            self.healthRate = 75
        elif (meals == 1):
            self.healthRate = 50
        else:
            print("Not Possible")

    def buy(self, items):
        if items * 10 <= self.money:
            self.money -= items * 10
        else:
            print("Not enough money")