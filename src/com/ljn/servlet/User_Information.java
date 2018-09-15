package com.ljn.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import com.ljn.dao.UsersDao;
import com.ljn.model.Users;

@WebServlet("/User_Information")
public class User_Information extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		HttpSession s=req.getSession();
		String uname=(String) s.getAttribute("uname");
        UsersDao ua=new UsersDao();
        Users u=null;
        try {
        	u=new Users();
			u=ua.get(uname);
			req.setAttribute("uname",u.getUname());
			req.setAttribute("mail", u.getMail());
			req.setAttribute("phone", u.getPhone());
			req.setAttribute("sex", u.getSex());
			req.setAttribute("truename", u.getTruename());
			req.setAttribute("usersid", u.getUsersId());
			req.setAttribute("cernum",u.getCernum());
			resp.sendRedirect("user_information2.jsp");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}


