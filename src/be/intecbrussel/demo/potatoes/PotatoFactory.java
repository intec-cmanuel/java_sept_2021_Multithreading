package be.intecbrussel.demo.potatoes;

import java.util.Scanner;

public class PotatoFactory {
    public void runFactory() {
        PotatoStock potatoStock = new PotatoStock();
        potatoStock.addPotatoes(100);

       PotatoMonitorThread pM = new PotatoMonitorThread(potatoStock);
       pM.start();

       PotatoPeelingThread jan = new PotatoPeelingThread(potatoStock);
       pM.setName("Jan");
       jan.start();

       PotatoPeelingThread nazif = new PotatoPeelingThread(potatoStock);
       pM.setName("Nazif");
       nazif.start();

       allowTheAddingOfPotatoes(potatoStock);
    }

    private void allowTheAddingOfPotatoes(PotatoStock potatoStock) {
        Scanner scanner = new Scanner(System.in);
        int userinput;
        while(true) {
            userinput = scanner.nextInt();

            if (userinput == -1) {
                break;
            }

            if (userinput > 0) {
                potatoStock.addPotatoes(userinput);
            }
        }
    }
}
