package org.ca.controller;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;

import org.ca.Model.Admin;

public class AdminController {
	private static String path="jdbc:mysql://localhost:3306/clinicaladvisor";
	private static String user="root";
	private static String password="123";
	
	public static Admin checkPassword(String aid,String pwd)
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(path,user,password);
	     String query="select * from admin where adminid='"+aid+"' and password='"+pwd+"'";
	     		 
	     ResultSet rs=DBHelper.executeQuery(cn, query);
	     if(rs.next())
	     { Admin A=new Admin();
	    	 A.setAdminid(rs.getString(1));
	    	 A.setAdminname(rs.getString(2));
	    	 return(A);
	    	 
	     }
	    	 
	     return(null);


	}catch(Exception e)
	{System.out.println("addNewRecord:"+e);
	 return(null);
	}
	}
}
