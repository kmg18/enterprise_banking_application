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

public class VerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public VerifyServlet() {
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
		int id = Integer.parseInt(request.getParameter("bid"));
		String pwd = request.getParameter("pwd");
		boolean flag = false;
	
		VerifyBean vb = new VerifyBean();
		flag = vb.verify(id,pwd);
	
		if(flag)
		{
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			RequestDispatcher rd = request.getRequestDispatcher("afterbankerlogin.html");
			rd.forward(request,response);
		}
		else
		{
			out.println("<center><h1>Invalid Credentials</h1></center>");
			RequestDispatcher rd = request.getRequestDispatcher("signin_banker.html");
			rd.include(request,response);
		}
	}

}
