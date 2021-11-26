<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/17/2021
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<h1>Employee Management</h1>
<h2>
    <a href="customers?action=customers">List All Employee</a>
</h2>
<c:if test="${mess!=null}">
    <strong style="color: red">${mess}</strong>
</c:if>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">

            <h2>
                Are you sure you want to delete a employee whose name is ${employee.employeeName} and id ${employee.employeeId}
            </h2>
            <tr>
                <th>Customer id:</th>
                <td>
                    <input type="text" name="id"disabled size="45"
                           value="<c:out value='${employee.employeeId}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Name:</th>
                <td>
                    <input type="text" name="name" disabled size="45"
                           value="<c:out value='${employee.employeeName}' />"
                    />
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Delete"/>
                    <button ><a href="employees?action=employees" style="text-decoration: none;color: black" >Cancel</a></button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
