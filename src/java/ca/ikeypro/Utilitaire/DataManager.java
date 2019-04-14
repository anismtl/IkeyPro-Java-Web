/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.ikeypro.Utilitaire;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import ca.ikeypro.model.Categorie;
import ca.ikeypro.model.Produit;
import java.sql.PreparedStatement;

/**
 *
 * @author Anis
 */
public class DataManager {

    private String dbURL = "";
    private String dbUserName = "";
    private String dbPassword = "";

    public void setDbURL(String dbURL) {
        this.dbURL = dbURL;
    }

    public String getDbURL() {
        return dbURL;
    }

    public void setDbUserName(String dbUserName) {
        this.dbUserName = dbUserName;
    }

    public String getDbUserName() {
        return dbUserName;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    /*
     * Open database connection
     */
    public Connection getConnection() {
        Connection conn = null;

        try {

            conn = DriverManager.getConnection(getDbURL(), getDbUserName(), getDbPassword());
        } catch (SQLException e) {
            System.out.println("Could not connect to DB");
            e.printStackTrace();
        }
        return conn;
    }

    public void putConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Enable to close DB connection");
                e.printStackTrace();
            }
        }
    }
    
       public ArrayList getListeCategorie()
{
	ArrayList listeCategorie=new ArrayList();
        Connection conn = getConnection();
	//Connection conn = getConnection();
        
  if (conn != null)
    {
    	ResultSet rs = null;
        Statement statement=null ;
        System.out.println("Categorie Connected");
	try
	{
	 String strQuery = "SELECT * FROM CATEGORIE ";
         statement =conn.createStatement();
	 rs=statement.executeQuery(strQuery);
            System.out.println(strQuery);
		Categorie cat;
		while(rs.next())
		{
                    cat=new Categorie();
                    cat.setIdCategorie(rs.getString("ID_CATEGORIE"));
                    cat.setCategorie(rs.getString("CATEGORIE"));
          
                    listeCategorie.add(cat);
		}
	}//end of try
	catch(SQLException ex){ex.printStackTrace();
          System.out.println("not Connected");
        }
	finally
	{
       	try
       	{
       		rs.close();
       		statement.close();
       	}
         	catch (SQLException e)
                {e.printStackTrace();}
         	
        putConnection(conn);
       }//end of finally
   }//end of if
   return listeCategorie;
}
    

       
       
       public ArrayList getListeProduit(String idCategorie)
{
	ArrayList listeProduit=new ArrayList();
        Connection conn = getConnection();
       //int id=Integer.parseInt(idCategorie);
        
  if (conn != null)
    {
    	ResultSet rs = null;
        Statement statement=null ;
         // PreparedStatement statement = null;
     System.out.println("ListeProduits Connected");
	try
	{
	 String strQuery = "SELECT * FROM PRODUIT WHERE ID_CATEGORIE =\'"+idCategorie+"\'";
         statement =conn.createStatement();
          statement = conn.prepareStatement(strQuery);
        // statement.setInt(1, id);
       // statement.setString(1, idCategorie);
	 rs=statement.executeQuery(strQuery);
            System.out.println(strQuery);
		Produit prod;
		while(rs.next())
		{
                    prod=new Produit();
                    prod.setCodeProduit(rs.getString("CODE_PRODUIT"));
                    prod.setProduit(rs.getString("PRODUIT"));
                 //   prod.setDateRelease(rs.getString("DATE_RELEASE"));
                    prod.setPrix(rs.getDouble("PRIX"));
                 //   prod.setPlateforme(rs.getString("PLATEFORME"));
                    prod.setEditeur(rs.getString("ID_EDITEUR"));
               //     prod.setEdition(rs.getString("ID_EDITION"));
                //    prod.setLangue(rs.getString("LANGUE"));
                    prod.setImage(rs.getString("IMAGE"));
                //    prod.setDisponibilite(rs.getShort("DISPONIBILITE"));
            
          
                    listeProduit.add(prod);
		}
	}//end of try
	catch(SQLException ex){ex.printStackTrace();
          System.out.println("not Connected");
        }
	finally
	{
       	try
       	{
       		rs.close();
       		statement.close();
       	}
         	catch (SQLException e)
                {e.printStackTrace();}
         	
        putConnection(conn);
       }//end of finally
        
   }//end of if
   return listeProduit;
}       
       
       
       
       
       
    
       
}
