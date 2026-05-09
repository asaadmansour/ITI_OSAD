# Task 1: Logical Operators
def check(number, start, end) :
    return number >= start and number <= end
print(check(16,5,15))
# Task 2: Logical AND, OR, NOT
def isEligible(age,have_coupon):
    return age < 18 or age > 65 or have_coupon
print(isEligible(12,False))
print(isEligible(40,True))
print(isEligible(40,False))
# Task 3: String Concatenation
def greetings(name):
    print("Hello",name + "!")
greetings("asaad")
# Task 4: String Slicing
def get_initials(full_name):
    names = full_name.split()
    return names[0][0] + names[1][0]
print(get_initials("Asaad Ahmed"))
# Task 5: String Formatting
def info(name, age):
    print(f"{name} is {age} years old.")
info("Asaad", 24)