from rectangle import Reactangle
from triangle import Triangle

# Driver Code
rect = Reactangle()
tri = Triangle()

rect.set_values()
print("Calculated Area of Rectangle =", rect.area())

tri.set_values()
print("Calculated Area of Triangle =", tri.area())

rect.set_color("Blue")
print("\nColor of Rectangle is :", rect.get_color())

tri.set_color("Purple")
print("Color of Triangle is :", tri.get_color())
