// http://localhost/phpmyadmin/

package firsttestngpackage;

import org.testng.annotations.Test;
import java.sql.*;


public class ConnectiontoDB {
@Test
public void f() {
	  
try{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection con=DriverManager.getConnection("jdbc:odbc:SeleniumDB","root","");

	Statement stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery("SELECT * FROM customers");
	
	while(rs.next()) {
		
	//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
	System.out.println(rs.getString("phone")+"   ==>   "+rs.getString("contactFirstName")+"   ==>   "+rs.getString("state"));
	
	}
	con.close();
	
	}
	catch(Exception e){
		System.out.println(e);
		}
	
}
}