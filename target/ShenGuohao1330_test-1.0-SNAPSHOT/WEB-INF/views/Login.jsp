<%--
  Created by IntelliJ IDEA.
  User: sghcmy
  Date: 2022/3/25
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>


<%@ include file="header.jsp" %>



<h1>Login</h1>
<%
      if(request.getAttribute("message")!=null){
              out.println(request.getAttribute("message"));
    }
%>

<%
     Cookie[] allCookies=request.getCookies();
     String username="",password="",rememberMeval="";
     if(allCookies!=null){

         for (Cookie c:allCookies){
             if(c.getName().equals("cusername")){
                 username=c.getValue();
             }
             if(c.getName().equals("cpassword")){
                 password=c.getValue();
             }
             if(c.getName().equals("cremeberMe")){
                 rememberMeval=c.getValue();
             }
         }
     }

%>

<form method="post" action="login">
username: <input name="username" type="text" value="<%=username%>"> <br/>
password: <input name="password" type="password" value="<%=password%>"> <br/>
<input name="login" type="submit" value="Login">  <br/>
<input name="rememberMe" type="checkbox" value="1" <%=rememberMeval.equals("1")?"checked":""%>/>RemeberMe  <br/>

</form>

<%@ include file="footer.jsp"%>
