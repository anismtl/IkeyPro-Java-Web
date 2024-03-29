<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib  uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${not empty sessionScope.lang ? sessionScope.lang : lang}" />
<fmt:bundle basename="app">
    <footer class="footer">
        <div class="container">
            <div class="row">

                <div class="col-lg-3 footer_col">
                    <div class="footer_column footer_contact">
                        <div class="logo_container">
                            <div class="logo"><a href="index.jsp">IkeyPro</a></div>
                        </div>
                        <div class="footer_title"><fmt:message key="PGotQuestion"/></div>
                        <div class="footer_phone">+1 514 000 0000</div>
                        <div class="footer_contact_text">
                            <p>17 Princess Road, London</p>
                            <p>Montreal NW18JR, QC</p>
                        </div>
                        <div class="footer_social">
                            <ul>
                                <li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
                                <li><a href="#"><i class="fab fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fab fa-youtube"></i></a></li>
                                <li><a href="#"><i class="fab fa-google"></i></a></li>
                                <li><a href="#"><i class="fab fa-vimeo-v"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="col-lg-2 offset-lg-2">
                    <div class="footer_column">
                        <div class="footer_title"><fmt:message key="PFindItFast"/></div>
                        <ul class="footer_list">
                                      <c:forEach var = "ligne" items="${ListCat}">
                                                        <li><a class="clc" href="ListeProduits?action=categorie&cat=${ligne.idCategorie}">${ligne.categorie}</a></li>
                                      </c:forEach> 
               
                        </ul>
                    </div>
                        
                        
                </div>

                <div class="col-lg-2">
                    <div class="footer_column">
                        <div class="footer_title"><fmt:message key="PFeaturedBrands"/></div>
                        <ul class="footer_list">
                                    <c:forEach var = "ligne" items="${ListeEditeurs}">
                                                        <li><a class="clc" href="ListeProduits?action=editeur&edit=${ligne.id_Editeur}">${ligne.editeur}</a></li>
                                      </c:forEach> 
                        </ul>
                    </div>
                </div>

                <div class="col-lg-2">
                    <div class="footer_column">
                        <div class="footer_title"><fmt:message key="PCustomerCare"/></div>
                        <ul class="footer_list">
                            <li><a href="#"><fmt:message key="PMyAccount"/></a></li>
                            <li><a href="#">Order Tracking</a></li>
                            <li><a href="#">Wish List</a></li>
                            <li><a href="#">Customer Services</a></li>
                            <li><a href="#">Returns / Exchange</a></li>
                            <li><a href="#">FAQs</a></li>
                            <li><a href="#">Product Support</a></li>
                        </ul>
                    </div>
                </div>

            </div>
        </div>
    </footer>

    <!-- Copyright -->

    <div class="copyright">
        <div class="container">
            <div class="row">
                <div class="col">

                    <div class="copyright_container d-flex flex-sm-row flex-column align-items-center justify-content-start">
                        <div class="copyright_content"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true" style="color:red"></i> by <a href="https://www.linkedin.com/in/anis-boutekadjiret/" target="_blank">Anis Boutekadjiret </a>, <a href="https://www.linkedin.com/in/judithadame/" target="_blank">Judith Adame-Aragon </a> and <a href="https://colorlib.com" target="_blank">Colorlib</a>.
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        </div>
                        <div class="logos ml-sm-auto">
                            <ul class="logos_list">
                                <li><a href="#"><img src="images/logos_1.png" alt=""></a></li>
                                <li><a href="#"><img src="images/logos_2.png" alt=""></a></li>
                                <li><a href="#"><img src="images/logos_3.png" alt=""></a></li>
                                <li><a href="#"><img src="images/logos_4.png" alt=""></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</fmt:bundle>   
