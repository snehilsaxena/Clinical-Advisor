package org.ca.View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerLogin
 */
@WebServlet("/CustomerLogin")
public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		 
		out.println("<html>");
		out.println("<form action=CheckCustomerLogin method=post>");
		 
		out.print("<table>");
		out.println("<caption><b><i>Customer Login</i></b></caption>");
		
		out.println("<tr><td><b><i>customerid:</i></b></td>");
		out.println("<td><input type=text name=cid size=30></td></tr>");
		
		
		
		out.println("<tr><td><b><i>Password:</i></b></td>");
		out.println("<td><input type=password name=pwd size=30></td></tr>");

		out.println("<tr><td><input type=submit value='Login'></td>");
		out.println("<td>&nbsp;</td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</html>");
	}
	

	
}
