package org.ca.controller;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;

import org.ca.Model.Clinic;
import org.ca.Model.Customer;
import org.ca.Model.RequestPage;

public class RequestPageController {
	private static String provider="jdbc:mysql://localhost:3306/clinicaladvisor";
	private static String userid="root";
	private static String password="123";
	public static boolean addNewRecord(RequestPage R)
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
	     String query="insert into requestpage(cid,state,city,clinic,time,date,purpose,status) values('"+R.getCid()+"','"+R.getState()+"','"+R.getCity()+"','"+R.getClinic()+"','"+R.getTime()+"','"+R.getDate()+"','"+R.getPurpose()+"','"+R.getStatus()+"')";
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
		 String query="select R.transactionid,R.cid,(select S.statename from states S where S.stateid=R.state),(select C.cityname from city C where C.cityid=R.city),(select C.clinicname from clinicinformation C where C.clinicid=R.clinic),R.time,R.date,R.purpose,R.status from requestpage R"; 
	     System.out.println(query);
	     ResultSet rs=DBHelper.executeQuery(cn, query);
	     return(rs);


	}catch(Exception e)
	{System.out.println("addNewRecord:"+e);
	 return(null);
	}
	}
	public static boolean changeStatus(String tranid)
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
		  
	     String query="update requestpage set status='appointed' where transactionid="+tranid;
	     System.out.println(query);
	    
	     boolean st=DBHelper.executeUpdate(cn, query);
	     return(st);


	}catch(Exception e)
	{System.out.println("EditRecord:"+e);
	 return(false);
	}
	}

	public static ResultSet DisplayStatus(String cid)
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
		String query="select * from requestpage where cid="+cid;  
	    System.out.println(query);
	     ResultSet rs=DBHelper.executeQuery(cn, query);
	     return(rs);


	}catch(Exception e)
	{System.out.println("addNewRecord:"+e);
	 return(null);
	}
	}

		}
	
