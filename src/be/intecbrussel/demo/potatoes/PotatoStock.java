package be.intecbrussel.demo.potatoes;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PotatoStock {
    private int amountOfPotatoesPeeled = 0;
    private List<Potato> potatoes = new LinkedList<>();
    private boolean hasUnpeeledPotatoes = false;

    private final Object potatoesMonitorObject = new Object();
    private final Object amountMonitorObject = new Object();
    private AtomicInteger hasUnpeeledMonitorObject = new AtomicInteger();

    public List<Potato> getPotatoes() {
        return potatoes;
    }

    public void peelPotato(){
        Potato potato;
        synchronized (potatoesMonitorObject) {
             potato = potatoes.remove(0);
        }

        if (!potato.isPeeled()){
            potato.peel();
            synchronized (amountMonitorObject) {
                amountOfPotatoesPeeled++;
            }

            synchronized (potatoesMonitorObject) {
                potatoes.add(potato);
            }

        } else {
            synchronized (potatoesMonitorObject) {
                potatoes.add(potato);
            }

            synchronized (hasUnpeeledMonitorObject) {
                hasUnpeeledPotatoes = false;
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
            synchronized (potatoesMonitorObject) {
                potatoes.add(0, new Potato());
            }

        }

        synchronized (hasUnpeeledMonitorObject) {
            hasUnpeeledPotatoes = true;
            System.out.println("New potatoes arrived, back to work");
            hasUnpeeledMonitorObject.notifyAll();
        }
    }

    public int getAmountOfPeeledPotatoes() {
        return amountOfPotatoesPeeled;
    }
}





















