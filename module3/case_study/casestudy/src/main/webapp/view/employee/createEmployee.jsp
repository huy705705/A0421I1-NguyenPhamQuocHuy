<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/17/2021
  Time: 2:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<center>
    <h1>Employee Management</h1>
    <h2>
        <a href="employees?action=employees">List All Employee</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Employee</h2>
            </caption>
            <tr>
                <th>Employee Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee birthday:</th>
                <td>
                    <input type="date" name="birthday" id="birthday" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee id card:</th>
                <td>
                    <input type="text" name="idCard" id="idCard" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee id salary:</th>
                <td>
                    <input type="text" name="salary" id="salary" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee phone:</th>
                <td>
                    <input type="text" name="phone" id="phone" size="45"/>
                </td>
            </tr>

            <tr>
                <th>Employee email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Position Id:</th>
                <td>
                    <select name="positionId" >
                        <c:forEach items="${positionEmployeeList}" var="positionEmployee">
                            <option value="${positionEmployee.positionId}">${positionEmployee.positionName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Education degree id:</th>
                <td>
                    <select name="educationDegreeId" >
                        <c:forEach items="${educationDegreeList}" var="educationDegree">
                            <option value="${educationDegree.educationDegreeId}">${educationDegree.educationDegreeName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Division id:</th>
                <td>
                    <select name="divisionId" >
                        <c:forEach items="${divisionList}" var="division">
                            <option value="${division.divisionId}">${division.divisionName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>User name:</th>
                <td>
                    <input type="text" name="userName" id="userName" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Role name:</th>
                <td>
                    <select name="roleId" >
                        <c:forEach items="${roleList}" var="role">
                            <option value="${role.roleId}">${role.roleName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
