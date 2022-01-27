package be.intecbrussel.demo.potatoes;

public class PotatoMonitorThread extends Thread{
    private PotatoStock potatoStock;
//    private Thread[] threads;

    public PotatoMonitorThread(PotatoStock potatoStock) {
        this.potatoStock = potatoStock;
    }

    public PotatoMonitorThread(PotatoStock potatoStock, PotatoPeelingThread... threads) {
        this.potatoStock = potatoStock;
//        this.threads = threads;
    }

    @Override
    public void run() {
        while (true) {

            displayInfo();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void displayInfo() {
        System.out.println("POTATOSTOCK INFO:");
        System.out.println("PEELED POTATOES: " + potatoStock.getAmountOfPeeledPotatoes());
        System.out.println("TOTAL POTATOES: " + potatoStock.getPotatoes().size());
        System.out.println();
    }
}
