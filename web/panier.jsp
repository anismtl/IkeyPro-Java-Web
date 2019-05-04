<%-- 
    Document   : panier
    Created on : 2019-04-28, 16:14:19
    Author     : Anis
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib  uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${not empty sessionScope.lang ? sessionScope.lang : sessionScope.langD}" />
<fmt:bundle basename="app">
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <title>Cart</title>
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
                <jsp:include page="WEB-INF/jspf/header2.jsp"/>


                <!-- Cart -->

                <div class="cart_section">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-10 offset-lg-1">
                                <div class="cart_container">
                                    <div class="cart_title">Shopping Cart</div>

                                    <c:forEach var = "ligne" items="${panier}">
                                        <div class="cart_items">
                                            <ul class="cart_list">
                                                <li class="cart_item clearfix">
                                                    <div class="cart_item_image"><img src="images/${ligne.image}" alt=""></div>
                                                    <div class="cart_item_info d-flex flex-md-row flex-column justify-content-between">
                                                        <div class="cart_item_name cart_info_col">
                                                            <div class="cart_item_title">Name</div>
                                                            <div class="cart_item_text"><a href="GererProduit?id=${ligne.codeProduit}">${ligne.produit}</a></div>
                                                        </div>
                                                        <div class="cart_item_quantity cart_info_col">
                                                            <div class="cart_item_title">Quantity</div>
                                                            <div class="cart_item_text">${ligne.qte}</div>
                                                        </div>
                                                        <div class="cart_item_price cart_info_col">
                                                            <div class="cart_item_title">Price</div>
                                                            <div class="cart_item_text">$${ligne.prix}</div>
                                                        </div>
                                                        <div class="cart_item_total cart_info_col">
                                                            <div class="cart_item_title">Action</div>
                                                            <div class="cart_item_text"> <form name="deleteForm"
                                                                                               action="Panier"
                                                                                               method="POST">

                                                                    <button type="submit" value="Delete" type="button" class="btn btn-sm btn-secondary" role="button"><fmt:message key="PDelete"/></button>

                                                                    <input type="hidden" name= "delindex" value='${panier.indexOf(ligne)}'>

                                                                    <input type="hidden" name="action" value="DELETE">
                                                                </form></div>
                                                        </div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </c:forEach>




                                    <div class="cart_buttons">
                                        <c:if test="${empty panier}">
                                            <a type="button" class="btn btn-lg btn-light disabled" href="Panier?action=VIDER" role="button">Vider Panier</a>
                                        </c:if>
                                        <c:if test="${!empty panier}">
                                            <a type="button" class="btn btn-lg btn-light" href="Panier?action=VIDER" role="button">Vider Panier</a>
                                        </c:if>
                                        <a type="button" class="btn btn-lg btn-light" href="ListeProduits?action=categorie&cat=2" role="button"><fmt:message key="PMagasiner"/></a>
                                        <c:if test="${empty panier}">
                                            <a type="button" class="btn btn-lg btn-primary disabled" href="ListeProduits?action=categorie&cat=2" role="button">Checkout</a>
                                        </c:if>
                                        <c:if test="${!empty panier}">
                                            <a type="button" class="btn btn-lg btn-primary" href="ListeProduits?action=categorie&cat=2" role="button">Checkout</a>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Newsletter -->


                <jsp:include page="WEB-INF/jspf/newsletter.jsp"/>
                <!-- Footer -->
                <jsp:include page="WEB-INF/jspf/footer.jsp"/>
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