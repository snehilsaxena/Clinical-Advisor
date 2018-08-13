package org.ca.View;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ca.controller.CustomerController;

/**
 * Servlet implementation class DisplayAllCustomers
 */
@WebServlet("/DisplayAllCustomers")
public class DisplayAllCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllCustomers() {
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
		 ResultSet rs=CustomerController.DisplayAll(); 	
		if(rs.next())
		{out.println("<html><a href=CustomerView>Add New Customer</a><br><center><table border=1>");
		out.println("<caption><b><i>List of Customer</i></b></caption>");
	    out.println("<tr><th>Name</th><th>Gender<br>/DOB</th><th>Disease</th><th>Address</th><th>Contact<br>Details</th><th>Referenceby</th><th>Update</th></tr>");	
	    do
	    {
	    out.println("<tr><td><i>"+rs.getString(1)+"<br>"+rs.getString(2)+"</i></td><td><i>"+rs.getString(3)+"<br>"+rs.getString(4)+"</i></td><td><i>"+rs.getString(5)+"</i></td><td><i>"+rs.getString(6)+"<br>"+rs.getString(7)+","+rs.getString(8)+"</i></td><td><i>"+rs.getString(9)+"<br>"+rs.getString(10)+"</i></td><td><i>"+rs.getString(12)+"</i></td><td><i><a href=DisplayCustomerByID?cid="+rs.getString(1)+">Edit/Delete</a></i></td></tr>");
	     
	    }while(rs.next());
		out.println("</table></center></html>");	
			
		}
		else
		{
		out.println("Record Not Found...");	
		}
		 
			
			
		}catch(Exception e){
		out.println("DisplayAllCustomers"+e);	
		}
		}
	}


