package com;

import java.util.*;
import java.util.Date;
import java.sql.*;

//public class ReportTransactions extends TimerTask {
//
//	@Override
//	public void run() {
////		try
////		{
////			Class.forName("oracle.jdbc.driver.OracleDriver");
////			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
////			Statement stmt = con.createStatement();
////			stmt.executeUpdate("insert into flag(id,fromaccount,toaccount,type,flag,tdate,amount,fromcustomerid,tocustomerid) select id,fromaccount,toaccount,type,flag,tdate,amount,fromcustomerid,tocustomerid from transactions where flag=1 and trunc(tdate)=trunc(sysdate)");
////			
////		}
////		catch(Exception e)
////		{
////			System.out.println(e);
////		}
//		for(int i=0;i<50;i++)
//			System.out.println(i);
//	}
//
//	public static void start()
//	{
//		ReportTransactions task = new ReportTransactions();
//        	Timer timer = new Timer();
//		Date mydate = new java.util.Date(); 
//        	mydate.setHours(9); 
//	        mydate.setMinutes(25); 
//	        timer.schedule(task,mydate,1000*10);
//	}
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		start();
//	}
//
//}

public class ReportTransactions implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
		Statement stmt = con.createStatement();
		stmt.executeUpdate("insert into flag(id,fromaccount,toaccount,type,tdate,amount,fromcustomerid,tocustomerid) select id,fromaccount,toaccount,type,tdate,amount,fromcustomerid,tocustomerid from transactions where flag=1 and trunc(tdate)=trunc(sysdate)");
		stmt.close();
		con.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
//		for(int i=0;i<50;i++)
//			System.out.println(i);
	}
	
}
