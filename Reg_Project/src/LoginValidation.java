import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginValidation extends HttpServlet
{
  public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException
  {
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  Connection con = null;  
  Statement stmt = null;
  ResultSet rs = null;
  String n=request.getParameter("username");
  String p=request.getParameter("password");
  
  if(ValidationDB.validate(n, p))
	{
		RequestDispatcher rd=request.getRequestDispatcher("Welcome");
		rd.forward(request,response);
	}
	else
	{
		out.print("Sorry username or password error");
		RequestDispatcher rd=request.getRequestDispatcher("LoginPage.html");
		rd.include(request,response);
	}
 
  }
}