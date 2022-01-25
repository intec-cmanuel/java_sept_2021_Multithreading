package be.intecbrussel.demo;

public class SleepThread extends Thread {
    @Override
    public void run(){
        int counter = 0;

        while (true) {
            System.out.println("Hello " + counter++);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("sleep thread woke up");
            }
        }
    }

}
