<%--
  Created by IntelliJ IDEA.
  User: sghcmy
  Date: 2022/3/16
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="header.jsp" %>

<form method="post" action="register">
    <input name="ID" type="text" value="ID"/><br/>
    <input name="username" type="text" value="username"/> <br/>
    <input name="password" type="password"minlength="8" value="password"> <br/>
    <input name="Email" type="email" value="Email"/> <br/>

    <label>Gender</label><input name="Gender" type="radio" value="Man"/>Man
    <input name="Gender" type="radio" value="Femail"/>Female <br/>
    <input name="birthday" type="date" value="Date of Birth(yyyy-mm-dd)"/> <br/>

    <input name="register" type="submit" value="register" />
</form>

<%@ include file="footer.jsp"%>