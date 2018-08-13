package org.ca.View;

import java.io.IOException;


import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ca.controller.ClinicController;

/**
 * Servlet implementation class DisplayAllClinic
 */
@WebServlet("/DisplayAllClinic")
public class DisplayAllClinic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllClinic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
PrintWriter out=response.getWriter();
		
		try{
			 ResultSet rs=ClinicController.DisplayAll(); 	
			if(rs.next())
			{out.println("<html><a href=ClinicView>Add New Clinic</a><br><center><table border=1>");
			out.println("<caption><b><i>List of Clinic</i></b></caption>");
		    out.println("<tr><th>Name</th><th>Specilist<br>Experience</th><th>Payment</th><th>time</th><th>Contact</th><th>Address</th><th>other details</th><th>doctorphotoes</th></tr>");	
		    do
		    {
		    out.println("<tr><td><i>"+rs.getString(1)+"<br>"+rs.getString(2)+"<br>Clinic name: "+rs.getString(3)+"<br>Doctor Name: "+rs.getString(4)+"</i></td><td><i>"+rs.getString(5)+"<br>"+rs.getString(6)+"</i></td><td><i>"+rs.getString(7)+"</i></td><td><i>"+rs.getString(8)+"<br>"+rs.getString(9)+"</i></td><td><i>"+rs.getString(10)+"<br>"+rs.getString(11)+"</i></td><td><i>"+rs.getString(12)+"<br>"+rs.getString(13)+"<br>"+rs.getString(14)+"</i></td><td><i>"+rs.getString(15)+"<br>"+rs.getString(16)+"</i></td><td><i><img src=images/doctor/"+rs.getString(17)+" width=50 height=50><br>"+"</i></td><td><a href=DisplayClinicByID?clid="+rs.getString(2)+">Edit/Delete</a></td></tr>");
		     
		    }while(rs.next());
			out.println("</table></center></html>");	
				
			} 
			else
			{
			out.println("Record Not Found...");	
			}
			}catch(Exception e){
			out.println("DisplayAllClinic"+e);	
			}
	
	}

}
