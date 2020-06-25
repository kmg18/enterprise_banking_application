package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VeriCustomer {
	public boolean verify(String cid)
	{
		boolean flag = false;
		String a=null;
		String b=null;
		int ano=Integer.parseInt(cid);
		try
		{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
			Connection con = ConnectionBean.getConnection();
			Statement stmt = con.createStatement();
			//System.out.println("IN verify bean "+id+" "+pwd);
			String sql = "select CUSTOMERID from CUSTOMERINFO where CUSTOMERID="+ano+ "AND PROFILESTATUS=1";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				
				
				
				//System.out.println(rs.getInt(1)+"  "+rs.getString(2));
				if( (rs.getInt(1)==ano)  )
				{	
					flag = true;
				}
			}
			else
			{
				System.out.println("no record");
			}
			System.out.println(flag);
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
	
	public ResultSet verifyacc(String cid)
	{
		boolean flag = false;
		int ano=Integer.parseInt(cid);
		//long a=Long.parseLong(acc);
		long b;
		ResultSet rs1=null;
		int amt;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
			Statement stmt = con.createStatement();
			//System.out.println("IN verify bean "+id+" "+pwd);
			String sql = "select CUSTOMERID from CUSTOMERINFO where CUSTOMERID="+ano+ "AND PROFILESTATUS=1";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				String sql1 = "select ACCOUNTNUMBER,AMOUNT from ACCOUNT where accountstatus=0 and CUSTOMERID="+rs.getInt(1)+"";
				System.out.println(sql1);
				 rs1 = stmt.executeQuery(sql1);
				
				
				//System.out.println(rs.getInt(1)+"  "+rs.getString(2));
				
					return rs1;
					
				}
				
				else
					{
					flag=false;
					return rs;
					}
			
		}
				
		catch(Exception e)
		{
			System.out.println(e);
		}
		return rs1;
		
	}
	public boolean closeacc(String acc)
	{
		boolean flag = false;
		//int ano=Integer.parseInt(cid);
		long a=Long.parseLong(acc);
		long b;
		int amt;
		try
		{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
			Connection con = ConnectionBean.getConnection();
			Statement stmt = con.createStatement();
			//System.out.println("IN verify bean "+id+" "+pwd);
			String sql = "update ACCOUNT set ACCOUNTSTATUS=0 where ACCOUNTNUMBER="+a+"";
			
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			flag=true;
			
			
			//Extra code for deleting profile
			rs = stmt.executeQuery("select customerid from account where ACCOUNTNUMBER="+a);	
			if(rs.next())
			{
				ResultSet rs1 = stmt.executeQuery("select count(*) from account where accountstatus=1 and  customerid="+rs.getInt(1));
				if(rs1.next() && rs1.getInt(1)==0)
				{
					stmt.executeUpdate("update customerinfo set profilestatus=0 where customerid="+a);
				}
			}
				//System.out.println(rs.getInt(1)+"  "+rs.getString(2));
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

}
