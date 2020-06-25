<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<%@ page import="java.sql.*" %>
<%@ page import="beans.*" %>
<html>
    <head>
        <!-- Basic Page Needs
        ================================================== -->
        <META HTTP-EQUIV="refresh" CONTENT="180; URL=error.jsp" />
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="icon" type="image/png" href="images/favicon.png">
        <title>Self Transfer</title>
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
       
       
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

       
        <!-- template main js -->
        <script src="js/validate.js"></script>
	
	<script src="js/selftransfer.js"></script>

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
                            <h2>Self Transfer</h2>
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
                            <h2 class="subtitle wow fadeInDown" >Self Transfer </h2>
                            <div class="contact-form">
                                <form id="tf" method="post" action="sendmail.php" role="form">
									<div class="form-group wow fadeInDown" >
									<div class="form-group">
									  <label for="sel1">From Account:</label>
									  <select class="form-control" name="fromacc" id="ff">
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
										
									  </select>
									</div></div><br>
									<div class="form-group wow fadeInDown" >
									<div class="form-group">
									  <label for="sel1">To Account:</label><br>
									  <label id="sel1" style=display:none;>From Account to Account cannot be the same</label>
									  <select class="form-control" name="toacc" id="toacc">
									    <%! int y; %>
                                    <%= y= (Integer)session.getAttribute("id") %>
											<%
											Beneficiary b1=new Beneficiary();
											try{
											ResultSet rs=b1.retrieve(y);
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
										
									  </select>
									</div></div><br>
                                    <div class="form-group wow fadeInDown" >
									<label for="comment">Enter Amount:</label><br>
									<label id="sel2" style=display:none;>Amount should be only numbers and greater than 0</label>
                                        <input type="text" placeholder=" Amount" class="form-control" name="amt" id="amt">
                                    </div>
									
									<div class="form-group wow fadeInDown" >
									<label for="comment">Transaction Password:</label><br>
									<label id="sel3" style=display:none;>*Transaction Password</label>
                                        <input type="password" placeholder="Password" class="form-control" name="tpassword" id="tpassword">
                                    </div>
									  <div id="submit" class="wow fadeInDown" >
                                        <button id="transfer" class="btn btn-default btn-send" >Transfer</button>
                                    </div>
                                    <div class="modal fade" id="myModal" role="dialog">
								    <div class="modal-dialog">
								    
								      <!-- Modal content-->
								      <div class="modal-content">
								        <div class="modal-header">
								          <button type="button" class="close" data-dismiss="modal">&times;</button>
								          <h4 class="modal-title">Note</h4>
								        </div>
								        <div class="modal-body" id="resfound">
								          
								        </div>
								        <div class="modal-footer">
								          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								        </div>
								      </div>
								      
								    </div>
								  </div>                      
                                    <div  class="wow fadeInDown" >
                                        
                                    </div>  
									
							

                                     
                                    
                                </form>
                            </div>
                        </div>
                    </div>
					<div class="col-md-2"></div>
            </div>
        </section>
    
    </body>
</html>