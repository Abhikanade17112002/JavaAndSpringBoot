package com.login.doa;

import java.sql.*;
import java.util.Collection;

public class UserDOA {
    private final String url = "jdbc:mysql://localhost:3306/school" ;
    private final String username = "root" ;
    private final String password = "Encora@12345" ;

    public boolean check(String user, String pass) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver

            Connection connection = DriverManager.getConnection(this.url, this.username, this.password);
            String query = "SELECT * FROM student WHERE username=? AND password=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            return rs.next(); // returns true if record exists
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
