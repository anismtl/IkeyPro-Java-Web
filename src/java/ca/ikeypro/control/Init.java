package ca.ikeypro.control;

import ca.ikeypro.DAO.*;
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
import ca.ikeypro.DAO.Categorie;
import ca.ikeypro.DAO.Produit;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Anis
 */
public class Init extends HttpServlet {
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

            Locale locale = Locale.getDefault();

            ResourceBundle bundle = ResourceBundle.getBundle("app", locale);

            session.setAttribute("bundle", bundle);

        //    List<Categorie> ListeCategories = CategorieDAO.getListeCategorie();

            List<Produit> ListeAllProduits = ProduitDAO.getListeDesProduits();
               request.getServletContext().setAttribute("ListeAllProduits", ListeAllProduits);

            //List<Produit> ListeMostViewProduits = ProduitDAO.getListeMostViewProduits();

         

          //  request.getServletContext().setAttribute("ListeMostViewProduits", ListeMostViewProduits);

         //   request.getServletContext().setAttribute("ListCat", ListeCategories);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/iKeyPro.jsp");

            dispatcher.forward(request, response);
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
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

//                       List<Produit> ListeAllProduits = ProduitDAO.getListeDesProduits();
//          Gson gson = new Gson();
//          String json = gson.toJson(ListeAllProduits);
//           request.setAttribute("cat", json);
//           response.setContentType("application/json");
//             response.setCharacterEncoding("UTF-8");
//             PrintWriter out = response.getWriter();
//             out.print(json);
//             out.flush();
//        
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
