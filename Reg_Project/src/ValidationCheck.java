

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Statement;

public class ValidationCheck extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 String username=request.getParameter("username");
		 String password=request.getParameter("password");
		 String age=request.getParameter("age");
		 String email=request.getParameter("email");
		 String address=request.getParameter("address");
		 String gender=request.getParameter("gender");
		 String skills=request.getParameter("skills");
		 String education=request.getParameter("education");
		 String resume=request.getParameter("resume");
try
{
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://192.168.0.108:3306/iyappan","root","olabsys@123");
	Statement stmt=con.createStatement();
	String sql="insert into iyap(username,password,age,email,gender,address,skills,education,resume)values('"+username+"','"+password+"',"+age+",'"+email+"','"+gender+"','"+address+"','"+skills+"','"+education+"','"+resume+"')";
	stmt.execute(sql);
	RequestDispatcher rd=request.getRequestDispatcher("SuccessPage.html");
	rd.forward(request,response);

	

	stmt.close();
	con.close();
	
	
}


catch(Exception e)
{  
    System.out.println("Exception is ;"+e);  
    }  


}
}
	
