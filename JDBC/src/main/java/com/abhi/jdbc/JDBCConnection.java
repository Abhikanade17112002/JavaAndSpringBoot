package com.abhi.jdbc;
import java.sql.*;




public class JDBCConnection {
    public static void connectToDB( String URL , String USERNAME , String PASSWORD ){

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)){

            System.out.println("Connection To The Data Base Is Succesfull ");
            connection.close();

        } catch (SQLException e) {
            System.out.println("Connection To The Data Base Unsuccesfull " + e.getMessage() );
        }

    }


    public static void retriveUsers(String URL , String USERNAME , String PASSWORD){


        String retriveUsersQuery = "SELECT * FROM student" ;
        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(retriveUsersQuery)
        ){

            System.out.println("Users Retrival Succesfull");

            while( result.next() ){
                int userId = result.getInt("studentId");
                String name = result.getString("studentName");


                System.out.println(userId + " | " + name + " | " );

            }


            connection.close();

        } catch (SQLException e) {
            System.out.println("Connection To The Data Base Unsuccesfull " + e.getMessage() );
        }

    }

    public static void insertUsers(String URL , String USERNAME , String PASSWORD , String NAME  , String EMAIL ){
        String insertUserQuery = "INSERT INTO users (name,email) VALUES(?,?)" ;
        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD) ;
            PreparedStatement statement = connection.prepareStatement(insertUserQuery) ;
        ){


            statement.setString(1,NAME);
            statement.setString(2,EMAIL);

            int noOfRowsAffected = statement.executeUpdate();
            System.out.println("No Of Rows Affected ==> "+ noOfRowsAffected);
            connection.close();

        } catch (SQLException e) {
            System.out.println("Connection To The Data Base Unsuccesfull " + e.getMessage() );
        }

    }
    public static void updateUserEmail(String URL , String USERNAME , String PASSWORD , int  ID  , String UPDATEDEMAIL){
        String updatedUSerEmailQuery = "UPDATE users SET email = ? WHERE id = ?";
        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD) ;
            PreparedStatement statement = connection.prepareStatement(updatedUSerEmailQuery) ;
        ){


            statement.setString(1,UPDATEDEMAIL);
            statement.setString(2, String.valueOf(ID));

            int noOfRowsAffected = statement.executeUpdate();
            System.out.println("No Of Rows Affected ==> "+ noOfRowsAffected);
            connection.close();

        } catch (SQLException e) {
            System.out.println("Connection To The Data Base Unsuccesfull " + e.getMessage() );
        }
    }

    public static void deleteUserWithID(String URL , String USERNAME , String PASSWORD , int  ID ){
        String deleteUSerWithID = "DELETE FROM users WHERE id = ?";
        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD) ;
            PreparedStatement statement = connection.prepareStatement(deleteUSerWithID) ;
        ){


            statement.setString(1,String.valueOf(ID));


            int noOfRowsAffected = statement.executeUpdate();
            System.out.println("No Of Rows Affected ==> "+ noOfRowsAffected);
            connection.close();

        } catch (SQLException e) {
            System.out.println("Connection To The Data Base Unsuccesfull " + e.getMessage() );
        }
    }
    public static void main( String [] args ){
        String URL = "jdbc:mysql://localhost:3306/testDB";
        String USERNAME = "root";
        String PASSWORD = "Pass@123";

        connectToDB(URL,USERNAME,PASSWORD);
        insertUsers(URL,USERNAME,PASSWORD,"Suman Kanade" , "suman21@gmail.com");
        updateUserEmail(URL,USERNAME,PASSWORD,1,"abhishekrangnathkanade21@gmail.com");
        deleteUserWithID(URL,USERNAME,PASSWORD,2);

        retriveUsers(URL,USERNAME,PASSWORD);

    }
}
