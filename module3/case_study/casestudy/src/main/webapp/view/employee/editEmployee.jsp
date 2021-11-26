<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/18/2021
  Time: 5:36 PM
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
        <a href="employees?action=employees">List All Employees</a>
    </h2>
    <c:if test="${mess!=null}">
        <strong style="color: red">${mess}</strong>
    </c:if>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Employee
                </h2>
            </caption>
<%--            <c:if test="${employee != null}">--%>
<%--                <input type="" name="id" value="<c:out value='${employee.employeeId}' />"/>--%>
<%--            </c:if>--%>
            <tr>
                <th>Id:</th>
                <td>
                    <input type="hidden" name="id" size="45"
                           value="<c:out value='${employee.employeeId}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${employee.employeeName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee birthday:</th>
                <td>
                    <input type="date" name="birthday" size="45"
                           value="<c:out value='${employee.employeeBirthday}' />"
                    />
                </td>
            </tr>
<%--            <tr>--%>
<%--                <th>Employee gender:</th>--%>
<%--                <td>--%>
<%--                    <input type="radio" name="gender"  value="1" ${employee.gender=="1"?"checked":""}>Male--%>
<%--                    <input type="radio" name="gender"  value="0" ${employee.gender=="0"?"checked":""}>Female--%>
<%--                </td>--%>
<%--            </tr>--%>
            <tr>
                <th>Employee id card:</th>
                <td>
                    <input type="text" name="idCard" size="45"
                           value="<c:out value='${employee.employeeIdCard}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee salary:</th>
                <td>
                    <input type="text" name="salary" size="45"
                           value="<c:out value='${employee.employeeSalary}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee phone:</th>
                <td>
                    <input type="text" name="phone" size="45"
                           value="<c:out value='${employee.employeePhone}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${employee.employeeEmail}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" size="15"
                           value="<c:out value='${employee.employeeAddress}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Position:</th>
                <td>
                    <select name="employeePositionId" id="employeePositionId">
                        <option value="0">--Select employee position --</option>
                        <c:forEach items="${positionEmployeeList}" var="positionEmployee">
                            <option value="${positionEmployee.positionId}"${positionEmployee.positionId==employee.employeePositionId?"selected":""}>
                                    ${positionEmployee.positionName}
                            </option>
                        </c:forEach>
                    </select>

                </td>
            </tr>
            <tr>
                <th>Employee education degree:</th>
                <td>
                    <select name="employeeEducationDegreeId" id="employeeEducationDegreeId">
                        <option value="0">--Select employee education degree --</option>
                        <c:forEach items="${educationDegreeList}" var="educationDegree">
                            <option value="${educationDegree.educationDegreeId}"${educationDegree.educationDegreeId==employee.employeeEducationDegreeId?"selected":""}>
                                    ${educationDegree.educationDegreeName}
                            </option>
                        </c:forEach>
                    </select>

                </td>
            </tr>
            <tr>
                <th>Employee Division:</th>
                <td>
                    <select name="employeeDivisionId" id="employeeDivisionId">
                        <option value="0">--Select employee division --</option>
                        <c:forEach items="${divisionList}" var="division">
                            <option value="${division.divisionId}"${division.divisionId==employee.employeeDivisionId?"selected":""}>
                                    ${division.divisionName}
                            </option>
                        </c:forEach>
                    </select>

                </td>
            </tr>
            <tr>
                <th>User name:</th>
                <td>
                    <input type="text" name="userName" size="45"
                           value="<c:out value='${employee.employeeUserName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee role: </th>
                <td>
                    <select name="employeeRoleId" id="">
                        <option value="0">--Select employee role --</option>
                        <c:forEach items="${userRoleList}" var="userRole">
                            <c:forEach items="${roleList}" var="role">
                                <option value="${userRole.roleId}"${userRole.userName==employee.employeeUserName&&userRole.roleId==role.roleId?"selected":""}>
                                        ${role.roleName}
                                </option>
                            </c:forEach>
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
