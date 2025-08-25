package com.multithreading.producerconsumer;

public class ProducerThread extends Thread  {
    private SharedResource sharedResource ;

    public ProducerThread( SharedResource sharedResource ){
        this.sharedResource = sharedResource ;
    }


    @Override
    public void run(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sharedResource.produceItem();
    }
}
