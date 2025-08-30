package com.multithreading.producerconsumer;

public class SharedResource {

    private boolean isDataAvailable  ;

    public SharedResource( boolean isDataAvailable ){
        this.isDataAvailable = isDataAvailable ;
    }


    public synchronized void produceItem(){

        System.out.println("Thread ==> " + Thread.currentThread().getName() + " Inside Produce Item Methode And Producing The Item ");
        this.isDataAvailable = true ;
        System.out.println("Thread ==> " + Thread.currentThread().getName() + " Completed Producing Thread ");
        System.out.println("Thread ==> " + Thread.currentThread().getName() + " Notifying The Availabilty Of Data");
        notifyAll();

    }

    public synchronized void  consumeItem(){
        System.out.println("Thread ==> " + Thread.currentThread().getName() + " Inside The Consume Item Methode");

        while ( !this.isDataAvailable ){
            try {
                System.out.println("Thread ==> " + Thread.currentThread().getName() + " Waiting For The Data To Be Available ");
                wait();


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread ==> " + Thread.currentThread().getName() + " Wait Completed . Comsuming The Available Data ");
        this.isDataAvailable = false ;
    }
}
