n = int(input("Enter an integer : "))
R = 2*n-1
for r in range (1, R):
    print()
    p = n
    c = n - abs(n-r) -1
    for j in range(1,c):
        print(p, end=" ")
        p-=1
    for j in range(1, R-2*c):
        print(p, end=" ")
    for j in range(1,c):
        p+=1
        print(p, end=" ")