package com.multithreading.producerconsumer;

public class Test {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(false) ;

        ProducerThread producerThread = new ProducerThread(sharedResource);
        ConsumerThread consumerThread = new ConsumerThread(sharedResource) ;

        producerThread.start();
        consumerThread.start();

    }
}
