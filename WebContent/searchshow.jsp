<%@page import="com.ljn.dao.FlightDao"%>
<%@page import="com.ljn.model.Flight"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.ljn.dao.BookTicketDao"%>
<%@page import="com.ljn.model.BookTicket"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>机票页面</title>
<link rel="stylesheet" href="./css/public.css">
<link rel="stylesheet" href="./css/private.css">
</head>
<body>
	<div class="head">
		<div class="head_inner public_container">
			<nav>
			<ul>
				<li><a href="##">首页</a></li>
				<li><a href="./flight_list.jsp">机票展示</a></li>
				<li><a href="./buylist.jsp">订购展示</a></li>
				<li><a href="##">关于我们</a></li>
			</ul>
			</nav>
			<div class="loginBox">
				<a href="./login.jsp">游客登录</a> <a href="./adminlogin.jsp">管理员登录</a>
			</div>
		</div>
	</div>
	<div class="f_list public_container">
		<li><b>出发地</b>&nbsp <em>目的地</em> &nbsp <b>起飞时间</b><b>到达时间</b><b>经济舱票价</b><b>豪华舱票价</b>
		</li>
		<%
	request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
	   FlightDao fd=new FlightDao();
      String fstart1=request.getParameter("fstart");
      String fend1=request.getParameter("fend");
	 List<Flight> list= fd.query(fstart1,fend1);
	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh24:mm:ss");
	 if(list!=null&&list.size()>0){
	 for(int i=0;i<list.size();i++){
		 String date1 = sdf.format(list.get(i).getStarttime());
		 String date2 = sdf.format(list.get(i).getStarttime());

	%>
		<ul>
			<li><b><%=list.get(i).getFstart() %></b>&nbsp <em><%=list.get(i).getFend() %></em>
				&nbsp <%=date1 %> <b><%=date2 %></b><b><%=list.get(i).getJprice() %></b><b><%=list.get(i).getHprice() %></b>
				<a href="./do.jsp?action=add&fid=<%=list.get(i).getFlightId()%>">订购</a></li>
		</ul>
		<%
		}
	   } 
	 %>
	</div>
	<a href="./buyList.jsp">查看订购目录</a>
	<a href="./index.jsp">返回主页</a>
</body>
</html>