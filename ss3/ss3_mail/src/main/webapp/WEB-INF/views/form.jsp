<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 2/6/25
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Mail information page</title>
</head>
<body>
<h2>Settings</h2
<form:form modelAttribute="emailSettings" action="/settings" method="post">
    <div>
        <label>Language</label>
        <form:select path="language">
            <form:options items="${languages}"/>
        </form:select>
    </div>
    <div>
        <label>Page size</label>
        <form:select path="pageSize">
            <form:options items="${pageSize}"/>;
        </form:select>
    </div>

    <div>
        <label>Spams filter:</label>
        <form:checkbox path="spamFilter"/> Enable spams filter
    </div>

    <div>
        <label>Signature:</label><br/>
        <form:textarea path="signature"/>
    </div>

    <div>
        <input type="submit" value="Update"/>
        <button type="reset">Cancel</button>
    </div>
</form:form>
</body>
</html>
