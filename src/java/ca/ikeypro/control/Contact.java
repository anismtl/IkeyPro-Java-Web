/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.ikeypro.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ca.ikeypro.Utilitaire.MailManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Anis
 */
public class Contact extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String timeStamp = new SimpleDateFormat("yyyy/MM/dd à HH:mm:ss").format(new Date());
            String from = request.getParameter("from");
            String email = request.getParameter("email");
            String telephone = request.getParameter("telephone");
            String mess = request.getParameter("message");

            String sujet = (" Message envoyé par : " + from);
            String Message = ("<b>Message Envoyé par : </b>" + from);
            Message += ("\n <br/><b>Le : </b>" + timeStamp);
            Message += ("\n <br/><b>Email : </b>" + email);
            Message += ("\n <br/><b>Téléphone : </b>" + telephone);
            Message += ("\n <br/>------------------------------------------------");
            Message += ("\n <br/><b>Message:</b><br/>" + mess);

            String Message2 = ("Bonjour " + from + ",");
            Message2 += ("<br/>Nous avons bien reçu votre requête et allons vous répondre dans les plus brefs délais.");
            Message2 += ("<br/>Cordialement, ");
            Message2 += ("<br/>IkeyPro.ca ");
            String confirmation = "Mail envoyé !";
            try {
                /* TODO output your page here. You may use following sample code. */
                MailManager.SendEmail("aboutekadjiret@yahoo.fr", sujet, Message);
                MailManager.SendEmail(email, " Confirmation", Message2);
                request.setAttribute("confirmation", confirmation);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/contact.jsp");
                dispatcher.forward(request, response);
            } catch (MessagingException ex) {
                Logger.getLogger(Init.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
