package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.*;

public class VerifyCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public VerifyCustomerServlet() {
        super();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2>Sorry Invalid Access</h1>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("cid"));
		String pwd = request.getParameter("pwd");
//		System.out.println("in verifycustomerservlet!");
		boolean flag = false;
	
		VerifyCustomerBean vb = new VerifyCustomerBean();
		
		flag = vb.isNew(id);
		if(flag)
		{
			out.println("<center><h1>Register Fisrt</h1></center>");
			RequestDispatcher rd = request.getRequestDispatcher("signup_user.html");
			rd.include(request,response);
			
		}
		else
		{
			flag = vb.verify(id,pwd);
		
			if(flag)
			{
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				String uname = vb.getUname(id);
				session.setAttribute("uname",uname);
				System.out.println(uname);
				RequestDispatcher rd = request.getRequestDispatcher("aftercustomerlogin.jsp");
				rd.forward(request,response);
			}
			else
			{
				out.println("<center><h1>Invalid Credentials</h1></center>");
				RequestDispatcher rd = request.getRequestDispatcher("signin_user.html");
				rd.include(request,response);
			}
		}
		out.close();
		
	}
	
}
