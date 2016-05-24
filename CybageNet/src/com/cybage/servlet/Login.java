package com.cybage.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Hashtable;

import javax.naming.Binding;
import javax.naming.Context;
import javax.naming.Name;
import javax.naming.NameClassPair;
import javax.naming.NameParser;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybage.book.CountUser;
import com.cybage.book.DataBaseFactory;

public class Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		String status=new DataBaseFactory().validateLogin(uname, pass);
		Cookie c=new Cookie("uname", uname);
		c.setMaxAge(24*60*60);
				if(status.equals("user"))
				{
					CountUser.inc();
					
					response.addCookie(c);
					response.sendRedirect("user.html");
				}
				else if(status.equals("admin"))
				{
					response.addCookie(c);
					response.sendRedirect("AdminLogin");
				}
				else
				{
					
					response.sendRedirect("login.html");
					//response.getWriter().print("Login Failed");
				}
			
		} 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
