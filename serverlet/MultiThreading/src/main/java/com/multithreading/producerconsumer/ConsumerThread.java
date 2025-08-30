package com.multithreading.producerconsumer;

public class ConsumerThread extends  Thread {

   private SharedResource sharedResource ;

   public ConsumerThread( SharedResource sharedResource ){
       this.sharedResource = sharedResource ;
   }


   @Override
    public void run(){
       sharedResource.consumeItem();
   }
}
