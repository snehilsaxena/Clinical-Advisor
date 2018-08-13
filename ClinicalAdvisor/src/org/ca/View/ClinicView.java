package org.ca.View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClinicView
 */
@WebServlet("/ClinicView")

public class ClinicView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClinicView() {
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
		out.println("<script src=asset/state.js></script>");
		out.println("<html>");
		out.println("<form action=ClinicSubmit method=post enctype='multipart/form-data'>");
		out.println("<a href=DisplayAllClinic>Display All Clinic</a><br>");
		out.print("<table>");
		out.println("<caption><b><i>Clinic Register</i></b></caption>");
		
		out.println("<tr><td><b><i>Type Id:</i></b></td>");
		out.println("<td><input type=text name=tid size=30></td></tr>");
		
		out.println("<tr><td><b><i>Clinic Id:</i></b></td>");
		out.println("<td><input type=text name=clid size=30></td></tr>");
		
		out.println("<tr><td><b><i>Clinic Name:</i></b></td>");
		out.println("<td><input type=text name=clin size=30></td></tr>");
		 
		out.println("<tr><td><b><i>Doctor Name:</i></b></td>");
		out.println("<td><input type=text name=dn placeholder='First Name' size=30>&nbsp;&nbsp;<input type=text name=odn placeholder='Second Name' size=30></td></tr>");
		
		out.println("<tr><td><b><i>Specialist:</i></b></td>");
		out.println("<td><input type=text name=cs size=30></td></tr>");
		
		out.println("<tr><td><b><i>Experience:</i></b></td>");
		out.println("<td><input type=text name=de size=30></td></tr>");

		out.println("<tr><td><b><i>Payment:</i></b></td>");
		out.println("<td><input type=text name=dp size=30></td></tr>");
		
		out.println("<tr><td><b><i>Opening time:</i></b></td>");
		out.println("<td><input type=text name=ot size=30></td></tr>");
		
		out.println("<tr><td><b><i>Closing time:</i></b></td>");
		out.println("<td><input type=text name=ct size=30></td></tr>");
		
		out.println("<tr><td><b><i>Mobile No:</i></b></td>");
		out.println("<td><input type=text name=cmob size=30>");
		
		out.println("<tr><td><b><i>Email Id:</i></b></td>");
		out.println("<td><input type=email name=cm size=30></td></tr>");
		
		out.println("<tr><td><b><i>Address:</i></b></td>");
		out.println("<td><textarea row=3 cols=30 name=cad ></textarea></td></tr>");
		
		out.println("<tr><td><b><i>State:</i></b></td>");
		out.println("<td><select name=cstate id=cstate></select></td></tr>");
		
		out.println("<tr><td><b><i>City:</i></b></td>");
		out.println("<td><select name=ccity id=ccity></select></td></tr>");
		
		out.println("<tr><td><b><i>Other facilities:</i></b></td>");
		out.println("<td><input type=text name=of size=30></td></tr>");
		
		out.println("<tr><td><b><i>Certificate:</i></b></td>");
		out.println("<td><input type=text name=ecr size=30></td></tr>");
		
		
		
		out.println("<tr><td><b><i>Doctor Photograph:</i></b></td>");
		out.println("<td><input type=file name=dph size=30></td></tr>");
		
		out.println("<tr><td><input type=submit></td>");
		out.println("<td><input type=reset></td></tr>");
				out.println("</table></form></html>");
				out.flush();
	}
	
	}


