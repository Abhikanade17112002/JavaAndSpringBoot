package org.jdbc.connecttodatabase;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectToDatabase {

    private final String url ;
    private final String username ;
    private final String passowrd ;

    public ConnectToDatabase(String url , String username, String passowrd) {
        this.url = url;
        this.username = username;
        this.passowrd = passowrd;
    }


    public Connection getDataBaseConnection(){

        try{
            Connection connection = DriverManager.getConnection(
                    this.url ,
                    this.username ,
                    this.passowrd
            ) ;

            return connection ;
        } catch (Exception e) {
            System.out.println("Database ERROR :: ==> " + e.getMessage());
        }

        return null ;

    }
}
