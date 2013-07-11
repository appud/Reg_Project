import java.sql.*;
public class ValidationDB
{
public static boolean validate(String name,String pass)
{
boolean status=false;
try {
	  Class.forName("com.mysql.jdbc.Driver");
	   Connection con =DriverManager.getConnection("jdbc:mysql://192.168.0.108:3306/iyappan","root","olabsys@123");
		PreparedStatement ps=con.prepareStatement("select * from iyap where username=? and password=?");
		ps.setString(1,name);
		ps.setString(2,pass);
		
		ResultSet rs=ps.executeQuery();
		status=rs.next();
}

catch(Exception e){System.out.println(e);}
return status;
}
}
	