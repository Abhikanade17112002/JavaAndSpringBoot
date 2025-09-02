<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = (String) session.getAttribute("username");
    // HTTP 1.1.
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

    // HTTP 1.0.
    response.setHeader("Pragma", "no-cache");

    // Proxies / backward compatibility
    response.setDateHeader("Expires", 0);


%>
<html>
<head>
    <title>Welcome Page</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 flex items-center justify-center h-screen">
    <div class="bg-white p-8 rounded-2xl shadow-md w-96 text-center">
        <h2 class="text-2xl font-bold text-green-600 mb-4">Welcome 🎉</h2>
        <p class="text-gray-700 mb-6">
            Hello, <span class="font-semibold"><%= username %></span>!
        </p>

        <a href="/video.jsp"
           class="inline-block bg-blue-500 text-white px-4 py-2 rounded-lg hover:bg-blue-600 transition">
            Go to Videos
        </a>
    </div>
</body>
</html>
