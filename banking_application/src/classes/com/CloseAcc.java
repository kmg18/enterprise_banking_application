package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import beans.VeriCustomer;

/**
 * Servlet implementation class CloseAcc
 */
public class CloseAcc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloseAcc() {
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
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		StringBuffer jb = new StringBuffer();
		String values[] = new String[2];
		VeriCustomer b = new VeriCustomer();
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
		    ResultSet rs=b.verifyacc(values[0]);
		    if(rs.next())
		    {
		    do
			{
		    	if(rs.getLong(2)==0)
		    	{
		    	
			    
				
			 
				out.print(rs.getString(1));
				out.print("/");
				//out.print(rs.getString(1)+"-"+rs.getString(2));
		    	}
		    	else
		    	{
		    		out.print("/");
		    	}
				
				
			
			}while(rs.next());
		  }
		    else 
		    {
		    	out.print("Invalid Customer ID");
		    }
		  }
			catch (Exception e) {
			    // crash and burn
			    throw new IOException("Error parsing JSON request string");
			  }
	}

}