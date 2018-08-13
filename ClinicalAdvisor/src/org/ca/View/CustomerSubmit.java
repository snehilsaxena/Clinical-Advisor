package org.ca.View;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ca.controller.CustomerController;
import org.ca.Model.Customer;

/**
 * Servlet implementation class CustomerSubmit
 */
@WebServlet("/CustomerSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)

public class CustomerSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerSubmit() {
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
	   Customer C=new Customer();
	   C.setCustomerid(request.getParameter("cid"));
	   C.setCustomername(request.getParameter("cfn")+" "+request.getParameter("cln"));
	   C.setDob(request.getParameter("cdob"));
	   C.setGender(request.getParameter("cg"));
	   C.setDisease(request.getParameter("cd"));
	 
	   C.setAddress(request.getParameter("cadd"));
	   C.setState(request.getParameter("cstate"));
	   C.setCity(request.getParameter("ccity"));

       C.setMobno(request.getParameter("cmo"));
	   C.setEmail(request.getParameter("cem"));
       C.setPassword(request.getParameter("cpass"));
      
       C.setReferenceby(request.getParameter("cr"));
    
       
	   boolean st=CustomerController.addNewRecord(C);
	   if(st)
	   {out.println("Record Submitted");
		   
	   }
	   else
	   {
		   out.println("Fail to Submit record...");
		   
	   }
	      
	   }
	catch(Exception e)
	    {System.out.println("CustomerSubmit"+e);
	    	
	    }
	    }
	}


