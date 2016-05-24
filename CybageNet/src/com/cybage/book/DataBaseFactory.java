package com.cybage.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseFactory
{
	MyConnection con=new MyConnection();
	
	public String registerUser(String uname,String pass,String address)
	{
		String status="fail";
		try
		{
			Connection connection=con.connect();
			PreparedStatement statement=connection.prepareStatement("insert into registration values(?,?,?,?)");
			statement.setString(1,uname);
			statement.setString(2,pass);
			statement.setString(3,address);
			statement.setString(4,"user");
			int res=statement.executeUpdate();
			if(res!=0)
			{
				status="success";
			}
			connection.close();
		}
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		return status;
	}
	
	public String validateLogin(String uname,String pass) 
	{
		
		Connection connection=con.connect();
		Statement st;
		String status="fail";
		try
		{
			st = connection.createStatement();
			
			ResultSet rs=st.executeQuery("select * from registration where uname='"+uname+"'and pass='"+pass+"'");
			if(rs.next())
			{
				status=rs.getString("status");
			}
			else
			{
				System.out.println("connection failed");
			}
			connection.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	public String addNewBook(String id,String title,int qty)
	{
		String status="fail";
		try
		{
			Connection connection=con.connect();
			PreparedStatement statement=connection.prepareStatement("insert into book_info values(?,?,?)");
			statement.setString(1,id);
			statement.setString(2,title);
			statement.setInt(3,qty);
			int res=statement.executeUpdate();
			if(res!=0)
			{
				status="success";
			}
			connection.close();
		}
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		return status;
	}
	public String removeBook(String id)
	{
		String status="fail";
		try
		{
			Connection connection=con.connect();
			Statement st=connection.createStatement();
			st.execute("delete from book_info where bookid='"+id+"'");
			st.execute("delete from book_review where bookid='"+id+"'");
			
			
			
			status="success";
			
			connection.close();
		}
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		return status;
	}
	
	
	public String addReview(String bookid,String review)
	{
		String status="fail";
		try
		{
			Connection connection=con.connect();
			PreparedStatement statement=connection.prepareStatement("insert into book_review values(?,?)");
			statement.setString(1,bookid);
			statement.setString(2,review);
			
			int res=statement.executeUpdate();
			if(res!=0)
			{
				status="success";	
			}
		
			connection.close();
		}
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		return status;
	}
	
	public String logDetail(String uname,String date)
	{
		Connection connection=con.connect();
	
		try
		{
			
			PreparedStatement statement=connection.prepareStatement("insert into log values(?,?)");
			statement.setString(1,uname);
			statement.setString(2,date);
			int res=statement.executeUpdate();
			connection.close();
		}
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		return "success";
		
	}
}
