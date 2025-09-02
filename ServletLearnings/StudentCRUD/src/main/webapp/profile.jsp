<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.studentapp.model.Student, com.studentapp.doa.StudentDOA" %>
<%


    String username = (String) request.getParameter("username");

        // Create DAO object
        StudentDOA dao = new StudentDOA();

        // Correct usage: use 'dao', not 'doa'
        Student student = dao.getStudentWithUserName(username);


%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Profile</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen flex items-center justify-center p-4">

    <div class="bg-white shadow-xl rounded-3xl w-full max-w-md p-6 sm:p-8">
        <!-- Header -->
        <div class="flex flex-col items-center">
            <div class="w-24 h-24 bg-gray-300 rounded-full flex items-center justify-center text-gray-500 text-2xl mb-4">
                <!-- Placeholder for profile image -->
                <span><%= student.getFirstName().charAt(0) %></span>
            </div>
            <h2 class="text-2xl font-bold text-gray-800 mb-1 text-center">
                <%= student.getFirstName() %> <%= student.getLastName() %>
            </h2>
            <p class="text-gray-500 mb-4 text-center">@<%= student.getUserName() %></p>
        </div>

        <!-- Profile Details -->
        <div class="space-y-3">

            <div class="flex justify-between items-center">
                <span class="text-gray-600 font-medium">Age:</span>
                <span class="text-gray-800"><%= student.getAge() %></span>
            </div>
            <div class="flex justify-between items-center">
                <span class="text-gray-600 font-medium">Gender:</span>
                <span class="text-gray-800"><%= student.getGender() %></span>
            </div>
            <div class="flex justify-between items-center">
                <span class="text-gray-600 font-medium">Email:</span>
                <span class="text-gray-800 break-all"><%= student.getEmail() %></span>
            </div>
            <div class="flex justify-between items-center">
                <span class="text-gray-600 font-medium">Phone:</span>
                <span class="text-gray-800"><%= student.getPhone() %></span>
            </div>
        </div>

        <!-- Actions -->
        <div class="mt-6 flex flex-col sm:flex-row justify-between gap-3">
            <a href="/welcome.jsp"
               class="flex-1 text-center bg-gray-500 text-white px-4 py-2 rounded-lg hover:bg-gray-600 transition">
               Back
            </a>
            <a href="/editstudent.jsp?username=<%= student.getUserName() %>"
               class="flex-1 text-center bg-yellow-500 text-white px-4 py-2 rounded-lg hover:bg-yellow-600 transition">
               Edit Profile
            </a>
        </div>
    </div>

</body>
</html>
