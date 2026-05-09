import json

class Office:
    employeesNum = 0

    def __init__(self, name, employees=None):
        self.name = name
        if employees is None:
            self.employees = []
        else:
            self.employees = employees
        Office.employeesNum += len(self.employees)

    def get_all_employees(self):
        return self.employees

    def get_employee(self, empId):
        for emp in self.employees:
            if hasattr(emp, 'id') and emp.id == empId:
                return emp
        return None

    def hire(self, employee):
        self.employees.append(employee)
        Office.employeesNum += 1

    def fire(self, empId):
        emp = self.get_employee(empId)
        if emp:
            self.employees.remove(emp)
            Office.employeesNum -= 1

    def deduct(self, empId, deduction):
        emp = self.get_employee(empId)
        if emp:
            emp.salary -= deduction

    def reward(self, empId, reward):
        emp = self.get_employee(empId)
        if emp:
            emp.salary += reward

    def check_lateness(self, empId, moveHour):
        emp = self.get_employee(empId)
        if emp:
            is_late = Office.calculate_lateness(9, moveHour, emp.distanceToWork, emp.car.velocity)
            if is_late:
                self.deduct(empId, 10)
            else:
                self.reward(empId, 10)

    @staticmethod
    def calculate_lateness(targetHour, moveHour, distance, velocity):
       
        if velocity == 0:
            return True 
        time_needed = distance / velocity
        arrival_time = moveHour + time_needed
        return arrival_time > targetHour

    @classmethod
    def change_emps_num(cls, num):
        cls.employeesNum = num

    def save(self):
        filename = f"{self.name}_office.json"
        
        data = {
            "name": self.name,
            "employeesNum": Office.employeesNum,
            "employees": []
        }
        
        for emp in self.employees:
            data["employees"].append({
                "id": emp.id,
                "name": emp.name,
                "email": emp.email,
                "salary": emp.salary,
                "distanceToWork": emp.distanceToWork,
                "car": {
                    "velocity": emp.car.velocity,
                    "fuelRate": emp.car.fuelRate
                }
            })
            
        with open(filename, 'w') as file:
            json.dump(data, file, indent=4)