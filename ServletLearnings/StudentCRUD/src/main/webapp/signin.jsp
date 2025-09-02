<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign In</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 flex items-center justify-center h-screen">
<div class="bg-white shadow-lg rounded-2xl w-96 p-8">
    <h2 class="text-2xl font-bold text-center text-gray-800 mb-6">Sign In</h2>
    <form action="/signin" method="post" class="space-y-5">
        <!-- Username -->
        <div>
            <label class="block text-sm font-medium text-gray-600">Username</label>
            <input type="text" name="username" required
                   class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring focus:ring-blue-400 focus:outline-none"/>
        </div>

        <!-- Password -->
        <div>
            <label class="block text-sm font-medium text-gray-600">Password</label>
            <input type="password" name="password" required
                   class="mt-1 w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring focus:ring-blue-400 focus:outline-none"/>
        </div>

        <!-- Submit -->
        <button type="submit"
                class="w-full bg-blue-600 text-white py-2 rounded-lg hover:bg-blue-700 transition">
            Sign In
        </button>
    </form>

    <p class="text-sm text-gray-600 text-center mt-4">
        Don’t have an account?
        <a href="signup.jsp" class="text-blue-600 hover:underline">Sign Up</a>
    </p>
</div>
</body>
</html>
