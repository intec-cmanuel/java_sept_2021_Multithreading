package be.intecbrussel.demo.potatoes;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class PotatoStock {
    private int amountOfPotatoesPeeled = 0;
    private List<Potato> potatoes = Collections.synchronizedList(new ArrayList<>());

    private final Object hasUnpeeledMonitorObject = new Object();

    public List<Potato> getPotatoes() {
        return potatoes;
    }

    public void peelPotato() {
        Potato potato;
            potato = potatoes.remove(0);

        if (!potato.isPeeled()) {
            potato.peel();
            amountOfPotatoesPeeled++;

            potatoes.add(potato);

        } else {
            potatoes.add(potato);

            synchronized (hasUnpeeledMonitorObject) {
                try {
                    System.out.printf("%s: work is done. Time for a break%n", Thread.currentThread().getName());
                    hasUnpeeledMonitorObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void addPotatoes(int amount) {
        for (int i = 0; i < amount; i++) {
            potatoes.add(0, new Potato());

        }

        System.out.println("New potatoes arrived, back to work");

        synchronized (hasUnpeeledMonitorObject) {
            hasUnpeeledMonitorObject.notifyAll();
        }
    }

    public int getAmountOfPeeledPotatoes() {
        return amountOfPotatoesPeeled;
    }
}





















