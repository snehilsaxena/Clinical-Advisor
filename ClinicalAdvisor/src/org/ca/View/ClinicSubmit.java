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
 * Servlet implementation class ClinicSubmit
 */
@WebServlet("/ClinicSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)

public class ClinicSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClinicSubmit() {
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
			C.setClistate(request.getParameter("cstate"));
			C.setClicity(request.getParameter("ccity"));
			C.setOtherfacility(request.getParameter("of"));
			C.setCertificate(request.getParameter("ecr"));
		
			
			
			//for file uploading
			Part part=request.getPart("dph");
			String path="C:/Users/HP/workspace/ClinicalAdvisor/WebContent/images/doctor";
			FileUpload f=new FileUpload(part,path);
			C.setDoctorphotoes(f.filename);
			
			boolean st=ClinicController.addNewRecord(C);
			if(st)
			   {
				   
				   out.println("record submitted");
				   
			   }
			   else
			   {
				   out.println("record not found....");	   
			   }
			      	
			    }catch(Exception e)
			    {System.out.println("clinicSubmit"+e);
			    	
			    }
	
	}

}
