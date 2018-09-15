<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./UpdateInformation" method="post">
		<input type="text" name="uname" placeholder="用户名"><br> <input
			type="password" name="pwd" placeholder="密码"><br> <input
			type="text" name="sex" placeholder="性别"><br> <input
			type="text" name="mail" placeholder="邮箱"><br> <input
			type="text" name="phone" placeholder="电话"><br> <input
			type="text" name="trueuname" placeholder="真实姓名"><br> <input
			type="text" name="cernum" placeholder="身份证号码"><br> <input
			type="submit" value="修改">
	</form>
</body>
</html>