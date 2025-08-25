package com.multithreading.producerconsumer2;

import com.multithreading.producerconsumer.ProducerThread;

public class Test {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(3) ;

        Producer producer = new Producer(sharedResource) ;
        Consumer consumer = new Consumer(sharedResource) ;

        producer.start();
        consumer.start();
    }
}
