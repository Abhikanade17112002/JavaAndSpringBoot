package com.multithreading.producerconsumer2;

public class Consumer  extends  Thread {

    private SharedResource sharedResource ;

    public Consumer( SharedResource sharedResource ){
        this.sharedResource = sharedResource ;
    }


    @Override
    public void run(){
        for (int i = 1; i <= 10 ; i++) {
            sharedResource.consumeItem();

        }


    }
}