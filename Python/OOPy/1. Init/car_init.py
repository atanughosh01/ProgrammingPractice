'''================= Class ===================='''
# empty class Car
class Car:
    def __init__(self, speed, color):
        print(f"\nSpeed --> {speed}")
        print(f"Color --> {color}")
        self.s = speed
        self.c = color
        print("__init__() is called")

'''================= Objects ===================='''
ford = Car(200, "red")    # ford object/instance of Car class
honda = Car(220, "blue")   # honda object/instance of Car class
audi = Car(250, "black")    # audi object/instance of Car class

try:
    print(f"\nSpeed of Ford is --> {ford.s} kmph")
    print(f"Color of Ford is --> {ford.c}")
except Exception as e:
    print(f"\nERROR : {e}")
    quit()
