package com.multithreading.executorservice.threadpoolexecutor;

import java.util.concurrent.*;


class CustomThreadFactory implements ThreadFactory{
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
public class TestingThreadPoolExecutor {
    public static void main(String[] args) {

        ExecutorService service = new ThreadPoolExecutor(
                2 , 5 , 5 , TimeUnit.MINUTES ,
                new ArrayBlockingQueue<>(5) , new CustomThreadFactory() ,
                new CustomTaskRejectionHandler()
        ) ;

        for( int i = 1 ; i <= 11 ; i++ ){

            int finalI = i;
            service.submit( () ->{


            System.out.println(" Task ==> " + finalI);


        }) ;

        }


//        if( ! service.isShutdown() ){
//            System.out.println("Force Full Shutdown ");
//            service.shutdownNow();
//        }

    }
}
