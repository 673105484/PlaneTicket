<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.ljn.dao.FlightDao"%>
<%@page import="com.ljn.model.Flight"%>
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
	<div class="header">
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
	<div class="banner">
		<div class="b_center public_container">
			<div class="m_search">
				<form action="searchshow.jsp" method="post">
					<table>
						<tr>
							<td>出发地</td>
							<td><input type="text" name="fstart"></td>
						</tr>
						<tr>
							<td>目的地</td>
							<td><input type="text" name="fend"></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="搜索" style="cursor: pointer"></td>
						</tr>
					</table>
				</form>
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
		<div class="bd clearfix">
			<div class="flight_list">
				<li><b>出发地</b>&nbsp <b>目的地</b>&nbsp<em>出发时间</em> &nbsp <em>到达时间</em>&nbsp<b>经济票价</b>&nbsp
					<b>豪华票价</b></li>
				<%
        session.getAttribute("uname");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8"); 
        
        Flight f=new Flight();
     FlightDao fd=new FlightDao();
     List<Flight> list= fd.query();
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
     if(list!=null&&list.size()>0){
     for(int i=0;i<list.size();i++){
         if(i>8){
             break;
         }
         String date2 = sdf.format(list.get(i).getEndtime());
         String date1 = sdf.format(list.get(i).getStarttime());
    %>
				<ul>
					<li><b><%=list.get(i).getFstart() %></b>&nbsp <b><%=list.get(i).getFend() %></b>&nbsp<em><%=date1 %></em>
						&nbsp <em><%=date2 %></em>&nbsp<b><%=list.get(i).getJprice()%></b>&nbsp
						<b><%=list.get(i).getHprice()%></b> <a
						href="./do.jsp?action=add&fid=<%=list.get(i).getFlightId()%>">订购</a>
					</li>
				</ul>
				<%}
     
     }
    %>
			</div>
		</div>
		<!--case-->
		<div class="case_wrap">
			<div class="case public_container">
				<div class="hd">
					<div class="s-hd">
						<h3>我们的理念</h3>
						<p>
							<b>PROGRAM HIGHLIGHT</b>
						</p>
					</div>

					<p>我们的宗旨是好好为人民服务，所以希望你们能够至此我们的工作</p>
					<p>时代的面前 我们不惧前行 唯有风雨 才见豪情</p>
				</div>
				<div class="lunbo">
					<ul>
						<li><a href="##"><img src="./img/5.png" alt=""></a>
							<div class="inner-div">中华人民共和国万岁</div>
							<div class="mask"></div></li>
						<li class="li_cen"><a href="##"><img src="./img/5.png"
								alt=""></a>
							<div class="inner-div">中华人民共和国万岁</div>
							<div class="mask"></div></li>
						<li><a href="##"><img src="./img/5.png" alt=""></a>
							<div class="inner-div">中华人民共和国万岁</div>
							<div class="mask"></div></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="footer">
			<div class="in_f">
				<a href="##">首页</a> <a href="##">订票界面</a> <a href="##">百度</a> <a
					href="##">阿里</a> <a href="##">tencent</a>
			</div>
			<p>前世的魏无羡万人唾骂，声名狼藉。被情同手足的师弟带人端了老巢，纵横一世，死无全尸。曾掀起腥风血雨的一代魔道祖师，重生成了一个……脑残。</p>
		</div>
</body>
</html>