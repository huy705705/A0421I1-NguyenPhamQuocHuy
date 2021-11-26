<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/15/2021
  Time: 9:22 AM
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
    <h1>Search customer by name</h1>
    <h2>
        <a href="customers?action=customers">List All Customers</a>
    </h2>
    <c:if test='${requestScope["mess"] != null}'>
        <span class="mess" style="color: crimson">${requestScope["mess"]}</span>
    </c:if>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Type name(Type id)</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Gender</th>
            <th>Id card</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td><c:out value="${customer.id}"/></td>
                <td>
                    <c:forEach items="${customerTypeList}" var="customerType">
                        <c:if test="${customer.typeId==customerType.customerTypeId}">
                            <span>${customerType.customerTypeName}</span>
                        </c:if>
                    </c:forEach>
                </td>
                <td><c:out value="${customer.name}"/></td>
                <td><c:out value="${customer.birthday}"/></td>
                <td>
                        <%--                    <c:out value="${customer.gender}"/>--%>
                    <c:if test="${customer.gender==1}">
                        <sp>Male</sp>
                    </c:if>
                    <c:if test="${customer.gender==0}">
                        <sp>Female</sp>
                    </c:if>
                </td>
                <td><c:out value="${customer.idCard}"/></td>
                <td><c:out value="${customer.phone}"/></td>
                <td><c:out value="${customer.email}"/></td>
                <td><c:out value="${customer.address}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
