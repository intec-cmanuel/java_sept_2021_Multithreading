package be.intecbrussel.demo;

public class CharacterThread extends Thread{
    private int amount;
    private String textToPrint;

    public CharacterThread(int amount, String textToPrint) {
        this.amount = amount;
        this.textToPrint = textToPrint;
    }

    @Override
    public void run() {
        for (int i = 0; i < amount; i++) {
            System.out.println(i + " - " + textToPrint);
        }
    }
}
