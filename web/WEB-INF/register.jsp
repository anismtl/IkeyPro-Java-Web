<%-- 
    Document   : register
    Created on : 2019-04-16, 18:32:36
    Author     : 1895127
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="/WEB-INF/erreur/erreur.jsp" %>
<%@taglib  uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${not empty sessionScope.lang ? sessionScope.lang : sessionScope.langD}" />
<fmt:bundle basename="app">
<!DOCTYPE html>
<html>
    <head>
        <title><fmt:message key="PInscription"/></title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="OneTech shop project">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
        <link href="plugins/fontawesome-free-5.0.1/css/fontawesome-all.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="styles/cart_styles.css">
        <link rel="stylesheet" type="text/css" href="styles/cart_responsive.css">
    </head>
    <body>
        <div class="super_container">
            <!-- Header -->
            <jsp:include page="jspf/header2.jsp"/>
        <div class="cart_section">
            <div class="container">
                <div class="row">
                    <div class="col-lg-10 offset-lg-1">
                        <div class="cart_container">
                            <div class="cart_title"><fmt:message key="PInscription"/></div>
                            <div class="cart_items">
                                <ul class="cart_list">
                                    <li class="cart_item clearfix">
                                        <form name="formInscription" action="Register" method="POST">
                                            <input type="hidden" name="action" value="completeInscription" />
                                            <div class="form-row">
                                                <div class="col-md-4">
                                                    <label for="validationServer01"><fmt:message key="PPrenom"/></label>
                                                    <input type="text" class="form-control" name="prenom" placeholder='<fmt:message key="PPrenom"/>' value="" required>
                                                </div>
                                                <div class="col-md-4 mb-3">
                                                    <label for="validationServer02"><fmt:message key="PNomDeFamille"/></label>
                                                    <input type="text" class="form-control" name="nom"  placeholder='<fmt:message key="PNomDeFamille"/>' value="" required>
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="col-md-4 mb-3">
                                                    <label for="validationServer01"><fmt:message key="PNomDutilisateur"/></label>
                                                    <input type="email" class="form-control" name="user" placeholder='<fmt:message key="PNomDutilisateur"/>' value="" required>${resultat}
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="col-md-4 mb-3">
                                                    <label for="validationServer02"><fmt:message key="PMotDePasse"/></label>
                                                    <input type="password" class="form-control" name="pass" placeholder='<fmt:message key="PMotDePasse"/>' value="" required>
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="col-md-4 mb-3">
                                                    <label for="validationServerUsername"><fmt:message key="PConfirmationDeMotDePasse"/></label>
                                                    <div class="input-group">
                                                        <input type="password" class="form-control" name="cpass" placeholder='<fmt:message key="PConfirmationDeMotDePasse"/>' required>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="col-md-6 mb-3">
                                                    <label for="validationServer03"><fmt:message key="PAdresse"/></label>
                                                    <input type="text" class="form-control" name="adresse" placeholder='<fmt:message key="PAdresse"/>' required>
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="col-md-3 mb-3">
                                                    <label for="validationServer04"><fmt:message key="PTelephone"/></label>
                                                    <input type="text" class="form-control" name="tel" placeholder='<fmt:message key="PTelephone"/>' required>
                                                </div>
                                            </div>
                                            <button class="btn btn-primary" type="submit"><fmt:message key="PCompletezLinscription"/></button>
                                        </form>
                                    </li>
                                </ul>
                            </div>
                            <!-- Order Total -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Newsletter -->
        <jsp:include page="jspf/newsletter.jsp"/>
        <!-- Footer -->
        <jsp:include page="jspf/footer.jsp"/>
        <script src="js/newsletter.js"></script>
        <script src="js/langues.js"></script>
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="styles/bootstrap4/popper.js"></script>
        <script src="styles/bootstrap4/bootstrap.min.js"></script>
        <script src="plugins/greensock/TweenMax.min.js"></script>
        <script src="plugins/greensock/TimelineMax.min.js"></script>
        <script src="plugins/scrollmagic/ScrollMagic.min.js"></script>
        <script src="plugins/greensock/animation.gsap.min.js"></script>
        <script src="plugins/greensock/ScrollToPlugin.min.js"></script>
        <script src="plugins/easing/easing.js"></script>
        <script src="js/cart_custom.js"></script>
</body>
</html>
</fmt:bundle>