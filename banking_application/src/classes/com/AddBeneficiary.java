package com;

import java.io.BufferedReader;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.json.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import beans.*;

import beans.VerifyCustomerBean;



/**
 * Servlet implementation class AddBeneficiary
 */
public class AddBeneficiary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBeneficiary() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2>Sorry Invalid Access</h1>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		StringBuffer jb = new StringBuffer();
		String values[] = new String[3];
		Beneficiary b = new Beneficiary();
		JSONObject rec=new JSONObject();
		boolean flag = false;
		int accno;
		JSONArray jsonObj = null;
		  String line = null;
		  try {
		    BufferedReader reader = request.getReader();
		    while ((line = reader.readLine()) != null)
		      jb.append(line);
		  } catch (Exception e) { /*report an error*/ }

		  try {
		    JSONObject jsonObject =  HTTP.toJSONObject(jb.toString());
		    String lng = jsonObject.getString("Method");
		    jsonObj = new JSONArray(lng);
		    for (int i = 0; i < jsonObj.length(); ++i) {
		         rec = jsonObj.getJSONObject(i);
		        //out.print(rec);
		        //String name = rec.getString("name");
		         values[i] = rec.getString("value");
		    }
		         //out.println(values[0]);
		        //out.println(values[2]);
		         
		        // ...
		         
				   
				    //accno=Integer.parseInt(values[2]);
				    //out.print(accno);
					flag = b.verify(values[2],values[0]);
					if(flag)
					{
						out.print("Valid");
						
					}
					else
					{
						out.print("Invalid Credentials");
						
					}
		    }
		  
		    
		     catch (JSONException e) {
		    // crash and burn
		    throw new IOException("Error parsing JSON request string");
		  }

			  

			/*String name = request.getParameter("");
			int age = Integer.parseInt(request.getParameter("Age"));
			int id = Integer.parseInt(request.getParameter("Id"));
			int salary = Integer.parseInt(request.getParameter("Salary"));
			String designation = request.getParameter("Designation");
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			PreparedStatement pstmt =  con.prepareStatement("insert into EMP values(?,?,?,?,?)");
			pstmt.setInt(1,id);
			pstmt.setString(2, name);
			pstmt.setInt(3,age);
			pstmt.setInt(4,salary);
			pstmt.setString(5,designation);
			pstmt.execute();
			RequestDispatcher rd = request.getRequestDispatcher("menu.html");
			rd.forward(request,response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("Sql Exception");
		}*/
		// TODO Auto-generated method stub
		
	}

}
