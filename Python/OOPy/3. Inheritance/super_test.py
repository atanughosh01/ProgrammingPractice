class Parent1:
    def __init__(self, name):
        print("Parent-1 init() is called,", "Name :", name)

class Parent2:
    def __init__(self, name):
        print("Parent-2 init() is called,", "Name :", name)

class Child1(Parent1, Parent2):
    def __init__(self):
        print("Child-1 init() is called")
        super().__init__("Tom")
        Parent1.__init__(self, "Akash")
        Parent2.__init__(self, "Rahul")

class Child2(Parent2, Parent1):
    def __init__(self):
        print("\nChild-2 init() is called")
        super().__init__("Jerry")
        Parent1.__init__(self, "Max")
        Parent2.__init__(self, "Harry")

child1 = Child1()
print(Child1.__mro__)

child2 = Child2()
print(Child2.__mro__)
