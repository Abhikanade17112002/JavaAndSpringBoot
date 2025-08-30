package com.multithreading.executorservice.threadpoolexecutor;

import java.util.concurrent.*;

public class CompleteableFutureTesting {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = new ThreadPoolExecutor( 3 , 5 , 5 , TimeUnit.MINUTES ,
               new ArrayBlockingQueue<>(5) , new CustomThreadFactory() , new CustomTaskRejectionHandler() ) ;

        CompletableFuture<String> result1 = CompletableFuture.supplyAsync(()->{
            return "Abhishek" ;
        } , service ) ;


        CompletableFuture<String> result2 = result1.thenApply((String str )->{
            return str + " Rangnath " ;
        }) ;

        CompletableFuture<String> result3 = result2.thenApplyAsync(( String str) ->{

            return str + " Kanade " ;
        }).thenComposeAsync(( String str )->{
            return CompletableFuture.supplyAsync(()->str)
                    .thenApply((String str2)-> str2 + " I Am ") ;
        } , service) ;

        System.out.println( result3.get() );


        CompletableFuture<String> finalCombination = result1.thenCombineAsync(result2,( String str1 , String str2 )->{
            return str1 + str2 ;
        } , service) ;

        System.out.println("Final  ==> " + finalCombination.get())
        ;


        service.shutdown();



    }
}
