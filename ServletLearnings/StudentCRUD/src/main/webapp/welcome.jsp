<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.studentapp.model.Student, com.studentapp.doa.StudentDOA" %>
<%
    // Authentication check
    HttpSession sessionUser = request.getSession();
    boolean isAuthenticated = (sessionUser != null && sessionUser.getAttribute("student") != null);

    Student loggedInStudent = isAuthenticated ? (Student) sessionUser.getAttribute("student") : null;
    String username = isAuthenticated ? loggedInStudent.getUserName() : "Guest";

    // Fetch all students from database
    StudentDOA dao = new StudentDOA();
    List<Student> students = dao.getStudents();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome - Student Portal</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen">
    <!-- Navbar -->
    <nav class="bg-blue-600 p-4 text-white flex justify-between items-center">
        <h1 class="text-xl font-bold">Student Portal</h1>
        <div class="flex items-center gap-6">
            <span>Hello, <strong><%= username %></strong></span>
            <% if (isAuthenticated) { %>
                <a href="/logout" class="bg-red-500 px-3 py-1 rounded-lg hover:bg-red-600">Logout</a>
            <% } else { %>
                <a href="signin.jsp" class="bg-green-500 px-3 py-1 rounded-lg hover:bg-green-600">Login</a>
            <% } %>
        </div>
    </nav>

    <!-- Students List -->
    <div class="max-w-5xl mx-auto mt-8">
        <div class="flex justify-between items-center mb-6">
            <h2 class="text-2xl font-semibold text-gray-700">All Students</h2>
            <% if (isAuthenticated) { %>
                <a href="/addstudent.jsp"
                   class="bg-green-600 text-white px-4 py-2 rounded-lg hover:bg-green-700">
                   + Add Student
                </a>
            <% } %>
        </div>

        <div class="overflow-x-auto bg-white shadow-md rounded-lg">
            <table class="min-w-full text-left border border-gray-200">
                <thead class="bg-gray-100 text-gray-700">
                    <tr>
                        <th class="px-4 py-2 border">First Name</th>
                        <th class="px-4 py-2 border">Last Name</th>
                        <th class="px-4 py-2 border">Age</th>
                        <th class="px-4 py-2 border">Email</th>
                        <th class="px-4 py-2 border">Gender</th>
                        <th class="px-4 py-2 border">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <% for(Student s : students) { %>
                        <tr class="hover:bg-gray-50">
                            <td class="px-4 py-2 border"><%= s.getFirstName() %></td>
                            <td class="px-4 py-2 border"><%= s.getLastName() %></td>
                            <td class="px-4 py-2 border"><%= s.getAge() %></td>
                            <td class="px-4 py-2 border"><%= s.getEmail() %></td>
                            <td class="px-4 py-2 border"><%= s.getGender() %></td>
                            <td class="px-4 py-2 border space-x-2">
                                <a href="/profile.jsp?username=<%= s.getUserName() %>"
                                   class="bg-blue-500 text-white px-3 py-1 rounded hover:bg-blue-600">
                                   Profile
                                </a>
                                <% if (isAuthenticated) { %>
                                    <a href="/editstudent.jsp?username=<%= s.getUserName() %>"
                                       class="bg-yellow-500 text-white px-3 py-1 rounded hover:bg-yellow-600">
                                       Edit
                                    </a>
                                    <a href="/deletestudent?username=<%= s.getUserName() %>"
                                       class="bg-red-500 text-white px-3 py-1 rounded hover:bg-red-600">
                                       Delete
                                    </a>
                                <% } %>
                            </td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
