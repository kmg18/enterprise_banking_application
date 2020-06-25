package beans;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONException;

import com.AutoGenerator;

public class Transfer {
	public int trans(String from,String to,String amt,String tp, int cid)
	{
		long f=Long.parseLong(from);
		long t=Long.parseLong(to);
		long a=Long.parseLong(amt); 
		int fc=0;
		int tc=0;
		long y=0;
		int tid1;
		int tid2;
		int tid3;
		int x;
		ResultSet rs1;
		ResultSet rs2;
		ResultSet rs3;
		PreparedStatement pstmt;
		try
		{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
			Connection con = ConnectionBean.getConnection();
			Statement stmt = con.createStatement();
			//System.out.println("IN verify bean "+id+" "+pwd);
			String sql = "select TRANSACTIONPASSWORD from CUSTOMER where CUSTOMERID="+cid+"";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
			System.out.println(rs.getString(1));
			System.out.println(tp);
				
				if( !((rs.getString(1)).equals(tp)))
				{	
					return 0;
				}
				else
				{
					String sqls="SELECT AMOUNT FROM ACCOUNT where ACCOUNTNUMBER="+f+"";
					System.out.println(sqls);
					
					rs1 = stmt.executeQuery(sqls);
					
					
					if((rs1.next()) && rs1.getLong(1)<0)
					{
						return 2;
					}
					else if( rs1.getLong(1)+500 <= a )
					{
						return 5;
					}
					else
					{
					do
					{
						tid1 = AutoGenerator.getTransactionId();
						rs1 = stmt.executeQuery("select * from TRANSACTIONS where ID="+tid1);
					}while(rs1.next());
					do
					{
						tid2 = AutoGenerator.getTransactionId();
						rs1 = stmt.executeQuery("select * from TRANSACTIONS where ID="+tid2);
					}while(rs1.next() && (tid1==tid2));
					
					String sql6="SELECT CUSTOMERID FROM ACCOUNT  where ACCOUNTSTATUS=1 AND ACCOUNTNUMBER="+f;
					rs1 = stmt.executeQuery(sql6);
					if(rs1.next())
					{
						fc=rs1.getInt(1);
					}
					else
					{
						return 0;
						
					}
					String sql7="SELECT CUSTOMERID FROM ACCOUNT where ACCOUNTSTATUS=1 AND ACCOUNTNUMBER="+t;
					rs1 = stmt.executeQuery(sql7);
					if(rs1.next())
					{
						tc=rs1.getInt(1);
					}
					else
					{
						System.out.print("No Records");
						return 0;
						
					}
					
					Statement stmt1 = con.createStatement();
					stmt1.addBatch("insert into TRANSACTIONS values("+tid1+","+f+","+t+",'debit',0,sysdate,"+a+","+fc+","+tc+")");
					stmt1.addBatch("insert into TRANSACTIONS values("+tid2+","+t+","+f+",'credit',0,sysdate,"+a+","+tc+","+fc+")");
					stmt1.addBatch("update ACCOUNT set AMOUNT=AMOUNT-"+a+" WHERE ACCOUNTNUMBER="+f);
					stmt1.addBatch("update ACCOUNT set AMOUNT=AMOUNT+"+a+" WHERE ACCOUNTNUMBER="+t);
					stmt1.executeBatch();
					
					rs1 = stmt1.executeQuery("select email from customerinfo where customerid="+fc);
					rs1.next();
					String femail = rs1.getString(1);
					rs1 = stmt1.executeQuery("select email from customerinfo where customerid="+fc);
					rs1.next();
					String temail = rs1.getString(1);
					
					EmailBean eb = new EmailBean();
					eb.send_mail("Fund Transfer of Amount $"+a+"has been debited from your Account", femail, "Wells Fargo Bank");
					eb.send_mail("Fund Transfer of Amount $"+a+"has been credited from your Account", temail, "Wells Fargo Bank");
					
					String sql2="SELECT AMOUNT FROM ACCOUNT where ACCOUNTNUMBER="+f;
					System.out.println(sql2);
					Statement stmt3 = con.createStatement();
					rs1 = stmt3.executeQuery(sql2);
					if(rs1.next() && rs1.getLong(1)<0)
					{
						do
						{
							tid3 = AutoGenerator.getTransactionId();
							rs2 = stmt.executeQuery("select * from TRANSACTIONS where ID="+tid2);
						}while(rs2.next() && (tid1==tid3) && (tid2==tid3) );
						
						y=rs1.getLong(1);
						System.out.println(y);
						long r = Math.abs(y);
								
								System.out.println(r);
								r=r+35;
								System.out.println(r);
						
								Statement stmt5 = con.createStatement();
						stmt5.addBatch("insert into TRANSACTIONS values("+tid3+","+f+",000000000,'Overdraft',0,sysdate,35,"+fc+",0)");
						stmt5.addBatch("update ACCOUNT set AMOUNT=AMOUNT-35 WHERE ACCOUNTNUMBER="+f);
						stmt5.executeBatch();
						
					}
										
					String sqlx="SELECT SUM(T1.AMOUNT),SUM(T2.AMOUNT) FROM TRANSACTIONS T1,TRANSACTIONS T2 Where TRUNC(sysdate) = TRUNC(T1.TDATE) AND TRUNC(sysdate) = TRUNC(T2.TDATE) AND T1.TYPE='debit' AND T2.TYPE='credit' AND T1.FROMCUSTOMERID="+fc+" AND T2.FROMCUSTOMERID="+tc+" AND TRUNC(T1.TDATE)=TRUNC(T2.TDATE)" ;
					//String sqlx="SELECT SUM(AMOUNT) FROM TRANSACTIONS Where TRUNC(sysdate) = TRUNC(TDATE) AND TYPE='debit' AND FROMACCOUNT="+f+"";
					//String sqly="SELECT SUM(AMOUNT) FROM TRANSACTIONS Where TRUNC(sysdate) = TRUNC(TDATE) AND TYPE='debit' AND FROMACCOUNT="+t+"";
					//System.out.println(sqlx);
					//System.out.println(sqly);
					Statement stmt2 = con.createStatement();
					rs1 = stmt2.executeQuery(sqlx);
					
					if(rs1.next())
					{
//						System.out.println(rs.getInt(1)+"  "+rs.getString(2));
						if( rs1.getLong(1)>10000 )
						{	
							stmt.executeQuery("update TRANSACTIONS set FLAG=1 where TRUNC(sysdate) = TRUNC(TDATE) AND TYPE='debit' AND FROMCUSTOMERID="+fc+"");
						}
						if( rs1.getLong(2)>10000 )
						{	
							stmt.executeQuery("update TRANSACTIONS set FLAG=1 where TRUNC(sysdate) = TRUNC(TDATE) AND TYPE='credit' AND FROMCUSTOMERID="+tc+"");
						}
						
						
					}
					
					else
					{
						return 0;
						//System.out.print("No Records");
					}
					
					String sql8="SELECT AMOUNT FROM ACCOUNT where ACCOUNTNUMBER="+f;
					System.out.println(sql8);
					//Statement stmt3 = con.createStatement();
					rs3 = stmt2.executeQuery(sql8);
					if(rs3.next() && rs3.getLong(1)<5000)
					{
						return 4;
					}
					else
					{
						return 1;
					}
			}
					}
				}
			
			
			else
			{
				return 3;
			}		
	
}
		catch (Exception e) {
		    // crash and burn
		    System.out.print(e);
		    return 0;
		  }
		
		//return 1;

}
}
