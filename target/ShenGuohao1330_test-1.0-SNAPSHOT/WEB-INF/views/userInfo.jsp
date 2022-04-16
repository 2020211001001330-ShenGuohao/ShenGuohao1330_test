<%@ page import="com.ShenGuohao.model.User" %><%--
  Created by IntelliJ IDEA.
  User: sghcmy
  Date: 2022/4/3
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>

<%--<%--%>
<%--        Cookie [] allcookies=request.getCookies();--%>
<%--        for(Cookie c:allcookies){--%>
<%--            out.println("<br/>"+c.getName()+"-----"+c.getValue());--%>
<%--        }--%>
<%--%>--%>

<%

//    User user=(User) request.getAttribute("user");
      User u=(User) session.getAttribute("user") ;

%>
<table width="600" border="1">

    <tr>
        <td>id</td>
        <td><%=u.getId()%></td>
    </tr>
    <tr>
        <td>username</td>
        <td><%=u.getUsername()%></td>
    </tr>
    <tr>
        <td>password</td>
        <td><%=u.getPassword()%></td>
    </tr>
    <tr>
        <td>email</td>
        <td><%=u.getEmail()%></td>
    </tr>
    <tr>
        <td>gender</td>
        <td><%=u.getGender()%></td>
    </tr>
    <tr>
        <td>birthday</td>
        <td><%=u.getBirthday()%></td>
    </tr>


</table>

<a href="updateuser">userupdate</a>

<%@ include file="footer.jsp" %>