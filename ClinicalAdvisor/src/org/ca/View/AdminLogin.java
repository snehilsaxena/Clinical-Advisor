package org.ca.View;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		 
		/*out.println("<html>");
		out.println("<form action=CheckAdminLogin method=post>");
		 
		out.print("<table>");
		out.println("<caption><b><i>Administrator Login</i></b></caption>");
		
		out.println("<tr><td><b><i>Admin Id:</i></b></td>");
		out.println("<td><input type=text name=aid size=30></td></tr>");
		
		
		
		out.println("<tr><td><b><i>Password:</i></b></td>");
		out.println("<td><input type=password name=pwd size=30></td></tr>");

		out.println("<tr><td><input type=submit value='Login'></td>");
		out.println("<td>&nbsp;</td></tr>");

	}

}*/
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println(".loginform{");
		out.println(" padding:10px;");
		out.println(" border:1px solid pink;");
		out.println(" border-radius:10px;");
		out.println(" width:300px;");
		out.println(" margin-top:10px;");
		out.println("}");
		out.println(".formheading{");
			out.println(" background-color:purple;");
		out.println("color:white;");
		out.println("padding:4px;");
		out.println("text-align:center;");
		out.println("}");
		out.println(".sub{");
		out.println("background-color:purple;");
		out.println("padding: 7px 40px 7px 40px;");
		out.println("color:white;");
		out.println("font-weight:bold;");
		out.println("margin-left:70px;");
		out.println("border-radius:5px;");
		out.println("}");

		out.println(" div {");
				 
				 
				  out.println(" width: 100px;");
				    
				    out.println(" height: 200px;");
				    
				    out.println(" background-color: pink;");

				   
				    out.println(" position: absolute;");
				    
				    out.println(" top:35%;");
				    
				     
		out.println(" bottom: 50%;");

		out.println(" left: 35%;");

		out.println(" right: 50%;");


		out.println(" margin: auto;");

		out.println("  }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='loginform' >");
		out.println("<h3 class='formheading'>Admin Login</h3>");
		out.println("<form action='CheckAdminLogin' method='post'>");
		out.println("<table align=center>");
		out.println("<tr><td>Admin ID:</td><td><input type='text' name='aid'/></td></tr>");
		out.println("<tr><td>Password:</td><td><input type='password' name='pwd'/></td></tr>");
		out.println("<tr><td colspan='2' style='text-align:center'><input class='sub' type='submit' value='login'/></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		}

		}

