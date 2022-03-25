<%--
  Created by IntelliJ IDEA.
  User: sghcmy
  Date: 2022/4/2
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>

<html>

<head>
       <title>uerList</title>
</head>

<body>
<%@ page import="java.sql.ResultSet" %>
<table width="600" border="1">

        <tr>
            <td>ID</td>
            <td>Username</td>
            <td>Password</td>
            <td>Email</td>
            <td>Gender</td>
            <td>Birthday</td>
        </tr>


       <%
           ResultSet res=(ResultSet) request.getAttribute("res");
           while (res.next()){
               String ID=res.getString("ID");
               String username=res.getString("username");
               String password=res.getString("password");
               String Email=res.getString("Email");
               String Gender=res.getString("Gender");
               String birthday=res.getString("birthday");

               out.println("<tr>");
               out.println("<td>"+ID+"</td>");
               out.println("<td>"+username+"</td>");
               out.println("<td>"+password+"</td>");
               out.println("<td>"+Email+"</td>");
               out.println("<td>"+Gender+"</td>");
               out.println("<td>"+birthday+"</td>");
               out.println("</tr>");
           }
       %>


</table>

</body>

</html>
