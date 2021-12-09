'''================= Class ===================='''
class Rectangle:
    def __init__(self, height, width):
        self.h = height
        self.w = width

'''================= Objects ===================='''
rect1 = Rectangle(20, 30)
rect2 = Rectangle(50, 40)

rect1.area = rect1.h * rect1.w
rect2.area = rect2.h * rect2.w

print(f"Area of Reactangle-1 = {rect1.area}")
print(f"Area of Reactangle-2 = {rect2.area}")
