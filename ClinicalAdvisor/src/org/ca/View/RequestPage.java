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

import org.ca.Model.Admin;
import org.ca.Model.Customer;

/**
 * Servlet implementation class RequestPage
 */
@WebServlet("/RequestPage")
public class RequestPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestPage() {
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
		 //session management
		  String id="";
		 HttpSession ses=request.getSession();
		 try{
			
		 String ltime=ses.getValue("SLTIME").toString();	
		 Customer C=(Customer)(ses.getValue("SCUSTOMER"));	
		id=C.getCustomerid(); 
       String nav="<i>Customer:"+C.getCustomername()+"["+C.getCustomerid()+"]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ltime+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=CustomerLogout>Logout</a></i><br><br>";		 
		 out.println(nav);
		}catch(Exception e){
			response.sendRedirect("CustomerLogin");
		}
		
		/////////////////
	
	
	out.println("<script src=asset/jquery-2.2.1.min.js></script>");
	out.println("<script src=asset/state.js></script>");
	out.println("<html>");
	out.println("<form action=RequestPageSubmit>");
	 
	out.print("<table>");
	out.println("<caption><b><i>Complaint Register</i></b></caption>");
	Calendar C=Calendar.getInstance();
	String cd=C.get(Calendar.YEAR)+"/"+(C.get(Calendar.MONTH)+1)+"/"+C.get(Calendar.DATE);
	//String []ap={"AM","PM"};
	String ct=C.get(Calendar.HOUR)+":"+C.get(Calendar.MINUTE)+":"+C.get(Calendar.SECOND);
	//+" "+ap[C.get(Calendar.AM_PM)];
	String cdd=cd+" "+ct;
	out.println("<tr><td><b><i>Current Date:</i></b></td>");
	out.println("<td><input type=text name=cd size=30 value='"+cdd+"'></td></tr>");
	
	out.println("<tr><td><b><i>Customer:</i></b></td>");
	out.println("<td><input type=text name=cid id=cid value="+id+"></td></tr>");

	
 
	out.println("<tr><td><b><i>State:</i></b></td>");
	out.println("<td><select id=cstate name=cstate ></td></tr>");

	
	 out.println("<tr><td><b><i>City:</i></b></td>");
	out.println("<td><select id=ccity name=ccity></select></td></tr>");
	
	out.println("<tr><td><b><i>Clinic:</i></b></td>");
	out.println("<td><select id=cliid name=cliid></select></td></tr>");
	
	out.println("<tr><td><b><i>Time:</i></b></td>");
	out.println("<td><input type=time id=time name=time></select></td></tr>");
	
	out.println("<tr><td><b><i>Date:</i></b></td>");
	out.println("<td><input type=date id=date name=date></select></td></tr>");
	
	out.println("<tr><td><b><i>Purpose:</i></b></td>");
	out.println("<td><input type=text id=text name=purpose></select></td></tr>");
	
	out.println("<tr><td><b><i>Status:</i></b></td>");
	out.println("<td><input type=text id=text name=status></select></td></tr>");
	
	out.println("<tr><td><input type=submit></td>");
	out.println("<td><input type=reset></td></tr>");
			out.println("</table></form></html>");
			out.flush();


}

}
		