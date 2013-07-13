

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManagerLogin
 */
@WebServlet("/ManagerLogin")
public class ManagerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("Manager login ");
		out.println("<br/>");
		
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://192.168.0.108:3306/iyappan","root","olabsys@123");
             PreparedStatement pst=con.prepareStatement("select * from manager");
			
             
             ResultSet rs =  pst.executeQuery();
             while (rs.next()) {
                 String username=(rs.getString("username"));             

                 if(username.equals(userName)){                     
                	 out.println("You are valid User");

                 }
                 else
                 {                          
                	 out.println("Sorry , You are Not Valid User");
         }
           }
      }catch (Exception ex) {
             ex.printStackTrace();
          }
      }      
			
}
