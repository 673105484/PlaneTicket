package com.ljn.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginFilter implements Filter{
private FilterConfig filterconfig;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
          HttpServletRequest requset=(HttpServletRequest )arg0;	
          HttpServletResponse response=(HttpServletResponse)arg1;
          requset.setCharacterEncoding("utf-8");
         String s= filterconfig.getInitParameter("nofilter");
          if(s!=null) {
        	String []str=  s.split(";");
        	for (int i = 0; i < str.length; i++) {
        		if(str[i]==null||"".equals(str[i]))continue;
				if(requset.getRequestURI().indexOf(str[i])!=-1) {
					arg2.doFilter(arg0, arg1);
					return;
				}
			}
          }
        if(requset.getSession().getAttribute("uname")!=null) {
          
        	  arg2.doFilter(arg0, arg1);
        
          }else {
        	  response.sendRedirect("login.jsp");
          }
			
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		filterconfig =arg0;
		
	}
	

}
