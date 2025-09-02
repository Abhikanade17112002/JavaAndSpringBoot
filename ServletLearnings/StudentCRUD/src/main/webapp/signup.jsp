<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 flex items-center justify-center min-h-screen">
<div class="bg-white shadow-lg rounded-2xl w-96 p-8">
    <h2 class="text-2xl font-bold text-center text-gray-800 mb-6">Create Account</h2>
    <form action="/addstudent" method="post" class="space-y-5">

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
                <!-- Email -->
                        <div>
                            <label class="block text-sm font-medium text-gray-600">Email</label>
                            <input type="email" name="email" required
                                   class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring focus:ring-green-400 focus:outline-none"/>
                        </div>
        <!-- Password -->
        <div>
            <label class="block text-sm font-medium text-gray-600">Password</label>
            <input type="password" name="password" required
                   class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring focus:ring-green-400 focus:outline-none"/>
        </div>





        <!-- Phone -->
        <div>
            <label class="block text-sm font-medium text-gray-600">Phone</label>
            <input type="tel" name="phone" required
                   class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring focus:ring-green-400 focus:outline-none"/>
        </div>

        <!-- Age -->
        <div>
            <label class="block text-sm font-medium text-gray-600">Age</label>
            <input type="number" name="age" min="1" required
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

        <!-- Submit -->
        <button type="submit"
                class="w-full bg-green-600 text-white py-2 rounded-lg hover:bg-green-700 transition">
            Sign Up
        </button>
    </form>

    <p class="text-sm text-gray-600 text-center mt-4">
        Already have an account?
        <a href="signin.jsp" class="text-green-600 hover:underline">Sign In</a>
    </p>
</div>
</body>
</html>
