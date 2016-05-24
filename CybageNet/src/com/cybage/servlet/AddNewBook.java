package com.cybage.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.book.DataBaseFactory;

public class AddNewBook extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id=request.getParameter("id");
		String title=request.getParameter("title");
		int qty=Integer.parseInt(request.getParameter("qty"));
		String status=new DataBaseFactory().addNewBook(id, title, qty);
		if(status=="success")
		{
			response.sendRedirect("admin.html");	
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

}
