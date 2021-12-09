class Hello:
    def __init__(self, num):
        self.a = 10
        self._b = 20
        self.__c = 30
        print("__init__() is called")

    def public_method(self):
        self.__private_method()
        print(hello.__c)
        print("Public Method is Called")

    def __private_method(self):
        print("Private Method is Called")

hello = Hello(69)
print(hello.a)
print(hello._b)
hello.public_method()
# hello.__private_method()
