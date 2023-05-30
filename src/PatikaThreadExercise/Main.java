package PatikaThreadExercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ThreadRace threadRace = new ThreadRace();

        ExecutorService executor = Executors.newFixedThreadPool(4); // 4 threadden oluşan bir thread havuzu

        for (int i = 0; i < 10000; i++) {
            executor.execute(threadRace);
        }

        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Genel çift liste\n" + threadRace.getEvenNumber());
        System.out.println("Genel tek liste\n" +threadRace.getOddNumbers());

    }

}
