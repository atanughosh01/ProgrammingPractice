// Using join() to wait for child threads to finish

class NewThread implements Runnable {
    String name;
    Thread t;

    NewThread(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New Thread : " + t);
    }

    // this is entry point for thread
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + " : " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + " Interrupted");
        }
        System.out.println("Thread " + name + " Exiting___");
    }
}

class DemoJoinTest {
    public static void main(String[] args) {
        NewThread nt1 = new NewThread("1st_Thread");
        NewThread nt2 = new NewThread("2nd_Thread");
        NewThread nt3 = new NewThread("3rd_Thread");

        // start the child threads
        Thread t1 = new Thread(nt1);
        t1.start();
        t1.setName("1st_Thread");
        Thread t2 = new Thread(nt2);
        t2.start();
        t2.setName("2nd_Thread");
        Thread t3 = new Thread(nt3);
        t3.start();
        t3.setName("3rd_Thread");

        // check if threads are alive or not
        System.out.println(" ");
        System.out.println("Thread " + t1.getName() + " is Alive : " + t1.isAlive());
        System.out.println("Thread " + t2.getName() + " is Alive : " + t2.isAlive());
        System.out.println("Thread " + t3.getName() + " is Alive : " + t3.isAlive());
        System.out.println(" ");

        // wait for threads to finish
        try {
            System.out.println("Waiting for Threads to Finish");
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("Main Thread was Interrupted");
        }
            
        // check if threads are alive or not
        System.out.println(" ");
        System.out.println("Thread " + t1.getName() + " is Alive : " + t1.isAlive());
        System.out.println("Thread " + t2.getName() + " is Alive : " + t2.isAlive());
        System.out.println("Thread " + t3.getName() + " is Alive : " + t3.isAlive());
        System.out.println(" ");

        System.out.println("Main Threaad is Exiting_____");
    }
}
