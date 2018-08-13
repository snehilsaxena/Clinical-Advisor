package org.ca.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class StateController {
	private static String provider="jdbc:mysql://localhost:3306/clinicaladvisor";
	private static String userid="root";
	private static String password="123";

	public static ResultSet DisplayAll()
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
	     String query="select * from states";
	   ResultSet rs=DBHelper.executeQuery(cn, query);
	     return(rs);


	}catch(Exception e)
	{System.out.println(e);
	 return(null);
	}
	}

	public static ResultSet DisplayAllCityByStateID(String stateid)
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
	     String query="select * from city where stateid='"+stateid+"'";
	     System.out.println(query);
	   ResultSet rs=DBHelper.executeQuery(cn, query);
	     return(rs);


	}catch(Exception e)
	{System.out.println(e);
	 return(null);
	}	
	}

}
