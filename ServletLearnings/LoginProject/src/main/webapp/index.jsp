<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
    <!-- Tailwind CDN -->
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 flex items-center justify-center h-screen">
    <div class="bg-white p-8 rounded-2xl shadow-md w-96">
        <h2 class="text-2xl font-bold mb-6 text-center text-gray-700">Login</h2>
        <form action="/verifylogin" method="post" class="space-y-5">
            <div>
                <label for="username" class="block text-gray-600 font-medium mb-1">Username</label>
                <input type="text" id="username" name="username" required
                       class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-400 focus:outline-none">
            </div>

            <div>
                <label for="password" class="block text-gray-600 font-medium mb-1">Password</label>
                <input type="password" id="password" name="password" required
                       class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-400 focus:outline-none">
            </div>

            <button type="submit"
                    class="w-full bg-blue-500 text-white py-2 rounded-lg hover:bg-blue-600 transition">
                Login
            </button>
        </form>
    </div>
</body>
</html>
