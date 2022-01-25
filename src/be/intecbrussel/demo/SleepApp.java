package be.intecbrussel.demo;

public class SleepApp {
    public static void main(String[] args) {
        SleepThread sleepThread = new SleepThread();
        sleepThread.start();
        while(true) {
            sleepThread.interrupt();
        }
    }
}
