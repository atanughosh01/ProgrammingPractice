class Salary:                                   # acts like content of the Employee class
    def __init__(self, pay, bonus):
        self.pay = pay
        self.bonus = bonus

    def annual_salary(self):
        return (self.pay*12) + self.bonus

class Employee:                                 # acts like a container of the Salary class
    def __init__(self, name, age, pay, bonus):
        self.pay = pay
        self.bonus = bonus
        self.name = name
        self.age = age
        self.obj_salary = Salary(pay, bonus)    # content of container

    def total_salary(self):
        return self.obj_salary.annual_salary()

# here the Salary class object is dependant on Employee class object
# beacause the Employee class object is holding the content of Salary class object
# so if we delete the Employee class object (emp) content --> -->
# --> Salary class object content will automatically be deleted
emp = Employee("Atanu", 20, 15000, 10000)       # container holding the content
print("\nTotal Salary = ", emp.total_salary())
