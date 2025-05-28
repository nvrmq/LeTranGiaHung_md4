<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 28/5/25
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Selection</title>
</head>
<body>
<h2>Chosen condiments for sandwich</h2>
<ul>
  <c:forEach var="item" items="${submitted}">
    <li>${item}</li>
  </c:forEach>
</ul>
</body>
</html>
