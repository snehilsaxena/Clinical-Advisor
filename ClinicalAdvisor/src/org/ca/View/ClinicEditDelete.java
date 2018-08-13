package org.ca.View;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.ca.controller.ClinicController;
import org.ca.Model.Clinic;
import org.softech.FileUpload;

/**
 * Servlet implementation class ClinicEditDelete
 */
@WebServlet("/ClinicEditDelete")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class ClinicEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClinicEditDelete() {
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
	    	
	    	Clinic C=new Clinic();
	  
	    	C.setTypeid(request.getParameter("tid"));
			C.setClinicid(request.getParameter("clid"));
			C.setClinicname(request.getParameter("clin"));
			C.setDoctorname(request.getParameter("dn")+" "+request.getParameter("odn"));
			 C.setSpecialist(request.getParameter("cs"));
			 C.setExperience(request.getParameter("de"));
			 C.setPayment(request.getParameter("dp"));
			 C.setOpeningtime(request.getParameter("ot"));
			 C.setClosingtime(request.getParameter("ct"));
			 C.setClimobno(request.getParameter("cmob"));
			 C.setCliemail(request.getParameter("cm"));
	   
	   C.setCliaddress(request.getParameter("cad"));
	   if(request.getParameter("cstate").equals("-Select-"))
	   C.setClistate(request.getParameter("cstate1"));
	   else
	   C.setClistate(request.getParameter("cstate"));
	  
	   if(request.getParameter("ccity").equals("-Select-"))  
	   C.setClicity(request.getParameter("ccity1"));
	   else 
		 C.setClicity(request.getParameter("ccity"));

	 boolean st=ClinicController.EditRecord(C);
	 response.sendRedirect("DisplayAllClinic");
	    
	    
	    }
	    else if(btn.equals("Edit Picture"))
	    {
	    
	//fileupload
	    	Part part=request.getPart("dph");
			String path="C:/Users/HP/workspace/ClinicalAdvisor/WebContent/images/doctor";
			FileUpload f=new FileUpload(part,path);
	 	    boolean st=ClinicController.EditPicture(f.filename, request.getParameter("clid"));
	 	response.sendRedirect("DisplayAllClinic");
	    }
	    else if(btn.equals("Delete"))
	    {
	    boolean st=ClinicController.DeleteRecord(request.getParameter("clid")); 	
	    response.sendRedirect("DisplayAllClinic");
	    }
	    	
	    	
	    }catch(Exception e)
	    {System.out.println("ClinicEditDelete"+e);
	    	
	    }
	
	}

}
