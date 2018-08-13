 package org.ca.View;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ca.Model.Customer;

/**
 * Servlet implementation class SearchPage
 */
@WebServlet("/SearchPage")
public class SearchPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
				 
		 out.println("<script src=asset/jquery-2.2.1.min.js></script>");
			out.println("<script src=asset/search.js></script>");
			out.println("<html>");
			out.println("<form action=SerchPageSubmit method=post>");
			 
			out.print("<table>");
					 
			out.println("<tr><td><b><i>State:</i></b></td>");
			out.println("<td><select name=cstate id=cstate></select></td></tr>");
			
			out.println("<tr><td><b><i>City:</i></b></td>");
			out.println("<td><select name=ccity id=ccity></select></td></tr>");
					
			out.println("<tr><td><b><i>Clinictype:</i></b></td>");
			out.println("<td><select id=ctype name=ctype></select></td></tr>");
			
			out.println("<tr><td><b><i>Clinic:</i></b></td>");
			out.println("<td><select id=cliid name=cliid></select></td></tr>");
						 
			out.println("<tr><td><input type=submit ></td>");
			out.println("<td><input type=reset></td></tr>");
					out.println("</table></form></html>");
					out.flush();
	
	}

}
