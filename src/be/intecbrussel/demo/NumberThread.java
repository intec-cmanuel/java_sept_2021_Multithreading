package be.intecbrussel.demo;

public class NumberThread extends Thread{
    private NumberCounter numberCounter;
    private int amount;

    public NumberThread (NumberCounter numberCounter, int amount) {
        this.numberCounter = numberCounter;
        this.amount = amount;
    }

    @Override
    public void run() {
        for (int i = 0; i < amount; i++){
            numberCounter.decrement();
        }
    }
}
