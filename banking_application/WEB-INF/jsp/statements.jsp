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
        <title>View Statements</title>
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
       
       
        
      <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs-3.3.7/jqc-1.12.4/dt-1.10.15/datatables.min.css"/>
 
<script type="text/javascript" src="https://cdn.datatables.net/v/bs-3.3.7/jqc-1.12.4/dt-1.10.15/datatables.min.js"></script>
        <script src="js/validate.js"></script>
       <script src="js/statements.js"></script>
        <!-- template main js -->
       
    </head>
    <body>
<% response.setHeader("Refresh", session.getMaxInactiveInterval()+";URL=error.jsp"); %>
        <!-- 
        ================================================== 
            Global Page Section Start
        ================================================== -->
        <section class="global-page-header">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="block">
                            <h2>Show Statements</h2>
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
                        <div class="block">
                        <form id="xu" method="post"  >
                        <div class="form-group wow fadeInDown" >
									<div class="form-group">
									<label>Account Number:</label>
                            <select class="form-control" name="ff" id="ff">
                            
									    <%! int x; %>
                                    <%= x= (Integer)session.getAttribute("id") %>
											<%
											Beneficiary b=new Beneficiary();
											try{
											ResultSet rs=b.retrieve(x);
												while(rs.next())
												{
													%><option value="<%= rs.getString(1) %>"><%= rs.getString(1)%></option><%
												}
											}
											catch(Exception e)
											{
												System.out.println(e);
											}
											%>
										
									  </select><br>
									  
									  <button id="search" class="btn btn-info btn-send" >Last 10 Transactions</button>
									  
									</div></div></form><br>
                        
                        
                            
									
									  
                            
                            <form id="ver" method="post" >
                            <div class="form-group wow fadeInDown">
                            <label for="comment">From Date:</label>
                                        <input type="date" placeholder="From Date" class="form-control" name="fd" id="fd">
                                    </div>
                                    <div class="form-group wow fadeInDown">
                             <label for="comment">To Date:</label>
                                        <input type="date" placeholder="To Date" class="form-control" name="td" id="td">
                                    </div>
                                   
                            <div id="submit" class="wow fadeInDown" >
                                        <button id="show" class="btn btn-info btn-send" >Show</button>
                                    </div>
                                    </form>
                           
                            <div>
                                
                        
                                    
                                   
                                    
                                    <div id="resfound" class="wow fadeInDown" style="display: none;">
                                    
                                    
										</div>
										 
										
                                    
                                    
                                                         
                                    
                                
                            </div>
                        </div>
                    </div>
					<div class="col-md-2"></div>
            </div>
        </section>
    
    </body>
</html>


