<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.studentapp.model.Student, com.studentapp.doa.StudentDOA" %>
<%
    // Get student id from request
    String username = request.getParameter("username");

    Student student = null;

        StudentDOA dao = new StudentDOA();
        student = dao.getStudentWithUserName(username);   // You must have this method in StudentDOA

    if (student == null) {
        response.sendRedirect("/welcome.jsp"); // Redirect if no student found
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Student</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen flex items-center justify-center">
<div class="bg-white shadow-lg rounded-lg p-8 w-full max-w-lg">
    <h2 class="text-2xl font-bold mb-6 text-center text-blue-600">Edit Student</h2>

    <form action="/updatestudent" method="post" class="space-y-4">
        <!-- Hidden ID -->
        <input type="hidden" name="id" value="<%= student.getId() %>"/>

        <!-- Username -->
        <div>
            <label class="block text-gray-700">Username</label>
            <input type="text" name="userName" value="<%= student.getUserName() %>"
                   class="w-full border rounded p-2" required/>
        </div>

        <!-- First Name -->
        <div>
            <label class="block text-gray-700">First Name</label>
            <input type="text" name="firstName" value="<%= student.getFirstName() %>"
                   class="w-full border rounded p-2" required/>
        </div>

        <!-- Last Name -->
        <div>
            <label class="block text-gray-700">Last Name</label>
            <input type="text" name="lastName" value="<%= student.getLastName() %>"
                   class="w-full border rounded p-2" required/>
        </div>

        <!-- Age -->
        <div>
            <label class="block text-gray-700">Age</label>
            <input type="number" name="age" value="<%= student.getAge() %>"
                   class="w-full border rounded p-2" required/>
        </div>

        <!-- Gender -->
        <div>
            <label class="block text-gray-700">Gender</label>
            <select name="gender" class="w-full border rounded p-2">
                <option value="Male" <%= "Male".equals(student.getGender()) ? "selected" : "" %>>Male</option>
                <option value="Female" <%= "Female".equals(student.getGender()) ? "selected" : "" %>>Female</option>
                <option value="Other" <%= "Other".equals(student.getGender()) ? "selected" : "" %>>Other</option>
            </select>
        </div>

        <!-- Email -->
        <div>
            <label class="block text-gray-700">Email</label>
            <input type="email" name="email" value="<%= student.getEmail() %>"
                   class="w-full border rounded p-2" required/>
        </div>

        <!-- Phone -->
        <div>
            <label class="block text-gray-700">Phone</label>
            <input type="text" name="phone" value="<%= student.getPhone() %>"
                   class="w-full border rounded p-2" required/>
        </div>

        <!-- Password -->
        <div>
            <label class="block text-gray-700">Password</label>
            <input type="password" name="password" value="<%= student.getPassword() %>"
                   class="w-full border rounded p-2" required/>
        </div>

        <!-- Submit -->
        <div class="flex justify-between">
            <a href="/welcome.jsp" class="bg-gray-400 text-white px-4 py-2 rounded hover:bg-gray-500">Cancel</a>
            <button type="submit" class="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700">
                Update Student
            </button>
        </div>
    </form>
</div>
</body>
</html>
