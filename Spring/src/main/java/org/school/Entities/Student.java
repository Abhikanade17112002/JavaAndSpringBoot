package org.school.Entities;
public class Student {

    private  int age ;
    private Computer computer ;

    public Student() {
        System.out.println("Created");
    }

    public Student( int age , Computer computer ){
        this.age = age ;
        this.computer = computer;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("The Setter Is Called SETTER INJECTION ");
        this.age = age;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }


    public void getInfo(){
        System.out.println("Hello I Am A Student Of Age "+ this.age  );
        computer.compile();
    }
}
