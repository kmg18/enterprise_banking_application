package beans;

import java.sql.*;

public class VerifyBean {
	public boolean verify(int name,String pwd)
	{
		boolean flag = false;
		try
		{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
			Connection con = ConnectionBean.getConnection();
			Statement stmt = con.createStatement();
//			System.out.println("IN verify bean "+name+" "+pwd);
			String sql = "select * from BANKER where USERNAME="+name+" and PASSWORD='"+pwd+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
//				System.out.println(rs.getInt(3)+"  "+rs.getString(4));
				if( (rs.getInt(3)==name) && (rs.getString(4).equals(pwd)) )
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
}
