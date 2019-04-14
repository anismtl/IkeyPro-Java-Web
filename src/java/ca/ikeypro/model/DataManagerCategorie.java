/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.ikeypro.model;

import ca.ikeypro.Utilitaire.DataManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Anis
 */
public class DataManagerCategorie {
     DataManager dataManager;
    
      public ArrayList getListeCetegorie()
{
	ArrayList listeCategorie=new ArrayList();
        Connection conn = dataManager.getConnection();
	//Connection conn = getConnection();
        
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
         	
        dataManager.putConnection(conn);
       }//end of finally
   }//end of if
   return listeCategorie;
}

      
      
      
      
}
