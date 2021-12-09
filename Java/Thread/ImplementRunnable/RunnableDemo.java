// create a second thread
class NewThread implements Runnable {
    Thread t;

    NewThread() {
        // create a new, second thread
        Thread t = new Thread(this, "DemoThread");
        System.out.println("Child Thread : " + t);
    }

    // this is the entry point for the second thread
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child Thread : " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child Interruppted");
        }
        System.out.println("Exiting Child Thread");
    }
}

class RunnableDemo {
    public static void main(String[] args) {
        NewThread nt = new NewThread(); // create a new thread

        Thread t = new Thread(nt);
        t.start(); // start the new thread

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread : " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main Thread Interruppted");
        }
        System.out.println("Exiting Main Thread");
    }
}