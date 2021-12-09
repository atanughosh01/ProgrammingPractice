from abc import ABC, abstractmethod
# ABC = Abstract Base Classes

class Shape(ABC):
    @abstractmethod     # decorator
    def area(self):
        pass

    @abstractmethod     # decorator
    def perimeter(self):
        pass

# Class Side must implement all abstract methods
class Square(Shape):
    def __init__(self, side):
        self.__side = side

    def area(self):
        return self.__side * self.__side

    def perimeter(self):
        return 4 * self.__side

try:
    square = Square(5)
    print(square.area())
    print(square.perimeter())
except Exception as e:
    print("\nException Caught :", e)
    quit()
