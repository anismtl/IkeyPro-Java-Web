<%-- 
    Document   : produit
    Created on : 2019-04-13, 19:21:49
    Author     : Anis
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib  uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:bundle basename="app">
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <title>Ikeypro - ${prod.produit}</title>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="description" content="OneTech shop project">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
            <link href="plugins/fontawesome-free-5.0.1/css/fontawesome-all.css" rel="stylesheet" type="text/css">
            <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
            <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
            <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
            <link rel="stylesheet" type="text/css" href="styles/product_styles.css">
            <link rel="stylesheet" type="text/css" href="styles/product_responsive.css">
        </head>

        <body>
            <div class="super_container">
                <!-- Header -->
                <jsp:include page="WEB-INF/jspf/header2.jsp"/>
                <!-- Single Product -->
                <div class="single_product">
                    <div class="container">
                        <div class="row">
                            <!-- Images -->
                            <!-- Selected Image -->
                            <div class="col-lg-5 order-lg-2 order-1">
                                <div class="image_selected"><img src="images/${prod.image}" alt=""></div>
                            </div>
                            <!-- Description -->
                            <div class="col-lg-5 order-3">
                                <div class="product_description">
                                    <div class="product_category"><b>${prod.editeur}</b></div>
                                    <div class="product_name">${prod.produit}</div>
                                    <div class="rating_r rating_r_4 product_rating"><i></i><i></i><i></i><i></i><i></i></div>
                                    <div class="product_text"> <a><b><fmt:message key="PVersion"/> :</b></as> ${prod.edition}  <br/>
                                            <b><fmt:message key="PPlateforme"/> : </b></as> ${prod.plateforme}  <br/>
                                            <b><fmt:message key="PLangue"/> :</b></as> ${prod.langue}  <br/>
                                            <b><fmt:message key="PReleaseDate"/> : </b></as> ${prod.dateRelease}  <br/>
                                            <b><fmt:message key="PEdition"/> :</b></as> ${prod.edition}  <br/>
                                    </div>
                                    <div class="order_info d-flex flex-row">
                                        <form name="ProduitForm" action="Panier" method="POST">
                                            <div class="clearfix" style="z-index: 1000;">
                                                <!-- Product Quantity -->
                                                <div class="product_quantity clearfix">
                                                    <span><fmt:message key="PQuantity"/> : </span>
                                                    <input id="quantity_input" type="text" pattern="[0-9]*" name="qty" value="1">
                                                    <input type="hidden" name="id" value="${prod.codeProduit}">
                                                    <input type="hidden" name="action" value="ADD">
                                                    <div class="quantity_buttons">
                                                        <div id="quantity_inc_button" class="quantity_inc quantity_control"><i class="fas fa-chevron-up"></i></div>
                                                        <div id="quantity_dec_button" class="quantity_dec quantity_control"><i class="fas fa-chevron-down"></i></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="product_price">$${prod.prix}</div>
                                            <div class="button_container">
                                                <button type="submit" class="button cart_button"><fmt:message key="PAddToCart"/></button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Recently Viewed -->
                <div class="viewed">
                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <div class="viewed_title_container">
                                    <h3 class="viewed_title"><fmt:message key="PRecentlyViewed"/></h3>
                                    <div class="viewed_nav_container">
                                        <div class="viewed_nav viewed_prev"><i class="fas fa-chevron-left"></i></div>
                                        <div class="viewed_nav viewed_next"><i class="fas fa-chevron-right"></i></div>
                                    </div>
                                </div>
                                <div class="viewed_slider_container">
                                    <!-- Recently Viewed Slider -->
                                    <div class="owl-carousel owl-theme viewed_slider">
                                        <!-- Most Viewed Item -->
                                        <c:forEach var = "ligne" items="${ListeMostViewProduits}">
                                            <div class="owl-item">
                                                <div class="viewed_item d-flex flex-column align-items-center justify-content-center text-center">
                                                    <div class="viewed_image"><img src="images/${ligne.image}" alt=""></div>
                                                    <div class="viewed_content text-center">
                                                        <div class="viewed_price">$${ligne.prix}</div>
                                                        <div class="viewed_name"><a href="GererProduit?id=${ligne.codeProduit}">${ligne.produit}</a></div>
                                                    </div>
                                                    <ul class="item_marks">
                                                        <li class="item_mark item_discount">-25%</li>
                                                        <li class="item_mark item_new"><fmt:message key="PNew"/></li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Brands -->
                <div class="brands">
                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <div class="brands_slider_container">
                                    <!-- Brands Slider -->
                                    <div class="owl-carousel owl-theme brands_slider">
                                        <div class="owl-item"><div class="brands_item d-flex flex-column justify-content-center"><img src="images/brands_1.jpg" alt=""></div></div>
                                        <div class="owl-item"><div class="brands_item d-flex flex-column justify-content-center"><img src="images/brands_2.jpg" alt=""></div></div>
                                        <div class="owl-item"><div class="brands_item d-flex flex-column justify-content-center"><img src="images/brands_3.jpg" alt=""></div></div>
                                        <div class="owl-item"><div class="brands_item d-flex flex-column justify-content-center"><img src="images/brands_4.jpg" alt=""></div></div>
                                        <div class="owl-item"><div class="brands_item d-flex flex-column justify-content-center"><img src="images/brands_5.jpg" alt=""></div></div>
                                        <div class="owl-item"><div class="brands_item d-flex flex-column justify-content-center"><img src="images/brands_6.jpg" alt=""></div></div>
                                        <div class="owl-item"><div class="brands_item d-flex flex-column justify-content-center"><img src="images/brands_7.jpg" alt=""></div></div>
                                        <div class="owl-item"><div class="brands_item d-flex flex-column justify-content-center"><img src="images/brands_8.jpg" alt=""></div></div>
                                    </div>
                                    <!-- Brands Slider Navigation -->
                                    <div class="brands_nav brands_prev"><i class="fas fa-chevron-left"></i></div>
                                    <div class="brands_nav brands_next"><i class="fas fa-chevron-right"></i></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Newsletter -->
                <jsp:include page="WEB-INF/jspf/newsletter.jsp"/>
                <!-- Footer -->
                <jsp:include page="WEB-INF/jspf/footer.jsp"/>
                <script src="js/jquery-3.3.1.min.js"></script>
                <script src="styles/bootstrap4/popper.js"></script>
                <script src="styles/bootstrap4/bootstrap.min.js"></script>
                <script src="plugins/greensock/TweenMax.min.js"></script>
                <script src="plugins/greensock/TimelineMax.min.js"></script>
                <script src="plugins/scrollmagic/ScrollMagic.min.js"></script>
                <script src="plugins/greensock/animation.gsap.min.js"></script>
                <script src="plugins/greensock/ScrollToPlugin.min.js"></script>
                <script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
                <script src="plugins/easing/easing.js"></script>
                <script src="js/product_custom.js"></script>
        </body>
    </html>
</fmt:bundle>