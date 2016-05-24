package com.cybage.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.book.CountUser;

public class AdminLogin extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int c=CountUser.getCount();
		PrintWriter out=response.getWriter();
		String c1="Add New Book Here";
		String c2="bookentry.html";
		Cookie[] ck=request.getCookies();
		out.println("<h2>Welcome Admin ....</h2>");
		out.println("Users Online::"+c);
		out.println("total visitor ::"+ck.length);
		out.println("<table border="+1+">");
		out.println("<tr><td>"+c1+"</td><td><a href="+c2+">Add Book</a></td></tr>");
		out.println("<tr><td>Remove Book</td><td><a href='bookremove.html'>Remove Book</a></td></tr>");
		out.println("<tr><td>Logout Here</td><td><a href='AdminLogout'>Logout</a></td></tr>");
		out.println("</table>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
