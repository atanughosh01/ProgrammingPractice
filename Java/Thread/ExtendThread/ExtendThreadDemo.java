// create a second thread
class NewThread extends Thread {

    NewThread() {
        // create a new, second thread
        super("Demo Thread");
        System.out.println("Child Thread : " + this);
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

class ExtendThreadDemo {
    public static void main(String[] args) {
        NewThread nt = new NewThread(); // create a new thread

        // Thread t = new Thread(nt);
        nt.start(); // start the new thread

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread : " + i);
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main Thread Interruppted");
        }
        System.out.println("Exiting Main Thread");
    }
}