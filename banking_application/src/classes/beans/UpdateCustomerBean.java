package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;

public class UpdateCustomerBean {
	public int updatecustomerdetails(String email,Long pno,String address,int cid)
	{
		try
		{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
			Connection con = ConnectionBean.getConnection();
			Statement stmt = con.createStatement();
			stmt.addBatch("update customerinfo set email='"+email+"' where customerid="+cid);
			stmt.addBatch("update customerinfo set phonenumber="+pno+" where customerid="+cid);
			stmt.addBatch("update customerinfo set address='"+address+"' where customerid="+cid);
			stmt.executeBatch();
			stmt.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return 0;
		}
		return 1;
	}
}
