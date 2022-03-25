<%@ include file="header.jsp" %>


<%--<a href="hello-servlet">Hello Servlet-week1</a>--%>
<%--<br/>--%>
<%--<a href="hello">Student Info Servlet-week2</a>--%>
<%--<br/>--%>
<%--<a href="life">Life Cycle Servlet-week3</a>--%>
<%--<br/>--%>
<%--<a href="register.jsp">Register-get-parameters-week3</a>--%>
<%--<br/>--%>
<%--<a href="config">Config-parameters-week4</a>--%>
<%--<br/>--%>
<%--<a href="register.jsp">Register JDBC -week4</a>--%>
<%--<br/>--%>
<%--<a href="Myjsp.jsp"> Include-week5</a>--%>
<%--<br/>--%>
<%--<a href="Login.jsp">Login-week5</a>--%>

<h2>welcome to my Online shoe Home Page</h2>

<form method="get" target="_blank" action="search">
     <input type="text" name="txt" size="30" />
     <select name="search">
         <option value="baidu">baidu</option>
         <option value="bing">bing</option>
         <option value="google">google</option>
     </select>
    <input type="submit" value="Search"/>
</form>

<%@ include file="footer.jsp"%>
