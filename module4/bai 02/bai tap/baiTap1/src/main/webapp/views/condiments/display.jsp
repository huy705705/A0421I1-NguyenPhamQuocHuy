<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 12/5/2021
  Time: 5:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/save" method="post">
    <input type="checkbox" id="condiment1" name="condiment" value="lettuce">
    <label for="condiment1"> Lettuce</label><br>

    <input type="checkbox" id="condiment2" name="condiment" value="tomato">
    <label for="condiment2">Tomato </label><br>

    <input type="checkbox" id="condiment3" name="condiment" value="mustard">
    <label for="condiment3">Mustard </label><br>

    <input type="checkbox" id="condiment4" name="condiment" value="sprouts">
    <label for="condiment4"> Sprouts</label><br>
    <input type="submit" value="Save">
</form>
</body>
</html>
