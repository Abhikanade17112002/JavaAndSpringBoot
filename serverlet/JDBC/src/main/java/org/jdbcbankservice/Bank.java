package org.jdbcbankservice;

import org.jdbc.connecttodatabase.ConnectToDatabase;

import java.sql.*;
import java.util.Scanner;

public class Bank {
    private final Connection connection ;

    public Bank(){
        String url = "jdbc:mysql://localhost:3306/BANK"; // db name = testdb
        String user = "root"; // your MySQL username
        String password = "Encora@12345";
        this.connection = new ConnectToDatabase(url,user,password).getDataBaseConnection();
    }


    public void getCustomers() throws SQLException {

        Statement statement = connection.createStatement() ;
        String getAllCustomers = "SELECT * FROM customers" ;


        ResultSet customers = statement.executeQuery(getAllCustomers) ;


        while( customers.next() ){

            int customerID      = customers.getInt("customer_id");
            String firstName    = customers.getString("first_name");
            String lastName     = customers.getString("last_name");
            String email        = customers.getString("email");
            String phone        = customers.getString("phone");
            String address      = customers.getString("address");
            Timestamp createdAt = customers.getTimestamp("created_at");

            // Print (or you can map into a POJO)
            System.out.println(customerID + " | "
                    + firstName + " " + lastName + " | "
                    + email + " | "
                    + phone + " | "
                    + address + " | "
                    + createdAt);
        }


    }



    public void getCustomerWithId( int cutomerId ) throws SQLException {

        String getCustomerWithId = "SELECT * FROM  customers WHERE customer_id = ? " ;
        PreparedStatement statement = connection.prepareStatement(getCustomerWithId);

        statement.setString(1,String.valueOf(cutomerId));

        ResultSet customerWithId = statement.executeQuery() ;

        while( customerWithId.next() ){

            int customerID      = customerWithId.getInt("customer_id");
            String firstName    = customerWithId.getString("first_name");
            String lastName     = customerWithId.getString("last_name");
            String email        = customerWithId.getString("email");
            String phone        = customerWithId.getString("phone");
            String address      = customerWithId.getString("address");
            Timestamp createdAt = customerWithId.getTimestamp("created_at");

            // Print (or you can map into a POJO)
            System.out.println(customerID + " | "
                    + firstName + " " + lastName + " | "
                    + email + " | "
                    + phone + " | "
                    + address + " | "
                    + createdAt);
        }



    }

    public void updateCustomerWithId( String firstName , String lastName , String email , int customerId ) throws SQLException {

        String updateCustomerQeuery = "UPDATE customers SET first_name = ? , last_name = ? , email = ? WHERE customer_id = ?" ;
        PreparedStatement statement = connection.prepareStatement(updateCustomerQeuery) ;
        statement.setString(1,firstName);
        statement.setString(2,lastName);
        statement.setString(3,email);
        statement.setInt(4,customerId);

        int noOfRowsAffected = statement.executeUpdate() ;

        if( noOfRowsAffected > 0 ){
            getCustomerWithId(customerId);
        }
        else {
            System.out.println("Something went wrong In Update Customer ");
        }

    }

    public void insertCustomerIntoDB(  ) throws SQLException{
       Scanner scan = new Scanner(System.in) ;
       String insertCustomerQeuery = "INSERT INTO customers(first_name,last_name,email,phone,address) VALUES(?,?,?,?,?)" ;
       PreparedStatement statement= connection.prepareStatement(insertCustomerQeuery);


        while( true ){


            System.out.print("Enter First Name ==> ");
            String firstName = scan.nextLine() ;
            System.out.print("Enter Last Name ==> ");
            String lastName = scan.nextLine() ;
            System.out.print("Enter Email ==> ");
            String email = scan.nextLine() ;
            System.out.print("Enter Phone ==> ");
            String phn = scan.nextLine() ;
            System.out.print("Enter Address ==> ");
            String address = scan.nextLine() ;

            statement.setString(1,firstName);
            statement.setString(2,lastName);
            statement.setString(3,email);
            statement.setString(4,phn);
            statement.setString(5,address);

            statement.addBatch();
            System.out.println("Want To Add More (Y/N) ==> ");
            String choice = scan.nextLine() ;

            if( choice.toUpperCase().equals("N") ){
                break;
            }

        }

        int noOfRowsAffected = 0 ;
        int [] result = statement.executeBatch();
        for (int i = 0; i < result.length; i++) {
             noOfRowsAffected += result[i] ;
        }
        System.out.println("Number Of Rows Affected ==> " + noOfRowsAffected);


    }


    public void performTransaction() throws SQLException {
        Scanner scan = new Scanner(System.in);

        String debitQuery = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
        String creditQuery = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";

        System.out.print("Enter Debit Account Number ==> ");
        String debitAccountNumber = scan.nextLine();
        System.out.print("Enter Debit Amount ==> ");
        double withdrawAmount = scan.nextDouble();
        scan.nextLine(); // consume newline
        System.out.print("Enter Credit Account Number ==> ");
        String creditAccountNumber = scan.nextLine();

        try {
            // start transaction
            connection.setAutoCommit(false);

            // 1. Check balance first
            if (!isSufficient(connection, withdrawAmount, debitAccountNumber)) {
                System.out.println("Transaction Failed: Insufficient balance.");
                connection.rollback();
                return;
            }

            // 2. Debit account
            try (PreparedStatement debitStmt = connection.prepareStatement(debitQuery)) {
                debitStmt.setDouble(1, withdrawAmount);
                debitStmt.setString(2, debitAccountNumber);
                debitStmt.executeUpdate();
            }

            // 3. Credit account
            try (PreparedStatement creditStmt = connection.prepareStatement(creditQuery)) {
                creditStmt.setDouble(1, withdrawAmount);
                creditStmt.setString(2, creditAccountNumber);
                creditStmt.executeUpdate();
            }

            // 4. Commit transaction
            connection.commit();
            System.out.println("Transaction Successful!");

        } catch (SQLException e) {
            connection.rollback();
            System.out.println("Transaction Failed: " + e.getMessage());
        } finally {
            connection.setAutoCommit(true); // restore auto-commit
        }
    }

    public boolean isSufficient(Connection connection, double withdrawAmount, String accountNumber) throws SQLException {
        String getBalanceQuery = "SELECT balance FROM accounts WHERE account_number = ?";
        try (PreparedStatement stmt = connection.prepareStatement(getBalanceQuery)) {
            stmt.setString(1, accountNumber);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    double balance = rs.getDouble("balance");
                    return balance >= withdrawAmount;
                }
            }
        }
        return false;
    }



}
