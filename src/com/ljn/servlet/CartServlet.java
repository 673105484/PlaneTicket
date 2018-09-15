package com.ljn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.ljn.dao.BookTicketDao;
import com.ljn.dao.FlightDao;
import com.ljn.model.BookTicket;
import com.ljn.model.Flight;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet{
	private String action ;
	BookTicket bt=new BookTicket();
          @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	  request.setCharacterEncoding("utf-8");
        	     response.setCharacterEncoding("utf-8");
        	     response.setContentType("text/html;charset=utf-8");
      		if(request.getParameter("action")!=null)
      		{  
      			
      			this.action = request.getParameter("action");
      			if(action.equals("add")) //如果是添加商品进购物车
      			{  
      				Flight f=new Flight();
      				FlightDao fd=new FlightDao();
      			    String  fid = request.getParameter("fid");
      	            //HttpSession session=request.getSession();
      	            //String  hyid=(String) session.getAttribute("usersId");
      	            BookTicketDao  bd=new BookTicketDao();
      	      		BookTicket b=new BookTicket();
      	      		b.setCernum(request.getParameter("cernum"));
      	      		b.setFid(fid);
      	      		b.setHyid(Integer.parseInt(request.getParameter("hyid")));
      	      		b.setPhone(request.getParameter("phone"));
      	      		b.setJptype(Integer.parseInt(request.getParameter("jptype")));
      	      	    b.setUname(request.getParameter("uname"));
      	      		try {
						bd.add(b);
						f=fd.get(fid);
						Integer num1=f.getHpiao();
						Integer num2=f.getJpiao();
						if(Integer.parseInt(request.getParameter("jptype"))==1) {
							num1=num1-1;
							f.setJpiao(num1);
							f.setHpiao(num2);
							fd.update(f,fid);
						}else {
							num2=num2-1;
							f.setJpiao(num1);
							f.setHpiao(num2);
							fd.update(f,fid);
						}
						request.getRequestDispatcher("/success.jsp").forward(request, response);
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
      			}
      		}
      		
      	}

}
