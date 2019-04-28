/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.ikeypro.control;

import ca.ikeypro.DAO.LignePanier;
import ca.ikeypro.DAO.Produit;
import ca.ikeypro.DAO.ProduitDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
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
        response.setContentType("text/html;charset=UTF-8");
        Vector buylist = (Vector) session.getAttribute("panier");
        String action = request.getParameter("action");
        
        if (action.equals("ADD")) {
          
       //booleen qui va être utilisé pour vérifier si l'item est déjà 
       //dans le panier
        boolean match=false;
        LignePanier aCD = getProduit(request);
        
        //si panier inexistant on va le créer(cas du 1er item à ajouter)
        if (buylist==null) {
            
          //on crée le panier
          buylist = new Vector();
          
          //on ajoute le premier CD
          buylist.addElement(aCD);
          
         //si le panier existe déjà (buylist non null) 
//        } else { 
//            
//          //on vérifie si le CD est déjà dans le panier?
//          //pour ne pas l'ajouter une autre fois 
////          for (int i=0; i< buylist.size(); i++) {
////            
////            on récupère l'item à la position i
////            Produit cd = (Produit) buylist.elementAt(i);
////            
////            // si on trouve l'item dans le panier
////            if (cd.getAlbum().equals(aCD.getAlbum())) {
////
////               //on va modifier la quantité en lui ajoutantant la
////               // nouvelle quantité
////              cd.setQuantity(cd.getQuantity()+aCD.getQuantity());
////
////              //on replace l'item dans le panier
////              buylist.setElementAt(cd,i);
////
////              //on active la variable qui montre qu'on a trouvé l'item
////              //dans le panier
////              match = true;
////            } //end of if name matches
////          } // end of for
//        
//        }
          session.setAttribute("panier", buylist);
            String url="/shop.jsp";
      ServletContext sc = getServletContext();
      RequestDispatcher rd = sc.getRequestDispatcher(url);
      rd.forward(request, response);
          
        }      
        }
    }

           //méthode utilitaire qui sert à récupérer les différentes
    //parties d'un item (CD)choisi de la liste (séparéespar le |)
    // et retourne un objet de type CD qui va être utlisé par la servlet
    private LignePanier getProduit(HttpServletRequest req) {
    //imagine if all this was in a scriptlet...ugly, eh?
    //on récupère l'item choisi par l'utilisateur dans la liste
    String id = req.getParameter("id");

    //on récupère la quantité saisie
    String qty = req.getParameter("qty");



    //on crée un objet CD avec les informations et on le retourne
    // à la servlet
        LignePanier p = new LignePanier();
  //  p.setCodeProduit(id);
//    cd.setAlbum(album);
//    cd.setArtist(artist);
//    cd.setCountry(country);
//    cd.setPrice((new Float(price)).floatValue());
//    cd.setQuantity((new Integer(qty)).intValue());
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