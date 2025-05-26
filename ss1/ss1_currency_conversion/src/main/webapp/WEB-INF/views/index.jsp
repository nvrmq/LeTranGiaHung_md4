<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Currency Converter(USD to VND)</h1>
<form action="/conversion" method="post">
    <label>Exchange rate from USD to VND</label>
    <input name="rate" type="number" step="0.001" required>
    <label>USD amount: </label>
    <input name="usd" type="number" step="0.001" required>
    <input type="submit" value="Convert">
</form>
</body>
</html>