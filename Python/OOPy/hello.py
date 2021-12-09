class Hello:
    def __init__(self):
        print("1st __init__ is called")

    def __init__(self):
        print("2nd __init__ is called")

    def __init__(self, name, *args, **kwargs):
        self.name = name
        self.age = 20
        print("3rd __init__ is called")

hello1 = Hello(10)
hello2 = Hello("Atanu")
hello3 = Hello("Atanu", "Ghosh", "JU", age=20, address="Burdwan")
