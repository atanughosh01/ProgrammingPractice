'''================= Class ===================='''
# empty class Car
class Car:
    pass

'''================= Objects ===================='''
ford = Car()    # ford object/instance of Car class
honda = Car()   # honda object/instance of Car class
audi = Car()    # audi object/instance of Car class

'''================= Attributes // Data-s ===================='''
# speed attr/data
ford.speed = 200
honda.speed = 220
audi.speed = 250

# color attr/data
ford.color = "red"
honda.color = "blue"
audi.color = "black"

print(f"\nSpeed of Ford is --> {ford.speed} kmph")
print(f"Color of Ford is --> {ford.color}")

# overwriting the previous attr
ford.speed = 300
print(f"\nSpeed of Ford is --> {ford.speed} kmph")
