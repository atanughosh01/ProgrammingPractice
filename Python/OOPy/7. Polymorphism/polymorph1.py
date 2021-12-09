
class PyCharm:

    def execute(self):
        print("\nCompiling Code")
        print("Executing Code")


class VSCode:

    def execute(self):
        print("\nSpellChecking")
        print("AutoCompleting")
        print("Compiling Code")
        print("Executing Code")


class Laptop:

    def code(self, ide):
        ide.execute()


ide1 = PyCharm()
ide2 = VSCode()

lap1 = Laptop()
lap1.code(ide1)

lap2 = Laptop()
lap2.code(ide2)
