package com.techpalle.dao;

import java.sql.*;
import java.util.ArrayList;

import com.techpalle.model.Student;

//Below class is used to write jdbc code
public class StudentDao 
{
	private static String url ="jdbc:mysql://localhost:3306/spring1";
	private static String username ="root";
	private static String password ="admin";
	
	private static Connection cn =null;
	private static Statement  stm =null;
	private static PreparedStatement ps =null;
	private static ResultSet rs =null;
	
	private static final String insertQry="insert into student(name,email,pw,mobile)values(?,?,?,?)";
	private static final  String displayAllStudentQry ="select * from Student";
	
	
	public static ArrayList<Student> getAllStudent() 
	{
		ArrayList<Student> al = new ArrayList<Student>();
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			cn = DriverManager.getConnection(url, username, password);
			
			stm = cn.createStatement();
			
			rs = stm.executeQuery(displayAllStudentQry);
			
			while(rs.next()) 
			{
				int i = rs.getInt("sno");
				String n = rs.getString("name");
				String e = rs.getString("email");
				String p = rs.getString("pw");
				long m = rs.getLong("mobile");
				
				Student s = new Student (i,n,e,p,m);
				
				al.add(s);
			}
			
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		finally 
		{
			try 
				{
					if (rs!=null) 
					{
					rs.close();
					}
					
					if (stm!=null) 
					{
					stm.close();
					}
					
					if (cn!=null) 
					{
					cn.close();
					}
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		
		return al;
	}
	
	public static void insertStudent(Student s) 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			cn = DriverManager.getConnection(url, username, password);
			
			ps = cn.prepareStatement(insertQry);
			
			ps.setString(1, s.getName());
			ps.setString(2,s.getEmail());
			ps.setString(3, s.getPassword());
			ps.setLong(4,s.getMobile());
			
			ps.executeUpdate();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		finally 
		{
			try 
				{
					if (ps!=null) 
					{
					ps.close();
					}
					
					if (cn!=null) 
					{
					cn.close();
					}
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}


