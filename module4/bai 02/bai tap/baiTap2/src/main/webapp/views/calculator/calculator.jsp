<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 12/5/2021
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="calculate" method="post">
    <input type="text" name="first" placeholder="Enter first number">
    <select name="operator" id="">
        <option value="+">Addition(+)</option>
        <option value="-">Subtract(-)</option>
        <option value="*">Multiply(*)</option>
        <option value="/">Division(/)</option>
    </select>
    <input type="text" name="second" placeholder="Enter second number">
    <input type="submit" value="Calculate">
</form>
<h1 style="color: red">${mess}</h1>
<h3>Result: ${result}</h3>
</body>
</html>
