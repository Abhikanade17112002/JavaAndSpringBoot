package com.example.loosecouplingconstructordependecyinjection;

public class AnimalManager {
    private Animal animal ;

    public AnimalManager( Animal animal ){
        this.animal = animal ;
    }

    @Override
    public String toString() {
        return "AnimalManager{" +
                "animal=" + animal +
                 "sound=" +  animal.sound()  +
                '}';
    }
}
