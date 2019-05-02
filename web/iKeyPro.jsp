<%-- 
    Document   : index
    Created on : 2019-04-07, 23:45:16
    Author     : Judith
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:bundle basename="app">
    <!DOCTYPE html>
    <html>
        <head>
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
                <jsp:include page="WEB-INF/header.jsp"/>
                <!-- Menu -->
                <div class="page_menu">
                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <div class="page_menu_content">
                                    <div class="page_menu_search">
                                        <form action="#">
                                            <input type="search" required="required" class="page_menu_search_input" placeholder="Search for products...">
                                        </form>
                                    </div>
                                    <ul class="page_menu_nav">
                                        <li class="page_menu_item has-children">
                                            <a href="#"><fmt:message key="PLanguage"/><i class="fa fa-angle-down"></i></a>
                                            <ul class="page_menu_selection">
                                                <li><a href="#"><fmt:message key="PEnglish"/><i class="fa fa-angle-down"></i></a></li>
                                                <li><a href="#"><fmt:message key="PFrech"/><i class="fa fa-angle-down"></i></a></li>
                                                <li><a href="#"><fmt:message key="PSpanish"/><i class="fa fa-angle-down"></i></a></li>
                                            </ul>
                                        </li>
                                        <li class="page_menu_item">
                                            <a href="#"><fmt:message key="PHome"/><i class="fa fa-angle-down"></i></a>
                                        </li>
                                        <li class="page_menu_item has-children">
                                            <a href="#"><fmt:message key="PSuperDeals"/><i class="fa fa-angle-down"></i></a>
                                            <ul class="page_menu_selection">
                                                <li><a href="#"><fmt:message key="PSuperDeals"/><i class="fa fa-angle-down"></i></a></li>
                                                <li class="page_menu_item has-children">
                                                    <a href="#">Menu Item<i class="fa fa-angle-down"></i></a>
                                                    <ul class="page_menu_selection">
                                                        <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                                        <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                                        <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                                        <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                                    </ul>
                                                </li>
                                                <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                                <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                                <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                            </ul>
                                        </li>
                                        <li class="page_menu_item has-children">
                                            <a href="#"><fmt:message key="PFeaturedBrands"/><i class="fa fa-angle-down"></i></a>
                                            <ul class="page_menu_selection">
                                                <li><a href="#">Featured Brands<i class="fa fa-angle-down"></i></a></li>
                                                <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                                <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                                <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                            </ul>
                                        </li>
                                        <li class="page_menu_item has-children">
                                            <a href="#"><fmt:message key="PTrendingStyles"/><i class="fa fa-angle-down"></i></a>
                                            <ul class="page_menu_selection">
                                                <li><a href="#">Trending Styles<i class="fa fa-angle-down"></i></a></li>
                                                <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                                <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                                <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                            </ul>
                                        </li>
                                        <li class="page_menu_item"><a href="blog.html">blog<i class="fa fa-angle-down"></i></a></li>
                                        <li class="page_menu_item"><a href="contact.html"><fmt:message key="Pcontact"/><i class="fa fa-angle-down"></i></a></li>
                                    </ul>
                                    <div class="menu_contact">
                                        <div class="menu_contact_item"><div class="menu_contact_icon"><img src="images/phone_white.png" alt=""></div>+38 068 005 3570</div>
                                        <div class="menu_contact_item"><div class="menu_contact_icon"><img src="images/mail_white.png" alt=""></div><a href="mailto:fastsales@gmail.com">fastsales@gmail.com</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
            <!-- Banner -->
            <div class="banner">
                <div class="banner_background" style="background-image:url(images/banner_background.jpg)"></div>
                <div class="container fill_height">
                    <div class="row fill_height">
                        <div class="banner_product_image"><img src="images/banner_product.png" alt=""></div>
                        <div class="col-lg-5 offset-lg-4 fill_height">
                            <div class="banner_content">
                                <h1 class="banner_text">new era of smartphones</h1>
                                <div class="banner_price"><span>$530</span>$460</div>
                                <div class="banner_product_name">Apple Iphone 6s</div>
                                <div class="button banner_button"><a href="GererProduit?id=5"><fmt:message key="PShopNow"/></a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Characteristics -->
            <div class="characteristics">
                <div class="container">
                    <div class="row">
                        <!-- Char. Item -->
                        <div class="col-lg-3 col-md-6 char_col">
                            <div class="char_item d-flex flex-row align-items-center justify-content-start">
                                <div class="char_icon"><img src="images/char_1.png" alt=""></div>
                                <div class="char_content">
                                    <div class="char_title">Free Delivery</div>
                                    <div class="char_subtitle">from $50</div>
                                </div>
                            </div>
                        </div>
                        <!-- Char. Item -->
                        <div class="col-lg-3 col-md-6 char_col">
                            <div class="char_item d-flex flex-row align-items-center justify-content-start">
                                <div class="char_icon"><img src="images/char_2.png" alt=""></div>
                                <div class="char_content">
                                    <div class="char_title">Free Delivery</div>
                                    <div class="char_subtitle">from $50</div>
                                </div>
                            </div>
                        </div>
                        <!-- Char. Item -->
                        <div class="col-lg-3 col-md-6 char_col">
                            <div class="char_item d-flex flex-row align-items-center justify-content-start">
                                <div class="char_icon"><img src="images/char_3.png" alt=""></div>
                                <div class="char_content">
                                    <div class="char_title">Free Delivery</div>
                                    <div class="char_subtitle">from $50</div>
                                </div>
                            </div>
                        </div>
                        <!-- Char. Item -->
                        <div class="col-lg-3 col-md-6 char_col">
                            <div class="char_item d-flex flex-row align-items-center justify-content-start">
                                <div class="char_icon"><img src="images/char_4.png" alt=""></div>
                                <div class="char_content">
                                    <div class="char_title">Free Delivery</div>
                                    <div class="char_subtitle">from $50</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Deals of the week -->
            <!-- Banner -->
            <div class="banner_2">
                <div class="banner_2_background" style="background-image:url(images/banner_2_background.jpg)"></div>
                <div class="banner_2_container">
                    <div class="banner_2_dots"></div>
                    <!-- Banner 2 Slider -->
                    <div class="owl-carousel owl-theme banner_2_slider">
                        <!-- Banner 2 Slider Item -->
                        <div class="owl-item">
                            <div class="banner_2_item">
                                <div class="container fill_height">
                                    <div class="row fill_height">
                                        <div class="col-lg-4 col-md-6 fill_height">
                                            <div class="banner_2_content">
                                                <div class="banner_2_category">Laptops</div>
                                                <div class="banner_2_title">MacBook Air 13</div>
                                                <div class="banner_2_text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas fermentum laoreet.</div>
                                                <div class="rating_r rating_r_4 banner_2_rating"><i></i><i></i><i></i><i></i><i></i></div>
                                                <div class="button banner_2_button"><a href="#">Explore</a></div>
                                            </div>
                                        </div>
                                        <div class="col-lg-8 col-md-6 fill_height">
                                            <div class="banner_2_image_container">
                                                <div class="banner_2_image"><img src="images/banner_2_product.png" alt=""></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>			
                            </div>
                        </div>
                        <!-- Banner 2 Slider Item -->
                        <div class="owl-item">
                            <div class="banner_2_item">
                                <div class="container fill_height">
                                    <div class="row fill_height">
                                        <div class="col-lg-4 col-md-6 fill_height">
                                            <div class="banner_2_content">
                                                <div class="banner_2_category">Laptops</div>
                                                <div class="banner_2_title">MacBook Air 13</div>
                                                <div class="banner_2_text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas fermentum laoreet.</div>
                                                <div class="rating_r rating_r_4 banner_2_rating"><i></i><i></i><i></i><i></i><i></i></div>
                                                <div class="button banner_2_button"><a href="#">Explore</a></div>
                                            </div>
                                        </div>
                                        <div class="col-lg-8 col-md-6 fill_height">
                                            <div class="banner_2_image_container">
                                                <div class="banner_2_image"><img src="images/banner_2_product.png" alt=""></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>			
                            </div>
                        </div>
                        <!-- Banner 2 Slider Item -->
                        <div class="owl-item">
                            <div class="banner_2_item">
                                <div class="container fill_height">
                                    <div class="row fill_height">
                                        <div class="col-lg-4 col-md-6 fill_height">
                                            <div class="banner_2_content">
                                                <div class="banner_2_category">Laptops</div>
                                                <div class="banner_2_title">MacBook Air 13</div>
                                                <div class="banner_2_text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas fermentum laoreet.</div>
                                                <div class="rating_r rating_r_4 banner_2_rating"><i></i><i></i><i></i><i></i><i></i></div>
                                                <div class="button banner_2_button"><a href="#">Explore</a></div>
                                            </div>
                                        </div>
                                        <div class="col-lg-8 col-md-6 fill_height">
                                            <div class="banner_2_image_container">
                                                <div class="banner_2_image"><img src="images/banner_2_product.png" alt=""></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>			
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Hot New Arrivals -->
            <div class="new_arrivals">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="tabbed_container">
                                <div class="tabs clearfix tabs-right">
                                    <div class="new_arrivals_title"><fmt:message key="PHotNewArrivals"/></div>
                                    <ul class="clearfix">
                                        <li class="active"></li>
                                    </ul>
                                    <div class="tabs_line"><span></span></div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-9" style="z-index:1;">
                                        <!-- Product Panel -->
                                        <div class="product_panel panel active">
                                            <div class="arrivals_slider slider">
                                                <!-- Slider Item -->
                                                <c:forEach var = "ligne" items="${ListeAllProduits}">
                                                    <c:choose>
                                                        <c:when test="${ligne.dateRelease == 2019}"> 
                                                            <div class="arrivals_slider_item">
                                                                <div class="border_active"></div>
                                                                <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                                    <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/${ligne.image}" alt=""></div>
                                                                    <div class="product_content">
                                                                        <div class="product_price">$${ligne.prix}</div>
                                                                        <div class="product_name"><div><a>${ligne.editeur}</a></div></div>
                                                                        <div class="product_name"><div><a href="GererProduit?id=${ligne.codeProduit}">${ligne.produit}</a></div></div>
                                                                        <div class="product_extras">
                                                                            <div class="product_color">
                                                                            </div>
                                                                            <button class="product_cart_button"><fmt:message key="PAddToCart"/></button>
                                                                        </div>
                                                                    </div>
                                                                    <ul class="product_marks">
                                                                        <li class="product_mark product_new">new</li>
                                                                    </ul>
                                                                </div>
                                                            </div>
                                                        </c:when>
                                                    </c:choose>
                                                </c:forEach>
                                            </div>
                                            <div class="arrivals_slider_dots_cover"></div>
                                        </div>
                                        <!-- Product Panel -->
                                        <div class="product_panel panel">
                                            <div class="arrivals_slider slider">
                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_1.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$225</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button"><fmt:message key="PAddToCart"/></button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount">-25%</li>
                                                            <li class="product_mark product_new"><fmt:message key="PNew"/></li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_2.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$379</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button active"><fmt:message key="PAddToCart"/></button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new"><fmt:message key="PNew"/></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_3.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$379</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button"><fmt:message key="PAddToCart"/></button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new"><fmt:message key="PNew"/></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_4.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$225</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button"><fmt:message key="PAddToCart"/></button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new"><fmt:message key="PNew"/></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_5.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$225</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_6.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$379</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_7.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$379</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount">-25%</li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_8.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$225</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_1.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$225</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_2.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$379</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_3.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$379</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_4.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$225</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_5.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$225</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_6.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$379</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_7.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$379</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_8.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$225</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="arrivals_slider_dots_cover"></div>
                                        </div>

                                        <!-- Product Panel -->
                                        <div class="product_panel panel">
                                            <div class="arrivals_slider slider">

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_1.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$225</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount">-25%</li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_2.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$379</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button active">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_3.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$379</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_4.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$225</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_5.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$225</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_6.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$379</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_7.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$379</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount">-25%</li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_8.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$225</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_1.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$225</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_2.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$379</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_3.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$379</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_4.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$225</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_5.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$225</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_6.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$379</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_7.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$379</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>

                                                <!-- Slider Item -->
                                                <div class="arrivals_slider_item">
                                                    <div class="border_active"></div>
                                                    <div class="product_item is_new d-flex flex-column align-items-center justify-content-center text-center">
                                                        <div class="product_image d-flex flex-column align-items-center justify-content-center"><img src="images/new_8.jpg" alt=""></div>
                                                        <div class="product_content">
                                                            <div class="product_price">$225</div>
                                                            <div class="product_name"><div><a href="product.html">Huawei MediaPad...</a></div></div>
                                                            <div class="product_extras">
                                                                <div class="product_color">
                                                                    <input type="radio" checked name="product_color" style="background:#b19c83">
                                                                    <input type="radio" name="product_color" style="background:#000000">
                                                                    <input type="radio" name="product_color" style="background:#999999">
                                                                </div>
                                                                <button class="product_cart_button">Add to Cart</button>
                                                            </div>
                                                        </div>
                                                        <div class="product_fav"><i class="fas fa-heart"></i></div>
                                                        <ul class="product_marks">
                                                            <li class="product_mark product_discount"></li>
                                                            <li class="product_mark product_new">new</li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="arrivals_slider_dots_cover"></div>
                                        </div>

                                    </div>

                                    <div class="col-lg-3">
                                        <div class="arrivals_single clearfix">
                                            <div class="d-flex flex-column align-items-center justify-content-center">
                                                <div class="arrivals_single_image"><img src="images/new_single.png" alt=""></div>
                                                <div class="arrivals_single_content">
                                                    <div class="arrivals_single_category"><a href="#">Smartphones</a></div>
                                                    <div class="arrivals_single_name_container clearfix">
                                                        <div class="arrivals_single_name"><a href="#">LUNA Smartphone</a></div>
                                                        <div class="arrivals_single_price text-right">$379</div>
                                                    </div>
                                                    <div class="rating_r rating_r_4 arrivals_single_rating"><i></i><i></i><i></i><i></i><i></i></div>
                                                    <form action="#"><button class="arrivals_single_button">Add to Cart</button></form>
                                                </div>
                                                <div class="arrivals_single_fav product_fav active"><i class="fas fa-heart"></i></div>
                                                <ul class="arrivals_single_marks product_marks">
                                                    <li class="arrivals_single_mark product_mark product_new">new</li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>

                                </div>

                            </div>
                        </div>
                    </div>
                </div>		
            </div>
            <!-- Best Sellers -->
            <!-- Trends -->
            <div class="trends">
                <div class="trends_background" style="background-image:url(images/trends_background.jpg)"></div>
                <div class="trends_overlay"></div>
                <div class="container">
                    <div class="row">
                        <!-- Trends Content -->
                        <div class="col-lg-3">
                            <div class="trends_container">
                                <h2 class="trends_title">Trends 2019</h2>
                                <div class="trends_text"><p>Lorem ipsum dolor sit amet, consectetur adipiscing Donec et.</p></div>
                                <div class="trends_slider_nav">
                                    <div class="trends_prev trends_nav"><i class="fas fa-angle-left ml-auto"></i></div>
                                    <div class="trends_next trends_nav"><i class="fas fa-angle-right ml-auto"></i></div>
                                </div>
                            </div>
                        </div>
                        <!-- Trends Slider -->
                        <div class="col-lg-9">
                            <div class="trends_slider_container">
                                <!-- Trends Slider -->
                                <div class="owl-carousel owl-theme trends_slider">
                                    <!-- Trends Slider Item -->
                                    <div class="owl-item">
                                        <div class="trends_item is_new">
                                            <div class="trends_image d-flex flex-column align-items-center justify-content-center"><img src="images/trends_1.jpg" alt=""></div>
                                            <div class="trends_content">
                                                <div class="trends_category"><a href="#">Smartphones</a></div>
                                                <div class="trends_info clearfix">
                                                    <div class="trends_name"><a href="product.html">Jump White</a></div>
                                                    <div class="trends_price">$379</div>
                                                </div>
                                            </div>
                                            <ul class="trends_marks">
                                                <li class="trends_mark trends_discount">-25%</li>
                                                <li class="trends_mark trends_new">new</li>
                                            </ul>
                                            <div class="trends_fav"><i class="fas fa-heart"></i></div>
                                        </div>
                                    </div>
                                    <!-- Trends Slider Item -->
                                    <div class="owl-item">
                                        <div class="trends_item">
                                            <div class="trends_image d-flex flex-column align-items-center justify-content-center"><img src="images/trends_2.jpg" alt=""></div>
                                            <div class="trends_content">
                                                <div class="trends_category"><a href="#">Smartphones</a></div>
                                                <div class="trends_info clearfix">
                                                    <div class="trends_name"><a href="product.html">Samsung Charm...</a></div>
                                                    <div class="trends_price">$379</div>
                                                </div>
                                            </div>
                                            <ul class="trends_marks">
                                                <li class="trends_mark trends_discount">-25%</li>
                                                <li class="trends_mark trends_new">new</li>
                                            </ul>
                                            <div class="trends_fav"><i class="fas fa-heart"></i></div>
                                        </div>
                                    </div>
                                    <!-- Trends Slider Item -->
                                    <div class="owl-item">
                                        <div class="trends_item is_new">
                                            <div class="trends_image d-flex flex-column align-items-center justify-content-center"><img src="images/trends_3.jpg" alt=""></div>
                                            <div class="trends_content">
                                                <div class="trends_category"><a href="#">Smartphones</a></div>
                                                <div class="trends_info clearfix">
                                                    <div class="trends_name"><a href="product.html">DJI Phantom 3...</a></div>
                                                    <div class="trends_price">$379</div>
                                                </div>
                                            </div>
                                            <ul class="trends_marks">
                                                <li class="trends_mark trends_discount">-25%</li>
                                                <li class="trends_mark trends_new">new</li>
                                            </ul>
                                            <div class="trends_fav"><i class="fas fa-heart"></i></div>
                                        </div>
                                    </div>
                                    <!-- Trends Slider Item -->
                                    <div class="owl-item">
                                        <div class="trends_item is_new">
                                            <div class="trends_image d-flex flex-column align-items-center justify-content-center"><img src="images/trends_1.jpg" alt=""></div>
                                            <div class="trends_content">
                                                <div class="trends_category"><a href="#">Smartphones</a></div>
                                                <div class="trends_info clearfix">
                                                    <div class="trends_name"><a href="product.html">Jump White</a></div>
                                                    <div class="trends_price">$379</div>
                                                </div>
                                            </div>
                                            <ul class="trends_marks">
                                                <li class="trends_mark trends_discount">-25%</li>
                                                <li class="trends_mark trends_new">new</li>
                                            </ul>
                                            <div class="trends_fav"><i class="fas fa-heart"></i></div>
                                        </div>
                                    </div>
                                    <!-- Trends Slider Item -->
                                    <div class="owl-item">
                                        <div class="trends_item">
                                            <div class="trends_image d-flex flex-column align-items-center justify-content-center"><img src="images/trends_2.jpg" alt=""></div>
                                            <div class="trends_content">
                                                <div class="trends_category"><a href="#">Smartphones</a></div>
                                                <div class="trends_info clearfix">
                                                    <div class="trends_name"><a href="product.html">Jump White</a></div>
                                                    <div class="trends_price">$379</div>
                                                </div>
                                            </div>
                                            <ul class="trends_marks">
                                                <li class="trends_mark trends_discount">-25%</li>
                                                <li class="trends_mark trends_new">new</li>
                                            </ul>
                                            <div class="trends_fav"><i class="fas fa-heart"></i></div>
                                        </div>
                                    </div>
                                    <!-- Trends Slider Item -->
                                    <div class="owl-item">
                                        <div class="trends_item is_new">
                                            <div class="trends_image d-flex flex-column align-items-center justify-content-center"><img src="images/trends_3.jpg" alt=""></div>
                                            <div class="trends_content">
                                                <div class="trends_category"><a href="#">Smartphones</a></div>
                                                <div class="trends_info clearfix">
                                                    <div class="trends_name"><a href="product.html">Jump White</a></div>
                                                    <div class="trends_price">$379</div>
                                                </div>
                                            </div>
                                            <ul class="trends_marks">
                                                <li class="trends_mark trends_discount">-25%</li>
                                                <li class="trends_mark trends_new">new</li>
                                            </ul>
                                            <div class="trends_fav"><i class="fas fa-heart"></i></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Reviews -->
            <!-- Recently Viewed -->
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
                                <!-- Recently Viewed Slider -->
                                <div class="row owl-carousel owl-theme viewed_slider" id="des">
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
            <script src="js.js"></script>
            <script src="js/newsletter.js"></script>
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