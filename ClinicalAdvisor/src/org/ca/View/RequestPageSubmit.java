package org.ca.View;

import java.io.IOException;
import java.io.PrintWriter;
import org.ca.Model.RequestPage;
import org.ca.controller.ClinicController;
import org.ca.controller.RequestPageController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestPageSubmit
 */
@WebServlet("/RequestPageSubmit")
public class RequestPageSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestPageSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try{
		PrintWriter out=	response.getWriter();
	RequestPage R = new RequestPage();
	R.setCid(request.getParameter("cid"));
	R.setState(request.getParameter("cstate"));
	R.setCity(request.getParameter("ccity"));
	R.setClinic(request.getParameter("cliid"));
	R.setTime(request.getParameter("time"));
	R.setDate(request.getParameter("date"));
	R.setPurpose(request.getParameter("purpose"));
	R.setPurpose(request.getParameter("status"));
	boolean st=RequestPageController.addNewRecord(R);
	if(st)
	   {
		   
		   out.println("record submitted");
		   
	   }
	   else
	   {
		   out.println("record not found....");	   
	   }
	    
	}catch(Exception e){System.out.println(e);}
	
	
	
	}

	
}
