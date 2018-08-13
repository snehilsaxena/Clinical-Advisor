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
 * Servlet implementation class DisplayClinicByID
 */
@WebServlet("/DisplayClinicByID")
public class DisplayClinicByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayClinicByID() {
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
			ResultSet rs=ClinicController.DisplayClinicByID(request.getParameter("clid"));
			if(rs.next())
			{
				out.println("<script src=asset/jquery-2.2.1.min.js></script>");
				out.println("<script src=asset/state.js></script>");
				out.println("<html>");
				out.println("<form action=ClinicEditDelete method=post enctype='multipart/form-data'>");
				out.println("<a href=DisplayAllClinic>Display All Clinic</a><br>");
				out.println("<table><tr><td>");
				out.print("<table>");
				out.println("<caption><b><i>Clinic Register[Update]</i></b></caption>");
				
				out.println("<tr><td><b><i>Type Id:</i></b></td>");
				out.println("<td><input type=text name=tid size=30 value='"+rs.getString(1)+"'></td></tr>");
				
				
				out.println("<tr><td><b><i>Clinic Id:</i></b></td>");
				out.println("<td><input type=text name=clid size=30 value='"+rs.getString(2)+"'></td></tr>");
				
				out.println("<tr><td><b><i>Clinic name:</i></b></td>");
				out.println("<td><input type=text name=clin size=30 value='"+rs.getString(3)+"'></td></tr>");
				
				out.println("<tr><td><b><i>Doctor name:</i></b></td>");
	
				String dn=rs.getString(4);
				String cdn[]=dn.split(" ");
				out.println("<td><input type=text name=dn placeholder='First Name' size=30 value='"+cdn[0]+"'><br><input type=text name=odn placeholder='Second Name' size=30 value='"+cdn[1]+"'></td></tr>");
				
				
				out.println("<tr><td><b><i>Specialist:</i></b></td>");
				out.println("<td><input type=text name=cs size=30 value='"+rs.getString(5)+"'></td></tr>");
				
				out.println("<tr><td><b><i>Experience:</i></b></td>");
				out.println("<td><input type=text name=de size=30 value='"+rs.getString(6)+"'></td></tr>");

				out.println("<tr><td><b><i>Payment:</i></b></td>");
				out.println("<td><input type=text name=dp size=30 value='"+rs.getString(7)+"'></td></tr>");
				
				out.println("<tr><td><b><i>Opening time:</i></b></td>");
				out.println("<td><input type=text name=ot size=30 value='"+rs.getString(8)+"'></td></tr>");
				
				out.println("<tr><td><b><i>Closing time:</i></b></td>");
				out.println("<td><input type=text name=ct size=30 value='"+rs.getString(9)+"'></td></tr>");
				
				out.println("<tr><td><b><i>Mobile No:</i></b></td>");
				out.println("<td><input type=text name=cmob size=30 value='"+rs.getString(10)+"'></td></tr>");
				
				out.println("<tr><td><b><i>Email Id:</i></b></td>");
				out.println("<td><input type=email name=cm size=30 value='"+rs.getString(11)+"'></td></tr>");				
				
				out.println("<tr><td><b><i>Address:</i></b></td>");
				out.println("<td><textarea rows=3 cols=30 name=cad >"+rs.getString(12)+"</textarea></td></tr>");
				
				out.println("<tr><td><b><i>State:</i></b></td>");
				out.println("<td><select name=cstate id=cstate></select>&nbsp;&nbsp;<input type=text name=cstate1 value='"+rs.getString(13)+"' readonly=true size=15></td></tr>");
				
				out.println("<tr><td><b><i>City:</i></b></td>");
				out.println("<td><select name=ccity id=ccity></select>&nbsp;&nbsp;<input type=text name=ccity1 value='"+rs.getString(14)+"' readonly=true size=15></td></tr>");
				
				out.println("<tr><td><b><i>Other Facility:</i></b></td>");
				out.println("<td><input type=text name=of size=30 value='"+rs.getString(15)+"'></td></tr>");
				
				
				out.println("<tr><td><b><i>Certificate:</i></b></td>");
				out.println("<td><input type=text name=ecr size=30 value='"+rs.getString(16)+"'></td></tr>");
				
				
				out.println("<tr><td><input type=submit value=Edit name=btn></td>");
				out.println("<td><input type=submit value=Delete name=btn></td></tr>");
						out.println("</table></td>");
						
			   out.println("<th valign=top><img src=images/doctor/"+rs.getString(17)+" width=225 height=250><br><br><input type=file name=dph>&nbsp;&nbsp;<input type=submit value='Edit Picture' name=btn></th></tr></table>");
			   out.println("</form></html>");
				 
			}
			else
			{
			out.println("Record Not Found....");	
			}
			
			
			
			 
			 
		 }catch(Exception e)
		 {
			 out.println("DisplayClinicByID"+e);
			 
		 }
		out.flush();
	}

}
