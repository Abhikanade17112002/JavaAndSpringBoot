<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // Dummy validation (replace with DB check in real apps)
    boolean isValid = "admin".equals(username) && "Pass".equals(password);
%>
<html>
<head>
    <title>Login Result</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 flex items-center justify-center h-screen">
    <div class="bg-white p-8 rounded-2xl shadow-md w-96 text-center">
        <%
            if (isValid) {
        %>
            <h2 class="text-2xl font-bold text-green-600 mb-4">Login Successful 🎉</h2>
            <p class="text-gray-700">Welcome, <span class="font-semibold"><%= username %></span>!</p>
        <%
            } else {
        %>
            <h2 class="text-2xl font-bold text-red-600 mb-4">Login Failed ❌</h2>
            <p class="text-gray-700">Invalid username or password.</p>
            <a href="index.jsp" class="mt-4 inline-block bg-blue-500 text-white px-4 py-2 rounded-lg hover:bg-blue-600 transition">
                Try Again
            </a>
        <%
            }
        %>
    </div>
</body>
</html>
