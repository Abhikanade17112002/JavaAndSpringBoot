<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Student List</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 p-10">
  <div class="max-w-4xl mx-auto bg-white shadow-lg rounded-lg p-6">
    <h2 class="text-3xl font-bold text-blue-600 mb-6 text-center">📚 Student List</h2>
    <%
      String url = "jdbc:mysql://localhost:3306/school";
      String username = "root";
      String password = "Encora@12345";

      try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection connection = DriverManager.getConnection(url, username, password);

          String query = "SELECT * FROM student";
          Statement statement = connection.createStatement();
          ResultSet rs = statement.executeQuery(query);
    %>
    <table class="min-w-full table-auto border border-gray-300 text-left">
      <thead class="bg-blue-100">
        <tr>
          <th class="border px-4 py-2">Name</th>
          <th class="border px-4 py-2">Age</th>
          <th class="border px-4 py-2">Email</th>
        </tr>
      </thead>
      <tbody>
        <%
          while (rs.next()) {
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String email = rs.getString("email");
        %>
        <tr class="hover:bg-gray-50">
          <td class="border px-4 py-2"><%= name %></td>
          <td class="border px-4 py-2"><%= age %></td>
          <td class="border px-4 py-2"><%= email %></td>
        </tr>
        <%
          }
          connection.close();
        %>
      </tbody>
    </table>
    <%
      } catch (Exception e) {
    %>
    <p class="text-red-600 text-center mt-4">❌ Error: <%= e.getMessage() %></p>
    <%
      }
    %>
  </div>
</body>
</html>
