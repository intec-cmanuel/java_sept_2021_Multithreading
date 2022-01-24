package be.intecbrussel.demo;

public class ThreadDemo {
    public static void main(String[] args) {

        CharacterThread potatoThread = new CharacterThread(100, "Potato");
        CharacterThread sushiThread = new CharacterThread(100, "Sushi");

        CharacterRunable characterRunable = new CharacterRunable(100, "Shoe");
        Thread shoeThread = new Thread(characterRunable);

        Thread lambdaThread = new Thread(() -> print(100, "Lambda"));

        System.out.println(sushiThread.getState());

        potatoThread.start();
        sushiThread.start();
        shoeThread.start();
        lambdaThread.start();

        System.out.println(sushiThread.getState());


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(sushiThread.getState());
        // sushiThread.start();

//        for(int i = 0; i < 100; i++) {
//            System.out.println(i + " - " + "Carrot");
//        }
    }

    private static void print(int amount, String textToPrint) {
        for (int i = 0; i < amount; i++) {
            System.out.println(i + " - " + textToPrint);
        }
    }
}


























