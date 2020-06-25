package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import beans.*;

public class AddAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AddAccount() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<h2>Sorry Invalid Access</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		StringBuffer jb = new StringBuffer();
		String values[] = new String[2];
		AddAcc b = new AddAcc();
		JSONObject rec=new JSONObject();
		long acc;
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
		        //out.println(values[1]);
		        acc=b.add(values[0],values[1]);
		        if(acc!=0)
		        {
		        out.print("Account is created Successfully and Account Number is "+acc);
		        }
		        else
		        {
		        	out.print("Exceeding Limit of accounts");
		        }
		         
		        // ...
		         
				   
				    //accno=Integer.parseInt(values[2]);
				    //out.print(accno);
		    //if(values[1]==null)
		    //{
					//flag = b.verify(values[0]);
		    //}
		    /*else flag=b.verifyacc(values[0], values[1]);
					if(flag)
					{
						out.print("Valid");
						
					}
					else
					{
						out.print("Invalid Credentials");
						
					}*/
		    }
		  
		    
		     catch (JSONException e) {
		    // crash and burn
		    throw new IOException("Error parsing JSON request string");
		  }
		
		    
		  
		    
		     
		// TODO Auto-generated method stub
	}

		// TODO Auto-generated method stub
	

}
