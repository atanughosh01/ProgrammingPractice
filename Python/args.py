
# repeat_lyrics()
# def repeat_lyrics():
#     print_lyrics()
#     print_lyrics()  
# def print_lyrics():
#     print("I am a Lumberjerk")
#     print("I sleep all day")


# a = {5, 6, 7}
# print(a)
# a.add(5)
# print(a)


# i = 1 
# while True:
#     if i % 2 == 0:
#         break
#     print(i)
#     i += 2


# def main():
#     try:
#         func()
#         print("print this after function call")
#     except ZeroDivisionError:
#         print("divided by zero, not possible")
#     except:
#         print("It's an exception")
# def func():
#     print(1/0)   
# main()


# A = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
# print(len(A))
# print([A[i][len(A)-1-i] for i in range(len(A))])


def d(f):
    def n(*args):
        return '$' + str(f(*args))
    return n   
@d
def p(a, t):
    return a + a*t
print(p(100, 0))

