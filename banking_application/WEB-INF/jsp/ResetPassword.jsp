<%@page import="beans.SecurityQuestionBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html class="no-js">
    <head>
        <!-- Basic Page Needs
        ================================================== -->
        <META HTTP-EQUIV="refresh" CONTENT="180; URL=errorbanker.jsp" />
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="icon" type="image/png" href="images/favicon.png">
        <title>Reset Password</title>
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
        
         <script src="js/validate.js"></script>
       <script src="js/resetpassword.js"></script>
       
       
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
                            <h2>Reset Password </h2>
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
                        <div class="contact-form">            
	<% Long e1 = Long.parseLong(request.getParameter("e1"));
	String e2 = request.getParameter("e2");
	String e4 = request.getParameter("e4");
	int cid = Integer.parseInt( request.getParameter("cid"));
	SecurityQuestionBean sqb = new SecurityQuestionBean();
	String result = sqb.checkAnswers(e1, e2, e4, cid);
	if(result.equals("Failed"))
	{
		
		%><jsp:forward page="forgotpassword.jsp"/><%
	}
	else if(result.equals("Successful"))
	{
		%>
			<form id="ResetPass" method="post" action="ResetSuccessful.jsp" >
                    <div class="form-group wow fadeInDown" >
						<label>New Password:</label><br>
						<label id="lpwd" style="display:none;">*New Password(Password should be alphnumeric with atleast 8 characters and 1 special character)</label>
							<input type="password" name="pwd" id="pwd" required>
					</div>
					<div class="form-group wow fadeInDown" >
						<label>Confirm New Password:</label><br>
						<label id="lcpwd" style="display:none;">Confirm Password and new password mismatch</label>
							<input type="password" name="cpwd" id="cpwd" required>
					</div>
					<input type="hidden" name="cid" value="<%=cid %>">
					<div class="form-group wow fadeInDown" >
						<input type="button" value="Update" id="Update" class="btn btn-default btn-send">
					</div>
				</form>
		<%
	}
	%>
	</div>
                        </div>
                    </div>
					<div class="col-md-2"></div>

            </div>
        </section>
    
    </body>
</html>
</body>
</html>