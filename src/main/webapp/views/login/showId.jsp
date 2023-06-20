<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Show ID</title>
</head>
<body>
<h1>Your ID:</h1>
<p><%= request.getAttribute("id") %></p>
</body>
</html>