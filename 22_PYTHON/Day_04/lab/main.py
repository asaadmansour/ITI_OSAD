from Person import Person
from Car import Car
from Employee import Employee
from Office import Office

def main():
    print("========================================")
    print("Welcome to the ITI Office Management System!")
    print("========================================")
    office_name = input("Enter the name of your Office: ")
    office = Office(office_name)

    while True:
        print("\n----------- Menu -----------")
        print("1. Hire Employee")
        print("2. Fire Employee")
        print("3. Show All Employees")
        print("4. Get Employee Details")
        print("5. Save Office to JSON")
        print("6. Exit")
        print("----------------------------")
        
        choice = input("Enter your choice (1-6): ")
        
        if choice == '1':
            print("\n-- Enter Employee Details --")
            name = input("Name: ")
            try:
                money = float(input("Money: "))
                health = float(input("Health Rate (0-100): "))
                emp_id = int(input("Employee ID: "))
                email = input("Email (must be valid format): ")
                salary = float(input("Salary (must be >= 1000): "))
                dist = float(input("Distance To Work: "))
                
                print("\n-- Enter Car Details --")
                car_name = input("Car Name: ")
                fuel = float(input("Car Fuel Rate (0-100): "))
                vel = float(input("Car Velocity (0-200): "))
                
                car = Car(car_name, fuel, vel)
                emp = Employee(name, money, "happy", health, emp_id, email, "password123", salary, car, dist)
                
                office.hire(emp)
                print(f"\n✅ Employee '{name}' hired successfully! Total Office Employees: {Office.employeesNum}")
            except Exception as e:
                print(f"\n❌ Error hiring employee: {e}")
                print("Please check your inputs and try again.")
                
        elif choice == '2':
            try:
                emp_id = int(input("Enter Employee ID to fire: "))
                emp = office.get_employee(emp_id)
                if emp:
                    office.fire(emp_id)
                    print(f"\n✅ Employee ID {emp_id} has been fired. Total Office Employees: {Office.employeesNum}")
                else:
                    print("\n❌ Employee not found.")
            except ValueError:
                print("\n❌ Invalid ID format.")
            
        elif choice == '3':
            employees = office.get_all_employees()
            print(f"\n-- All Employees in {office.name} --")
            if not employees:
                print("No employees in the office yet.")
            for e in employees:
                print(f"ID: {e.id} | Name: {e.name} | Salary: {e.salary} | Email: {e.email}")
                
        elif choice == '4':
            try:
                emp_id = int(input("Enter Employee ID to view: "))
                e = office.get_employee(emp_id)
                if e:
                    print(f"\n-- Details for Employee {e.name} --")
                    print(f"ID: {e.id}")
                    print(f"Email: {e.email}")
                    print(f"Salary: {e.salary}")
                    print(f"Distance To Work: {e.distanceToWork}")
                    print(f"Money: {e.money}")
                    print(f"Mood: {e.mood}")
                    print(f"Health Rate: {e.healthRate}")
                    print(f"Car: {e.car.name} (Fuel: {e.car.fuelRate}, Velocity: {e.car.velocity})")
                else:
                    print("\n❌ Employee not found.")
            except ValueError:
                print("\n❌ Invalid ID format.")
                
        elif choice == '5':
            office.save()
            print(f"\n✅ Data saved successfully to {office.name}_office.json!")
            
        elif choice == '6':
            print("\nGoodbye! 👋")
            break
        else:
            print("\n❌ Invalid choice, please select a number from 1 to 6.")

if __name__ == "__main__":
    main()
