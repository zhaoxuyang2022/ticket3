<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录注册页面</title>
</head>
<body>




<form action="${pageContext.request.contextPath}/loginServlet" method="post">
        用户名:
        <input type="text" name="name" placeholder="请输入用户名"/>
        密码：
        <input type="password" name="password" placeholder="请输入密码"/>
    <hr/>
        <input type="submit" value="登录">
        <a href="${pageContext.request.contextPath}/register.jsp">注册</a>
</form>

<div>
    <strong>${login_msg}</strong>
</div>

</body>
</html>
