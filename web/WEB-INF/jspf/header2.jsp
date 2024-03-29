<%-- 
    Document   : header2
    Created on : 2019-04-11, 04:48:48
    Author     : Anis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${not empty sessionScope.lang ? sessionScope.lang : sessionScope.langD}" />
<fmt:bundle basename="app">
    <header class="header">
        <!-- Top Bar -->
        <div class="top_bar">
            <div class="container">
                <div class="row">
                    <div class="col d-flex flex-row">
                        <div class="top_bar_contact_item"><div class="top_bar_icon"><img src="images/phone.png" alt=""></div>+514 000 0000</div>
                        <div class="top_bar_contact_item"><div class="top_bar_icon"><img src="images/mail.png" alt=""></div><a href="mailto:ikeyprofessionnel@gmail.com">ikeyprofessionnel@gmail.com</a></div>
                        <div class="top_bar_content ml-auto">
                            <div class="top_bar_menu">
                                <ul class="standard_dropdown top_bar_dropdown">
                                    <c:if test="${sessionScope.lang == 'fr'}">
                                    </c:if>
                                    <c:if test="${not empty sessionScope.lang ? sessionScope.lang=='fr' : sessionScope.langD =='fr'}">
                                        <li>
                                            <a href="#"><fmt:message key="PFrancaisLangue"/><i class="fas fa-chevron-down"></i></a>
                                            <ul>
                                                <li><a href="#" onclick="changeLangue('es');"><fmt:message key="PEspagnolLangue"/></a></li>
                                                <li><a href="#" onclick="changeLangue('en');"><fmt:message key="PEnglishLangue"/></a></li>   
                                            </ul>
                                        </li>
                                    </c:if>
                                    <c:if test="${not empty sessionScope.lang ? sessionScope.lang=='es' : sessionScope.langD =='es'}">
                                        <li>
                                            <a href="#"><fmt:message key="PEspagnolLangue"/><i class="fas fa-chevron-down"></i></a>
                                            <ul>
                                                <li><a href="#" id="llang" onclick="changeLangue('fr');"><fmt:message key="PFrancaisLangue"/></a></li>
                                                <li><a href="#" id="llang" onclick="changeLangue('en');"><fmt:message key="PEnglishLangue"/></a></li>   
                                            </ul>
                                        </li>
                                    </c:if> 
                                    <c:if test="${not empty sessionScope.lang ? sessionScope.lang=='en' : sessionScope.langD =='en'}">
                                        <li>
                                            <a href="#"><fmt:message key="PEnglishLangue"/><i class="fas fa-chevron-down"></i></a>
                                            <ul>
                                                <li><a href="#" id="llang" onclick="changeLangue('fr');"><fmt:message key="PFrancaisLangue"/></a></li>
                                                <li><a href="#" id="llang" onclick="changeLangue('es');"><fmt:message key="PEspagnolLangue"/></a></li>   
                                            </ul>
                                        </li>
                                    </c:if>     
                                </ul>
                            </div>
                            <div class="top_bar_user">
                                <div class="user_icon"><img src="images/user.svg" alt=""></div>
                                <c:if test="${empty sessionScope.client}">
                                    <div> <a href="Affichage?action=register"><fmt:message key="PRegister"/></a></div>
                                    <div><a href="Affichage?action=login"><fmt:message key="PSignIn"/></a></div>
                                </c:if>
                                <c:if test="${not empty sessionScope.client}">
                                    <div> <a href="monCompte.jsp"><fmt:message key="PWelcome"/> "${sessionScope.client.prenomClient}" <fmt:message key="PYourCompte"/></a></div>
                                    <div><a href="LogOut"><fmt:message key="PSignOut"/></a></div>
                                </c:if>
                            </div>                            
                        </div>
                    </div>
                </div>
            </div>		
        </div>
        <!-- Header Main -->
        <div class="header_main">
            <div class="container">
                <div class="row">
                    <!-- Logo -->
                    <div class="col-lg-2 col-sm-3 col-3 order-1">
                        <div class="logo_container">
                            <div class="logo"><a href="index.jsp">IkeyPro</a></div>
                        </div>
                    </div>
                    <!-- Search -->
                    <div class="col-lg-6 col-12 order-lg-2 order-3 text-lg-left text-right">
                        <div class="header_search">
                            <div class="header_search_content">
                                <div class="header_search_form_container">
                                    <form action="Recherche" class="header_search_form clearfix">
                                        <input type="search" name="rechecheStr" required="required" class="header_search_input" placeholder="<fmt:message key="PSearchProducts"/>">
                                        <div class="custom_dropdown">
                                            <div class="custom_dropdown_list">
                                                <span class="custom_dropdown_placeholder clc"><fmt:message key="PRechecheParTout"/></span>
                                               
                                                <ul class="custom_list clc">
                                                </ul>
                                            </div>
                                        </div>
                                        <button type="submit" class="header_search_button trans_300" value="Submit"><img src="images/search.png" alt=""></button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Wishlist -->
                    <div class="col-lg-4 col-9 order-lg-3 order-2 text-lg-left text-right">
                        <div class="wishlist_cart d-flex flex-row align-items-center justify-content-end">
                            <div class="wishlist d-flex flex-row align-items-center justify-content-end">
                            </div>
                            <!-- Cart -->
                            <div class="cart">
                                <div class="cart_container d-flex flex-row align-items-center justify-content-end">
                                    <div class="cart_icon">
                                        <img src="images/cart.png" alt="">
                                        <div class="cart_count"><span>       
                                                <c:if test="${empty panier}">0</c:if>
                                                <c:if test="${!empty panier}">${panier.size()}</c:if>
                                                </span>
                                            </div>
                                        </div>
                                        <div class="cart_content">
                                            <div class="cart_text"><a href="<c:if test="${empty panier}">#</c:if>
                                                                  <c:if test="${!empty panier}">Panier?action=AFFICHER</c:if>"><fmt:message key="PCart"/></a></div>
                                        <div class="cart_price"> <c:if test="${empty total}">0$</c:if>
                                            <c:if test="${!empty total}">${total}$</c:if>   
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Main Navigation -->
                <nav class="main_nav">
                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <div class="main_nav_content d-flex flex-row">
                                    <!-- Categories Menu -->
                                    <div class="cat_menu_container">
                                        <div class="cat_menu_title d-flex flex-row align-items-center justify-content-start">
                                            <div class="cat_burger"><span></span><span></span><span></span></div>
                                            <div class="cat_menu_text"><fmt:message key="Pcategories"/></div>
                                    </div>
                                    <ul class="cat_menu">
                                        <c:forEach var = "ligne" items="${ListCat}">
                                            <li><a href="ListeProduits?action=categorie&cat=${ligne.idCategorie}"> ${ligne.categorie} <i class="fas fa-chevron-right"></i></a></li>
                                                </c:forEach>
                                    </ul>
                                </div>
                                <!-- Main Nav Menu -->
                                <div class="main_nav_menu ml-auto">
                                    <ul class="standard_dropdown main_nav_dropdown">
                                        <li><a href="index.jsp"><fmt:message key="PHome"/><i class="fas fa-chevron-down"></i></a></li>
                                        <li class="hassubs">
                                            <a href="#"><fmt:message key="PLastChanse"/><i class="fas fa-chevron-down"></i></a>
                                            <ul>
                                                <c:forEach var = "ligne" items="${ListeLastDispo}">
                                                    <li><a href="GererProduit?id=${ligne.codeProduit}">${ligne.produit}<i class="fas fa-chevron-down"></i></a></li>
                                                </c:forEach>
                                            </ul>
                                        </li>                                        
                                        <li class="hassubs">
                                            <a href="#"><fmt:message key="PEdition"/><i class="fas fa-chevron-down"></i></a>
                                            <ul>
                                                <c:forEach var = "ligne" items="${ListeEdition}">
                                                    <li><a href="ListeProduits?action=edition&edition=${ligne.id_Edition}">${ligne.edition}<i class="fas fa-chevron-down"></i></a> </li>
                                                </c:forEach>
                                            </ul>
                                        </li>
                                        <li class="hassubs">
                                            <a href="#"><fmt:message key="PFeaturedBrands"/><i class="fas fa-chevron-down"></i></a>
                                            <ul>
                                                <c:forEach var = "ligne" items="${ListeEditeurs}">
                                                <li><a href="ListeProduits?action=editeur&edit=${ligne.id_Editeur}">${ligne.editeur}<i class="fas fa-chevron-down"></i></a> </li>
                                                </c:forEach>
                                            </ul>
                                        </li>
                                        <li><a href="Affichage?action=blog"><fmt:message key="PBlog"/><i class="fas fa-chevron-down"></i></a></li>
                                        <li><a href="Affichage?action=contact"><fmt:message key="PContact"/><i class="fas fa-chevron-down"></i></a></li>
                                    </ul>
                                </div>
                                <!-- Menu Trigger -->
                                <div class="menu_trigger_container ml-auto">
                                    <div class="menu_trigger d-flex flex-row align-items-center justify-content-end">
                                        <div class="menu_burger">
                                            <div class="menu_trigger_text">menu</div>
                                            <div class="cat_burger menu_burger_inner"><span></span><span></span><span></span></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>
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
                                            <li><a href="#"><fmt:message key="PEnglishLangue"/><i class="fa fa-angle-down"></i></a></li>
                                            <li><a href="#"><fmt:message key="PItalianLangue"/><i class="fa fa-angle-down"></i></a></li>
                                            <li><a href="#"><fmt:message key="PSpanishLangue"/><i class="fa fa-angle-down"></i></a></li>
                                            <li><a href="#"><fmt:message key="PMandarinLangue"/><i class="fa fa-angle-down"></i></a></li>
                                        </ul>
                                    </li>
                                    <li class="page_menu_item has-children">
                                        <a href="#"><fmt:message key="PCurrency"/><i class="fa fa-angle-down"></i></a>
                                        <ul class="page_menu_selection">
                                            <li><a href="#">US <fmt:message key="PDollarCurrency"/><i class="fa fa-angle-down"></i></a></li>
                                            <li><a href="#">EUR <fmt:message key="PEuroCurrency"/><i class="fa fa-angle-down"></i></a></li>
                                            <li><a href="#">GBP <fmt:message key="PBritishPoundCurrency"/><i class="fa fa-angle-down"></i></a></li>
                                            <li><a href="#">JPY <fmt:message key="PYuanCurrency"/><i class="fa fa-angle-down"></i></a></li>
                                        </ul>
                                    </li>
                                    <li class="page_menu_item">
                                        <a href="index.jsp"><fmt:message key="PHome"/><i class="fa fa-angle-down"></i></a>
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
                                            <li><a href="#"><fmt:message key="PFeaturedBrands"/><i class="fa fa-angle-down"></i></a></li>
                                            <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                            <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                            <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                        </ul>
                                    </li>
                                    <li class="page_menu_item has-children">
                                        <a href="#"><fmt:message key="PTrendingStyles"/><i class="fa fa-angle-down"></i></a>
                                        <ul class="page_menu_selection">
                                            <li><a href="#"><fmt:message key="PTrendingStyles"/><i class="fa fa-angle-down"></i></a></li>
                                            <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                            <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                            <li><a href="#">Menu Item<i class="fa fa-angle-down"></i></a></li>
                                        </ul>
                                    </li>
                                    <li class="page_menu_item"><a href="blog.jsp"><fmt:message key="PBlog"/><i class="fa fa-angle-down"></i></a></li>
                                    <li class="page_menu_item"><a href="contact.jsp"><fmt:message key="PContact"/><i class="fa fa-angle-down"></i></a></li>
                                </ul>

                                <div class="menu_contact">
                                    <div class="menu_contact_item"><div class="menu_contact_icon"><img src="images/phone_white.png" alt=""></div>+38 068 005 3570</div>
                                    <div class="menu_contact_item"><div class="menu_contact_icon"><img src="images/mail_white.png" alt=""></div><a href="mailto:ikeyprofessionnel@gmail.com">ikeyprofessionnel@gmail.com</a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </header>
</fmt:bundle>