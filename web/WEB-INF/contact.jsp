<%-- 
    Document   : contact
    Created on : 2019-04-10, 22:21:05
    Author     : Anis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="/WEB-INF/erreur/erreur.jsp" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${not empty sessionScope.lang ? sessionScope.lang : sessionScope.langD}" />
<fmt:bundle basename="app">
    <!DOCTYPE html>
    <html>
        <head>
            <title>Contact</title>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="description" content="OneTech shop project">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
            <link href="plugins/fontawesome-free-5.0.1/css/fontawesome-all.css" rel="stylesheet" type="text/css">
            <link rel="stylesheet" type="text/css" href="styles/contact_styles.css">
            <link rel="stylesheet" type="text/css" href="styles/contact_responsive.css">

        </head>

        <body>

            <div class="super_container">

                <!-- Header -->

                <jsp:include page="jspf/header2.jsp"/>

                <!-- Contact Info -->

                <div class="contact_info">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-10 offset-lg-1">
                                <div class="contact_info_container d-flex flex-lg-row flex-column justify-content-between align-items-between">

                                    <!-- Contact Item -->
                                    <div class="contact_info_item d-flex flex-row align-items-center justify-content-start">
                                        <div class="contact_info_image"><img src="images/contact_1.png" alt=""></div>
                                        <div class="contact_info_content">
                                            <div class="contact_info_title"><fmt:message key="PTelephone"/></div>
                                            <div class="contact_info_text">+1514 000 0000</div>
                                        </div>
                                    </div>

                                    <!-- Contact Item -->
                                    <div class="contact_info_item d-flex flex-row align-items-center justify-content-start">
                                        <div class="contact_info_image"><img src="images/contact_2.png" alt=""></div>
                                        <div class="contact_info_content">
                                            <div class="contact_info_title">Email</div>
                                            <div class="contact_info_text">ikeypro@gmail.com</div>
                                        </div>
                                    </div>

                                    <!-- Contact Item -->
                                    <div class="contact_info_item d-flex flex-row align-items-center justify-content-start">
                                        <div class="contact_info_image"><img src="images/contact_3.png" alt=""></div>
                                        <div class="contact_info_content">
                                            <div class="contact_info_title"><fmt:message key="PAdresse"/></div>
                                            <div class="contact_info_text">10 Suffolk at Soho, London, UK</div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Contact Form -->



                <div class="contact_form">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-10 offset-lg-1">
                                <div class="contact_form_container">
                                    <div class="contact_form_title"><fmt:message key="PGetintouch"/></div>

                                    <form action="Contact" id="contact_form" method="POST">
                                        <div class="contact_form_inputs d-flex flex-md-row flex-column justify-content-between align-items-between">
                                            <input type="text" name="from" id="contact_form_name" class="contact_form_name input_field" placeholder="Your name" required="required" data-error="Name is required.">
                                            <input type="text" name="email" id="contact_form_email" class="contact_form_email input_field" placeholder="Your email" required="required" data-error="Email is required.">
                                            <input type="text" name="telephone" id="contact_form_phone" class="contact_form_phone input_field" placeholder="Your phone number">
                                        </div>
                                        <div class="contact_form_text">
                                            <textarea id="contact_form_message" class="text_field contact_form_message" name="message" rows="4" placeholder="Message" required="required" data-error="Please, write us a message."></textarea>
                                        </div>
                                        <div class="contact_form_button">
                                            <button type="submit" class="button contact_submit_button"><fmt:message key="PSend"/></button>  <a><b>${confirmation}</b></a>
                                        </div>
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel"></div>
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
                <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyCIwF204lFZg1y4kPSIhKaHEXMLYxxuMhA"></script>
                <script src="js/contact_custom.js"></script>
        </body>

    </html>
</fmt:bundle>