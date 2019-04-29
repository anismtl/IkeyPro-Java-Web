package ca.ikeypro.control;

import ca.ikeypro.Utilitaire.DataManager;
import ca.ikeypro.DAO.Categorie;
import ca.ikeypro.DAO.CategorieDAO;
import ca.ikeypro.DAO.NewsletterDAO;
import ca.ikeypro.DAO.Produit;
import ca.ikeypro.DAO.ProduitDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Anis
 */
public class Ajax extends HttpServlet {

    /**
     * DataManager dataManager; Processes requests for both HTTP
     * <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        response.setContentType("application/json");
        if (action.equals("N")) {
            String email = request.getParameter("courriel");
            String resultat = NewsletterDAO.Inscription(email);

            Gson gson = new Gson();

            String json = gson.toJson(resultat);

            System.out.println("Email:"+email);
            System.out.println("Resultat:"+resultat);
            out.print(json);
            out.flush();
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
        if (action.equals("C")) {
            List<Categorie> ListeCat = (List<Categorie>) request.getServletContext().getAttribute("ListCat");
            Gson gson = new Gson();
            String json = gson.toJson(ListeCat);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(json);
            out.flush();
        } else if (action.equals("P")) {
            List<Produit> ListeMostViewProduits = (List<Produit>) request.getSession().getAttribute("ListeMostViewProduits");
            Gson gson = new Gson();
            String json = gson.toJson(ListeMostViewProduits);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(json);
            out.flush();
        } else if (action.equals("N")) {
            Object courriel = request.getAttribute("courriel");
            //    List<Categorie> ListeCat = (List<Categorie>) request.getServletContext().getAttribute("ListCat");
            Gson gson = new Gson();
            String json = gson.toJson(courriel);
            System.out.println(json);
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
