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
        <title>Add Beneficiary</title>
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
       <script src="js/addbeneficiary.js"></script>
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
                            <h2>Add Beneficiary </h2>
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
                            <h2 class="subtitle wow fadeInDown" >Add Beneficiary</h2>
                            <div class="contact-form">
                                <form id="signin_banker" method="post" role="form">
                        
                                    <div class="form-group wow fadeInDown" >
                                    <lable>Beneficiary Name:</lable>
                                        <input type="text" placeholder="Benificiary name" class="form-control" name="fname" id="fname">
                                    </div>
                                    <div class="form-group wow fadeInDown" >
                                    <label for="sel1">From Account:</label>
                                    <select class="form-control" name="license">
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
                                        
                                    </div>
									<div class="form-group wow fadeInDown" >
									<label>Beneficiary Account Number:</label>
                                        <input type="text" placeholder="Benificiary Account Number" class="form-control" name="na" id="na">
                                    </div>
                                    
                                    
                                    <div id="submit" class="wow fadeInDown" >
                                        <button id="verify" class="btn btn-default btn-send" >Verify</button>
                                    </div>                      
                                    <div id="add" class="wow fadeInDown" style=display:none>
                                        <button id="add" class="btn btn-default btn-send" >Add</button>
                                    </div> 
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="modal fade" id="myModal" role="dialog">
								    <div class="modal-dialog">
								    
								      <!-- Modal content-->
								      <div class="modal-content">
								        <div class="modal-header">
								          <button type="button" class="close" data-dismiss="modal">&times;</button>
								          <h4 class="modal-title">Note</h4>
								        </div>
								        <div class="modal-body" id="resfound1">
								          
								        </div>
								        <div class="modal-footer">
								          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								        </div>
								      </div>
								      
								    </div>
								  </div>
					<div class="col-md-2"></div>
            </div>
        </section>
    
    </body>
</html>


