package ca.ikeypro.DAO;

import ca.ikeypro.Utilitaire.DataManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Judith
 */
public class ProduitDAO {

    public static ArrayList getListeProduit(String idCategorie) {
        ArrayList liste = new ArrayList();
        Connection conn;
        try {
            conn = DataManager.getInstance().getConnection();
            //System.out.println("Produits Connected");
            String strQuery = "SELECT * FROM PRODUIT WHERE ID_CATEGORIE =\'" + idCategorie + "\'";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(strQuery);
            //System.out.println(strQuery);
            Produit prod;
            while (rs.next()) {
                prod = new Produit();
                prod.setCodeProduit(rs.getString("CODE_PRODUIT"));
                prod.setProduit(rs.getString("PRODUIT"));
                //prod.setDateRelease(rs.getString("DATE_RELEASE"));
                prod.setPrix(rs.getDouble("PRIX"));
                //prod.setPlateforme(rs.getString("PLATEFORME"));
                prod.setEditeur(rs.getString("ID_EDITEUR"));
                //prod.setEdition(rs.getString("ID_EDITION"));
                //prod.setLangue(rs.getString("LANGUE"));
                prod.setImage(rs.getString("IMAGE"));
                //prod.setDisponibilite(rs.getShort("DISPONIBILITE"));
                liste.add(prod);
            }
            return liste;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DataManager.getInstance().closeConnection();
        }
        return liste;
    }

    public static ArrayList<Produit> getListeDesProduits() {
        ArrayList<Produit> listeProduits = new ArrayList();
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {
                String requette = "SELECT P.CODE_PRODUIT, P.PRODUIT, P.DATE_RELEASE, P.PRIX, "
                        + "P.PLATEFORME , EUR.EDITEUR ID_EDITEUR, EON.EDITION ID_EDITION, P.LANGUE, P.IMAGE, P.DISPONIBILITE, P.NBCONSULT "
                        + " FROM PRODUIT P"
                        + " INNER JOIN EDITEUR EUR ON P.ID_EDITEUR = EUR.ID_EDITEUR"
                        + " INNER JOIN EDITION EON ON P.ID_EDITION = EON.ID_EDITION";
                // System.out.println(requette);
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(requette);
                Produit prod;
                while (rs.next()) {
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
                return listeProduits;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DataManager.getInstance().closeConnection();
            }
        }
        return listeProduits;
    }

    public static ArrayList<Produit> getListeDesProduitsByName(String name) {
        ArrayList<Produit> listeProduits = new ArrayList();
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {
                String requette = " SELECT  P.CODE_PRODUIT, P.PRODUIT, P.DATE_RELEASE, P.PRIX, P.PLATEFORME, "
                        + " EUR.EDITEUR, P.ID_EDITEUR, EON.EDITION, P.ID_EDITION, "
                        + " P.LANGUE, P.IMAGE, P.DISPONIBILITE, P.NBCONSULT "
                        + " FROM PRODUIT P "
                        + " INNER JOIN EDITEUR EUR ON P.ID_EDITEUR = EUR.ID_EDITEUR "
                        + " INNER JOIN EDITION EON ON P.ID_EDITION = EON.ID_EDITION "
                        + " INNER JOIN CATEGORIE C ON P.ID_CATEGORIE = C.ID_CATEGORIE "
                        + " WHERE LOWER(P.PRODUIT)    LIKE '%" + name + "%' OR "
                        + "       LOWER(EUR.EDITEUR)  LIKE '%" + name + "%' OR "
                        + "       LOWER(EON.EDITION)  LIKE '%" + name + "%' OR "
                        + "       LOWER(P.PLATEFORME) LIKE '%" + name + "%' OR"
                        + "       LOWER(C.CATEGORIE)  LIKE '%" + name + "%' ";
                // System.out.println(requette);
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(requette);
                Produit prod;
                while (rs.next()) {
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
                    System.out.println("PRODUITS: "+prod.toString());
                }
                return listeProduits;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DataManager.getInstance().closeConnection();
            }
        }
        return listeProduits;
    }

    public static ArrayList<Editeur> getListeDistinctEditeurByCat(String name) {
        ArrayList<Editeur> listeEditeurs = new ArrayList();
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {
                String requette = " SELECT  DISTINCT(P.ID_EDITEUR), EUR.EDITEUR"
                        + " FROM PRODUIT P "
                        + " INNER JOIN EDITEUR EUR ON P.ID_EDITEUR = EUR.ID_EDITEUR "
                        + " WHERE P.ID_CATEGORIE= '" + name + "' ";

                System.out.println(requette);
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(requette);
                Editeur edit;
                while (rs.next()) {
                    edit = new Editeur();
                    edit.setId_Editeur(rs.getString("ID_EDITEUR"));
                    edit.setEditeur(rs.getString("EDITEUR"));

                    listeEditeurs.add(edit);
                }
                // return listeEditeurs;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DataManager.getInstance().closeConnection();
            }
        }
        return listeEditeurs;
    }

    public static ArrayList<Edition> getListeDistinctEditionByCat(String name, String editeur) {
        ArrayList<Edition> listeEditions = new ArrayList();
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {
                String requette = " SELECT  DISTINCT(P.ID_EDITION), EUR.EDITION"
                        + " FROM PRODUIT P "
                        + " INNER JOIN EDITION EUR ON P.ID_EDITION = EUR.ID_EDITION "
                        + " WHERE P.ID_CATEGORIE= '" + name + "' AND P.ID_EDITEUR = '" + editeur + "'";

                System.out.println(requette);
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(requette);
                Edition edit;
                while (rs.next()) {
                    edit = new Edition();
                    edit.setId_Edition(rs.getString("ID_EDITION"));
                    edit.setEdition(rs.getString("EDITION"));

                    listeEditions.add(edit);
                }
                // return listeEditeurs;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DataManager.getInstance().closeConnection();
            }
        }
        return listeEditions;
    }

        public static ArrayList<String> getListeDistinctLangue(String categorie, String editeur, String edition) {
        ArrayList<String> listeLangues = new ArrayList();
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {
                String requette = " SELECT  DISTINCT(P.LANGUE) "
                        + " FROM PRODUIT P "
                        + " INNER JOIN EDITEUR EUR ON P.ID_EDITEUR = EUR.ID_EDITEUR "
                        + " INNER JOIN EDITION EON ON P.ID_EDITION = EON.ID_EDITION "
                        + " INNER JOIN CATEGORIE C ON P.ID_CATEGORIE = C.ID_CATEGORIE "
                        + " WHERE "
                        + "       EUR.EDITEUR  = '" + editeur + "' AND "
                        + "       EON.EDITION  = '" + edition + "' AND "
                        + "       C.CATEGORIE  = '" + categorie + "'";

                System.out.println(requette);
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(requette);
                String langue;
                while (rs.next()) {
                    langue = rs.getString(0);
                    listeLangues.add(langue);
                    System.out.println("*=*=*=*=*=*=*=*=*= Liste de langues "+langue+" *=*=*=*=*=*=*=*=*=");
                }
                // return listeEditeurs;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DataManager.getInstance().closeConnection();
            }
        }
        return listeLangues;
    }
        
    public static ArrayList<Produit> getListeMostViewProduits() {
        ArrayList<Produit> listeProduits = new ArrayList();
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {
                String requette = "SELECT P.CODE_PRODUIT, P.PRODUIT, P.DATE_RELEASE, P.PRIX, "
                        + "P.PLATEFORME , EUR.EDITEUR ID_EDITEUR, EON.EDITION ID_EDITION, P.LANGUE, P.IMAGE, P.DISPONIBILITE, P.NBCONSULT "
                        + " FROM PRODUIT P"
                        + " INNER JOIN EDITEUR EUR ON P.ID_EDITEUR = EUR.ID_EDITEUR"
                        + " INNER JOIN EDITION EON ON P.ID_EDITION = EON.ID_EDITION"
                        + " ORDER BY NBCONSULT DESC"
                        + " FETCH FIRST 6 ROWS ONLY";
                //System.out.println(requette);
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(requette);
                Produit prod;
                while (rs.next()) {
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
                return listeProduits;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DataManager.getInstance().closeConnection();
            }
        }
        return listeProduits;
    }

    public static ArrayList<Produit> rechercheProduits(String cat, String editeur,String edition) {
        ArrayList<Produit> listeProduits = new ArrayList();
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {
                String requette = "SELECT *"
                        + " FROM PRODUIT"
                        + " WHERE ID_CATEGORIE= '" + cat + "' AND ID_EDITEUR = '" + editeur + "' AND ID_EDITION = '" + edition + "'";
                System.out.println(requette);
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(requette);
                Produit prod;
                while (rs.next()) {
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
                return listeProduits;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DataManager.getInstance().closeConnection();
            }
        }
        return listeProduits;
    }

    public static ArrayList<Produit> getListeDesProduitsByCat(String idCategorie) {
        ArrayList<Produit> listeProduits = new ArrayList();
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {
                String requette = "SELECT P.CODE_PRODUIT, P.PRODUIT, P.DATE_RELEASE, P.PRIX, "
                        + " P.PLATEFORME , EUR.EDITEUR ID_EDITEUR, EON.EDITION ID_EDITION, P.LANGUE, P.IMAGE, P.DISPONIBILITE, P.NBCONSULT "
                        + " FROM PRODUIT P "
                        + " INNER JOIN EDITEUR EUR ON P.ID_EDITEUR = EUR.ID_EDITEUR "
                        + " INNER JOIN EDITION EON ON P.ID_EDITION = EON.ID_EDITION "
                        + " WHERE ID_CATEGORIE ='" + idCategorie + "'";
                //System.out.println(requette);
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(requette);
                Produit prod;
                while (rs.next()) {
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
                return listeProduits;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DataManager.getInstance().closeConnection();
            }
        }
        return listeProduits;
    }

    public static ArrayList<Produit> getListeDesProduitsByEditeur(String idEditeur) {
        ArrayList<Produit> listeProduits = new ArrayList();
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {
                String requette = "SELECT P.CODE_PRODUIT, P.PRODUIT, P.DATE_RELEASE, P.PRIX, "
                        + " P.PLATEFORME , EUR.EDITEUR ID_EDITEUR, EON.EDITION ID_EDITION, P.LANGUE, P.IMAGE, P.DISPONIBILITE, P.NBCONSULT "
                        + " FROM PRODUIT P "
                        + " INNER JOIN EDITEUR EUR ON P.ID_EDITEUR = EUR.ID_EDITEUR "
                        + " INNER JOIN EDITION EON ON P.ID_EDITION = EON.ID_EDITION "
                        + " WHERE P.ID_EDITEUR ='" + idEditeur + "'";
                //System.out.println(requette);
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(requette);
                Produit prod;
                while (rs.next()) {
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
                return listeProduits;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DataManager.getInstance().closeConnection();
            }
        }
        return listeProduits;
    }

    public static ArrayList<Produit> getListeDesProduitsByEdition(String idEdition) {
        ArrayList<Produit> listeProduits = new ArrayList();
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {
                String requette = "SELECT P.CODE_PRODUIT, P.PRODUIT, P.DATE_RELEASE, P.PRIX, "
                        + " P.PLATEFORME , EUR.EDITEUR ID_EDITEUR, EON.EDITION ID_EDITION, P.LANGUE, P.IMAGE, P.DISPONIBILITE, P.NBCONSULT "
                        + " FROM PRODUIT P "
                        + " INNER JOIN EDITEUR EUR ON P.ID_EDITEUR = EUR.ID_EDITEUR "
                        + " INNER JOIN EDITION EON ON P.ID_EDITION = EON.ID_EDITION "
                        + " WHERE P.ID_EDITION ='" + idEdition + "'";
                //System.out.println(requette);
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(requette);
                Produit produit;
                while (rs.next()) {
                    produit = new Produit();
                    produit.setCodeProduit(rs.getString("CODE_PRODUIT"));
                    produit.setProduit(rs.getString("PRODUIT"));
                    produit.setDateRelease(rs.getString("DATE_RELEASE"));
                    produit.setPrix(rs.getDouble("PRIX"));
                    produit.setPlateforme(rs.getString("PLATEFORME"));
                    produit.setEditeur(rs.getString("ID_EDITEUR"));
                    produit.setEdition(rs.getString("ID_EDITION"));
                    produit.setLangue(rs.getString("LANGUE"));
                    produit.setImage(rs.getString("IMAGE"));
                    produit.setDisponibilite(rs.getShort("DISPONIBILITE"));
                    produit.setNbconsulte(rs.getInt("NBCONSULT"));
                    listeProduits.add(produit);
                }
                return listeProduits;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DataManager.getInstance().closeConnection();
            }
        }
        return listeProduits;
    }

    public static ArrayList<Produit> getListeDesProduitsByDispo() {
        ArrayList<Produit> listeProduits = new ArrayList();
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {
                String requette = "SELECT P.CODE_PRODUIT, P.PRODUIT, P.DATE_RELEASE, P.PRIX, "
                        + "P.PLATEFORME , EUR.EDITEUR ID_EDITEUR, EON.EDITION ID_EDITION, P.LANGUE, P.IMAGE, P.DISPONIBILITE, P.NBCONSULT "
                        + " FROM PRODUIT P"
                        + " INNER JOIN EDITEUR EUR ON P.ID_EDITEUR = EUR.ID_EDITEUR"
                        + " INNER JOIN EDITION EON ON P.ID_EDITION = EON.ID_EDITION"
                        + " WHERE P.DISPONIBILITE = 1";
                // System.out.println(requette);
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(requette);
                Produit prod;
                while (rs.next()) {
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
                return listeProduits;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DataManager.getInstance().closeConnection();
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
    public static Produit getProduit(String idProduit) {
        int nbconsult = 0;
        Produit prod = new Produit();
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {
                String req = "SELECT P.CODE_PRODUIT, P.PRODUIT, P.DATE_RELEASE, P.PRIX, "
                        + " P.PLATEFORME , EUR.EDITEUR ID_EDITEUR, "
                        + " EON.EDITION ID_EDITION, P.LANGUE, P.IMAGE, P.DISPONIBILITE, P.NBCONSULT "
                        + " FROM PRODUIT P "
                        + " INNER JOIN EDITEUR EUR ON P.ID_EDITEUR = EUR.ID_EDITEUR "
                        + " INNER JOIN EDITION EON ON P.ID_EDITION = EON.ID_EDITION "
                        + "WHERE CODE_PRODUIT ='" + idProduit + "'";
                //System.out.println(req);
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(req);
                if (rs.next()) {
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
                    nbconsult = prod.getNbconsulte();
                }
                return prod;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DataManager.getInstance().closeConnection();
            }
        }
        updateNbConsult(idProduit, nbconsult);
        return prod;
    }

    private static void updateNbConsult(String idProdit, int nbConsult) {
        //Client client = new Client();
        nbConsult++;
        Connection conn = DataManager.getInstance().getConnection();
        if (conn != null) {
            try {
                String req = "UPDATE PRODUIT SET NBCONSULT=" + nbConsult + " WHERE CODE_PRODUIT=\'" + idProdit + "\'";
                //System.out.println(req);
                Statement statement = conn.createStatement();
                statement.executeUpdate(req);
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DataManager.getInstance().closeConnection();
            }
        }
    }
}
