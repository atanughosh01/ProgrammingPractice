def main():
    try:
        func()
        print("print this after function call")
    except ZeroDivisionError:
        print("divided by zero, not possible")
    except:
        print("It's an exception")
        
def func():
    print(1/0)
    
main()
