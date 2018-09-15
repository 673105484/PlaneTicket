package com.ljn.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ljn.dao.UsersDao;
import com.ljn.model.Users;

@WebServlet("/UpdateInformation")
public class UpdateInformation extends HttpServlet{
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
         HttpSession session=req.getSession();
         int id=(int)session.getAttribute("usersId");
         Users u =new Users(uname,trueuname,pwd,sex,cernum,mail,phone);
         UsersDao ua=new UsersDao();
         try {
 			ua.update(u,id);
 			resp.sendRedirect("user_information.jsp");
 		} catch (SQLException e) {
 			req.getRequestDispatcher("failure.jsp").forward(req, resp);
 			e.printStackTrace();
 		}
         
    }
    }

