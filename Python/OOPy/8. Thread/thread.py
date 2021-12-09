from time import sleep
from threading import Thread


class  Hello(Thread):
    def run(self):
        for i in range(10):
            print("Hello")
            sleep(1)


class Hi(Thread):
    def run(self):
        for i in range(10):
            print("Hi\n")
            sleep(1)


t1 = Hello()
t2 = Hi()

t1.start()
sleep(0.1)
t2.start()

t1.join()
t2.join()

print("Good Bye!")