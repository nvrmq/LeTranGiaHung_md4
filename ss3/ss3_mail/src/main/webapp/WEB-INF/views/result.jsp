<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 2/6/25
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Updated Settings</h2>
<p><b>Language:</b> ${emailSettings.language}</p>
<p><b>Page Size:</b> ${emailSettings.pageSize} emails/page</p>
<p><b>Spams Filter:</b> ${emailSettings.spamFilter ? "Enabled" : "Disabled"}</p>
<p><b>Signature:</b><br/>
<pre>${emailSettings.signature}</pre>
</p>
<a href="/settings">Back</a>
</body>
</html>
