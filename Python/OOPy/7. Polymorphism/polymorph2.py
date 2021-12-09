
a = 10
b = 59
x = 6900

# first way to add
c = a + b + x
print(c)

# second way to add
d = a.__add__(b)
d = d.__add__(x)
print(d)

# third way to add
e = int.__add__(a, b)
e = int.__add__(e, x)
print(e)
