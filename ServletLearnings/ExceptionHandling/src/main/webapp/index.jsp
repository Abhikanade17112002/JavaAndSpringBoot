<%@ page errorPage="error.jsp" %>

<html>
<head>
    <title>Error Test Page</title>
</head>
<body>
    <h2>Hello World!</h2>
    <%
        int x = 8 / 0;  // This will throw ArithmeticException
    %>
</body>
</html>
