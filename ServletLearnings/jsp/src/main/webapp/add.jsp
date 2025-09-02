<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Submit Two Numbers</title>
  <!-- Tailwind CDN -->
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-700 w-full h-full">
<%


 int num1 =Integer.parseInt( request.getParameter("num1") );
        int num2 = Integer.parseInt(request.getParameter("num2")) ;



     out.println("num1 ==> " + num1 + " num2 ==> " + num2 + " num1 + num2 ==> " + num1 + num2) ;


 %>
 

</body>
</html>
