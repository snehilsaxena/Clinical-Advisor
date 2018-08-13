package org.ca.View;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ca.controller.RequestPageController;

/**
 * Servlet implementation class CheckStatus
 */
@WebServlet("/CheckStatus")
public class CheckStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
		PrintWriter out=response.getWriter();
		out.println("<html><table border=1>");
		
		ResultSet rs=RequestPageController.DisplayStatus(request.getParameter("cid"));
		if(rs.next())
		{
		out.println("<caption><b><i>List of Request</i></b></caption>");
	    out.println("<tr><th>Transition Id<th>Customer ID</th><th>State<th>City</th><th>Clinic</th><th>time<br>Date</th><th>Purpose</th><th>Status</th><th>APPOINT</th></tr>");	
	    do
	    {
	    out.println("<tr><td>"+rs.getString(1)+"</td><td><i>"+rs.getString(2)+"</i></td><td><i>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</i></td><td><i>"+rs.getString(5)+"<br>"+rs.getString(6)+"</i></th><th><i>"+rs.getString(7)+"</i></td><td><i>"+rs.getString(8)+"</i></td><td>"+rs.getString(9)+"</td><td><a href=ChangeStatus?tranid="+rs.getString(1)+">Click to Appoint</a></td></tr>");
	     
	    }while(rs.next());
		out.println("</table></center></html>");	
			
		} 
		else
		{
		out.println("Record Not Found...");	
		}
		}catch(Exception e){System.out.println(e);}
		
	}
}
