package be.intecbrussel.demo;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ThreadDurationApp {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {for(int i = 0; i < 1000000; i++) System.out.println("hello");});

        LocalTime beforeRunning;
        LocalTime afterRunning;

        beforeRunning = LocalTime.now();
        thread.start();

        while(thread.getState() != Thread.State.TERMINATED){
        }

        afterRunning = LocalTime.now();

        System.out.println(ChronoUnit.SECONDS.between(beforeRunning, afterRunning) + " seconds have past");
    }
}
