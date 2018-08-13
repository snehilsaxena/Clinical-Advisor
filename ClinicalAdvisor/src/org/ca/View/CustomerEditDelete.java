package org.ca.View;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ca.controller.CustomerController;

import org.ca.Model.Customer;

/**
 * Servlet implementation class CustomerEditDelete
 */
@WebServlet("/CustomerEditDelete")
public class CustomerEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerEditDelete() {
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
		   String btn=request.getParameter("btn");
		    if(btn.equals("Edit"))
		    {
		    	
		    	Customer C=new Customer();
		   C.setCustomerid(request.getParameter("cid"));
		   C.setCustomername(request.getParameter("cfn")+" "+request.getParameter("cln"));
		   C.setDob(request.getParameter("cdob"));
		   C.setGender(request.getParameter("cg"));
		   C.setDisease(request.getParameter("cd"));
		   C.setAddress(request.getParameter("cadd"));
		   if(request.getParameter("cstate").equals("-Select-"))
		   C.setState(request.getParameter("cstate1"));
		   else
		   C.setState(request.getParameter("cstate"));
		  
		   if(request.getParameter("ccity").equals("-Select-"))  
		   C.setCity(request.getParameter("ccity1"));
		   else 
			 C.setCity(request.getParameter("ccity"));
		   C.setMobno(request.getParameter("cmo"));
		   C.setEmail(request.getParameter("cem"));
		
		C.setReferenceby(request.getParameter("cr"));
		
		boolean st=CustomerController.EditRecord(C);
		 response.sendRedirect("DisplayAllCustomers");
		    
		     }
		 	
		    else if(btn.equals("Delete"))
		    {
		    boolean st=CustomerController.DeleteRecord(request.getParameter("cid")); 	
		    response.sendRedirect("DisplayAllCustomers");
		    }
		    	
		    	
		    }catch(Exception e)
		    {System.out.println("Customer/EditDelete"+e);
		    	
		    }
	
	
	
	
	}
	}


