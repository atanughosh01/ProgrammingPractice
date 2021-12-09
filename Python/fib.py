# def fib(n):
#     if n == 0:
#         return 0
#     elif n == 1:
#         return 1
#     else:
#         return fib(n - 1) + fib(n - 2)

def fib(limit):
    a, b = 0, 1                 # Initialize first two base Fibonacci Numbers
    i = 1                       # Initialize the iteration variable
    yield a
    yield b
    while(i != limit):          # One by one yield next Fibonacci Number
        a, b = b, a+b
        i += 1
        yield b

try:
    n = int(input('Enter upto which Fibonacci number you want to print : '))
except:
    print('Error ! Please enter numeric value')
    quit()

fib_num = fib(n-1)          # Create a generator object 'fib_num'
print('1st', n, 'Fibonacci numbers are : ', end=" ")

try:
    while(True):                # Iterating over the generator object using next
        print(next(fib_num), ' ', end=" ")
except StopIteration:
    quit()
    

def trace(f):
    f.indent = 0
    def g(x):
        print('|  ' * f.indent + '|--', f.__name__, x)
        f.indent += 1
        value = f(x)
        print('|  ' * f.indent + '|--', 'return', repr(value))
        f.indent -= 1
        return value
    return g


fib = trace(fib)
print(fib(4))
