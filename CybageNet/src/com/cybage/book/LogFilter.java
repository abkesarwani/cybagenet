package com.cybage.book;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class LogFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException 
	{
		
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
			
			String uname=request.getParameter("uname");
			new DataBaseFactory().logDetail(uname,new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new java.util.Date()));
			chain.doFilter(request,response);
		
	}


	public void destroy()
	{
		// TODO Auto-generated method stub
		
	}

}
