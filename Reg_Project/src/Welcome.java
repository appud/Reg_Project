
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Welcome extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
			{

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String n=request.getParameter("username");
		out.print("Welcome to Olabsys : "+n);
		out.println("<br/>");
		out.println("<a href='ManagerLogin.html'>ManagerLogin </a>");
		out.println("<br/>");
		out.println("<a href='EmpList.html'>List of Emp</a>");
		
		out.close();
	}

}
