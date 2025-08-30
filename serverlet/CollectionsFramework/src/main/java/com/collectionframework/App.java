package com.collectionframework;

class Animal{
    public void sound(){
        System.out.println("Sound");
    }
}

class Dog extends Animal {
    public void sound(){
        System.out.println("Dog IS Barking");
    }
    public void walk(){
        System.out.println("Dog IS walking ");
    }
}
public class App 
{
    public static void main( String[] args )
    {
        Animal Dog = new Dog() ;
        Dog.sound();

    }
}
