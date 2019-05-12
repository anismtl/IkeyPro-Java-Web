<%-- 
    Document   : confirmaton
    Created on : 2019-05-12, 16:58:42
    Author     : Anis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib  uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${not empty sessionScope.lang ? sessionScope.lang : sessionScope.langD}" />
<fmt:bundle basename="app">
    <!DOCTYPE html>
    <html>
        <head>
            <title>Erreur</title>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="description" content="OneTech shop project">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
            <link href="plugins/fontawesome-free-5.0.1/css/fontawesome-all.css" rel="stylesheet" type="text/css">
            <link rel="stylesheet" type="text/css" href="styles/regular_styles.css">
            <link rel="stylesheet" type="text/css" href="styles/regular_responsive.css">

        </head>

        <body>

            <div class="super_container">

                <!-- Header -->

                <jsp:include page="jspf/header2.jsp"/>

                <!-- Single Blog Post -->

                <div class="single_post">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-8 offset-lg-2">
                                <div class="single_post_title"></div>
                                <div class="single_post_text">
                                   

                                    <div class="single_post_quote text-center">
                                        <div class="quote_image"><img src="images/quote.png" alt=""></div>
                                        <div class="quote_name">OUUPS !</div>
                                        <div class="quote_text"> <b>Erreur Inconnu !</b> ${st}</div>
                                                                        
                                        
                                        
                                    </div>

                                   
                                </div>
                            </div>
                        </div>
                    </div>
                </div>




                <!-- Newsletter -->

                <jsp:include page="jspf/newsletter.jsp"/>

                <!-- Footer -->
                <jsp:include page="jspf/footer.jsp"/>
                <script src="js/langues.js"></script>
                <script src="js/newsletter.js"></script>
                <script src="js/jquery-3.3.1.min.js"></script>
                <script src="styles/bootstrap4/popper.js"></script>
                <script src="styles/bootstrap4/bootstrap.min.js"></script>
                <script src="plugins/greensock/TweenMax.min.js"></script>
                <script src="plugins/greensock/TimelineMax.min.js"></script>
                <script src="plugins/scrollmagic/ScrollMagic.min.js"></script>
                <script src="plugins/greensock/animation.gsap.min.js"></script>
                <script src="plugins/greensock/ScrollToPlugin.min.js"></script>
                <script src="plugins/easing/easing.js"></script>
                <script src="js/regular_custom.js"></script>
        </body>

    </html>
</fmt:bundle>