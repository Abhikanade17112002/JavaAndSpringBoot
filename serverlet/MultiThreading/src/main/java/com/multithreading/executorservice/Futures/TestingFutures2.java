package com.multithreading.executorservice.Futures;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestingFutures2 {
    public static void main(String[] args) {
        ExecutorService service = new ThreadPoolExecutor(
                2, 5, 5, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(5), new CustomThreadFactory(),
                new CustomTaskRejectionHandler()
        );
        List<Integer> myList = new ArrayList<>();
        Runnable runnable = () -> {
            try {
                Thread.sleep(11000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            myList.add(100);
            System.out.println("Modification Successfull");
        };

        Future<List<Integer>> futureObj = service.submit(runnable, myList);

        try {
//            List<Integer> modifiedList = futureObj.get( );
//            System.out.println("Size ==> " + modifiedList.size());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


        service.shutdown();


//        try {
//            if( !service.awaitTermination(10000 , TimeUnit.MILLISECONDS) ){
//                System.out.println("Inside Forced");
//                service.shutdownNow() ;
//            }
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//

    }
}
