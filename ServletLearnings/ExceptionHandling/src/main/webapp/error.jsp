<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Error Occurred</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 h-screen flex items-center justify-center">
  <div class="text-center px-6">
    <h1 class="text-6xl font-bold text-blue-600 mb-4">Oops!</h1>
    <p class="text-xl text-red-600 mb-2"><%= exception.getMessage() %></p>
    <p class="text-gray-600 mb-6">
      Something went wrong. We're working on it.
    </p>
    <a href="index.jsp" class="inline-block px-6 py-2 bg-blue-600 text-white rounded hover:bg-blue-700 transition">
      Back to Home
    </a>
  </div>
</body>
</html>
