<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="beans.*" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html class="no-js">
    <head>
        <!-- Basic Page Needs
        ================================================== -->
        <META HTTP-EQUIV="refresh" CONTENT="180; URL=errorbanker.jsp" />
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="icon" type="image/png" href="images/favicon.png">
        <title>Forgot Password</title>
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
        <link href="http://getbootstrap.com/2.3.2/assets/css/bootstrap-responsive.css" rel="stylesheet" type="text/css" />
        <script src="js/bootstrap.min.js"></script>
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
                            <h2>First Time Registration </h2>
                            <ol class="breadcrumb">
                                <li>
                                    <a href="index.jsp">
                                        <i class="ion-ios-home"></i>
                                        Home
                                    </a>
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
                            <h1 class="subtitle wow fadeInDown" >Reset Password</h1>
                            
                            <div class="contact-form">
                                <form id="Security" method="post" action="ResetPassword.jsp" >
                                
                        
                                     <div class="form-group wow fadeInDown" >
                                     <label>What is your first phone number?</label>
                                        <input type="number" placeholder ="Answer in 10 digits only" class="form-control" name="e1" id="e1" required>
                                    </div>
                                    <div class="form-group wow fadeInDown" >
                                     <label>What is the best birthday gift you ever received?</label>
                                        <input type="text" placeholder ="Answer in 30 characters only" class="form-control" name="e2" id="e2" required>
                                    </div>
                                     </div>
                                    <div class="form-group wow fadeInDown" >
                                     <% int cid=Integer.parseInt(request.getParameter("cid")); 
                                     SecurityQuestionBean sqb = new SecurityQuestionBean();
                                     ResultSet rs=sqb.getquestion(cid);
                                     if(rs.next())
                                     {
                                    	 %><label><%=rs.getString(1) %></label>
                                    	 <% 
                                     }
                                     %>
                                        
                                     <div class="form-group wow fadeInDown" >
                                   
                                        <input type="text" placeholder="Answer in 30 characters only" class="form-control" name="e4" id="e4" required>
                                        
                                    </div>
                                    	<input type="hidden" name="cid" value="<%=cid %>">
                                    <div class="wow fadeInDown" >
                                        <input type="submit" value="Proceed" class="btn btn-default btn-send">
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


