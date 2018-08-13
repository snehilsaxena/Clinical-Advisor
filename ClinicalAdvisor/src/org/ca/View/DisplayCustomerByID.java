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
 * Servlet implementation class DisplayCustomerById
 */
@WebServlet("/DisplayCustomerById")
public class DisplayCustomerByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayCustomerByID() {
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
			ResultSet rs=CustomerController.DisplayById(request.getParameter("cid")); 
			if(rs.next())
			{
				out.println("<script src=asset/jquery-2.2.1.min.js></script>");
				out.println("<script src=asset/state.js></script>");
				out.println("<html>");
				out.println("<form action=CustomerEditDelete method=post enctype='multipart/form-data'>");
				out.println("<a href=DisplayAllCustomers>Display All Customer</a><br>");
				out.println("<table><tr><td>");
				out.print("<table>");
				out.println("<caption><b><i>Customer Register[Update]</i></b></caption>");
				out.println("<tr><td><b><i>Customer Id:</i></b></td>");
				out.println("<td><input type=text name=cid size=30 value='"+rs.getString(1)+"'></td></tr>");
				
				out.println("<tr><td><b><i>Name:</i></b></td>");
				String n=rs.getString(2);
				String cn[]=n.split(" ");
				out.println("<td><input type=text name=cfn placeholder='First Name' size=30 value='"+cn[0]+"'><br><input type=text name=cln placeholder='Second Name' size=30 value='"+cn[1]+"'></td></tr>");
			
			    		 
				out.println("<tr><td><b><i>Birth Date:</i></b></td>");
				out.println("<td><input type=date name=cdob size=30 value='"+rs.getString(3)+"'></td></tr>");
				if(rs.getString(4).equals("Male"))
				{
				out.println("<tr><td><b><i>Gender:</i></b></td>");
				out.println("<td><input type=radio name=cg value=Male checked>Male<input type=radio name=cg value=Female>Female</td></tr>");
				}
				else
				{
					out.println("<tr><td><b><i>Gender:</i></b></td>");
					out.println("<td><input type=radio name=cg value=Male>Male<input type=radio name=cg value=Female checked>Female</td></tr>");	
				}
		
				out.println("<tr><td><b><i>Disease:</i></b></td>");
				out.println("<td><input type=text name=cd >"+rs.getString(5)+"</td></tr>");
				
				out.println("<tr><td><b><i>Address:</i></b></td>");
				out.println("<td><textarea row=3 cols=30 name=cadd >"+rs.getString(6)+"</textarea></td></tr>");
				
				out.println("<tr><td><b><i>State:</i></b></td>");
				out.println("<td><select name=cstate id=cstate></select></td></tr>");
				
				out.println("<tr><td><b><i>City:</i></b></td>");
				out.println("<td><select name=ccity id=ccity></select></td></tr>");
				
				out.println("<tr><td><b><i>Mobile:</i></b></td>");
				out.println("<td><input type=text name=cmo size=30 value='"+rs.getString(9)+"'></td></tr>");
				
				out.println("<tr><td><b><i>Email Id:</i></b></td>");
				out.println("<td><input type=email name=cem size=30 value='"+rs.getString(10)+"'></td></tr>");
				
				out.println("<tr><td><b><i>Reference By:</i></b></td>");
				out.println("<td><input type=text name=cr size=30 value='"+rs.getString(12)+"'></td></tr>");
				
				
				out.println("<tr><td><input type=submit value=Edit></td>");
				out.println("<td><input type=submit value=Delete></td></tr>");
				out.println("</table></td>");
			   out.println("</form></html>");
					
				 
			}
			else
			{
			out.println("Record Not Found....");	
			}
			
			
			
			 
			 
		 }catch(Exception e)
		 {
			 out.println("DisplayCustomerByID"+e);
		 }
		out.flush();	
	}
	}


