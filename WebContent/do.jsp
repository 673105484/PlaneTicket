<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<div class="inner-head public_container">
			<div class="log">
				<!--img src-->
				<a href="##">第五组飞机</a>
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
	<!--service-->
	<div class="service public_container">
		<div class="hd">
			<div class="s-hd">
				<h3>我们的服务</h3>
				<p>
					<b>PROGRAM HIGHLIGHT</b>
				</p>
			</div>

			<p>我们的宗旨是好好为人民服务，所以希望你们能够至此我们的工作</p>
			<p>时代的面前 我们不惧前行 唯有风雨 才见豪情</p>
		</div>
		<div class="service public_container clearfix">
			<div class="admin">
				<form
					action="./CartServlet?action=add&fid=<%=request.getParameter("fid")%>"
					method="POST">
					<table>
						<tr>
							<td>姓名</td>
							<td><input type="text" name="uname" value=""></td>
						</tr>
						<tr>
							<td>身份证号码</td>
							<td><input type="text" name="cernum"></td>
						</tr>
						<tr>
							<td>电话</td>
							<td><input type="text" name="phone"></td>
						</tr>
						<tr>
							<td>购买机票类型</td>
							<td><input type="text" name="jptype"
								placeholder="机票类型 1代表豪华舱 2代表经济舱"></td>
						</tr>
						<tr>
							<td>会员号</td>
							<td><input type="text" name="hyid"
								value=<%=session.getAttribute("usersId")%>></td>
						</tr>
						<tr>
							<td></td>
							<td><input class="sb" type="submit" value="购买"> <a
								href="./flight_list.jsp">返回</a></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
</body>
</html>