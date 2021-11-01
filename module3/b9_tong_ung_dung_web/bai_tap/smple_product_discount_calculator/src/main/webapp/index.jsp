<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 10/30/2021
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/converter" method="post">
    <label>Product Description: </label><br/>
    <input type="text" name="name" placeholder="Name" value="Fan"/><br/>
    <label>List Price:  </label><br/>
    <input type="text" name="price" placeholder="Price" value="22000"/><br/>
    <label>Discount Percent: </label><br/>
    <input type="text" name="rate" placeholder="Rate Discount" value="10"/><br/>
    <input type = "submit" id = "submit" value = "Converter"/>
  </form>
  </body>
</html>
