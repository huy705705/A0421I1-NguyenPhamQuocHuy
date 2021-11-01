<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 10/31/2021
  Time: 4:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<h1>Simple calculator</h1>
<form action="">
  <fieldset>
    <table>
      <tr>
        <td>First operand: </td>
        <td><input type="text" name="firt-operand"> </td>
      </tr>
      <tr>
        <td>Operator: </td>
        <td>
          <select name="operator" id="">
            <option value="+">Addition</option>
            <option value="-">Subtraction</option>
            <option value="*">Multiplication</option>
            <option value="/">Division</option>
          </select>
        </td>
      </tr>
      <tr>
        <td>Second operand: </td>
        <td><input type="text" name="second-operand"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Calculate"></td>
      </tr>
    </table>
  </fieldset>
</form>
  </body>
</html>
