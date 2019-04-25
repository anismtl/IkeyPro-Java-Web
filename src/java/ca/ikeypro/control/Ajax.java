/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.ikeypro.control;

import ca.ikeypro.Utilitaire.DataManager;
import ca.ikeypro.model.Categorie;
import ca.ikeypro.model.DataManagerCategorie;
import ca.ikeypro.model.DataManagerProduit;
import ca.ikeypro.model.Produit;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anis
 */
public class Ajax extends HttpServlet {
DataManager dataManager;
    /**
     * DataManager dataManager;
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
            /* TODO output your page here. You may use following sample code. */

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
         String action = request.getParameter("action");
         if (action.equals("C")){
         //List<Produit> ListeAllProduits = DataManagerProduit.getListeDesProduitsByCat("2");
        List<Categorie> ListeCat = DataManagerCategorie.getListeCetegorie();
          Gson gson = new Gson();
          String json = gson.toJson(ListeCat);
           request.setAttribute("categ", json);
            response.setContentType("application/json");
             response.setCharacterEncoding("UTF-8");
             PrintWriter out = response.getWriter();
             out.print(json);
             out.flush();
         } else if (action.equals("P"))
         {
            List<Produit> ListeAllProduits = DataManagerProduit.getListeMostViewProduits();
                 Gson gson = new Gson();
          String json = gson.toJson(ListeAllProduits);
           request.setAttribute("Categ", json);
            response.setContentType("application/json");
             response.setCharacterEncoding("UTF-8");
             PrintWriter out = response.getWriter();
             out.print(json);
             out.flush();
         }
        
        
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
