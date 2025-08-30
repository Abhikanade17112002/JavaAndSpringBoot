package com.collectionframework.priorityqueueandcomparatorvscomparable;

import java.util.Arrays;
import java.util.Comparator;


class Car{
    String model ;
    String type ;

    public Car(String model, String type) {
        this.model = model;
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

class Bike  {
    String brand;
    String type;

    public Bike(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}

class BikeBrandComparator implements Comparator<Bike> {


    @Override
    public int compare(Bike o1, Bike o2) {
        return o2.getBrand().compareTo(o1.getBrand());
    }
}


class BikeTypeComparator implements Comparator<Bike> {


    @Override
    public int compare(Bike o1, Bike o2) {
        return o2.getType().compareTo(o1.getType());
    }
}
public class ComparatorVsComparable {
    public static void main(String[] args) {

//        int [] array = { 4 , 2 , 7 , 8 } ;
//
//        Arrays.sort(array , ( int  a , int b )-> a-b );

        Integer [] array = { 4 , 2 , 7 , 8 } ;

        Arrays.sort(array , ( Integer a , Integer b )-> a - b );

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }


        Car[] cars = new Car[10];

        cars[0] = new Car("Tesla Model S", "Electric");
        cars[1] = new Car("Ford Mustang", "Sports");
        cars[2] = new Car("Toyota Corolla", "Sedan");
        cars[3] = new Car("BMW X5", "SUV");
        cars[4] = new Car("Audi A4", "Sedan");
        cars[5] = new Car("Mercedes G-Class", "SUV");
        cars[6] = new Car("Porsche 911", "Sports");
        cars[7] = new Car("Honda Civic", "Sedan");
        cars[8] = new Car("Jeep Wrangler", "SUV");
        cars[9] = new Car("Nissan Leaf", "Electric");
        // Print all cars
        for (Car car : cars) {
            System.out.println(car);
        }


        Arrays.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.getModel().compareTo(o1.getModel()) ;
            }
        });
        // Print all cars

        System.out.println();
        System.out.println("After ==> ");
        for (Car car : cars) {
            System.out.println(car);
        }



                // Create 10 Bike objects
                Bike[] bikes = new Bike[10];

                bikes[0] = new Bike("Royal Enfield Classic 350", "Cruiser");
                bikes[1] = new Bike("Kawasaki Ninja 300", "Sports");
                bikes[2] = new Bike("Yamaha R15 V4", "Sports");
                bikes[3] = new Bike("Honda Activa", "Scooter");
                bikes[4] = new Bike("Bajaj Pulsar 220F", "Sports");
                bikes[5] = new Bike("Harley Davidson Street 750", "Cruiser");
                bikes[6] = new Bike("Suzuki Hayabusa", "Superbike");
                bikes[7] = new Bike("TVS Apache RTR 160", "Sports");
                bikes[8] = new Bike("Ducati Panigale V4", "Superbike");
                bikes[9] = new Bike("Hero Splendor Plus", "Commuter");

        System.out.println("Before Sorting Bikes ==> ");
                // Print all bikes
                for (Bike bike : bikes) {
                    System.out.println(bike);
                }
        System.out.println();
        System.out.println("After Sorting Based On Brand ==> ");
        for (Bike bike : bikes) {
            System.out.println(bike);
        }
        System.out.println();
        Arrays.sort(bikes , new BikeBrandComparator());
        System.out.println();
        System.out.println("After Sorting Based On Type ==> ");
        Arrays.sort(bikes , new BikeTypeComparator());
        for (Bike bike : bikes) {
            System.out.println(bike);
        }
        System.out.println();



    }
}
