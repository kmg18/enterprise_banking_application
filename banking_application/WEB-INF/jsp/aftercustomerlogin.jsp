<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html class="no-js">
    <head>
        <!-- Basic Page Needs
        ================================================== -->
        <META HTTP-EQUIV="refresh" CONTENT="180; URL=error.jsp" />
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="icon" type="image/png" href="images/favicon.png">
        <title>Customer Home Page</title>
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
      
        <!-- template main js -->
       
    </head>
    <body>
	<% response.setHeader("Refresh", session.getMaxInactiveInterval()+";URL=error.jsp"); 
	%>

        <!-- 
        ================================================== 
            Global Page Section Start
        ================================================== -->
        <section class="global-page-header">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="block">
                            <h2>Customer Home</h2>
                            <ol class="breadcrumb" style="inline">
                                
                                <li>
                                	<h3> Welcome <%=session.getAttribute("uname") %></h3>
                                    <form action="logoutServletCustomer" method="post">
                                        <input type="submit" value="Logout" class="btn btn-default btn-send">
                                    </form>
                                </li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>   
        </section>
         <section id="works" class="works">
                <div class="container">
                    <div class="row">
					<div class="col-sm-3 col-xs-6">
						</div>
                        <div class="col-sm-3 col-xs-6">
                            <figure class="wow fadeInLeft animated portfolio-item" >
                                <div class="img-wrapper">
                                    <img src="images/portfolio/fund.png" class="img-responsive" alt="this is a title" >
                                    <div class="overlay">
                                        <div class="buttons">
                                            <a rel="gallery" class="fancybox" href="selftransfer.jsp">Self</a>
                                            <a href="othertransfer.jsp">Others</a>
                                        </div>
                                    </div>
                                </div>
                                <figcaption>
                                <h4>
                                <a href="#">
                                    Fund Transfer
                                </a>
                                </h4>
                                
                                </figcaption>
                            </figure>
                        </div>
						
                        <div class="col-sm-3 col-xs-6">
                            <figure class="wow fadeInLeft animated" >
                                <div class="img-wrapper">
                                    <img src="images/portfolio/view.png" class="img-responsive" alt="this is a title" >
                                    <div class="overlay">
                                        <div class="buttons">
                                            
                                            <a rel="gallery" class="fancybox" href="statements.jsp">View Statements</a>
                                            <a href="balance.jsp">View Balance</a>
                                        </div>
                                    </div>
                                </div>
                                <figcaption>
                                <h4>
                                <a href="#">
                                    View
                                </a>
								</h4>
                              
                                </figcaption>
                            </figure>
                        </div>
						<div class="col-sm-3 col-xs-6">
						</div>
                        
    
    </body>
</html>
