package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CustomerMenuBean;
import beans.VerifyCustomerBean;


public class CustomerMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CustomerMenu() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2>Sorry Invalid Access</h1>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		CustomerMenuBean cmb = new CustomerMenuBean();
		
		CustomerInfo ci1 = new CustomerInfo();
		Account a1 = new Account();
	
		try
		{
			Long ssn = Long.parseLong(request.getParameter("ssn"));
			String result = cmb.verifyFico(ssn);
			if(result.equals("Failed"))
			{	
				RequestDispatcher rd = request.getRequestDispatcher("customheader.html");
				rd.include(request,response);
				out.println("<br><br><br><center><h1>Customer is not Eligible!</h1></center>");
			}
			else if(result.equals("Successful"))
			{
				ci1.setSsn(ssn);
				String fname = request.getParameter("fname");
				ci1.setFirstName(fname);
				ci1.setMiddleName(request.getParameter("mname"));
				String lname = request.getParameter("lname");
				ci1.setLastName(lname);
				ci1.setEmail(request.getParameter("email"));
				ci1.setPhoneNumber(Long.parseLong(request.getParameter("pno")));
				ci1.setAddress(request.getParameter("address"));
				
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			
				Date dob = formatter.parse(request.getParameter("dob"));
				ci1.setDob(dob);
//				System.out.println(new SimpleDateFormat("MM-dd-yyyy").format(date));
//				System.out.println(new SimpleDateFormat("MM/dd/yyyy").format(date));
			
				ci1.setGender(request.getParameter("gender"));
				ci1.setCountry(request.getParameter("country"));
				
				ci1.setIdentificationType(request.getParameter("license"));
				ci1.setIdentificationId(Long.parseLong(request.getParameter("ID")));
				Date issuedate = formatter.parse(request.getParameter("issue"));
				ci1.setIssueDate(issuedate);
				Date expirydate = formatter.parse(request.getParameter("expiry"));
				ci1.setExpiryDate(expirydate);
				
				a1.setAccountType(request.getParameter("type"));
				
				result = cmb.createNewUser(ci1,a1);
				RequestDispatcher rd = request.getRequestDispatcher("customheader.html");
				rd.include(request,response);
				out.println(result);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}		
}
