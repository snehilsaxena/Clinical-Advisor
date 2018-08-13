package org.ca.View;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerView
 */
@WebServlet("/CustomerView")
public class CustomerView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubPrintWriter out=response.getWriter();
		
		PrintWriter out=response.getWriter();
		out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
		out.println("<script src='asset/state.js'></script>");
		
		out.println("<html>");
		out.println("<form action=CustomerSubmit method=post>");
		out.print("<table>");
		out.println("<caption><b><i>Customer Information</i></b></caption>");
		out.println("<tr><td><b><i>Customer ID:</i></b></td>");
		out.println("<td><input type=text name=cid size=30></td></tr>");
		
		out.println("<tr><td><b><i>Name:</i></b></td>");
		out.println("<td><input type=text name=cfn placeholder='First Name' size=30>&nbsp;&nbsp;<input type=text name=cln placeholder='Second Name' size=30></td></tr>");
	
		
	 
		out.println("<tr><td><b><i>Birth Date:</i></b></td>");
		out.println("<td><input type=date name=cdob size=30></td></tr>");
		
		out.println("<tr><td><b><i>Gender:</i></b></td>");
		out.println("<td><input type=radio name=cg value=Male>Male<input type=radio name=cg value=Female>Female</td></tr>");
		
		out.println("<tr><td><b><i>Disease:</i></b></td>");
		out.println("<td><input type=text name=cd size=30></td></tr>");
		
		out.println("<tr><td><b><i>Address:</i></b></td>");
		out.println("<td><textarea row=3 cols=30 name=cadd ></textarea></td></tr>");
		
		out.println("<tr><td><b><i>State:</i></b></td>");
		out.println("<td><select name=cstate  id=cstate></select></td></tr>");
		
		out.println("<tr><td><b><i>City:</i></b></td>");
		out.println("<td><select name=ccity id=ccity></select></td></tr>");
		
		out.println("<tr><td><b><i>MobNo:</i></b></td>");
		out.println("<td><input type=text name=cmo size=30></td></tr>");
		
		out.println("<tr><td><b><i>Email:</i></b></td>");
		out.println("<td><input type=cmail name=cem size=30></td></tr>");
		
		out.println("<tr><td><b><i>Password:</i></b></td>");
		out.println("<td><input type=password name=cpass size=30></td></tr>");
		
		out.println("<tr><td><b><i>Confirm Password:</i></b></td>");
		out.println("<td><input type=password name=ccpwd size=30></td></tr>");
		
		out.println("<tr><td><b><i>Reference By:</i></b></td>");
		out.println("<td><input type=text name=cr size=30></td></tr>");
		
		
		out.println("<tr><td><input type=submit></td>");
		out.println("<td><input type=reset></td></tr>");
				out.println("</table></form></html>");
				out.flush();
	 	



	}

}
