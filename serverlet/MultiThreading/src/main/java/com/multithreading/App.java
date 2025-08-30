package com.multithreading;

import com.multithreading.runnableinterface.TestingRunnable;

public class App
{
    public static void main( String[] args )
    {
        System.out.println(" Thread == > " +  Thread.currentThread().getName() + " " + Thread.currentThread().getPriority() );
//        TestingRunnable test = new TestingRunnable() ;
//        new Thread(test).start();

        ClassWithMonitorLock classWithMonitorLock = new ClassWithMonitorLock() ;

        Thread t1 = new Thread(()-> classWithMonitorLock.task1() ) ;
        Thread t2 = new Thread(()-> classWithMonitorLock.task2() ) ;
        Thread t3 = new Thread(()-> classWithMonitorLock.task3() ) ;


        t1.start();
        t2.start();
        t3.start();

    }
}
