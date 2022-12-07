<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form  action="${pageContext.request.contextPath}/registerServlet" method="post">
    姓名：<input type="text" name="name"><br>
    手机号：<input type="text" name="telephone"><br>
    密  码：<input type="password" name="password"><br>
    <input type="submit" value="注册"><br>
    <div>
    <strong>${register_msg}</strong>
    </div>
</form>
</body>
</html>
