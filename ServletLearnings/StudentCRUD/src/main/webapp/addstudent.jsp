<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.studentapp.model.Student" %>
<%
    // Optional: check if user is authenticated

    Student loggedInStudent = (Student) session.getAttribute("student");

    System.out.println("Student ==> " + loggedInStudent);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Student</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen flex items-center justify-center p-4">

<div class="bg-white shadow-lg rounded-2xl w-full max-w-md p-6 sm:p-8">
    <h2 class="text-2xl font-bold text-center text-gray-800 mb-6">Add New Student</h2>

     <form action="/addstudent" method="post" class="space-y-4">


            <!-- First Name -->
            <div>
                <label class="block text-sm font-medium text-gray-600">First Name</label>
                <input type="text" name="firstName" required
                       class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring focus:ring-green-400 focus:outline-none"/>
            </div>

            <!-- Last Name -->
            <div>
                <label class="block text-sm font-medium text-gray-600">Last Name</label>
                <input type="text" name="lastName" required
                       class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring focus:ring-green-400 focus:outline-none"/>
            </div>

            <!-- Age -->
            <div>
                <label class="block text-sm font-medium text-gray-600">Age</label>
                <input type="number" name="age" required min="1"
                       class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring focus:ring-green-400 focus:outline-none"/>
            </div>

            <!-- Gender -->
            <div>
                <label class="block text-sm font-medium text-gray-600">Gender</label>
                <select name="gender" required
                        class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring focus:ring-green-400 focus:outline-none">
                    <option value="">Select Gender</option>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                    <option value="Other">Other</option>
                </select>
            </div>

            <!-- Email -->
            <div>
                <label class="block text-sm font-medium text-gray-600">Email</label>
                <input type="email" name="email" required
                       class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring focus:ring-green-400 focus:outline-none"/>
            </div>

            <!-- Phone -->
            <div>
                <label class="block text-sm font-medium text-gray-600">Phone</label>
                <input type="text" name="phone" required
                       class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring focus:ring-green-400 focus:outline-none"/>
            </div>

            <!-- Password -->
            <div>
                <label class="block text-sm font-medium text-gray-600">Password</label>
                <input type="password" name="password" required
                       class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring focus:ring-green-400 focus:outline-none"/>
            </div>

            <!-- Submit -->
            <button type="submit"
                    class="w-full bg-green-600 text-white py-2 rounded-lg hover:bg-green-700 transition">
                Add Student
            </button>
        </form>

    <div class="mt-4 text-center">
        <a href="welcome.jsp" class="text-gray-600 hover:underline">Back to Students List</a>
    </div>
</div>

</body>
</html>
