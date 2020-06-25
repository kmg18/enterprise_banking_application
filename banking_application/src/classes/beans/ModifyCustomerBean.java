package beans;

import java.sql.*;

public class ModifyCustomerBean {
	public ResultSet retrieve(int id)
	{
		ResultSet rs = null;
		try
		{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
			Connection con = ConnectionBean.getConnection();
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery("select email,phonenumber,address,customerid from customerinfo where customerid="+id);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return rs;
	}
}
