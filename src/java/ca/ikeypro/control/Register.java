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
 *
 * @author Judith
 */
public class Register extends HttpServlet {

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
            String Url;
            HttpSession session = request.getSession();
            String nomClient = request.getParameter("nom");
            String prenomClient = request.getParameter("prenom");
            String courriel = request.getParameter("user");
            String motPasse = request.getParameter("pass");
            String adresseClient = request.getParameter("adresse");
            String tel = request.getParameter("tel");
            Client client = new Client(nomClient, prenomClient, courriel, tel, adresseClient, motPasse);
            String Resultat = ClientDAO.insert(client);
            System.out.println(Resultat);
            switch (Resultat) {
                case "EXISTE":
                    request.setAttribute("resultat", "Ce couriel existe deja");
                    Url = "/WEB-INF/register.jsp";
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(Url);
                    dispatcher.forward(request, response);
                    break;
                case "REUSSI":
                    session.removeAttribute("client");
                    Client c = ClientDAO.getClient(courriel);
                    session.setAttribute("client", c);
                    Url = "/WEB-INF/iKeyPro.jsp";
                    ServletContext sc = getServletContext();
                    RequestDispatcher rd = sc.getRequestDispatcher(Url);
                    rd.forward(request, response);
                    break;
                default:
                    Url = "/WEB-INF/erreur/erreur.jsp";
                    ServletContext sci = getServletContext();
                    RequestDispatcher rdi = sci.getRequestDispatcher(Url);
                    rdi.forward(request, response);
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
