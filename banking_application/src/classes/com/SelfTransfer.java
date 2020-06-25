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
import org.json.JSONException;
import org.json.JSONObject;

import beans.*;

/**
 * Servlet implementation class SelfTransfer
 */
public class SelfTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelfTransfer() {
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
		PrintWriter out = response.getWriter();
		StringBuffer jb = new StringBuffer();
		String values[] = new String[5];
		int y;
		int i=0;
		Transfer b = new Transfer();
		JSONObject rec=new JSONObject();
		int flag = 0;
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
		    for (; i < jsonObj.length(); ++i) {
		         rec = jsonObj.getJSONObject(i);
		        //out.print(rec);
		        //String name = rec.getString("name");
		         values[i] = rec.getString("value");
		    }
		    y= (Integer) request.getSession().getAttribute("id");
		    //values[i]=y;
		         //out.println(values[0]);
		        //out.println(values[1]);
		        //out.println(y);
		        // ...
		         
				   
				    //accno=Integer.parseInt(values[2]);
				    //out.print(accno);
		    
					flag = b.trans(values[0],values[1],values[2],values[3],y);
					if(flag==1)
					{
						
						out.print("<center><h3>Transfer completed</h3></center>");
						
					}
					if(flag==2)
					{
						out.print("<center><h3>Balance less than 0</h3></center>");
					}
					if(flag==4)
					{
						out.print("<center><h3>Transfer completed<br>Balance less than 5000</h3></center>");
					}
					if(flag==0)
					{
						out.print("<center><h3>Invalid Credentials</h3></center>");
					}
					if(flag==5)
					{
						out.println("<center><h3>Insufficient Funds</h3></center>");
					}
		  }
		  catch (JSONException e) {
			    // crash and burn
			    throw new IOException("Error parsing JSON request string");
			  }
		  
		// TODO Auto-generated method stub
	}

}
