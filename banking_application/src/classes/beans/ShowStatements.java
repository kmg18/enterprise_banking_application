package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowStatements {
	
	public ResultSet showt(String acc1)
	{
		long acc=Long.parseLong(acc1);
		ResultSet rs=null;
		try{
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
		Connection con = ConnectionBean.getConnection();
		Statement stmt = con.createStatement();
		//System.out.println("IN verify bean "+id+" "+pwd);
		String sql = "select FROMACCOUNT,TOACCOUNT,TYPE,TDATE,AMOUNT from TRANSACTIONS where FROMACCOUNT="+acc+" AND ROWNUM <= 10 order by tdate desc";
		System.out.println(sql);
		rs = stmt.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return rs;
		
		
	}
	
	public ResultSet show(String acc1,String f,String t)
	{
		long acc=Long.parseLong(acc1);
		ResultSet rs=null;
		try{
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
			Connection con = ConnectionBean.getConnection();
		Statement stmt = con.createStatement();
		//System.out.println("IN verify bean "+id+" "+pwd);
		String sql = "select FROMACCOUNT,TOACCOUNT,TYPE,TDATE,AMOUNT from TRANSACTIONS where FROMACCOUNT="+acc+" and trunc(TDATE) between to_date('"+f+"','yyyy-mm-dd') and to_date('"+t+"','yyyy-mm-dd') order by tdate desc";
		System.out.println(sql);
		rs = stmt.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return rs;
		
		
	}
	
	public ResultSet balance(int id)
	{
		//long acc=Long.parseLong(acc1);
		ResultSet rs=null;
		try{
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
			Connection con = ConnectionBean.getConnection();
		Statement stmt = con.createStatement();
		//System.out.println("IN verify bean "+id+" "+pwd);
		String sql = "select ACCOUNTNUMBER,ACCOUNTTYPE,AMOUNT from ACCOUNT where CUSTOMERID="+id;
		System.out.println(sql);
		rs = stmt.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return rs;
		
		
	}

}
