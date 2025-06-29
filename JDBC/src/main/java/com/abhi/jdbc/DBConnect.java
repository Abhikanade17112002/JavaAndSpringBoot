package com.abhi.jdbc;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Scanner;


class DBconnect{

    public static void establishConnection(String URL , String USER , String PASSWORD){
        try{
            Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Connection To The DB Success");
        }
        catch (SQLException e){

            System.out.println("Failed Conecting To The DB ");

        }
    }


    public static void insertUser( String URL , String USER , String PASSWORD ,String name , String email ){


        try{
            Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Connection To The DB Success");

            String query = "INSERT INTO users (name,email) VALUES(?,?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1,name);
            statement.setString(2,email);

            int rowsAffected = statement.executeUpdate();
            System.out.println("No Of Affected Rows ==> "+rowsAffected);
        }
        catch (SQLException e){

            System.out.println("Failed Conecting To The DB ");

        }
    }
    public static void getAllUsers(String URL , String USER , String PASSWORD ){
        try{
            Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            String query = "SELECT * FROM users" ;
            Statement statement = connection.createStatement() ;

            ResultSet rs = statement.executeQuery(query);


            while( rs.next()){
                int ID = rs.getInt("id");
                String Name = rs.getString("name");
                String Email = rs.getString("email");
                System.out.println(ID + " | " + Name + " | " + Email);
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void updateUserEmail(int id, String newEmail) {
        String sql = "UPDATE users SET email = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newEmail);
            stmt.setInt(2, id);
            int rows = stmt.executeUpdate();
            System.out.println(rows + " user updated.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static  void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            System.out.println(rows + " user deleted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main( String [] args ){


        // Replace with your database name
        String url
                = "jdbc:mysql://localhost:3306/testDB";

        // Replace with your MySQL username
        String username = "root";

        // Replace with your MySQL password
        String password = "Pass@123";

//        establishConnection(url,username,password);
//        insertUser(url,username,password,"Abhishek Kanade","abhikanade301@gmail.com");
getAllUsers(url,username,password);



    }

}