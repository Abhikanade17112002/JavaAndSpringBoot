package com.multithreading.producerconsumer2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SharedResource {

    private Queue<Integer> queue ;

    private int bufferSize ;

    public SharedResource(int bufferSize ){
        this.queue = new LinkedList<>() ;
        this.bufferSize = bufferSize ;
    }


    public synchronized void produceItem( int i ){

        while( this.queue.size() == this.bufferSize ){
            try{
                System.out.println("Thread ==> " + Thread.currentThread().getName() + " Inside Produce Methode And Waiting For Consumer To Consume .");
                wait();
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        System.out.println("Thread ==> " + Thread.currentThread().getName() + " Out Of The waiting And Producing The Item ." + " ==> " + i);
        queue.add(i) ;
        System.out.println("Thread ==> " + Thread.currentThread().getName() + " Production Succesfull . Notifying Consumer Thread ");
        notify();
    }

    public synchronized int consumeItem(){
        while( queue.isEmpty() ){
            try {
                System.out.println("Thread ==> " + Thread.currentThread().getName() + " Inside Consume Methode And Waiting For Producer To Produce .");
                wait();
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }

        }
        System.out.println("Thread ==> " + Thread.currentThread().getName() + " Out Of The waiting And Consuming The Item ." );
        int x = queue.poll() ;
        System.out.println("Thread ==> " + Thread.currentThread().getName() + " Consumption of [ "+ x +" ] Succesfull . Notifying Producer Thread ");
        notify();
        return x ;
    }
}
