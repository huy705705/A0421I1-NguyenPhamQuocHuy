<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 10/31/2021
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Trang chu</h1>
<h2>Hien thi danh sach khach hang</h2>
<table>
    <tr>
        <th>Ten</th>
        <th>Ngay sinh</th>
        <th>Dia chi</th>
        <th>Anh</th>
    </tr>
    <c:forEach items="${list}" var="customer" varStatus="status">
        <tr>
            <td>${status.name}</td>
            <td>${status.birthday}</td>
            <td>${status.address}</td>
            <td>${status.describe}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
