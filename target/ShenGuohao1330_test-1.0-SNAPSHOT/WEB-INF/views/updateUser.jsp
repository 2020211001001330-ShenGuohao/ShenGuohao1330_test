<%--
  Created by IntelliJ IDEA.
  User: sghcmy
  Date: 2022/4/16
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="header.jsp" %>
<%
     User u=(User) session.getAttribute("user");

     String id="",username="",password="",Eamil="",Gender="",birthday="";
     if(u!=null){
         id=u.getId().trim();
         username=u.getUsername().trim();
         password=u.getPassword().trim();
         Eamil=u.getEmail().trim();
         Gender=u.getGender().trim();
         birthday=u.getBirthday().trim();
     }


%>


<form method="post" action="updateuser">
    <input name="ID" type="text"value="<%=id%>" /><br/>
    <input name="username" type="text" value="<%=username%>"/> <br/>
    <input name="password" type="password" value="<%=password%>"/> <br/>
    <input name="Email" type="email" value="<%=Eamil%>"/> <br/>

    <label>Gender</label><input name="Gender" type="radio"value="Man" <%="Man".equals(Gender)?"checked":""%> />Man
    <input name="Gender" type="radio" value="Female" <%="Female".equals(Gender)?"checked":""%> />Female <br/>
    <input name="birthday" type="date" value="<%=birthday%>"/> <br/>

    <input name="register" type="submit"  value="Save Change"/>
</form>

<%@ include file="footer.jsp"%>