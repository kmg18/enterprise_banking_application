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
        <title>Modify Customer</title>
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
       <script src="js/modifyuser.js"></script>
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
                                <form id="modiuser" method="post" action="modifydata.jsp" role="form">
                        
                                    <div class="form-group wow fadeInDown" >
                                    <label>Customer ID:</label><br>
                                    <label id="sel1" style=display:none;>*Invalid Customer Id</label>
                                        <input type="number" placeholder="Customer ID" class="form-control" name="cid" id="cid">
                                    </div>
                                    <div id="submit" class="wow fadeInDown" >
                                        <input type="button" id="search" class="btn btn-default btn-send" value="Search">
                                    </div>
                                    <div id="resfound" class="wow fadeInDown" style="display: none;">
                                        <%  %>
                                    </div>
                                    <div id="confirm" class="wow fadeInDown" style="display: none;">
                                    <span>Are you sure?</span>
                                        <button id="yes" class="btn btn-default btn-send" >Yes</button>
                                        <button id="No" class="btn btn-default btn-send" >No</button>
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


