package be.intecbrussel.demo;

public class TooManyThreadsApp {
    public static void main(String[] args) {

        while(true) {
            Thread thread = new Thread(() -> {
                for (int a = 0; a < 3000000; a++) {
                    for (int b = 0; b < 3000000; b++) {
                        System.out.println("hello " + Thread.currentThread().getName());
                    }
                }
            });
            thread.start();
        }
    }
}
