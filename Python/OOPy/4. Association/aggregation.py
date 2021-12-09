class Salary:
    def __init__(self, pay, bonus):
        self.pay = pay
        self.bonus = bonus

    def annual_salary(self):
        return (self.pay*12) + self.bonus

class Employee:
    def __init__(self, name, age, salary):
        self.name = name
        self.age = age
        self.obj_salary = salary

    def total_salary(self):
        return self.obj_salary.annual_salary()

# here the Salary class object is NOT dependant on Employee class object
# beacause the Employee class object is NOT holding the content of Salary class object
# so if we delete the Employee class object (emp) content --> -->
# --> Salary class object (sal) content won't be deleted automatically, both are independant
sal = Salary(15000, 10000)
emp = Employee("Atanu", 20, sal)
print("\nTotal Salary = ", emp.total_salary())
