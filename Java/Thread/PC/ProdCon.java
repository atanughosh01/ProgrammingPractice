// A correct implementation of a producer and consumer.
class Buffer {
    int n;
    boolean empty = false;

    synchronized int get() {
        while (!empty)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        System.out.println("Got: " + n);
        empty = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        while (empty)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        this.n = n;
        empty = true;
        System.out.println("Put: " + n);
        notify();
    }
}

class Producer implements Runnable {
    Buffer b;

    Producer(Buffer b) {
        this.b = b;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i = 0;
        while (true) {
            b.put(i++);
        }
    }
}

class Consumer implements Runnable {
    Buffer b;

    Consumer(Buffer b) {
        this.b = b;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        while (true) {
            b.get();
        }
    }
}

class ProdCon {
    public static void main(String args[]) {

        
        Buffer b = new Buffer();
        new Producer(b);
        new Consumer(b);
        System.out.println("Press Control-C to stop.");
    }
}