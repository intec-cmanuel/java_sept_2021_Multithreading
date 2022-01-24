package be.intecbrussel.demo;

public class NumberDemo {
    public static void main(String[] args) {

        NumberCounter numberCounter = new NumberCounter();

        NumberThread numberThread = new NumberThread(numberCounter, 10000);
        NumberThread numberThread2 = new NumberThread(numberCounter, 10000);
        NumberThread numberThread3 = new NumberThread(numberCounter, 10000);

        numberThread.start();
        numberThread2.start();
        numberThread3.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(numberCounter);
    }
}
























