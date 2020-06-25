<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@ page import="java.sql.*" %>
<%@ page import="beans.*" %>
    <head>
        <!-- Basic Page Needs
        ================================================== -->
        <META HTTP-EQUIV="refresh" CONTENT="180; URL=error.jsp" />
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="icon" type="image/png" href="images/favicon.png">
        <title>Balance</title>
        <meta name="description" content="">
        <meta name="keywords" content="">
        <meta name="author" content="">
        <!-- Mobile Specific Metas
        ================================================== -->
        <meta name="format-detection" content="telephone=no">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <!-- Template CSS Files
        ================================================== -->
        <!-- Twitter Bootstrs CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Ionicons Fonts Css -->
        <link rel="stylesheet" href="css/ionicons.min.css">
        <!-- animate css -->
        <link rel="stylesheet" href="css/animate.css">
        <!-- Hero area slider css-->
        <link rel="stylesheet" href="css/slider.css">
        <!-- owl craousel css -->
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="css/owl.theme.css">
        <link rel="stylesheet" href="css/jquery.fancybox.css">
        <!-- template main css file -->
        <link rel="stylesheet" href="css/main.css">
        <!-- responsive css -->
        <link rel="stylesheet" href="css/responsive.css">
        
        <!-- Template Javascript Files
        ================================================== -->
       
        <script src="js/jquery.min.js"></script>
        
        <script src="js/bootstrap.min.js"></script>
        <script src="js/validate.js"></script>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs/dt-1.10.15/datatables.min.css"/>
 
<script type="text/javascript" src="https://cdn.datatables.net/v/bs/dt-1.10.15/datatables.min.js"></script>
        
  
        <!-- template main js -->
       
    </head>
    <body>

        <!-- 
        ================================================== 
            Global Page Section Start
        ================================================== -->
        <section class="global-page-header">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="block">
                            <h2>View Balance</h2>
                            <ol class="breadcrumb">
                                <li>
                                    <a href="aftercustomerlogin.jsp">
                                        <i class="ion-ios-home"></i>
                                        Customer Home
                                    </a>
                                    <form action="logoutServletCustomer" method="post">
                                        <input type="submit" value="Logout" class="btn btn-default btn-send">
                                    </form>
                                </li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>   
        </section><!--/#page-header-->


        <!-- 
        ================================================== 
            Contact Section Start
        ================================================== -->
        <section id="contact-section">
            <div class="container">
                <div class="row">
				<div class="col-md-2"></div>
                    <div class="col-md-8">
                    <%! int x; %>
                                    <%= x= (Integer)session.getAttribute("id") %>
                    <%
                    ShowStatements b=new ShowStatements();
                    try{
                    ResultSet rs=b.balance(x);
						ResultSetMetaData rsmd = rs.getMetaData();
						int count = rsmd.getColumnCount();
						out.println("<table  class='table table-bordered' id='myTable' ><thead><tr>");
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
                    %>
                        
                        </div>
                    </div>
					<div class="col-md-2"></div>
            </div>
        </section>
    
    </body>
</html>


