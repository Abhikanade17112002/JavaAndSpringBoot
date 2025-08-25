package org.school;

import org.school.Entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {

        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml") ;

        Student student = (Student) context.getBean("Student");
//        Student student1 = (Student) context.getBean("Student");

//        student.info();

//        System.out.println(student.equals(student1));
//        System.out.println(student.getAge() + " " + student.getLaptop());
        student.getInfo();

    }
}
