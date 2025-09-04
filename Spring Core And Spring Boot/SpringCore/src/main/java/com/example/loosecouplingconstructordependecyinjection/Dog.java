package com.example.loosecouplingconstructordependecyinjection;

public class Dog  extends Animal {
    public String sound() {
        return "Dog ==> Bhaaav Bhaaav" ;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "legs=" + legs +
                ", type='" + type + '\'' +
                '}';
    }
}
