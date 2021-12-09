from polygon import Polygon
from shape import Shape

class Reactangle(Polygon, Shape):
    def area(self):
        return self.get_height() * self.get_width()
