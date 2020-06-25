package beans;

import java.sql.*;

import com.*;
import javax.activation.*;
import beans.*;


public class CustomerMenuBean {
	public String verifyFico(Long ssn)
	{
		String result=null;
		try
		{
			
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
			Connection con = ConnectionBean.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from FICO where ssn="+ssn);
			if(rs.next())
			{
				if(rs.getInt(2)>620)
					result = "Successful";
			}
			else
			{
				stmt.executeUpdate("insert into fico values("+ssn+",850)");
				result =  "Successful";
			}
			rs.close();
			stmt.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("create new fico user... "+e);
			result = "Failed";
		}
		return result;
	}
	public String createNewUser(CustomerInfo ci1,Account a1)
	{
		try
		{
			
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
			Connection con = ConnectionBean.getConnection();
			Statement stmt = con.createStatement();
			PreparedStatement pstmt;
			
			int custid;
			ResultSet rs;
			do
			{
				custid = AutoGenerator.getCustomerId();
				rs = stmt.executeQuery("select * from customerinfo where customerid="+custid);
			}while(rs.next());
			
			String pwd = AutoGenerator.getPassword();
			String tpwd = "";
			
			Long accno;
			do
			{
				accno = AutoGenerator.getAccountNumber();
				rs = stmt.executeQuery("select * from account where accountnumber="+accno);
			}while(rs.next());
			
			pstmt =  con.prepareStatement("insert into Customer values(?,?,?)");
			pstmt.setInt(1, custid);
			pstmt.setString(2, pwd);
			pstmt.setString(3, tpwd);
			pstmt.execute();
			
			pstmt =  con.prepareStatement("insert into Customerinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setLong(1, ci1.getSsn());
			pstmt.setInt(2,custid);
			pstmt.setString(3, ci1.getFirstName());
			pstmt.setString(4, ci1.getLastName());
			pstmt.setString(5, ci1.getEmail());
			pstmt.setLong(6, ci1.getPhoneNumber());
			pstmt.setString(7, ci1.getAddress());
			
			Date dob = new Date(ci1.getDob().getTime());
			pstmt.setDate(8, dob);
			
			pstmt.setInt(9, 1);
			pstmt.setString(10,ci1.getMiddleName());
			pstmt.setString(11,ci1.getGender());
			pstmt.setString(12,ci1.getCountry());
			pstmt.setString(13,ci1.getIdentificationType());
			pstmt.setLong(14,ci1.getIdentificationId());
			pstmt.setDate(15,new Date(ci1.getIssueDate().getTime()));
			pstmt.setDate(16, new Date(ci1.getExpiryDate().getTime()));
			pstmt.execute();
			
			
			pstmt =  con.prepareStatement("insert into Account values(?,?,?,?,?,?)");
			pstmt.setLong(1,accno);
			pstmt.setString(2, a1.getAccountType());
			pstmt.setDate(3,new Date(new java.util.Date().getTime()));
			pstmt.setInt(4, 1);
			pstmt.setInt(5, 5000);
			pstmt.setInt(6,custid);
			pstmt.execute();
			stmt.close();
			con.close();
			EmailBean eb = new EmailBean();
			eb.approve(accno,custid , pwd,ci1.getEmail());
			
			rs.close();
			pstmt.close();
			stmt.close();
			pstmt.close();
//			return "<br><br><br><h2>Successful registration of "+ci1.getFirstName()+" "+ci1.getLastName()+"</h2><br><table><tr><th> Account number : </th><td>"+accno+"</td></tr><tr><th> Customer Id: </th><td>"+custid+"</td></tr><th> password : </th><td>"+pwd+"</td></tr></table>";
			return "<br><br><br><h2>Successful registration of "+ci1.getFirstName()+" "+ci1.getLastName()+"</h2><br><table><tr><th> Account number : </th><td>"+accno+"</td></tr><tr><th> Customer Id: </th><td>"+custid+"</td></tr></table>";
		}
		catch(Exception e)
		{
			System.out.println("create new user... "+e);
		}
		return "<br><h1>Failed Attempt! Invalid Credentials</h1>";
	}
}
