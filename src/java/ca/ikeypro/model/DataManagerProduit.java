/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.ikeypro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Anis
 */
public class DataManagerProduit {
    public static Connection getConnection(){
        String url="jdbc:oracle:thin:@ikeypro.ca:1521:XE";
        String user = "ikeypro";
        String pwd = "ikeypro2019";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url , user , pwd);
            System.out.println("connection effectuee");
        } 
        catch (SQLException ex) {
            System.out.println("connection impossible");
            ex.printStackTrace();
        }
        return conn;
    }
    public static void putConnection(Connection conn){
        if(conn != null){
            try{
                conn.close();
            }
            catch(SQLException e){
                System.out.println("incapable de fermer la connection");
                e.printStackTrace();
            }
        }
    }
    public static ArrayList<Produit> getListeDesProduits(){
        ArrayList<Produit> listeProduits = new ArrayList();
        Connection conn = getConnection();
        if(conn != null){
            ResultSet rs = null;
            Statement statement = null;
            try{
                String requette = "SELECT P.CODE_PRODUIT, P.PRODUIT, P.DATE_RELEASE, P.PRIX, "
                        + "P.PLATEFORME , EUR.EDITEUR ID_EDITEUR, EON.EDITION ID_EDITION, P.LANGUE, P.IMAGE, P.DISPONIBILITE, P.NBCONSULT "
                        + " FROM PRODUIT P"
                        + " INNER JOIN EDITEUR EUR ON P.ID_EDITEUR = EUR.ID_EDITEUR"
                        + " INNER JOIN EDITION EON ON P.ID_EDITION = EON.ID_EDITION";
                System.out.println(requette);
                statement = conn.createStatement();
                rs = statement.executeQuery(requette);
                Produit prod;
                while(rs.next()){
                    prod = new Produit();
                    prod.setCodeProduit(rs.getString("CODE_PRODUIT"));
                    prod.setProduit(rs.getString("PRODUIT"));
                   prod.setDateRelease(rs.getString("DATE_RELEASE"));
                    prod.setPrix(rs.getDouble("PRIX"));
                   prod.setPlateforme(rs.getString("PLATEFORME"));
                    prod.setEditeur(rs.getString("ID_EDITEUR"));
                    prod.setEdition(rs.getString("ID_EDITION"));
                   prod.setLangue(rs.getString("LANGUE"));
                    prod.setImage(rs.getString("IMAGE"));
                   prod.setDisponibilite(rs.getShort("DISPONIBILITE"));
                   prod.setNbconsulte(rs.getInt("NBCONSULT"));
                   listeProduits.add(prod);
                }
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
            finally{
                try{
                    rs.close();
                    statement.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                putConnection(conn);
            }
        }
        return listeProduits;
    }
 
    public static ArrayList<Produit> getListeMostViewProduits(){
        ArrayList<Produit> listeProduits = new ArrayList();
        Connection conn = getConnection();
        if(conn != null){
            ResultSet rs = null;
            Statement statement = null;
            try{
                String requette = "SELECT P.CODE_PRODUIT, P.PRODUIT, P.DATE_RELEASE, P.PRIX, "
                        + "P.PLATEFORME , EUR.EDITEUR ID_EDITEUR, EON.EDITION ID_EDITION, P.LANGUE, P.IMAGE, P.DISPONIBILITE, P.NBCONSULT "
                        + " FROM PRODUIT P"
                        + " INNER JOIN EDITEUR EUR ON P.ID_EDITEUR = EUR.ID_EDITEUR"
                        + " INNER JOIN EDITION EON ON P.ID_EDITION = EON.ID_EDITION"
                        + " ORDER BY NBCONSULT DESC"
                        + " FETCH FIRST 10 ROWS ONLY";
                System.out.println(requette);
                statement = conn.createStatement();
                rs = statement.executeQuery(requette);
                Produit prod;
                while(rs.next()){
                    prod = new Produit();
                    prod.setCodeProduit(rs.getString("CODE_PRODUIT"));
                    prod.setProduit(rs.getString("PRODUIT"));
                   prod.setDateRelease(rs.getString("DATE_RELEASE"));
                    prod.setPrix(rs.getDouble("PRIX"));
                   prod.setPlateforme(rs.getString("PLATEFORME"));
                    prod.setEditeur(rs.getString("ID_EDITEUR"));
                    prod.setEdition(rs.getString("ID_EDITION"));
                   prod.setLangue(rs.getString("LANGUE"));
                    prod.setImage(rs.getString("IMAGE"));
                   prod.setDisponibilite(rs.getShort("DISPONIBILITE"));
                   prod.setNbconsulte(rs.getInt("NBCONSULT"));
                   listeProduits.add(prod);
                }
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
            finally{
                try{
                    rs.close();
                    statement.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                putConnection(conn);
            }
        }
        return listeProduits;
    }    
    
    
    public static ArrayList<Produit> getListeDesProduitsByCat(String idCategorie){
        ArrayList<Produit> listeProduits = new ArrayList();
        Connection conn = getConnection();
        if(conn != null){
            ResultSet rs = null;
            Statement statement = null;
            try{
                String requette = "SELECT P.CODE_PRODUIT, P.PRODUIT, P.DATE_RELEASE, P.PRIX, "
                        + " P.PLATEFORME , EUR.EDITEUR ID_EDITEUR, EON.EDITION ID_EDITION, P.LANGUE, P.IMAGE, P.DISPONIBILITE, P.NBCONSULT "
                        + " FROM PRODUIT P "
                        + " INNER JOIN EDITEUR EUR ON P.ID_EDITEUR = EUR.ID_EDITEUR "
                        + " INNER JOIN EDITION EON ON P.ID_EDITION = EON.ID_EDITION "
                        + " WHERE ID_CATEGORIE ='" + idCategorie + "'";
                System.out.println(requette);
                statement = conn.createStatement();
                rs = statement.executeQuery(requette);
                Produit prod;
                while(rs.next()){
                    prod = new Produit();
                    prod.setCodeProduit(rs.getString("CODE_PRODUIT"));
                    prod.setProduit(rs.getString("PRODUIT"));
                   prod.setDateRelease(rs.getString("DATE_RELEASE"));
                    prod.setPrix(rs.getDouble("PRIX"));
                   prod.setPlateforme(rs.getString("PLATEFORME"));
                    prod.setEditeur(rs.getString("ID_EDITEUR"));
                    prod.setEdition(rs.getString("ID_EDITION"));
                   prod.setLangue(rs.getString("LANGUE"));
                    prod.setImage(rs.getString("IMAGE"));
                   prod.setDisponibilite(rs.getShort("DISPONIBILITE"));
                   prod.setNbconsulte(rs.getInt("NBCONSULT"));
                   listeProduits.add(prod);
                }
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
            finally{
                try{
                    rs.close();
                    statement.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                putConnection(conn);
            }
        }
        return listeProduits;
    }
    
    
//    public static ArrayList<Produit> getRechercheProduits(String cat, double prixmin, double prixmax, String ordre){
//        ArrayList<Produit> listeProduits = new ArrayList();
//        Connection conn = getConnection();
//        String requette;
//        if(conn != null){
//            ResultSet rs = null;
//            PreparedStatement statement = null;
//            try{
//                if ("ASC".equals(ordre))
//                      requette = "SELECT * FROM PRODUITS WHERE CATEGORIE = ? AND PRIX BETWEEN ? AND ? ORDER BY PRIX ASC";
//                else requette = "SELECT * FROM PRODUITS WHERE CATEGORIE = ? AND PRIX BETWEEN ? AND ? ORDER BY PRIX DESC";
//                statement = conn.prepareStatement(requette);
//                statement.setString(1, cat);
//                statement.setDouble(2, prixmin);
//                statement.setDouble(3, prixmax);
//                //statement.setString(4, ordre);
//                rs = statement.executeQuery();
//                Produit produit;
//                while(rs.next()){
//                    produit = new Produit();
//                    produit.setIdProduit(rs.getString("idproduit"));
//                    produit.setNomProduit(rs.getString("nomproduit"));
//                    produit.setDescription(rs.getString("description"));
//                    produit.setCategorie(rs.getString("categorie"));
//                    produit.setPrixProduit(rs.getDouble("prix"));
//                    listeProduits.add(produit);
//                }
//            }
//            catch(SQLException ex){
//                ex.printStackTrace();
//            }
//            finally{
//                try{
//                    rs.close();
//                    statement.close();
//                }
//                catch(SQLException e){
//                    e.printStackTrace();
//                }
//                putConnection(conn);
//            }
//        }
//        return listeProduits;
//    }
    public static Produit getProduit(String idProduit){
        String req ;
        int nbconsult = 0;
        Produit prod = new Produit();
        Connection conn = getConnection();
        if(conn != null){
            ResultSet rs = null;
            Statement statement = null;
            try{
                req = "SELECT P.CODE_PRODUIT, P.PRODUIT, P.DATE_RELEASE, P.PRIX, "
                        + " P.PLATEFORME , EUR.EDITEUR ID_EDITEUR, "
                        + " EON.EDITION ID_EDITION, P.LANGUE, P.IMAGE, P.DISPONIBILITE, P.NBCONSULT "
                        + " FROM PRODUIT P "
                        + " INNER JOIN EDITEUR EUR ON P.ID_EDITEUR = EUR.ID_EDITEUR "
                        + " INNER JOIN EDITION EON ON P.ID_EDITION = EON.ID_EDITION "
                        + "WHERE CODE_PRODUIT ='" + idProduit + "'";
                statement = conn.createStatement();
                
                rs = statement.executeQuery(req);
                if(rs.next()){
                    prod = new Produit();
                    prod.setCodeProduit(rs.getString("CODE_PRODUIT"));
                    prod.setProduit(rs.getString("PRODUIT"));
                   prod.setDateRelease(rs.getString("DATE_RELEASE"));
                    prod.setPrix(rs.getDouble("PRIX"));
                   prod.setPlateforme(rs.getString("PLATEFORME"));
                    prod.setEditeur(rs.getString("ID_EDITEUR"));
                    prod.setEdition(rs.getString("ID_EDITION"));
                   prod.setLangue(rs.getString("LANGUE"));
                    prod.setImage(rs.getString("IMAGE"));
                   prod.setDisponibilite(rs.getShort("DISPONIBILITE"));
                   prod.setNbconsulte(rs.getInt("NBCONSULT"));
                nbconsult =prod.getNbconsulte();
                }
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
            finally{
                try{
                       
                    rs.close();
                    statement.close();
               
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                putConnection(conn);
            }
        }
        updateNbConsult(idProduit, nbconsult);
        return prod;
    }
    
    
    private static void updateNbConsult(String idProdit,int nbConsult){
        
         String req ;
        //Client client = new Client();
        nbConsult++;
        Connection conn ;
        conn = getConnection();
        if(conn != null){
            
            Statement statement = null;
            try{
                req = "UPDATE PRODUIT SET NBCONSULT="+nbConsult+" WHERE CODE_PRODUIT=\'"+idProdit+"\'";
                System.out.println(req);
                statement = conn.createStatement();
                statement.executeUpdate(req);
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
            finally{
                try{
                   
                    statement.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                putConnection(conn);
            }
        }         
    
        
    }
    
    
}

