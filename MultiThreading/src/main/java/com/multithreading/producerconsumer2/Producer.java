package com.multithreading.producerconsumer2;



public class Producer extends  Thread {

    private SharedResource sharedResource ;
    public Producer( SharedResource sharedResource ){
        this.sharedResource = sharedResource ;
    }


    @Override
    public void run(){
        for (int i = 1; i <= 10 ; i++) {
            sharedResource.produceItem(i);

        }
    }
}