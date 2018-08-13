package org.ca.controller;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;

import org.ca.Model.Admin;
import org.ca.Model.Customer;

public class CustomerController {
	private static String provider="jdbc:mysql://localhost:3306/clinicaladvisor";
	private static String userid="root";
	private static String password="123";
	public static boolean addNewRecord(Customer c)
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
	     String query="insert into customerinfo values('"+c.getCustomerid()+"','"+c.getCustomername()+"','"+c.getDob()+"','"+c.getGender()+"','"+c.getDisease()+"','"+c.getAddress()+"','"+c.getState()+"','"+c.getCity()+"','"+c.getMobno()+"','"+c.getEmail()+"','"+c.getPassword()+"','"+c.getReferenceby()+"')";
	    System.out.println(query);
	     boolean st=DBHelper.executeUpdate(cn, query);
	     return(st);


	}catch(Exception e)
	{System.out.println("addNewRecord:"+e);
	 return(false);
	}

		
	}
	public static ResultSet DisplayAll()
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
	     String query="select * from customerinfo"; 
	     System.out.println(query);
	     ResultSet rs=DBHelper.executeQuery(cn, query);
	     return(rs);


	}catch(Exception e)
	{System.out.println(" DisplayAll:"+e);
	 return(null);
	}
	}

	public static ResultSet DisplayById(String cid)
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
	     String query="select * from customerinfo where customerid='"+cid+"'"; 
	     System.out.println(query);
	     ResultSet rs=DBHelper.executeQuery(cn, query);
	     return(rs);


	}catch(Exception e)
	{System.out.println("DisplayById:"+e);
	 return(null);
	}
	}
	public static boolean EditRecord(Customer C)
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
		  
	     String query="update  customerinfo set customername='"+C.getCustomername()+"', dob='"+C.getDob()+"',gender='"+C.getGender()+"',disease='"+C.getDisease()+"',address='"+C.getAddress()+"',state='"+C.getState()+"',city='"+C.getCity()+"',mobno='"+C.getMobno()+"',email='"+C.getEmail()+"',referenceby='"+C.getReferenceby()+"' where customerid='"+C.getCustomerid()+"'";
	     System.out.println(query);
	    
	     boolean st=DBHelper.executeUpdate(cn, query);
	     return(st);


	}catch(Exception e)
	{System.out.println("EditRecord:"+e);
	 return(false);
	}
	}

	public static boolean DeleteRecord(String cid)
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
		  
	     String query="delete from customerinfo  where customerid='"+cid+"'";
	     System.out.println(query);
	     boolean st=DBHelper.executeUpdate(cn, query);
	     return(st);


	}catch(Exception e)
	{System.out.println("DeleteRecord:"+e);
	 return(false);
	}
	}
	public static Customer checkPassword(String cid,String pwd)
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
	     String query="select * from customerinfo where customerid='"+cid+"' and password='"+pwd+"'";
	     		 
	     ResultSet rs=DBHelper.executeQuery(cn, query);
	     if(rs.next())
	     { Customer C=new Customer();
	    	 C.setCustomerid(rs.getString(1));
	    	 C.setCustomername(rs.getString(2));
	    	 return(C);
	    	 
	     }
	    	 
	     return(null);


	}catch(Exception e)
	{System.out.println("addNewRecord:"+e);
	 return(null);
	}
	}

}
