package org.jdbc;

import org.jdbc.connecttodatabase.ConnectToDatabase;
import org.jdbcbankservice.Bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
     Bank bank = new Bank() ;
     bank.performTransaction();

    }
}
