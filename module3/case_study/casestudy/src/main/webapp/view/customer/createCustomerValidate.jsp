<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/20/2021
  Time: 4:43 PM
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

    <h1>Customer Management</h1>
    <h2>
        <a href="customers?action=customers">List All Customers</a>
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
                    Edit Customer
                </h2>
            </caption>
            <c:if test="${customer != null}">
                <input type="hidden" name="id" value="<c:out value='${oldCustomer.id}' />"/>
            </c:if>
            <tr>
                <th>Customer Type Name:</th>
                <td>
                    <select name="customerTypeId" id="">
                        <option value="0">--Select type customer--</option>
                        <c:forEach items="${customerTypeList}" var="customerType">
                            <option value="${customerType.customerTypeId}"${customerType.customerTypeId==oldCustomer.typeId?"selected":""}>
                                    ${customerType.customerTypeName}
                            </option>
                        </c:forEach>
                    </select>

                </td>
            </tr>
            <tr>
                <th>Customer Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${oldCustomer.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer birthday:</th>
                <td>
                    <input type="date" name="birthday" size="45"
                           value="<c:out value='${oldCustomer.birthday}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer gender:</th>
                <td>
                    <input type="radio" name="gender"  value="1" ${oldCustomer.gender=="1"?"checked":""}>Male
                    <input type="radio" name="gender"  value="0" ${oldCustomer.gender=="0"?"checked":""}>Female
                </td>
            </tr>
            <tr>
                <th>Customer id card:</th>
                <td>
                    <input type="text" name="idCard" size="45"
                           value="<c:out value='${oldCustomer.idCard}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer phone:</th>
                <td>
                    <input type="text" name="phone" size="45"
                           value="<c:out value='${oldCustomer.phone}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${oldCustomer.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" size="15"
                           value="<c:out value='${oldCustomer.address}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
            <tr>
                <th>Message:</th>
                <td>
                    <span>${emailMess}</span>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
