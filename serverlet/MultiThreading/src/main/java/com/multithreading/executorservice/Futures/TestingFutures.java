package com.multithreading.executorservice.Futures;

import java.util.concurrent.*;

class CustomThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r) ;
        thread.setPriority(Thread.NORM_PRIORITY);
        return  thread ;
    }
}


class CustomTaskRejectionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task Rejected ==> " + r.toString());
    }
}
public class TestingFutures {
    public static void main(String[] args) {
        ExecutorService service = new ThreadPoolExecutor(
                2 , 5 , 5 , TimeUnit.MINUTES ,
                new ArrayBlockingQueue<>(5) , new CustomThreadFactory() ,
                new CustomTaskRejectionHandler()
        ) ;

        Runnable  runnable = ()->{
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ;
            System.out.println("Task");
        } ;


        Future<?> futureObj = service.submit(runnable) ;

        try{

            futureObj.get(3000 , TimeUnit.MILLISECONDS ) ;
            System.out.println("Is Task Done After 3 Sec ==> " + futureObj.isDone());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try{

            futureObj.get() ;
            System.out.println("Is Task Done  ==> " + futureObj.isDone());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        System.out.println(futureObj.isCancelled());









    }
}
