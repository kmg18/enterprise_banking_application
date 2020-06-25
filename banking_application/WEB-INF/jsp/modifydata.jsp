<%@page import="beans.ModifyCustomerBean" import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html class="no-js">
    <head>
        <!-- Basic Page Needs
        ================================================== -->
        <META HTTP-EQUIV="refresh" CONTENT="180; URL=errorbanker.jsp" />
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="icon" type="image/png" href="images/favicon.png">
        <title>Modify customer</title>
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
       <script src="js/modifydata.js"></script>
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
                            <h2>Modify Customer</h2>
                            <ol class="breadcrumb">
                                <li>
                                    <a href="afterbankerlogin.html">
                                        <i class="ion-ios-home"></i>
                                        Banker Home
                                    </a>
                                    <form action="logout" method="post">
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
                            <h2 class="subtitle wow fadeInDown" >Modify Customer</h2>
                            <div class="contact-form">
                            	<form id="updateform" action="updatecustomer" method="post">
                                <% int cid = Integer.parseInt(request.getParameter("cid")); 
                                	ModifyCustomerBean mcb = new ModifyCustomerBean();
                                	ResultSet rs = mcb.retrieve(cid);
                                	if(rs.next())
                                	{
                                		%> <div class="form-group wow fadeInDown">
                                			<label>Email</label><br>
                                			<label id="lemail" style=display:none;>*Invalid Email</label>
                                			<input type="email" name="email" id="email" value="<%=rs.getString(1)  %>" required>
                                			</div>
                                			<div class="form-group wow fadeInDown" >
                                			<label>Phone Number</label><br>
                                			<label id="lpno" style=display:none;>*Invalid Phonenumber</label>
                                			<input type="text" name="pno" id="pno" value="<%=rs.getString(2)  %>" required>
                                			</div>
                                			<div class="form-group wow fadeInDown" >
                                			<label>Address</label>
                                			<input type="textarea" name="address" id="address" value="<%=rs.getString(3)  %>" required>
                                			<input type="hidden" name="cid" id="cid" value="<%=rs.getString(4)  %>">
                                			</div>
                                			<input type="button" value="Update" id="update" class="btn btn-default btn-send">
                                		<%
                                	}
                                %>
                                </form>
                            </div>
                        </div>
                    </div>
					<div class="col-md-2"></div>
            </div>
        </section>
    
    </body>
</html>


