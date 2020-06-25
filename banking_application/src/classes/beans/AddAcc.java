package beans;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.*;

public class AddAcc {
	public long add(String cid,String acctype)
	{
		long accno=0;
		int c=Integer.parseInt(cid); 
		ResultSet rs1;
		PreparedStatement pstmt;
		try
		{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
			Connection con = ConnectionBean.getConnection();
			Statement stmt = con.createStatement();
			do
			{
				accno = AutoGenerator.getAccountNumber();
				rs1 = stmt.executeQuery("select * from account where accountnumber="+accno);
			}while(rs1.next());
			
			rs1 = stmt.executeQuery("select count(*) from account where customerid="+c+" and accounttype='"+acctype+"'");
			if(rs1.next() && rs1.getInt(1)<5 )
			{
				pstmt =  con.prepareStatement("insert into Account values(?,?,?,?,?,?)");
				pstmt.setLong(1,accno);
				pstmt.setString(2,acctype);
				pstmt.setDate(3,new Date(new java.util.Date().getTime()));
				pstmt.setInt(4, 1);
				pstmt.setInt(5, 5000);
				pstmt.setInt(6,c);
				pstmt.execute();
				pstmt.close();
			}
			else
			{
				System.out.println("Exceeding Limit");
				return 0;
			}
			rs1.close();
			stmt.close();
			con.close();
			
			//System.out.println("IN verify bean "+id+" "+pwd);
			
		}
		catch(Exception e)
		{
			System.out.print("Error");
		}
		return accno;
	
}
}
