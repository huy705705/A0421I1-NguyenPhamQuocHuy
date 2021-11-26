<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/17/2021
  Time: 8:32 AM
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

    <form action="/employees" method="get">
        <input type="hidden" name="action" value="searchEmployeeByCountryAndName">
        <input type="text" name="employeeCountry" placeholder="Enter country">
        <input type="text" name="employeeName" placeholder="Enter name">
        <input type="submit" value="Search">
    </form>
    <h2>
        <a href="employees?action=employees">List All Employee</a>
    </h2>
    <h2>
        <a href="/employees?action=createEmployee">Add New Employee</a>
    </h2>
    <h2>
        <a href="/employees?action=sortEmployee">Sort by Name </a>
    </h2>
    <c:if test='${requestScope["mess"] != null}'>
        <span class="mess" style="color: crimson">${requestScope["mess"]}</span>
    </c:if>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Employees was searched </h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Id card</th>
            <th>Salary</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Position Id</th>
            <th>education degree id</th>
            <th>Division id</th>
            <th>User name</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="employee" items="${employeeList}">
            <tr>
                <td><c:out value="${employee.employeeId}"/></td>
                <td><c:out value="${employee.employeeName}"/></td>
                <td><c:out value="${employee.employeeBirthday}"/></td>
                <td><c:out value="${employee.employeeIdCard}"/></td>
                <td><c:out value="${employee.employeeSalary}"/></td>
                <td><c:out value="${employee.employeePhone}"/></td>
                <td><c:out value="${employee.employeeEmail}"/></td>
                <td><c:out value="${employee.employeeAddress}"/></td>
                <td>
                    <c:forEach items="${positionEmployeeList}" var="positionEmployee">
                        <c:if test="${employee.employeePositionId==positionEmployee.positionId}">
                            <span>${positionEmployee.positionName}</span>
                        </c:if>
                    </c:forEach>
                </td>
                <td>

                    <c:forEach items="${educationDegreeList}" var="educationDegree">
                        <c:if test="${employee.employeeEducationDegreeId==educationDegree.educationDegreeId}">
                            <span>${educationDegree.educationDegreeName}</span>
                        </c:if>
                    </c:forEach>
                </td>
                <td>

                    <c:forEach items="${divisionList}" var="division">
                        <c:if test="${employee.employeeDivisionId==division.divisionId}">
                            <span>${division.divisionName}</span>
                        </c:if>
                    </c:forEach>

                </td>
<%--                <td>--%>
<%--                    <c:forEach items="${userRoleList}" var="userRole">--%>
<%--                        <c:forEach items="${roleList}" var="role">--%>
<%--                            <c:if test="${userRole.userName==employee.employeeUserName&&userRole.roleId==role.roleId}">--%>
<%--                                <span >${role.roleName}</span>--%>
<%--                            </c:if>--%>
<%--                        </c:forEach>--%>
<%--                    </c:forEach>--%>

<%--                </td>--%>
                <td><c:out value="${employee.employeeUserName}"/></td>
                <td>
                    <a href="/employees?action=editEmployee&id=${employee.employeeId}">Edit</a>
                    <a href="/employees?action=deleteEmployee&id=${employee.employeeId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
