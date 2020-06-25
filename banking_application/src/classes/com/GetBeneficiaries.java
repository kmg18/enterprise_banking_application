package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

import beans.Beneficiary;
import java.sql.*;

/**
 * Servlet implementation class GetBeneficiaries
 */
public class GetBeneficiaries extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBeneficiaries() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
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
		    //out.print(values[0]);
		    ResultSet rs=b.retrieveben(values[0]);
		    while(rs.next())
			{
		    	
		    	
			    
				
			 
				out.print(rs.getString(1));
				out.print("/");
				
			
			}
		  }catch (Exception e) { /*report an error*/ }
		  
		// TODO Auto-generated method stub
	}

}
