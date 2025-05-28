<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>Calculator</h2>
<form action="calculate" method="post">
    <input type="number" required name="var1">
    <input type="number" required name="var2">
    <br/><br/>

    <button type="submit" name="operator" value="+">Addition</button>
    <button type="submit" name="operator" value="-">Subtraction</button>
    <button type="submit" name="operator" value="x">Multiplication</button>
    <button type="submit" name="operator" value="/">Division</button>
</form>
<c:if test="${not empty message}">
    <p><strong>${message}</strong></p>
</c:if>
</body>
</html>