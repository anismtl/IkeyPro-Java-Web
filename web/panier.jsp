<%-- 
    Document   : panier
    Created on : 2019-04-28, 16:14:19
    Author     : Anis
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib  uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
                                <div class="cart_items">
                                    <ul class="cart_list">
                                        <li class="cart_item clearfix">
                                      <div class="cart_item_image"></div>
                                            <div class="cart_item_info d-flex flex-md-row flex-column justify-content-between">
                                                <div class="cart_item_name cart_info_col">
                                                    <div class="cart_item_title">Name</div>
                                                
                                                </div>
                                             
                                                <div class="cart_item_quantity cart_info_col">
                                                    <div class="cart_item_title">Quantity</div>
                                                   
                                                </div>
                                                <div class="cart_item_price cart_info_col">
                                                    <div class="cart_item_title">Price</div>
                                                 
                                                </div>
                                                <div class="cart_item_total cart_info_col">
                                                    <div class="cart_item_title">Total</div>
                                                  
                                                </div>
                                                    <div class="cart_item_Action cart_info_col">
                                                    <div class="cart_item_title">Action</div>
                                                  
                                                </div>
                                            </div>  
                                        </li>
                                         <c:forEach var = "ligne" items="${panier}">
                                        <li class="cart_item clearfix">
                                          <div class="cart_item_image"><img src="images/${ligne.image}" alt=""></div>
                                            <div class="cart_item_info d-flex flex-md-row flex-column justify-content-between">
                                                <div class="cart_item_name cart_info_col">
                                                  
                                                    <div class="cart_item_text"><a href="GererProduit?id=${ligne.codeProduit}">${ligne.produit}</a></div>
                                                </div>
                                       
                                                <div class="cart_item_quantity cart_info_col">
                                                  
                                                    <div class="cart_item_text"> ${ligne.qte}</div>
                                                </div>
                                                <div class="cart_item_price cart_info_col">
                                                 
                                                    <div class="cart_item_text">${ligne.prix}</div>
                                                </div>
                                                <div class="cart_item_total cart_info_col">
                                                  
                                                    <div class="cart_item_text">$${ligne.qte * ligne.prix} </div>
                                                </div>
                                                   <div class="cart_item_total cart_info_col">
                                                  
                                                    <div class="cart_item_text">        <form name="deleteForm"
                          action="Panier"
                          method="POST">
                       
                        <button type="submit" value="Delete" type="button" class="btn btn-outline-info">Delete</button>

                        <input type="hidden" name= "delindex" value='${panier.indexOf(ligne)}'>

                        <input type="hidden" name="action" value="DELETE">
                    </form></div>
                                                </div>
                                            </div>
                                        </li>
                                        </c:forEach>
                                    </ul>
                                </div>

                                <!-- Order Total -->
                                <div class="order_total">
                                    <div class="order_total_content text-md-right">
                                        <div class="order_total_title">Order Total:</div>
                                        <div class="order_total_amount">$${total}</div>
                                    </div>
                                </div>

                                <div class="cart_buttons">
                                    <a type="submit" class="button cart_button_clear" href="ListeProduits?cat=2">Magasiner</a>
                                    <button type="button" class="button cart_button_checkout">Add to Cart</button>
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