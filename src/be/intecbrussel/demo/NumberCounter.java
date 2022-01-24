package be.intecbrussel.demo;

import java.util.Scanner;

public class NumberCounter {
    private static int counter;
    private Object monitorObject = new Object();

    public void increment() {
        synchronized (monitorObject) {
            counter++;
        }
    }

    public synchronized void decrement() {
            counter--;
    }

    @Override
    public String toString() {
        return "counter is at: " + counter;
    }
}


















