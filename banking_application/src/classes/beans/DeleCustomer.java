package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleCustomer {
	public boolean verify(String cid)
	{
		boolean flag = false;
		//String a=null;
		//String b=null;
		int c=Integer.parseInt(cid);
		//long ano=Long.parseLong(accno);
		try
		{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
			Connection con = ConnectionBean.getConnection();
			Statement stmt = con.createStatement();
			//System.out.println("IN verify bean "+id+" "+pwd);
			String sql = "select CUSTOMERID from CUSTOMERINFO where CUSTOMERID="+c+ "AND PROFILESTATUS=1";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				String sql1 = "select ACCOUNTNUMBER from ACCOUNT where CUSTOMERID="+rs.getInt(1)+" AND ACCOUNTSTATUS=1";
				System.out.println(sql1);
				ResultSet rs1 = stmt.executeQuery(sql1);
				
				
				//System.out.println(rs.getInt(1)+"  "+rs.getString(2));
				if(rs1.next())
				{
					
					flag = false;
					
				}
				
				else flag=true;
				System.out.println(flag);
				
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
	
	public ResultSet del(String cid)
	{
		int c=Integer.parseInt(cid);
		ResultSet rs=null;
		try{
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
		Connection con = ConnectionBean.getConnection();
		Statement stmt = con.createStatement();
		//System.out.println("IN verify bean "+id+" "+pwd);
		String sql = "select CUSTOMERID,FIRSTNAME,SSN from CUSTOMERINFO where CUSTOMERID="+c+ "AND PROFILESTATUS=1";
		System.out.println(sql);
		rs = stmt.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return rs;
		
		
	}
	public boolean deleuser(String cid)
	{
		boolean flag = false;
		int c=Integer.parseInt(cid);
		//long a=Long.parseLong(acc);
		long b;
		//int amt;
		try
		{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
			Connection con = ConnectionBean.getConnection();
			Statement stmt = con.createStatement();
			//System.out.println("IN verify bean "+id+" "+pwd);
			String sql = "update CUSTOMERINFO set PROFILESTATUS=0 where CUSTOMERID="+c+"";
			
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			flag=true;
				
				
				
				//System.out.println(rs.getInt(1)+"  "+rs.getString(2));
				
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}

}
