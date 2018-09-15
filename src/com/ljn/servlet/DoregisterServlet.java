package com.ljn.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ljn.dao.UsersDao;
import com.ljn.model.Users;
@WebServlet("/Doregister")
public class DoregisterServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
   	    String uname = req.getParameter("uname");
 		String pwd = req.getParameter("pwd");
        String sex=req.getParameter("sex");
        String mail=req.getParameter("mail");
        String phone=req.getParameter("phone");
        String trueuname=req.getParameter("trueuname");
        String cernum=req.getParameter("cernum");
        Users u =new Users(uname,trueuname,pwd,sex,cernum,mail,phone);
        UsersDao ua=new UsersDao();
        try {
			ua.add(u);
			resp.sendRedirect("login.jsp");
		} catch (SQLException e) {
			req.getRequestDispatcher("register.jsp").forward(req, resp);
			e.printStackTrace();
		}
        
   }
 }
