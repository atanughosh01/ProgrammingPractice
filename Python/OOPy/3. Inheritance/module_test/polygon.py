class Polygon:
    __height = None
    __width = None

    def set_values(self, *args):
        height = int(input("\nEnter Height : "))
        width = int(input("Enter Width : "))
        self.__height = height
        self.__width = width

    def get_height(self):
        return self.__height

    def get_width(self):
        return self.__width
