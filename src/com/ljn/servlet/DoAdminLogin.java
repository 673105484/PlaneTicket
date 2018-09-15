package com.ljn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ljn.dao.AdminDao;
import com.ljn.dao.UsersDao;
import com.ljn.model.Admin;
import com.ljn.model.Users;

@WebServlet("/doLogin")
public class DoAdminLogin extends HttpServlet{
       @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	     req.setCharacterEncoding("utf-8");
    	      resp.setCharacterEncoding("utf-8");
    	      resp.setContentType("text/html;charset=utf-8");  
    		    String uname = req.getParameter("uname");
    			String pwd = req.getParameter("pwd");
    	        UsersDao  ud=new UsersDao();
    	        Users u=null;
    		    try {
    		    	 u=new Users() ;
    		    	  u=ud.get(uname) ;
    		    	 System.out.println(uname);
    				if(u.getUname()!=null) 
    				{
    						System.out.println(u.toString());
    						if(u.getPwd().equals(pwd)){
    							System.out.println("chenggong ");
    							HttpSession session=req.getSession() ;
    							session.setAttribute("uname", uname);
    							session.setAttribute("usersId", u.getUsersId());
    		
    							resp.sendRedirect("index.jsp");
    						}
    						else{
    							System.out.println("cshibai1");
    							req.getRequestDispatcher("index.jsp").forward(req, resp);
    						}
    					}
    				else {
    						System.out.println("cshibai2");
    						req.getRequestDispatcher("login.jsp").forward(req, resp);
    						}
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    				
    			
    }
}
