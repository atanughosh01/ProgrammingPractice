import math

class Circle:
    def __init__(self, radius):
        print("Circle __init__() is called")
        self.__radius = radius

    def set_radius(self, radius):
        self.__radius = radius

    def get_radius(self):
        return self.__radius

    def area(self):
        return math.pi * self.__radius ** 2

    # overloaded operator
    def __add__(self, circle_object):
        return Circle(self.__radius + circle_object.__radius)

    # overloaded operator
    def __lt__(self, circle_object):
        return self.__radius < circle_object.__radius

    # overloaded operator
    def __gt__(self, circle_object):
        return self.__radius > circle_object.__radius

    # overloaded operator
    def __str__(self):
        return "Circle Area = " + str(self.area())

c1 = Circle(2)
c2 = Circle(3)

try:
    c3 = c1 + c2
except Exception as e:
    print("\nException Caught :", e)
    quit()

print("\nValue of Pi =", math.pi)
print(c1.get_radius(), "\t", c1.area())
print(c2.get_radius(), "\t", c2.area())
print(c3.get_radius(), "\t", c3.area())

print(c1 < c2)
print(c1 > c2)

print(str(c1))
print(str(c2))
