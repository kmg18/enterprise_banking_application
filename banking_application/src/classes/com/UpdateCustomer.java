package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UpdateCustomerBean;

public class UpdateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateCustomer() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2>Sorry Invalid Access</h1>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out = response.getWriter();
			String email = request.getParameter("email");
			Long pno = Long.parseLong(request.getParameter("pno"));
			String address = request.getParameter("address");
			int cid = Integer.parseInt(request.getParameter("cid"));
			UpdateCustomerBean ucb = new UpdateCustomerBean();
			int flag = ucb.updatecustomerdetails(email,pno,address,cid);
			RequestDispatcher rd = request.getRequestDispatcher("customheader.html");
			rd.include(request,response);
			if(flag==1)
			{	
				out.println("<br><br><br><center><h1> Updated Succesfully</h1></center>");
			}
			else
			{
				out.println("<br><br><br><center><h1> Updation Unsuccesful</h1></center>");
			}
	}

}
