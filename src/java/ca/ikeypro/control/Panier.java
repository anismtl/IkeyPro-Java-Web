/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.ikeypro.control;

import ca.ikeypro.DAO.Client;
import ca.ikeypro.DAO.Commande;
import ca.ikeypro.DAO.CommandeDAO;
import ca.ikeypro.DAO.LigneCommandeDAO;
import ca.ikeypro.DAO.LignePanier;
import ca.ikeypro.Utilitaire.MailManager;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
    Date dateCommande = null;
   
//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd à HH:mm:ss").format(new Date());

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
            response.sendRedirect("WEB-INF/erreurExceptions/erreurOUPS.jsp");

        }
        response.setContentType("text/html;charset=UTF-8");

        Vector buylist = (Vector) session.getAttribute("panier");
        String action = request.getParameter("action");

        if (!action.equals("CHECKOUT")) {
            float total = 0;
            session.setAttribute("total", total);
            if (action.equals("DELETE")) {

                //on récupère l'indice de l'item à supprimer  
                String del = request.getParameter("delindex");

                //on supprime l'item du panier
                int d = (new Integer(del)).intValue();
                buylist.removeElementAt(d);
                int nb = buylist.size();
                if (nb == 0) {
                    total = 0;

                    session.setAttribute("total", total);
                    // session.setAttribute("panier", buylist);
                    String url = "/ListeProduits?action=categorie&cat=2";
                    ServletContext sc = getServletContext();
                    RequestDispatcher rd = sc.getRequestDispatcher(url);
                    rd.forward(request, response);
                } else {
                    total = 0;
                    for (int i = 0; i < buylist.size(); i++) {
                        LignePanier cd = (LignePanier) buylist.elementAt(i);
                        int qte = cd.getQte();
                        float prix = cd.getPrix();
                        total += qte * prix;
                    }
                    session.setAttribute("total", total);
                    // session.setAttribute("panier", buylist);
                    String url = "/panier.jsp";
                    ServletContext sc = getServletContext();
                    RequestDispatcher rd = sc.getRequestDispatcher(url);
                    rd.forward(request, response);

                }

                // si clic sur ajouter au panier
            } else if (action.equals("VIDER")) {
                buylist.removeAllElements();
                total = 0;

                session.setAttribute("total", total);
                // session.setAttribute("panier", buylist);
                String url = "/ListeProduits?action=categorie&cat=2";
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

                    Client   c = (Client) session.getAttribute("client");
                    int idClient = c.getIdClient();
                    
                    Calendar calendar = Calendar.getInstance();
                    java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());

                    CommandeDAO.insert(idClient, ourJavaDateObject);
                  //  Commande com = CommandeDAO.getCommande(idClient, ourJavaDateObject);
                 //   int idcom = com.getId_Commande();
                   int idcom = CommandeDAO.getCommandeId(idClient, ourJavaDateObject);
                    MailManager.SendConfirmation(c.getCourriel(), tx, idcom,amt);
                    System.out.println("ID commande :" + idcom);
                    for (int i = 0; i < buylist.size(); i++) {
                        LignePanier anOrder = (LignePanier) buylist.elementAt(i);
                        String code =anOrder.getCodeProduit();
                        float price = anOrder.getPrix();
                        int qty = anOrder.getQte();
                        //  total += (price * qty);
                        LigneCommandeDAO.insert(i+1, code, idcom, qty);
                    }
                    buylist.removeAllElements();
                    total = 0;
                    String url = "/WEB-INF/confirmation.jsp";
                    request.setAttribute("tx", tx);
                    request.setAttribute("st", st);
                    request.setAttribute("cc", cc);
                    request.setAttribute("amt", amt);
                    ServletContext sc = getServletContext();
                    RequestDispatcher rd = sc.getRequestDispatcher(url);
                    rd.forward(request, response);

                } else {
                    String url = "/WEB-INF/erreur.jsp";
                    ServletContext sc = getServletContext();
                    RequestDispatcher rd = sc.getRequestDispatcher(url);
                    rd.forward(request, response);
                }

            } else if (action.equals("ADD")) {

                //booleen qui va être utilisé pour vérifier si l'item est déjà 
                //dans le panier
                boolean match = false;
                LignePanier aProduit = getProduit(request);

                //si panier inexistant on va le créer(cas du 1er item à ajouter)
                if (buylist == null) {

                    //on crée le panier
                    buylist = new Vector();

                    //on ajoute le premier CD
                    buylist.addElement(aProduit);

                    //si le panier existe déjà (buylist non null) 
                } else {

                    //on vérifie si le CD est déjà dans le panier?
                    //pour ne pas l'ajouter une autre fois 
                    for (int i = 0; i < buylist.size(); i++) {

                        // on récupère l'item à la position i
                        LignePanier cd = (LignePanier) buylist.elementAt(i);

                        // si on trouve l'item dans le panier
                        if (cd.getCodeProduit().equals(aProduit.getCodeProduit())) {

                            //on va modifier la quantité en lui ajoutantant la
                            // nouvelle quantité
                            cd.setQte(cd.getQte() + aProduit.getQte());
                            //  cd.setQuantity(cd.getQuantity()+aCD.getQuantity());
////
////              //on replace l'item dans le panier
                            buylist.setElementAt(cd, i);
////
////              //on active la variable qui montre qu'on a trouvé l'item
////              //dans le panier
                            match = true;
                        } //end of if name matches
                    } // end of for
//        
                    if (!match) //on ajoute l'item au panier
                    {
                        buylist.addElement(aProduit);
                    }
                }
                total = 0;
                for (int i = 0; i < buylist.size(); i++) {
                    LignePanier cd = (LignePanier) buylist.elementAt(i);
                    int qte = cd.getQte();
                    float prix = cd.getPrix();
                    total += qte * prix;
                }
                session.setAttribute("total", total);
                session.setAttribute("panier", buylist);
                String url = "/panier.jsp";
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher(url);
                rd.forward(request, response);

            }

        } else if (action.equals("CHECKOUT")) {

            //on va calculer le prix total
         Client   c = (Client) session.getAttribute("client");
            if (c != null) {

//                int idClient = c.getIdClient();
//                Calendar calendar = Calendar.getInstance();
//                java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
//
//                CommandeDAO.insert(idClient, ourJavaDateObject);
//                Commande com = CommandeDAO.getCommande(idClient, ourJavaDateObject);
//                int idcom = com.getId_Commande();
//                System.out.println("ID commande :" + idcom);
//                for (int i = 0; i < buylist.size(); i++) {
//                    LignePanier anOrder = (LignePanier) buylist.elementAt(i);
//                    float price = anOrder.getPrix();
//                    int qty = anOrder.getQte();
//                    //  total += (price * qty);
//                }
//            //deviner à quoi cela sert ??????
//          //  total += 0.005;
//         //   String amount = new Float(total).toString();
//            int n = amount.indexOf('.');
//            amount = amount.substring(0, n + 3);
//            session.setAttribute("total", amount);
                //on redirige la requête vers la page de Checkout
                String url = "/checkout.jsp";
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher(url);
                rd.forward(request, response);
            } else {
                String url = "/login.jsp";
                session.setAttribute("origine", "ch");
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher(url);
                rd.forward(request, response);
                // System.out.println("forward origine ch a faire");

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
        // à la servlet
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
