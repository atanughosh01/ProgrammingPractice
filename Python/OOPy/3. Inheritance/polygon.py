class Polygon:
    __height = None
    __width = None

    def set_values(self, height, width):
        print("set_values() is called")
        self.__height = height
        self.__width = width

    def get_height(self):
        print("\nget_height() is called")
        return self.__height

    def get_width(self):
        print("get_width() is called")
        return self.__width

class Reactangle(Polygon):
    def area(self):
        return self.get_height() * self.get_width()

class Triangle(Polygon):
    def area(self):
        return self.get_height() * self.get_width() / 2

rect = Reactangle()
tri = Triangle()

rect.set_values(30, 20)
tri.set_values(30, 20)

print(rect.area())
print(tri.area())
