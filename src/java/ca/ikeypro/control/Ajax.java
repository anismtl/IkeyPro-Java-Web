package ca.ikeypro.control;

import ca.ikeypro.DAO.Categorie;
import ca.ikeypro.DAO.NewsletterDAO;
import ca.ikeypro.DAO.Produit;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
     * @throws javax.mail.MessagingException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, MessagingException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        response.setContentType("application/json");
        switch (action) {
            case "Inscription":
                {
                    String email = request.getParameter("courriel");
                    String resultat = NewsletterDAO.Inscription(email);
                    Gson gson = new Gson();
                    String json = gson.toJson(resultat);
                    out.print(json);
                    out.flush();
                    break;
                }
            case "Surpression":
                {
                    String email = request.getParameter("courriel");
                    String resultat = NewsletterDAO.Desabonner(email);
                    System.out.println(resultat);
                    Gson gson = new Gson();
                    String json = gson.toJson(resultat);
                    out.print(json);
                    out.flush();
                    break;
                }
            case "Produits":
                {
                    List<Produit> ListeMostViewProduits = (List<Produit>) request.getServletContext().getAttribute("ListeMostViewProduits");
                    Gson gson = new Gson();
                    String json = gson.toJson(ListeMostViewProduits);
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    out.print(json);
                    out.flush();
                    break;
                }
            case "Categories":
                {
                    List<Categorie> ListeCat = (List<Categorie>) request.getServletContext().getAttribute("ListCat");
                    Gson gson = new Gson();
                    String json = gson.toJson(ListeCat);
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    out.print(json);
                    out.flush();
                    break;
                }
            case "ChangeLangue":
                String langue = request.getParameter("langue");
                if (langue.equals("es")) {
                    System.out.println("langue recu:" + langue);
                    session.removeAttribute("lang");
                    session.setAttribute("lang", "es");
                    Gson gson = new Gson();
                    String json = gson.toJson("ok");
                    out.print(json);
                    out.flush();
                    
                } else if (langue.equals("fr")) {
                    System.out.println("langue recu:" + langue);
                    session.setAttribute("lang", "fr");
                    Gson gson = new Gson();
                    String json = gson.toJson("ok");
                    out.print(json);
                    out.flush();
                    
                } else if (langue.equals("en")) {
                    System.out.println("langue recu:" + langue);
                    session.setAttribute("lang", "en");
                    Gson gson = new Gson();
                    String json = gson.toJson("ok");
                    out.print(json);
                    out.flush();
                    
                }   break;
            default:
                break;
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

        try {
            processRequest(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(Ajax.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(Ajax.class.getName()).log(Level.SEVERE, null, ex);
        }
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
