public class JStackDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new Worker());
        thread.start();
    }

    static class Worker implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread run start");
            while (true) {
                System.out.println("Thread Name:" + Thread.currentThread().getName());
            }
        }
    }
}
