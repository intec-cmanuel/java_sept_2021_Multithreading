package be.intecbrussel.demo;

public class DeadlockApp {
    public static void main(String[] args) {
        NumberCounter numberCounter = new NumberCounter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++){
                numberCounter.incrementBothCounters();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++){
                numberCounter.decrementBothCounters();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(numberCounter);
    }
}
