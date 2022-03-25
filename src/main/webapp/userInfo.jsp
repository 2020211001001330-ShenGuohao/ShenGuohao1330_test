<%--
  Created by IntelliJ IDEA.
  User: sghcmy
  Date: 2022/4/3
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>

<table width="600" border="1">

    <tr>
        <td>id</td>
        <td><%=request.getAttribute("id")%></td>
    </tr>
    <tr>
        <td>username</td>
        <td><%=request.getAttribute("username")%></td>
    </tr>
    <tr>
        <td>password</td>
        <td><%=request.getAttribute("password")%></td>
    </tr>
    <tr>
        <td>email</td>
        <td><%=request.getAttribute("email")%></td>
    </tr>
    <tr>
        <td>gender</td>
        <td><%=request.getAttribute("gender")%></td>
    </tr>
    <tr>
        <td>birthday</td>
        <td><%=request.getAttribute("birthday")%></td>
    </tr>


</table>

<%@ include file="footer.jsp" %>