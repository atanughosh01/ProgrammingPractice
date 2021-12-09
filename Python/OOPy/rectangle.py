'''================= Class ===================='''
class Rectangle:
    pass

'''================= Objects ===================='''
rect1 = Rectangle()
rect2 = Rectangle()

'''================= Attributes ===================='''
rect1.height = 20
rect1.width = 30

rect2.height = 50
rect2.width = 40

rect1.area = rect1.height * rect1.width
rect2.area = rect2.height * rect2.width

print(f"Area of Reactangle-1 = {rect1.area}")
print(f"Area of Reactangle-2 = {rect2.area}")
