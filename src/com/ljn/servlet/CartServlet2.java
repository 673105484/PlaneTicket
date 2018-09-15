package com.ljn.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ljn.dao.BookTicketDao;
import com.ljn.dao.FlightDao;
import com.ljn.model.Flight;

@WebServlet("/CartServlet2")
public class CartServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 request.setCharacterEncoding("utf-8");
         response.setCharacterEncoding("utf-8");
         response.setContentType("text/html;charset=utf-8");  
				String bookTicketId= request.getParameter("bookTicketId");
				String fid=request.getParameter("fid");
				int   type=Integer.parseInt(request.getParameter("type"));
				Flight f=new Flight();
				FlightDao fd=new FlightDao();
				BookTicketDao bd=new BookTicketDao();
				try {
					
				bd.del(bookTicketId);
				f=fd.get(fid);
				Integer num1=f.getJpiao();
				Integer num2=f.getHpiao();
				System.out.println(num1);
				System.out.println(num2);
				if(type==1) {
					System.out.println(num1);
					num1=num1+1;
					f.setJpiao(num1);
					f.setHpiao(num2);
					fd.update(f,fid);
				}else {
					num2=num2+1;
					f.setJpiao(num1);
					f.setHpiao(num2);
					fd.update(f,fid);
				}
				request.getRequestDispatcher("/delsuccess.jsp").forward(request, response);
			} catch (NumberFormatException | SQLException e) {
				request.getRequestDispatcher("/buylist.jsp").forward(request, response);
				e.printStackTrace();
			}
			}
		
		
    }
