package com.stan.springbootcourse.corejava.part3;

import java.time.Duration;
import java.util.concurrent.*;

public class ExecutorWithTimeout {

    private static final ExecutorService EXECUTOR =
        Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static String getName(String name){
        return name;
    }

//    public static <T> T callWithTimeout(Callable<T> callable, Duration timeout) throws Exception {
//        Future<T> future = EXECUTOR.submit(callable);
//        try {
//            return future.get(timeout.toMillis(), TimeUnit.MILLISECONDS);
//        }finally {
//            EXECUTOR.shutdown();
//        }
//    }

    public static <T> T callWithTimeout(Callable<T> task, Duration timeout)
        throws TimeoutException, ExecutionException, InterruptedException {

        Future<T> future = EXECUTOR.submit(task);
        try {
            return future.get(timeout.toMillis(), TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            future.cancel(true); // stop task on timeout
            throw e;
        } catch (InterruptedException e) {
            future.cancel(true);
            Thread.currentThread().interrupt(); // restore interrupt
            throw e;
        }
    }

    public static void shutdown() {
        EXECUTOR.shutdown();
    }

    public static void main(String[] args) {
        try {
            String myName = callWithTimeout(
                () -> getName("Chidozie"),
                Duration.ofSeconds(2)
            );
            System.out.println("Your name is " + myName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }


}
