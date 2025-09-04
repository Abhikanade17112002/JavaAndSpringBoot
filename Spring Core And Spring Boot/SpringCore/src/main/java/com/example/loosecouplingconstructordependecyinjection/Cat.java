package com.example.loosecouplingconstructordependecyinjection;

public class Cat extends Animal{
    @Override
    public String sound() {
        return "Cat ==> Meow Meow ";
    }

    public  void r(){

    }

    @Override
    public String toString() {
        return "Cat{" +
                "legs=" + legs +
                ", type='" + type + '\'' +
                '}';
    }
}
