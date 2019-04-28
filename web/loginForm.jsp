<%-- 
    Document   : loginForm
    Created on : 2019-04-07, 23:50:25
    Author     : Judith
--%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib  uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:bundle basename="app">
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>IkeyPro</title>
            <meta name="description" content="OneTech shop project">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
            <link href="plugins/fontawesome-free-5.0.1/css/fontawesome-all.css" rel="stylesheet" type="text/css">
            <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
            <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
            <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
            <link rel="stylesheet" type="text/css" href="plugins/slick-1.8.0/slick.css">
            <link rel="stylesheet" type="text/css" href="styles/main_styles.css">
            <link rel="stylesheet" type="text/css" href="styles/responsive.css">
        </head>
        <body>
            <div class="super_container">
                <!-- Header -->
             
                <div class="wrapper fadeInDown">
                    <div id="formContent">
                        <!-- Tabs Titles -->
                        <!-- Icon -->
                        <div class="fadeIn first">
                            <img src="http://danielzawadzki.com/codepen/01/icon.svg" id="icon" alt="User Icon" />
                        </div>
                        <!-- Login Form -->
                        <form>
                            <input type="text" id="login" class="fadeIn second" name="login" placeholder="login">
                            <input type="text" id="password" class="fadeIn third" name="login" placeholder="password">
                            <input type="submit" class="fadeIn fourth" value="Log In">
                        </form>
                        <!-- Remind Passowrd -->
                        <div id="formFooter">
                            <a class="underlineHover" href="#"><fmt:message key="PForgotPassword"/></a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Newsletter -->
            <jsp:include page="WEB-INF/jspf/newsletter.jsp"/>
            <!-- Footer -->
            <jsp:include page="WEB-INF/jspf/footer.jsp"/>
            <script src="js.js"></script>
            <script src="js/jquery-3.3.1.min.js"></script>
            <script src="styles/bootstrap4/popper.js"></script>
            <script src="styles/bootstrap4/bootstrap.min.js"></script>
            <script src="plugins/greensock/TweenMax.min.js"></script>
            <script src="plugins/greensock/TimelineMax.min.js"></script>
            <script src="plugins/scrollmagic/ScrollMagic.min.js"></script>
            <script src="plugins/greensock/animation.gsap.min.js"></script>
            <script src="plugins/greensock/ScrollToPlugin.min.js"></script>
            <script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
            <script src="plugins/slick-1.8.0/slick.js"></script>
            <script src="plugins/easing/easing.js"></script>
            <script src="js/custom.js"></script>
        </body>
    </html>
</fmt:bundle>
