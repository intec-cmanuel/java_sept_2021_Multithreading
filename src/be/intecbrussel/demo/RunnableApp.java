package be.intecbrussel.demo;

public class RunnableApp {
    public static void main(String[] args) {
        while (true) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            new Thread(runnable).start();

        }
    }
}
