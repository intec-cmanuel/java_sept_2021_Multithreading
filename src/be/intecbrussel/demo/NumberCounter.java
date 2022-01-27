package be.intecbrussel.demo;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class NumberCounter {
    private AtomicInteger counter = new AtomicInteger();
    private static int counter2;
    private final Object monitorObject = new Object();
    private final Object secondMonitorObject = new Object();

    public void incrementBothCounters() {
        synchronized (monitorObject) {
//            counter++;

            synchronized (secondMonitorObject) {
                counter2++;
            }
        }

    }

    public void decrementBothCounters() {
        synchronized (monitorObject) {
//            counter--;

            synchronized (secondMonitorObject) {
                counter2--;
            }
        }


    }

    public void increment() {
            counter.incrementAndGet();

    }

    public void decrement() {
        synchronized (monitorObject) {
//            counter--;
        }
    }

    @Override
    public String toString() {
        return "counter1 : " + counter + " | counter2 : " + counter2;
    }
}


















