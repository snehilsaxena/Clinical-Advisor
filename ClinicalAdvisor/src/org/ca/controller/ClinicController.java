package org.ca.controller;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;

import org.ca.Model.Clinic;
import org.ca.Model.Customer;

public class ClinicController {
	private static String provider="jdbc:mysql://localhost:3306/clinicaladvisor";
	private static String userid="root";
	private static String password="123";
	public static boolean addNewRecord(Clinic C)
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
	     String query="insert into clinicinformation values('"+C.getTypeid()+"','"+C.getClinicid()+"','"+C.getClinicname()+"','"+C.getDoctorname()+"','"+C.getSpecialist()+"','"+C.getExperience()+"','"+C.getPayment()+"','"+C.getOpeningtime()+"','"+C.getClosingtime()+"','"+C.getClimobno()+"','"+C.getCliemail()+"','"+C.getCliaddress()+"','"+C.getClistate()+"','"+C.getClicity()+"','"+C.getOtherfacility()+"','"+C.getCertificate()+"','"+C.getDoctorphotoes()+"')";
	    System.out.print(query);
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
	     String query="select * from clinicinformation C";  
	     ResultSet rs=DBHelper.executeQuery(cn, query);
	     return(rs);


	}catch(Exception e)
	{System.out.println("ClinicController/DisplayAll"+e);
	 return(null);
	}
	}

	public static ResultSet DisplayClinicByID(String clid)
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
		String query="select C.typeid,C.clinicid,C.clinicname,C.doctorname,C.specialist,C.experience,C.payment,C.openingtime,C.closingtime,C.climobno,C.cliemail,C.cliaddress,(select S.statename from states S where S.stateid=C.clistate),(select K.cityname from city K where K.cityid=C.clicity),C.otherfacility,C.certificate,C.doctorphotoes  from clinicinformation C   where C.clinicid='"+clid+"'";  
	    System.out.println(query);
	     ResultSet rs=DBHelper.executeQuery(cn, query);
	     return(rs);


	}catch(Exception e)
	{System.out.println("ClinicalController/DisplayClinicByID"+e);
	 return(null);
	}
	}
	
	public static ResultSet DisplayClinicByCityId(String cityid)
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
		  
	     String query="select* from clinicinformation  where clicity='"+cityid+"'";
	     System.out.println(query);
	     ResultSet rs=DBHelper.executeQuery(cn, query);
	     return(rs);


	}catch(Exception e)
	{System.out.println("addNewRecord"+e);
	 return(null);
	}

	}
	
	
	public static boolean EditRecord(Clinic C)
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
		  
	     String query="update  clinicinformation set clinicname='"+C.getClinicname()+"',doctorname='"+C.getDoctorname()+"',specialist='"+C.getSpecialist()+"',experience='"+C.getExperience()+"',Payment='"+C.getPayment()+"',openingtime='"+C.getOpeningtime()+"',closingtime='"+C.getClosingtime()+"',climobno='"+C.getClimobno()+"',cliemail='"+C.getCliemail()+"',cliaddress='"+C.getCliaddress()+"',clicity='"+C.getClicity()+"',clistate='"+C.getClistate()+"',otherfacility='"+C.getOtherfacility()+"',certificate='"+C.getCertificate()+"', where clinicid='"+C.getClinicid()+"'";
	     System.out.println(query);
	     boolean st=DBHelper.executeUpdate(cn, query);
	     return(st);


	}catch(Exception e)
	{System.out.println("ClinicContoller/EditRecord"+e);
	 return(false);
	}
	}

	public static boolean DeleteRecord(String clid)
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
		  
	     String query="delete from clinicinformation  where clinicid='"+clid+"'";
	     System.out.println(query);
	     boolean st=DBHelper.executeUpdate(cn, query);
	     return(st);


	}catch(Exception e)
	{System.out.println("ClinicContoller/DeleteRecord"+e);
	 return(false);
	}

	}
	

	public static boolean EditPicture(String filename,String clid)
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
		  
	     String query="update  clinicinformation set doctorphotoes='"+filename+"' where clinicid='"+ clid+"'";
	     System.out.println(query);
	     boolean st=DBHelper.executeUpdate(cn, query);
	     return(st);


	}catch(Exception e)
	{System.out.println("ClinicController/EditPicture:"+e);
	 return(false);
	}
	}
	
}
