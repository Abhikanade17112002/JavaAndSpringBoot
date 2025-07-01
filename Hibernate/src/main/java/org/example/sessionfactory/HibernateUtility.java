package org.example.sessionfactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

    private static SessionFactory sessionFactory ;

    static{
        try{
            if( sessionFactory == null ){
                sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Something went wrong in SESSION FACTORY creation ==> " + e.getMessage());
        }
    }



    public static SessionFactory getSessionFactory(){
        return sessionFactory ;
    }
}
