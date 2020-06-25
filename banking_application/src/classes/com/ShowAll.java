package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

import beans.ShowStatements;

/**
 * Servlet implementation class ShowAll
 */
public class ShowAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAll() {
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
		String values[] = new String[3];
		ShowStatements b = new ShowStatements();
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
					
						ResultSet rs=b.show(values[0],values[1],values[2]);
						ResultSetMetaData rsmd = rs.getMetaData();
						int count = rsmd.getColumnCount();
						out.println("<table id='myTable'  class='table table-bordered'  ><thead><tr>");
						for(int i=1;i<=count;i++)
							out.println("<th>"+rsmd.getColumnName(i)+"</th>");
						out.println("</thead></tr>");
						while(rs.next())
						{
							out.println("<tbody >");
							out.println("<tr>");
							for(int i=1;i<=count;i++)
							{
								out.println("<td>"+rs.getString(i)+"</td>");
							}
							out.println("</tr>");
						}
						out.println("</tbody></table>");
						
						}
						catch(Exception e)
						{
							out.print("Exception");
						}
						//out.print("Valid");
						
					
		// TODO Auto-generated method stub
	}

}
