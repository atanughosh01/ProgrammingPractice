class Rectangle:
    def __init__(self, height = None, width = None):
        self.__height = height
        self.__width = width
        print("__init__() is called")

    def set_height(self, *val_height):
        val_height = int(input("\nEnter Height : "))
        self.__height = val_height

    def set_width(self, *val_width):
        val_width = int(input("Enter Width : "))
        self.__width = val_width

    def get_height(self):
        print(f"\nEntered Height = {self.__height}")
        return self.__height

    def get_width(self):
        print(f"Entered Width = {self.__width}")
        return self.__width

    def get_area(self):
        print(f"\nCalculated Area = {self.__height} * {self.__width} = {self.__height*self.__width}")
        # return self.__height*self.__width

try:
    rect1 = Rectangle()
    rect2 = Rectangle()
except Exception as e:
    print("ERROR :", e)
    quit()

rect1.set_height()
rect1.set_width()
rect1.get_height()
rect1.get_width()
rect1.get_area()

rect2.set_height()
rect2.set_width()
rect2.get_height()
rect2.get_width()
rect2.get_area()
