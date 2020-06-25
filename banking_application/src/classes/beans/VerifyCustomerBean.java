package beans;

import java.sql.*;

public class VerifyCustomerBean {
	
	public boolean isNew(int id)
	{
		boolean flag = false;
		try
		{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
			Connection con = ConnectionBean.getConnection();
			Statement stmt = con.createStatement();
//			System.out.println("IN verify bean "+id+" "+pwd);
			String sql = "select * from CUSTOMER where CUSTOMERID="+id+" and TRANSACTIONPASSWORD is NULL";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				flag=true;
			}
			else
			{
				System.out.println("no record");
			}
			rs.close();
			stmt.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}
	
	
	public boolean verify(int id,String pwd)
	{
		boolean flag = false;
		try
		{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
			Connection con = ConnectionBean.getConnection();
			
			Statement stmt = con.createStatement();
//			System.out.println("IN verify bean "+id+" "+pwd);
			String sql = "select * from CUSTOMER a inner join CUSTOMERINFO b on a.customerid=b.customerid and a.CUSTOMERID="+id+" and a.PASSWORD='"+pwd+"' and b.Profilestatus=1";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
//				System.out.println(rs.getInt(1)+"  "+rs.getString(2));
				if( (rs.getInt(1)==id) && (rs.getString(2).equals(pwd)) )
				{	
					flag = true;
				}
			}
			else
			{
				System.out.println("no record");
			}
			rs.close();
			stmt.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}
	
	public String getUname(int cid)
	{
		String uname = null;
		try
		{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
			Connection con = ConnectionBean.getConnection();
			Statement stmt = con.createStatement();
			String sql = "select firstname,lastname from CUSTOMERINFO where customerid="+cid;
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				uname = rs.getString(1)+" "+rs.getString(2);
			}
			System.out.println(uname);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return uname;
	}
	
}
