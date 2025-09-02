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
    <title>Videos Page</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 flex items-center justify-center min-h-screen">
    <div class="bg-white p-8 rounded-2xl shadow-md w-full max-w-2xl text-center">
        <h2 class="text-2xl font-bold text-gray-700 mb-6">Welcome, <%= username %> 🎬</h2>

        <!-- Video embed -->
        <div class="aspect-w-16 aspect-h-9 mb-6">
            <iframe width="560" height="315" src="https://www.youtube.com/embed/OuBUUkQfBYM?si=oxFGqPvSHPBXNelp" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
        </div>

        <!-- Logout link -->
        <a href="/logout"
           class="inline-block bg-red-500 text-white px-4 py-2 rounded-lg hover:bg-red-600 transition">
            Logout
        </a>
    </div>
</body>
</html>
