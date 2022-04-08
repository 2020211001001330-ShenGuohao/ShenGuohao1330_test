<%@ page import="com.ShenGuohao.model.User" %><%--
  Created by IntelliJ IDEA.
  User: sghcmy
  Date: 2022/4/3
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>

<%
    User user=(User) request.getAttribute("user");
%>
<table width="600" border="1">

    <tr>
        <td>id</td>
        <td><%=user.getId()%></td>
    </tr>
    <tr>
        <td>username</td>
        <td><%=user.getUsername()%></td>
    </tr>
    <tr>
        <td>password</td>
        <td><%=user.getPassword()%></td>
    </tr>
    <tr>
        <td>email</td>
        <td><%=user.getEmail()%></td>
    </tr>
    <tr>
        <td>gender</td>
        <td><%=user.getGender()%></td>
    </tr>
    <tr>
        <td>birthday</td>
        <td><%=user.getBirthday()%></td>
    </tr>


</table>

<%@ include file="footer.jsp" %>