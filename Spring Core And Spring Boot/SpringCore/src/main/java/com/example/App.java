package com.example;

//import com.example.Student.Student;
//import com.example.constructorbaseddependencyinjection.Student;
import com.example.loosecouplingconstructordependecyinjection.Animal;
import com.example.loosecouplingconstructordependecyinjection.AnimalManager;
import com.example.loosecouplingconstructordependecyinjection.Cat;
import com.example.loosecouplingconstructordependecyinjection.Dog;
import com.example.setterbaseddependencyinjection.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml") ;
//
//        Student student = (Student)context.getBean("student") ;
//        System.out.println(student);


//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationsetterbasedinstattionContext.xml") ;
//
//        Student student = (Student)context.getBean("student") ;
//        System.out.println(student);

//        Animal animal1 = new Cat();
//        Animal animal2 = new Dog() ;
//        animal1.setLegs(4);
//        animal1.setType("CAT");
//        animal2.setLegs(5);
//        animal2.setType("DOG");
//
//        System.out.println(animal1);
//        System.out.println(animal2);
//        Animal animal1 = new Cat();
//        animal1.setType("CAT");
//        animal1.setLegs(4);
//        AnimalManager manager1 = new AnimalManager( animal1 ) ;
//        System.out.println( manager1.toString() );

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationLooseCouplingContext.xml") ;

        AnimalManager catManager = (AnimalManager) context.getBean("catmanager");
        AnimalManager dogManager = (AnimalManager) context.getBean("dogmanager");
        AnimalManager cowManager = (AnimalManager) context.getBean("cowmanager");

        System.out.println();
        System.out.println(catManager );

        System.out.println();


        System.out.println();
        System.out.println(dogManager);
        System.out.println();

        System.out.println();
        System.out.println(cowManager);
        System.out.println();


    }
}
