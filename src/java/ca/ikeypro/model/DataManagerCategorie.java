/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.ikeypro.model;

import ca.ikeypro.Utilitaire.DataManager;
import static ca.ikeypro.model.DataManagerProduit.getConnection;
import static ca.ikeypro.model.DataManagerProduit.putConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Anis
 */
public class DataManagerCategorie {
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
    
    
    
    
    
    
    
    

    
      public static ArrayList<Categorie> getListeCetegorie()
{

       
        ArrayList<Categorie> listeCategorie = new ArrayList();
        Connection conn = getConnection();
	
        
  if (conn != null)
    {
    	ResultSet rs = null;
        Statement statement=null ;
        System.out.println("Connected");
	try
	{
	 String strQuery = "SELECT * FROM CATEGORIE ";
         statement =conn.createStatement();
	 rs=statement.executeQuery(strQuery);
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

      
      
      
      
}
