package org.example;

import org.example.sessionfactory.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Queue;

public class StudentService {

    SessionFactory sessionFactory = HibernateUtility.getSessionFactory() ;

    public void saveStudent( Student student ){

        try(Session session = sessionFactory.openSession()){

            Transaction transaction = session.beginTransaction() ;

            session.persist(student);

            transaction.commit();

            System.out.println("Saved Student Succesfully ");
        }
        catch (Exception e){
            System.out.println("Save  Student "+e.getMessage());
        }
        finally {
        return;
        }
    }


    public Student getStudentById( long Id ){

        try(Session session = sessionFactory.openSession() ){

            Student retrivedStudent = session.find(Student.class , Id);

             return retrivedStudent ;

        }
        catch (Exception e){
            System.out.println("Get Student By Id "+ e.getMessage());
            return null ;
        }
    }


    public Student updateStudentById( Student newStudent , long Id ){
        Student updatedStudent = null ;
        try( Session session = sessionFactory.openSession() ){
            Transaction transaction = session.beginTransaction() ;
            Student oldStudent = session.find(Student.class , Id) ;
            System.out.println(newStudent.getStudentName()+" "+newStudent.getStudentCollege());
            oldStudent.setStudentName(newStudent.getStudentName());
            oldStudent.setStudentCollege(newStudent.getStudentCollege());
            updatedStudent = session.merge(oldStudent);
            transaction.commit();

        }
        catch (Exception e){
            System.out.println("Update Student "+e.getMessage());
        }
        finally {
            return updatedStudent ;
        }
    }


    public void deleteStudentById( long Id ){

        try( Session session = sessionFactory.openSession() ){
            Transaction transaction = session.beginTransaction() ;
            Student student = session.find(Student.class , Id ) ;
            session.remove(student);
            transaction.commit();
        }
        catch (Exception e){
            System.out.println("Delete Student "+e.getMessage());
        }


    }

     //    Hibernate Query Langauge ( HQL ) -> database independent query

    public List<Student> getAllStudentsUsingHql(){


        try( Session session = sessionFactory.openSession()){
            String getHQL = "FROM Student";

            Query<Student> query = session.createQuery( getHQL , Student.class ) ;

            return query.list() ;



        } catch (Exception e) {
            System.out.println("Get All Students HQL "+e.getMessage());
            return null;
        }

    }


    public Student getStudentByNameHQL( String name ){
        try( Session session = sessionFactory.openSession()){
            String getStudentByNameHql = "FROM Student WHERE studentName = ?";
            Query<Student> query = session.createQuery(getStudentByNameHql,Student.class) ;
            query.setParameter(1,name) ;
            return query.uniqueResult() ;

        } catch (Exception e) {
            System.out.println("Get Student By Name " + e.getMessage() );
            return null ;
        }
    }



//    PGINATION HQL Query

    public List<Student> getPaginatedStudents( int pageNo , int pageSize ){
        try(Session session = sessionFactory.openSession()){

            String paginatedQuery = "FROM Student" ;

            Query<Student> query = session.createQuery(paginatedQuery,Student.class);
            query.setFirstResult((pageNo-1)*pageSize);
            query.setMaxResults(pageSize);

            return query.list() ;


        }
        catch (Exception e){
            System.out.println("Get PaginatedStudents "+ e.getMessage());
            return null ;
        }
    }



}
