package be.intecbrussel.demo;

public class DaemonThreadDemo {
    public static void main(String[] args) {
//        NoDaemonThreads();
        DaemonThread();
    }

    private static void NoDaemonThreads(){
        Thread thread = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                System.out.println("Hello");
            }
        });
        thread.start();

    }

    private static void DaemonThread() {
        Thread thread = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                System.out.println("Hello");
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}
