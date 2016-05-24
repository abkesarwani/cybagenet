package com.cybage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybage.book.MyConnection;

public class SearchBook extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		MyConnection con=new MyConnection();
	
	String title=request.getParameter("title");
	HttpSession sess=request.getSession();
	Connection connection=con.connect();
	try
	{
		Statement st=connection.createStatement();
		ResultSet rs=st.executeQuery("select * from book_info where title='"+title+"'");
		PrintWriter out=response.getWriter();
		String str1="Book Id";
		String str2="Title";
		String str3="Quantity";
		out.println("<h1>");
		out.println("Book Details Are ::");
		out.println("</h1>");
		out.println("<table border="+1+"><tr><td>"+str1+"</td><td>"+str2+"</td><td>"+str3+"</td></tr>");
		if(rs.next())
		{
			out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td></tr>");
						
		}
		out.println("</table>");
		String bookid=rs.getString(1);
		rs.close();
		ResultSet rs1=st.executeQuery("select * from book_review where bookid='"+bookid+"'");
		
		for (int i = 0; i < 7; i++)
		{
			out.println("</br>");
			
		}
		out.println("<h1>");
		out.println("Book Review Are :=");
		out.println("</h1>");
		out.println("<table border="+1+"");
		String a="=>";
		
		
		while(rs1.next())
		{
			out.println("<tr><td>"+a+"</td><td>"+rs1.getString(2)+"</td></tr>");
						
		}
		out.println("</table>");
		for (int i = 0; i < 5; i++)
		{
			out.println("</br>");
			
		}
		out.println("<h3>");
		out.println("Add Your Review::");
		out.println("</h3>");
		
		
		
		response.getWriter().println("<form action='AddReview' method='get'>");
		response.getWriter().println("<input type='textarea'  name='review'>");
		response.getWriter().println( "<input type='submit' value='Add Review'>");
		response.getWriter().println("</form >");
		sess.setAttribute("id",bookid);
		for (int i = 0; i < 5; i++)
		{
			out.println("</br>");
			
		}
		response.getWriter().println("</br><a href='Logout'>Logout</a>");
		connection.close();
		
	
	} 
	catch (SQLException e)
	{
		e.printStackTrace();
	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
