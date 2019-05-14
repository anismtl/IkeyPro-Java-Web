package ca.ikeypro.control;

import ca.ikeypro.DAO.CategorieDAO;
import ca.ikeypro.DAO.EditeurDAO;
import ca.ikeypro.DAO.EditionDAO;
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
                case "categorie": {
                    String categorie = request.getParameter("cat");
                    List<Produit> ListeProd = ProduitDAO.getListeDesProduitsByCat(categorie);
                    String titre =CategorieDAO.getCategorie(categorie);
                    System.out.println("titre1:"+titre);
                    session.setAttribute("ListePro", ListeProd);
                    request.setAttribute("titre", titre);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/shop.jsp");
                    dispatcher.forward(request, response);
                    break;
                }
                case "editeur": {
                    String editeur = request.getParameter("edit");
                    List<Produit> ListeProdEditeur = ProduitDAO.getListeDesProduitsByEditeur(editeur);
                    String titre=EditeurDAO.getEditeur(editeur);
                    session.setAttribute("ListePro", ListeProdEditeur);
                     request.setAttribute("titre", titre);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/shop.jsp");
                    dispatcher.forward(request, response);
                    break;
                }
                case "edition": {
                    String edition = request.getParameter("edition");
                    List<Produit> ListeProdEdition = ProduitDAO.getListeDesProduitsByEdition(edition);
                    String titre=EditionDAO.getEdition(edition);
                    request.setAttribute("titre", titre);
                    session.setAttribute("ListePro", ListeProdEdition);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/shop.jsp");
                    dispatcher.forward(request, response);
                    break;
                }

                case "recherche": {
                    String edition2 = request.getParameter("edition2");
                    String editeur2 = request.getParameter("editeur2");
                    String cat = request.getParameter("cat");
                    List<Produit> ListeProdEditeur = ProduitDAO.rechercheProduits(cat, editeur2, edition2);
                    request.setAttribute("titre", "Recherche");
                    session.setAttribute("ListePro", ListeProdEditeur);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/shop.jsp");
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
