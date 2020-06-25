package beans;
import java.sql.*;

public class SecurityQuestionBean {
	public ResultSet getquestion(int cid)
	 {
	 ResultSet rs=null;
	 try
	 {
//		 Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
		 Connection con = ConnectionBean.getConnection();
			Statement stmt = con.createStatement();
			rs=stmt.executeQuery("select question from security where customerid="+cid);
		
	 }
	 catch (Exception e)
	 {
		 System.out.println(e);
	 }
	 return rs;
	 }
	public String checkAnswers(Long e1,String e2,String e4,int cid)
	{
		String result = null;
		try
		 {
//			 Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
			Connection con = ConnectionBean.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from security where customerid="+cid+" and firstphoneno="+e1+" and bestbdaygift='"+e2+"' and answer='"+e4+"'");
			if(rs.next())
			{
				result = "Successful";
			}
			else
			{
				result = "Failed";
			}
			rs.close();
			con.close();
			stmt.close();
		 }
		 catch (Exception e)
		 {
			 result = "Failed";
			 System.out.println(e);
		 }
		return result;
	}
	
	public String updatePassword(int cid,String pwd)
	{
		String result = null;
		try
		 {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
			Connection con = ConnectionBean.getConnection();
			Statement stmt = con.createStatement();
			stmt.executeUpdate("update customer set password='"+pwd+"' where customerid="+cid);
			result = "Successful";
			
			stmt.close();
			con.close();
			
		 }
		 catch (Exception e)
		 {
			 result = "Failed";
			 System.out.println(e);
		 }
		return result;
	}
}
