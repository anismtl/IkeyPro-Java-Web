<%-- 
    Document   : newsletter
    Created on : 2019-04-20, 15:52:19
    Author     : Anis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib  uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:bundle basename="app">
    <div class="newsletter">
        <div class="container">
            <div class="row">
                <div class="col">
                   
                    <div class="newsletter_container d-flex flex-lg-row flex-column align-items-lg-center align-items-center justify-content-lg-start justify-content-center">
                        <div class="newsletter_title_container">
                            
                            <div class="newsletter_icon"><img src="images/send.png" alt=""></div>
                            <div class="newsletter_title">Sign up for Newsletter</div>
                            <div class="newsletter_text"><p>...and receive %20 coupon for first shopping.</p></div>
                        </div>
                        
                        <div class="newsletter_content clearfix">
                            
                            <form action="#" name="news" class="newsletter_form ">
                                <input id="email" name="email" type="email" class="newsletter_input" required="required" placeholder="Enter your email address">
                                <input type="button" class="newsletter_button" onclick="inscription()" value="<fmt:message key="PSubscribe"/>"/>
                            </form>
                                <div class="newsletter_unsubscribe_link"><a color="blue" onclick="desabonner();"><fmt:message key="PUnsubscribe"/></a></div>
                               
                               
                        </div>
                               
                    </div>
                                <div align="center"> <span id="resultat" align="center"> </span></div>  
                               
                </div>
            </div>
        </div>
    </div>
</fmt:bundle>
