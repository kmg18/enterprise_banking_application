package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifyCustomerSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public VerifyCustomerSignup() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2>Sorry Invalid Access</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("cid"));
		String opwd = request.getParameter("opwd");
		String npwd = request.getParameter("npwd");
		String tpwd = request.getParameter("tpwd");
		Long e1 = Long.parseLong(request.getParameter("e1"));
		String e2 = request.getParameter("e2");
		String e3 = request.getParameter("e3");
		String e4 = request.getParameter("e4");
		System.out.println("insert into security values("+id+","+e1+",'"+e2+"','"+e3+"','"+e4+"')");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.60:1521:xe","system","admin");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customer where customerid="+id+" and password='"+opwd+"' and transactionpassword is null");
			if(rs.next())
			{
				stmt.executeUpdate("update customer set password='"+npwd+"' where customerid="+id);
				stmt.executeUpdate("update customer set transactionpassword='"+tpwd+"' where customerid="+id);
				stmt.executeUpdate("insert into security values("+id+","+e1+",'"+e2+"','"+e3+"','"+e4+"')");
				out.println("<center><h1>Registration Successful .Please Login</h1></center>");
				RequestDispatcher rd = request.getRequestDispatcher("signin_user.html");
				rd.forward(request,response);
			}
			else
			{
				response.setContentType("text/html");
				
				out.println("<h2>Sorry Invalid Credentials</h1>");
				RequestDispatcher rd = request.getRequestDispatcher("signup_user.html");
				rd.include(request,response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
