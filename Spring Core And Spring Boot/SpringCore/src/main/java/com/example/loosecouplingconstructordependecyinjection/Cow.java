package com.example.loosecouplingconstructordependecyinjection;

public class Cow extends Animal{

    public  int legs  ;
    public String sound() {
        return "Cow ==> Mhaaaa Mhaaaaa" ;
    }

    @Override
    public String toString() {
        return "Cow{" +
                "legs=" + legs +
                ", type='" + type + '\'' +
                '}';
    }
}
