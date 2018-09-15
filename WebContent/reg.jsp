<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>index</title>
<link rel="stylesheet" href="./css/public.css">
<link rel="stylesheet" href="./css/index.css">
</head>
<body>
	<!--导航栏-->
	<div class="header clearfix">
		<div class="inner-head public_container">
			<div class="log">
				<!--img src-->
				<a href="./index.jsp">第五组飞机</a>
			</div>
			<div class="nav">
				<ul>
					<li><a href="./index.jsp">网站首页</a></li>
					<li><a href="./flight_list.jsp">订票页面</a></li>
					<li><a href="./buylist.jsp">已订购机票</a></li>
					<li><a href="##">关于我们</a></li>
<%
                       if(session.getAttribute("uname")!=null){ 
                    %>
					<li><a href="user_information.jsp">欢迎你，<%=session.getAttribute("uname") %></a><a href="./outLogin">退出</a></li>
					<%
                      } else{
                     %>

					<li><a href="reg.jsp" style="color: red">注册</a> <a
						href="./login.jsp">登录</a></li>
					<%
                      }
                    %>
				</ul>
			</div>
		</div>
	</div>
	<!--大图-->
	<!--service-->
	<div class="service public_container clearfix">
		<div class="admin">
			<form action="./Doregister" method="post">
				<input type="text" name="uname" placeholder="用户名"><br>
				<input type="password" name="pwd" placeholder="密码"><br>
				<input type="text" name="sex" placeholder="性别"><br> <input
					type="text" name="mail" placeholder="邮箱"><br> <input
					type="text" name="phone" placeholder="电话"><br> <input
					type="text" name="trueuname" placeholder="真实姓名"><br> <input
					type="text" name="cernum" placeholder="身份证号码"><br> <input
					type="submit" value="注册" <a href="login.jsp">返回登录页面</a>>
			</form>
		</div>
	</div>
	<a href="./login.html">返回登录</a>
	<div class="footer">
		<div class="in_f">
			<a href="##">首页</a> <a href="##">订票界面</a> <a href="##">百度</a> <a
				href="##">阿里</a> <a href="##">tencent</a>
		</div>
		<p>前世的魏无羡万人唾骂，声名狼藉。被情同手足的师弟带人端了老巢，纵横一世，死无全尸。曾掀起腥风血雨的一代魔道祖师，重生成了一个……脑残。</p>
	</div>
</body>
</html>