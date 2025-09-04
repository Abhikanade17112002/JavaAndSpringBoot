package com.example.loosecouplingconstructordependecyinjection;

public abstract class Animal {
   public int legs ;
   public String type ;


   public abstract String sound() ;

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "legs=" + legs +
                ", type='" + type + '\'' +
                '}';
    }
}
