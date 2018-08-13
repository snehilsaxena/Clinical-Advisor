package org.ca.View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ca.Model.Admin;
import org.ca.Model.Customer;
import org.ca.controller.AdminController;
import org.ca.controller.CustomerController;

/**
 * Servlet implementation class CheckCustomerLogin
 */
@WebServlet("/CheckCustomerLogin")
public class CheckCustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCustomerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			PrintWriter out=response.getWriter();
		Customer C=CustomerController.checkPassword(request.getParameter("cid"),request.getParameter("pwd"));	
		out.println("<html>");	
		if(C==null)
			{out.println("<font color=red>Invalid Userid/Password</font>");
			 	
			}
		else
		{ HttpSession ses=request.getSession();
		   ses.putValue("SCUSTOMER", C);
		   ses.putValue("SLTIME", new java.util.Date());
			response.sendRedirect("RequestPage");
		}
		}
		catch(Exception e)
		{System.out.println(e);
			
		}
		
		
		}

	

		
		
	}

