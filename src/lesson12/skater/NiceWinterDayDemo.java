package lesson12.skater;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class NiceWinterDayDemo {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(4);
        System.out.println("Good morning everyone we are opened!!!");

        final SkatingRink skatingRink = new SchoolSkatingRink();

        List<Future<String>> futureList = new ArrayList();
        Random random = new Random();

        for (int i = 0; i < 10; ++i) {
            final Skater skater = new Skater("Skater " + i);

            Future<String> future = executor.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {

                    Skates skates = skatingRink.getSkates(skater);
                    sleep(random.nextInt(7000));
                    skatingRink.returnSkates(skates, skater);

                    return skater.getName() + " return skate";
                }
            });

            futureList.add(future);
        }
        for (Future<String> fut : futureList) {
            try {
                fut.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        System.out.println("Goodbye!");
    }

    private static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

