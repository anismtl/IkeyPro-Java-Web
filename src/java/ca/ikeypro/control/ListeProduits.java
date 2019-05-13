package ca.ikeypro.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ca.ikeypro.DAO.Produit;
import ca.ikeypro.DAO.ProduitDAO;

/**
 * @author Anis
 */
public class ListeProduits extends HttpServlet {

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
            String action = request.getParameter("action");
            switch (action) {
                case "categorie":
                    {
                        String categorie = request.getParameter("cat");
                        List<Produit> ListeProd = ProduitDAO.getListeDesProduitsByCat(categorie);
                        session.setAttribute("ListProdui", ListeProd);
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/shop.jsp");
                        dispatcher.forward(request, response);
                        break;
                    }
                case "editeur":
                    {
                        String editeur = request.getParameter("edit");
                        List<Produit> ListeProdEditeur = ProduitDAO.getListeDesProduitsByEditeur(editeur);
                        session.setAttribute("ListeProdEditeur", ListeProdEditeur);
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/editeurs.jsp");
                        dispatcher.forward(request, response);
                        break;
                    }
                case "edition":
                    {
                        String edition = request.getParameter("edition");
                        List<Produit> ListeProdEdition = ProduitDAO.getListeDesProduitsByEdition(edition);
                        session.setAttribute("ListeProdEdition", ListeProdEdition);
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/edition.jsp");
                        dispatcher.forward(request, response);
                        break;
                    }
                case "lastDispo":
                    {
                        List<Produit> ListeProdLastDispo = ProduitDAO.getListeDesProduitsByDispo();
                        session.setAttribute("ListeProdLastDispo", ListeProdLastDispo);
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/lastDispo.jsp");
                        dispatcher.forward(request, response);
                        break;
                    }
                default:
                    break;
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
