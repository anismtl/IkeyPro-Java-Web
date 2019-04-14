/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.ikeypro.control;

import ca.ikeypro.Utilitaire.DataManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ca.ikeypro.model.Categorie;
import ca.ikeypro.model.DataManagerCategorie;
import ca.ikeypro.model.DataManagerProduit;
import ca.ikeypro.model.Produit;

/**
 *
 * @author Anis
 */
public class Init extends HttpServlet {
   DataManager dataManager;

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

            HttpSession session = request.getSession();
List<Categorie> ListeCategories = dataManager.getListeCategorie();
//session.setAttribute("ListCat", ListeCategories);
     List<Produit> ListeAllProduits = DataManagerProduit.getListeDesProduits();
   request.getServletContext().setAttribute("ListeAllProduits", ListeAllProduits);
 request.getServletContext().setAttribute("ListCat", ListeCategories);
       RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/iKeyPro.jsp");
       dispatcher.forward(request, response); 
        }
    }
                      @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        dataManager = new DataManager();
        dataManager.setDbURL(config.getInitParameter("dbURL"));
        dataManager.setDbUserName(config.getInitParameter("dbUserName"));
        dataManager.setDbPassword(config.getInitParameter("dbPassword"));
        try{
           Class.forName(config.getInitParameter("jdbcDriver"));
        }
        catch (Exception ex)
        {
            System.out.println("Initialize connector string");
            ex.printStackTrace();
        }}

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
