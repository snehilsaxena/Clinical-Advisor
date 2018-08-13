package org.ca.controller;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import org.ca.Model.SearchPage;
import org.ca.Model.RequestPage;

public class SearchController {
	private static String provider="jdbc:mysql://localhost:3306/clinicaladvisor";
	private static String userid="root";
	private static String password="123";
	public static ResultSet DisplayAllTypeByCityId(String cityid)
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
	     String query="select * from typeofclinic where cityid='"+cityid+"'";
	   ResultSet rs=DBHelper.executeQuery(cn, query);
	     return(rs);


	}catch(Exception e)
	{System.out.println(e);
	 return(null);
	}
	
	
	}
	public static ResultSet DisplayAllClinicByTypeId(String typeid)
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
	     String query="select * from clinicinformation where typeid='"+typeid+"'";
	   ResultSet rs=DBHelper.executeQuery(cn, query);
	     return(rs);


	}catch(Exception e)
	{System.out.println(e);
	 return(null);
	}
	
	
	}
	
	}
