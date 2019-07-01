package task1;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        ExecutorService executor1 = Executors.newFixedThreadPool(3);
        ExecutorService executor2 = Executors.newFixedThreadPool(3);
        ExecutorService executor3 = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 100; i++) {
            switch (i % 3) {
                case 0:
                    int finalI = i;
                    Future<?> result = executor1.submit(() -> System.out.println(finalI));

                    try {
                        result.get();
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                    break;
                case 1:
                    finalI = i;
                    result = executor2.submit(() -> System.out.println(finalI));

                    try {
                        result.get();
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    finalI = i;
                    result = executor3.submit(() -> System.out.println(finalI));

                    try {
                        result.get();
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }
        executor1.shutdown();
        executor2.shutdown();
        executor3.shutdown();
    }
}