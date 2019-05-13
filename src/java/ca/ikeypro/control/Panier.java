/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.ikeypro.control;

import ca.ikeypro.DAO.Client;
import ca.ikeypro.DAO.CommandeDAO;
import ca.ikeypro.DAO.LigneCommandeDAO;
import ca.ikeypro.DAO.LignePanier;
import ca.ikeypro.Utilitaire.MailManager;
import java.io.IOException;
import java.util.Calendar;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Anis
 */
public class Panier extends HttpServlet {

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
        HttpSession session = request.getSession();

        if (session == null) {
            response.sendRedirect("WEB-INF/erreur/erreur.jsp");

        }
        response.setContentType("text/html;charset=UTF-8");

        Vector buylist = (Vector) session.getAttribute("panier");
        String action = request.getParameter("action");

        if (!action.equals("CHECKOUT")) {
            //  float total = 0;
            //  session.setAttribute("total", total);
            if (action.equals("DELETE")) {

                //on récupère l'indice de l'item à supprimer  
                String del = request.getParameter("delindex");

                //on supprime l'item du panier
                int d = (new Integer(del)).intValue();
                buylist.removeElementAt(d);
                int nb = buylist.size();
                if (nb == 0) {
                    float total = 0;

                    session.setAttribute("total", total);
                    String url = "/ListeProduits?action=categorie&cat=2";
                    ServletContext sc = getServletContext();
                    RequestDispatcher rd = sc.getRequestDispatcher(url);
                    rd.forward(request, response);
                } else {
                    float total = 0;
                    for (int i = 0; i < buylist.size(); i++) {
                        LignePanier cd = (LignePanier) buylist.elementAt(i);
                        int qte = cd.getQte();
                        float prix = cd.getPrix();
                        total += qte * prix;
                    }
                    session.setAttribute("total", total);
                    String url = "/WEB-INF/panier.jsp";
                    ServletContext sc = getServletContext();
                    RequestDispatcher rd = sc.getRequestDispatcher(url);
                    rd.forward(request, response);

                }

                // si clic sur ajouter au panier
            } else if (action.equals("VIDER")) {
                buylist.removeAllElements();
                float total = 0;

                session.setAttribute("total", total);
                String url = "/WEB-INF/iKeyPro.jsp";
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher(url);
                rd.forward(request, response);

            } else if (action.equals("AFFICHER")) {
                String url = "/WEB-INF/panier.jsp";
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher(url);
                rd.forward(request, response);
            } else if (action.equals("CONFIRM")) {
                String st = request.getParameter("st");
                String tx = request.getParameter("tx");
                String cc = request.getParameter("cc");
                String amt = request.getParameter("amt");
                System.out.println("TX: " + tx);
                System.out.println("ST: " + st);
                System.out.println("ST: " + amt + "" + cc);
                if (st.equals("Completed")) {

                    Client c = (Client) session.getAttribute("client");
                    int idClient = c.getIdClient();

                    Calendar calendar = Calendar.getInstance();
                    java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());

                    CommandeDAO.insert(idClient, date);

                    int idCommande = CommandeDAO.getCommandeId(idClient, date);
                    MailManager.SendConfirmation(c.getCourriel(), tx, idCommande, amt);
                    System.out.println("ID commande :" + idCommande);
                    for (int i = 0; i < buylist.size(); i++) {
                        LignePanier anOrder = (LignePanier) buylist.elementAt(i);
                        String code = anOrder.getCodeProduit();
                        float price = anOrder.getPrix();
                        int qty = anOrder.getQte();
                        LigneCommandeDAO.insert(i + 1, code, idCommande, qty);
                    }
                    buylist.removeAllElements();
                    float total = 0;
                    session.setAttribute("total", total);
                    String url = "/WEB-INF/confirmation.jsp";
                    request.setAttribute("tx", tx);
                    request.setAttribute("st", st);
                    request.setAttribute("cc", cc);
                    request.setAttribute("amt", amt);
                    ServletContext sc = getServletContext();
                    RequestDispatcher rd = sc.getRequestDispatcher(url);
                    rd.forward(request, response);

                } else {
                    String url = "/WEB-INF/erreur/erreur.jsp";
                    ServletContext sc = getServletContext();
                    RequestDispatcher rd = sc.getRequestDispatcher(url);
                    rd.forward(request, response);
                }

            } else if (action.equals("ADD")) {

                boolean match = false;
                LignePanier aProduit = getProduit(request);

                if (buylist == null) {

                    buylist = new Vector();

                    buylist.addElement(aProduit);

                } else {

                    for (int i = 0; i < buylist.size(); i++) {

                        LignePanier cd = (LignePanier) buylist.elementAt(i);

                        if (cd.getCodeProduit().equals(aProduit.getCodeProduit())) {

                            cd.setQte(cd.getQte() + aProduit.getQte());

                            buylist.setElementAt(cd, i);

                            match = true;
                        } //end of if name matches
                    } // end of for
//        
                    if (!match) //on ajoute l'item au panier
                    {
                        buylist.addElement(aProduit);
                    }
                }
                float total = 0;
                for (int i = 0; i < buylist.size(); i++) {
                    LignePanier cd = (LignePanier) buylist.elementAt(i);
                    int qte = cd.getQte();
                    float prix = cd.getPrix();
                    total += qte * prix;
                }
                session.setAttribute("total", total);
                session.setAttribute("panier", buylist);
                String url = "/WEB-INF/panier.jsp";
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher(url);
                rd.forward(request, response);

            }

        } else if (action.equals("CHECKOUT")) {

            Client c = (Client) session.getAttribute("client");
            if (c != null) {

                String url = "/WEB-INF/checkout.jsp";
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher(url);
                rd.forward(request, response);
            } else {
                String url = "/WEB-INF/login.jsp";
                session.setAttribute("origine", "ch");
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher(url);
                rd.forward(request, response);

            }

        }
    }

    private LignePanier getProduit(HttpServletRequest req) {

        String id = req.getParameter("id");
        String name = req.getParameter("name");

        //on récupère la quantité saisie
        String qty = req.getParameter("qty");
        String prix = req.getParameter("prix");
        String image = req.getParameter("image");

        //on crée un objet Lignepanier avec les informations et on les retourne
       
        LignePanier p = new LignePanier();
        p.setCodeProduit(id);
        p.setProduit(name);
        p.setQte(new Integer(qty).intValue());
        p.setPrix(new Float(prix).floatValue());
        p.setImage(image);

        return p;
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
