<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 12/4/2021
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Translate</h1>
<form action="translate" method="post">
    <h4>English: </h4>
    <input type="text" name="english" placeholder="Enter word">
    <input type="submit" value="Translate"><br>
    <h5 style="color: red">${mess}</h5>
    <h4>Result:</h4>
    <input type="text" name="result" value="${result}" disabled>

</form>
</body>
</html>
