<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>Condiments selection page</h2>
<form action="submit" method="post">
    <label><input type="checkbox" name="condiment" value="lettuce">Lettuce</label>
    <label><input type="checkbox" name="condiment" value="tomato">Tomato</label>
    <label><input type="checkbox" name="condiment" value="mustard">Mustard</label>
    <label><input type="checkbox" name="condiment" value="sprouts">Sprouts</label>
    <input type="submit" value="Submit">
</form>
</body>
</html>