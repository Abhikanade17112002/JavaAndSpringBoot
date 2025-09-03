package com.example;

//import com.example.Student.Student;
//import com.example.constructorbaseddependencyinjection.Student;
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


        ApplicationContext context = new ClassPathXmlApplicationContext("applicationsetterbasedinstattionContext.xml") ;

        Student student = (Student)context.getBean("student") ;
        System.out.println(student);

    }
}
