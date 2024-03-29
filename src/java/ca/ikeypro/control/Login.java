package ca.ikeypro.control;

import ca.ikeypro.DAO.Client;
import ca.ikeypro.DAO.ClientDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Judith
 */
public class Login extends HttpServlet {

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
            String courriel = request.getParameter("user");
            String pw = request.getParameter("pass");
            String location = "/";
            String Resultat = ClientDAO.VerifierUser(courriel, pw);

            switch (Resultat) {
                case "CORRECT":
                    String origine = (String) session.getAttribute("origine");
                    Client client = ClientDAO.getClient(courriel);
                    session.setAttribute("client", client);

                    if (origine != null) {
                        location = "/WEB-INF/panier.jsp";
                        session.removeAttribute("origine");
                    } else {
                        location = "/index.jsp";
                    }

                    break;
                case "USER":
                    request.setAttribute("usererror", "Ce user nexiste pas");
                    location = "/WEB-INF/login.jsp";
                    break;
                case "PASS":
                    request.setAttribute("passerror", "Mot de passe incorrect");
                    location = "/WEB-INF/login.jsp";
                    break;
                default:
                    break;
            }

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(location);

            dispatcher.forward(request, response);
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
