package org.ca.View;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ca.Model.Customer;

/**
 * Servlet implementation class CustomerHome
 */
@WebServlet("/CustomerHome")
public class CustomerHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String cid="";
		 out.println("<html>");
		 //session management
		 HttpSession ses=request.getSession();
		 try{
			
		 String ltime=ses.getValue("SLTIME").toString();	
		 Customer C=(Customer)(ses.getValue("SCUSTOMER"));	
		
		 cid=C.getCustomerid();
        String nav="<i>Admin:"+C.getCustomername()+"["+C.getCustomerid()+"]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ltime+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=CustomerLogout>Logout</a></i><br><hr>";		 
		 out.println(nav);
		}catch(Exception e){
			response.sendRedirect("CustomerLogin");
			
		}
		/////////////////
		
		out.println("<html width=100%>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td valign=top>");
		out.println("<a href=RequestPage target=mw>ADD NEW APPOINTMENT</a><br>");
		out.println("<a href=CheckStatus?cid="+cid+" target=mw>Update Customer</a><br>");
		out.println("</td>");
		out.println("<td>");
		out.println("<iframe width=1000 height=700 frameborder=0 name=mw></iframe>");
		out.println("</table></form></html>");
	}


}
