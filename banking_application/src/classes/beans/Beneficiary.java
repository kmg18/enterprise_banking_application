package beans;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.AutoGenerator;

public class Beneficiary {
	public boolean verify(String accno,String name)
	{
		boolean flag = false;
		String a=null;
		String b=null;
		long ano=Long.parseLong(accno);
		try
		{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
			Connection con = ConnectionBean.getConnection();
			Statement stmt = con.createStatement();
			//System.out.println("IN verify bean "+id+" "+pwd);
			String sql = "select CUSTOMERID from ACCOUNT where ACCOUNTNUMBER="+ano+ "AND ACCOUNTSTATUS=1";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				
					flag = true;
					
				
				
				
			}
			else
			{
				System.out.println("no record");
			}
			rs.close();
			con.close();
			stmt.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}
	
	public ResultSet retrieve(int x)
	{
		boolean flag = false;
		String a=null;
		String b=null;
		int cid=x;
		//System.out.print(cid);
		ResultSet rs=null;
		try
		{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
			Connection con = ConnectionBean.getConnection();
			Statement stmt = con.createStatement();
			 rs = stmt.executeQuery("Select ACCOUNTNUMBER from account where ACCOUNTSTATUS=1 AND CUSTOMERID="+cid+"");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return rs;
	}
	
	public ResultSet retrieveben(String x)
	{
		boolean flag = false;
		String a=null;
		String b=null;
		long cid=Long.parseLong(x);
		//System.out.print(cid);
		ResultSet rs=null;
		try
		{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
			Connection con = ConnectionBean.getConnection();
			Statement stmt = con.createStatement();
			 rs = stmt.executeQuery("Select TOACCOUNT,BNAME from Benificiary where FROMACCOUNT="+cid+"");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return rs;
	}
	
	public boolean add(String accno,String acno,String name)
	{
		boolean flag = false;
		String a=null;
		String b=null;
		long fno=Long.parseLong(accno);
		long tono=Long.parseLong(acno);
		int bno;
		
		
			ResultSet rs1;
			PreparedStatement pstmt;
			try
			{
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
				Connection con = ConnectionBean.getConnection();
				Statement stmt = con.createStatement();
				do
				{
					bno = AutoGenerator.getBenNumber();
					rs1 = stmt.executeQuery("select * from Benificiary where id="+bno);
				}while(rs1.next());
				String sql1 = "select * from Benificiary where FROMACCOUNT="+fno+" AND TOACCOUNT="+tono+"";
				System.out.println(sql1);
				ResultSet rs = stmt.executeQuery(sql1);
				
				
				//System.out.println(rs.getInt(1)+"  "+rs.getString(2));
				if(rs.next())
				{
					
					flag = false;
					
				}
				
				else flag=true;
				System.out.println(flag);
				if(flag)
				{
				pstmt =  con.prepareStatement("insert into Benificiary values(?,?,?,?)");
				pstmt.setInt(1,bno);
				pstmt.setLong(2,fno);
				pstmt.setLong(3,tono);
				pstmt.setString(4,name);
				pstmt.execute();
				}
				else return false;

				//System.out.println("IN verify bean "+id+" "+pwd);
				
			}
			catch(Exception e)
			{
				System.out.print("Error");
			}
			
		
			
		return true;
	}

}
