package org.example;

import org.example.sessionfactory.HibernateUtility;
import org.hibernate.SessionFactory;

import java.util.List;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;


public class Main {
    public static void main(String[] args) {

        System.out.printf("Hello and welcome!");
        StudentService service = new StudentService();
        Student student1 = new Student();
        student1.setActive(true);
        student1.setStudentCollege("PCCOE Pune");
        student1.setPhone("9370820686");
        student1.setStudentName("Abhishek Kanade");

        Student student2 = new Student();
        student2.setActive(true);
        student2.setStudentCollege("PCCOE Ravet");
        student2.setPhone("9011486754");
        student2.setStudentName("Rutuja Rathod");
        Student student3 = new Student();
        student3.setActive(true);
        student3.setStudentCollege("PCCOE Nutan");
        student3.setPhone("9011486754");
        student3.setStudentName("Suman Kanade");

        Certificate certificate1 = new Certificate();
        certificate1.setCertificateName("Java1");
        certificate1.setStudent(student1);
        Certificate certificate2 = new Certificate();
        certificate2.setCertificateName("Java2");
        certificate2.setStudent(student1);
        Certificate certificate3 = new Certificate();
        certificate3.setCertificateName("Java3");
        certificate3.setStudent(student2);

        student1.getCertificates().add(certificate1);
        student1.getCertificates().add(certificate2);
        student2.getCertificates().add(certificate3);


//        service.saveStudent(student1);
//        service.saveStudent(student2);
//        service.saveStudent(student3);

//        System.out.println(service.getStudentById(1));

//        Student student = service.updateStudentById(student3,2);
//        service.deleteStudentById(2);

        List<Student> students = service.getPaginatedStudents(1,10);

       students.forEach((student)-> System.out.println(student.getStudentName()));






    }
}