class Car:
    def __init__(self, speed, color):
        self.__spd = speed
        self.__col = color
        print("__init__() is called")

    def set_speed(self, value):
        self.__spd = value

    def get_speed(self):
        return self.__spd

    def set_color(self, color_value):
        self.__col = color_value

    def get_color(self):
        return self.__col

ford = Car(200, "red")
honda = Car(220, "blue")
audi = Car(250, "black")

ford.set_speed(500)
ford.set_color("Purple")

ford.__spd = 600
ford.__col = "B&W"

print(f"\nSpeed of Ford is --> {ford.get_speed()} kmph")
print(f"Color of Ford is --> {ford.get_color()}")
