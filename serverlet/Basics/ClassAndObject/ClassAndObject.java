package ClassAndObject;

class Person{

    int age ;
    String name ;

    public Person( int age , String name ){
        this.age = age ;
        this.name = name ;
    }

    public void displayInfo(){
        System.out.println(this.name + " " + this.age );
    }
}

public class ClassAndObject {
    public static void main(String[] args) {

        Person p1 = new Person(21 , "Abhishek") ;

        p1.displayInfo();
    }
}
