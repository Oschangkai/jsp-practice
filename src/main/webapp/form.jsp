<%--
  Created by IntelliJ IDEA.
  User: KaiYi.C
  Date: 2019/11/12
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
<form method="post" action="show">
<%--    enctype="multipart/form-data">--%>
    String: <input type="text" name="string"><br>
<%--    Select File: <input type="file" name="filename" value="" /><br>--%>
    <input type="submit" name="send" value="送出">
</form>
</body>
</html>
