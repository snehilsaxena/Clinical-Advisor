package org.ca.View;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ca.controller.DBHelper;

import org.ca.controller.StateController;
import org.json.JSONObject;

/**
 * Servlet implementation class FetchStatesJSON
 */
@WebServlet("/FetchStatesJSON")
public class FetchStatesJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchStatesJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		try{
	   ResultSet rs=StateController.DisplayAll();		
		 ArrayList<JSONObject> obj=DBHelper.JsonEngine(rs);	
		 out.println(obj);
		}
		catch(Exception e)
		{out.println("statesjson"+e);
	}

}}
