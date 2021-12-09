// controlling the main thread
class ThreadDemo {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("Current Thread : " + t);
        System.out.println("Name of Current Thread : " + t.getName());

        // change name of the thread
        t.setName("MyThread");
        System.out.println("After name change : " + t);
        System.out.println("New Name is : " + t.getName());

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main Thread Interruppted");
        }

        System.out.println("Exiting Thread------------");
    }
}