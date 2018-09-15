<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ljn.dao.UsersDao"%>
<%@page import="com.ljn.model.Users"%>
<%@page import="org.apache.catalina.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.title {
	width: 30%;
	background-color: #CCC;
	font-weight: bold;
}

.content {
	width: 70%;
	background-color: #CBCFE5;
}
</style>
</head>
<body>
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
	<div class="f_list public_container">
		<li><b>用户名</b>&nbsp <em>性别</em> &nbsp <b>电话</b>编号</li>
		<%
	  Users u=new Users();
	 UsersDao ud=new UsersDao();
     u=ud.get((int)session.getAttribute("usersId"));
     if(u.getUname()!=null){
	  
	%>
		<ul>
			<li><b><%=u.getUname()%></b>&nbsp <em><%=u.getSex() %></em>
				&nbsp <%=u.getPhone() %> <b><%=u.getUsersId() %></b></li>
		</ul>
		<%
	}
	%>
		<a href="updateinformation.jsp">修改个人信息</a>
	</div>
	<a href="./buyList.jsp">查看订购目录</a>
	<a href="./index.jsp">返回主页</a>
</body>
</html>