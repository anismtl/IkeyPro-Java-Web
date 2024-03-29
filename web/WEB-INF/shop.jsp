<%-- 
    Document   : shop
    Created on : 2019-04-10, 22:05:16
    Author     : Anis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="/WEB-INF/erreur/erreur.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib  uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate var="year" value="${now}" pattern="yyyy" />
<fmt:setLocale value="${not empty sessionScope.lang ? sessionScope.lang : sessionScope.langD}" />
<fmt:bundle basename="app">
    <!DOCTYPE html>
    <html>
        <head>
            <title>IkeyPro - Shop -  ${titre} </title>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="description" content="OneTech shop project">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
            <link href="plugins/fontawesome-free-5.0.1/css/fontawesome-all.css" rel="stylesheet" type="text/css">
            <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
            <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
            <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
            <link rel="stylesheet" type="text/css" href="plugins/jquery-ui-1.12.1.custom/jquery-ui.css">
            <link rel="stylesheet" type="text/css" href="styles/shop_styles.css">
            <link rel="stylesheet" type="text/css" href="styles/shop_responsive.css">
        </head>
        <body>
            <div class="super_container">
                <!-- Header -->
                <jsp:include page="jspf/header2.jsp"/>
                <!-- Home -->
                <div class="home">
                    <div class="home_background parallax-window" data-parallax="scroll" data-image-src="images/shop_background.jpg"></div>
                    <div class="home_overlay"></div>
                    <div class="home_content d-flex flex-column align-items-center justify-content-center">
                        <h2 class="home_title">      
                              ${titre}
                        </h2>
                    </div>
                </div>



                <!-- Shop -->
                <div class="shop">
                    <!-- Recherche -->
                    <form action="ListeProduits?action=recherche" method="POST">
                        <div class="container my-5">
                            <div class="reserverarea position border text-center">
                                <div class="row text-center">

                                    <div class="col-md-2">
                                        <h4 class="py-3 px-2">Rechercher<br> Avancé</h4>
                                    </div>
                                    <div class="col-md-10">
                                        <div class="cherchertable">
                                            <div class="row">
                                                <div class="col-md-3 ">
                                                    <div class="book_tabel_item py-3 px-2">
                                                        <div class="form-group d-flex justify-content-center">
                                                            <h6>Catégorie</h6>   
                                                        </div>
                                                        <div class="input-group  d-flex justify-content-center">
                                                            <select name="cat" class="custom-select mr-sm-2" id="cat" required><option>--Choisir--</option><option value="Alaska">Alaska</option><option value="Asie">Asie</option><option value="Australie">Australie </option><option value="Bahamas">Bahamas </option><option value="Bermudes">Bermudes</option><option value="Canada">Canada </option><option value="Caraïbes">Caraïbes </option><option value="Cuba">Cuba</option></select>
                                                        </div>

                                                    </div>
                                                </div>
                                                
                                                <div class="col-md-3">
                                                    <div class="book_tabel_item py-3 px-2">
                                                        <div class="form-group  d-flex justify-content-center">
                                                            <h6>Editeur</h6>   
                                                        </div>
                                                        <div class="input-group  d-flex justify-content-center">
                                                            <select name="editeur2" class="custom-select mr-sm-2" id="des" required><option>--Choisir--</option> </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="book_tabel_item py-3 px-2">
                                                        <div class="form-group  d-flex justify-content-center">
                                                            <h6>Edition</h6>   
                                                        </div>
                                                        <div class="input-group  d-flex justify-content-center">
                                                            <select name="edition2" class="custom-select mr-sm-2" id="dur" required><option>--Choisir--</option></select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-2 distan">
                                                    <div class="book_tabel_item">
                                                        <div class="form-group  d-flex justify-content-center">
                                                            <h6></h6>   
                                                        </div>
                                                        <button class="btn btncher" type="submit" id="bChercher">Rechercher</button>
                                                        <!--<a class="btn btncher" href="#" id="bChercher">Rechercher</a>-->
                                                        </form>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="container">
                            <div class="row">

                                <div class="col-lg-12">
                                    <!-- Shop Content -->
                                    <div class="shop_content">
                                        <div class="shop_bar clearfix">
                                            <div class="shop_product_count"><span>${ListePro.size()}</span> products found</div>
                                            <div class="shop_sorting">
                                                <span>Sort by:</span>
                                                <ul>
                                                    <li>
                                                        <span class="sorting_text"><fmt:message key="PName"/><i class="fas fa-chevron-down"></span></i>
                                                        <ul>
                                                            <li class="shop_sorting_button" data-isotope-option='{ "sortBy": "name" }'><fmt:message key="PName"/></li>
                                                            <li class="shop_sorting_button"data-isotope-option='{ "sortBy": "price" }'><fmt:message key="PPrice"/></li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="product_grid">
                                            <div class="product_grid_border"></div>
                                            <!-- Product Item -->
                                            <c:forEach var = "ligne" items="${ListePro}">
                                                <!-- Product Item -->
                                                <div class="product_item is_new">
                                                    <div class="product_border"></div>
                                                    <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/${ligne.image}" alt=""></div>
                                                    <div class="product_content">
                                                        <div class="product_price">$ ${ligne.prix}</div>
                                                        <div class="product_name"><div>${ligne.editeur}</div></div>
                                                        <div class="product_name"><div><a href="GererProduit?id=${ligne.codeProduit}" tabindex="0">${ligne.produit}</a></div></div>
                                                    </div>
                                                    <ul class="product_marks">
                                                        <c:choose>
                                                            <c:when test="${ligne.dateRelease == year}"> 
                                                                <li class="product_mark product_new">new</li> 
                                                                </c:when>
                                                            </c:choose>
                                                    </ul>
                                                </div>
                                            </c:forEach>
                                            <!-- Shop Page Navigation -->
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Most Viwed Viewed -->
                        <div class="viewed">
                            <div class="container">
                                <div class="row">
                                    <div class="col">
                                        <div class="viewed_title_container">
                                            <h3 class="viewed_title"><fmt:message key="PMostViewed"/></h3>
                                            <div class="viewed_nav_container">
                                                <div class="viewed_nav viewed_prev"><i class="fas fa-chevron-left"></i></div>
                                                <div class="viewed_nav viewed_next"><i class="fas fa-chevron-right"></i></div>
                                            </div>
                                        </div>
                                        <div class="viewed_slider_container">
                                            <!-- Most Viewed Slider -->
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
                </div>
            </div>
            <!-- Newsletter -->
            <jsp:include page="jspf/newsletter.jsp"/>
            <!-- Footer -->
            <jsp:include page="jspf/footer.jsp"/>
            <script src="js/langues.js"></script>
            <script src="js/newsletter.js"></script>
            <script src="js/recherche.js"></script>
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
            <script src="plugins/Isotope/isotope.pkgd.min.js"></script>
            <script src="plugins/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
            <script src="plugins/parallax-js-master/parallax.min.js"></script>
            <script src="js/shop_custom.js"></script>
        </body>
    </html>
</fmt:bundle>