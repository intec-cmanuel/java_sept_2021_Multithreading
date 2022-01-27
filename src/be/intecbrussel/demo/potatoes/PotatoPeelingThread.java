package be.intecbrussel.demo.potatoes;

public class PotatoPeelingThread extends Thread{
    private PotatoStock potatoStock;

    public PotatoPeelingThread(PotatoStock potatoStock) {
        this.potatoStock = potatoStock;
    }

    @Override
    public void run() {
        while (true) {
            potatoStock.peelPotato();

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
