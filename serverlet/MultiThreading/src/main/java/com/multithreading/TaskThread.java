package com.multithreading;

public class TaskThread implements Runnable {
    ClassWithMonitorLock obj ;

    public TaskThread( ClassWithMonitorLock obj ){
        this.obj = obj ;
    }
    @Override
    public void run(){

    }
}
