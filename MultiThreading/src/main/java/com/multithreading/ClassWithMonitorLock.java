package com.multithreading;

public class ClassWithMonitorLock  {


    public synchronized void task1(){
        try{

            System.out.println("Inside Task1");
            Thread.sleep(10000);
            System.out.println("Completed Task1");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void task2(){
        System.out.println("Inside Task2 But Outside Lock");

        synchronized (this){
            System.out.println("Inside Task2 Inside Lock");
        }
        System.out.println("Finished Task2");
    }


    public void task3(){
        System.out.println("Inside Task 3");
    }


}
