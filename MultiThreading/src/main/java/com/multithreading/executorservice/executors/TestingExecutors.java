package com.multithreading.executorservice.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestingExecutors {

    public static void main( String [] args ){
       ExecutorService executorService =  Executors.newSingleThreadExecutor() ;

        List<Integer> myList = new ArrayList<>() ;

       Runnable runnable = ()->{
           System.out.println("Inside The Runnable Task ");
           System.out.println("Adding The Element ==> ");
           myList.add(10) ;
       } ;

       executorService.submit(runnable , myList) ;



       if( ! executorService.isShutdown() ){
           System.out.println("Shutting Down Force Fully The Service ");
           executorService.shutdownNow() ;
       }



    }
}
