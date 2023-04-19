package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Models.Show;
import utile.conxBD;


public class ShowDAO {
	
	private static Connection conn = conxBD.getInstance();


//****************************Ajouter Show************************************
			public static int ajouterShow(Show Show) {
				int ShowId = 0;
				System.out.println("-------connexion is "+conn);
				PreparedStatement pstmt = null;
			    ResultSet rs = null;
		        
		        try {
		        	String sql = "INSERT INTO Show VALUES (?,?,?,?,?,?,?,?)";
	        		pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		        	System.out.println("coonexion is---------------------- "+conn);
		        	pstmt.setInt(1, Show.getId_show());
		        	pstmt.setString(2, Show.getTitre_show());
		        	pstmt.setObject(3, Show.getDate_difussion_show());
		        	pstmt.setString(4, Show.getPays());
		        	pstmt.setString(5, Show.getLangue());
		        	pstmt.setInt(6,Show.isIs_a_film());
		            pstmt.setString(7, Show.getGenre_show());
		            pstmt.setString(8, Show.getAffiche());
		        
		        	pstmt.executeUpdate();
		        	
		            // 4- Recupérer l'Id généré par le SGBD
		        	rs = pstmt.getGeneratedKeys();
		            
		            if(rs.next())
		            	ShowId = rs.getInt(1);
		            
		        }catch (SQLException ex) {
		            System.out.println(ex.getMessage());
		            
		        }
				return ShowId;
			}
//*****************************Modification Show***********************************************
			
			public static int modifTitreShow(int id_show,String titre) {
			
				PreparedStatement pstmt = null;
			    ResultSet rs = null;
			    try {
		            String sql = "UPDATE Show SET titre_show=? WHERE ID_show=?";
		            pstmt = conn.prepareStatement(sql);
		            pstmt.setString(1, titre);
		        	pstmt.setInt(2, id_show);
		        	pstmt.executeUpdate();
		            // 4- Recupérer l'Id généré par le SGBD
		        	rs = pstmt.getGeneratedKeys();

		        }catch (SQLException ex) {
		            System.out.println(ex.getMessage());
		        }
				return id_show;
			}
			
	  //**********************************************************************************
			public static int modifPaysShow(int id_show,String pays) {
			
				PreparedStatement pstmt = null;
			    ResultSet rs = null;
			    try {
		            String sql = "UPDATE Show SET pays_show=? WHERE ID_show=?";
		            pstmt = conn.prepareStatement(sql);
		            pstmt.setString(1, pays);
		        	pstmt.setInt(2, id_show);
		        	pstmt.executeUpdate();
		            // 4- Recupérer l'Id généré par le SGBD
		        	rs = pstmt.getGeneratedKeys();

		        }catch (SQLException ex) {
		            System.out.println(ex.getMessage());
		        }
				return id_show;
			}
	
       //**************************************************************************************
    	public static int modifLangueShow(int id_show,String langue) {
		
		PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
            String sql = "UPDATE Show SET langue_show=? WHERE ID_show=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,langue);
        	pstmt.setInt(2,id_show);
        	pstmt.executeUpdate();
            // 4- Recupérer l'Id généré par le SGBD
        	rs = pstmt.getGeneratedKeys();

        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
		return id_show;
	}
	
	//*******************************************************************
	public static int modifdateShow(int id_show,LocalDate annif) {
	
		PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
            String sql = "UPDATE Show SET DATE_DIFF=? WHERE ID_show=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1, annif);
        	pstmt.setInt(2, id_show);
        	pstmt.executeUpdate();
            // 4- Recupérer l'Id généré par le SGBD
        	rs = pstmt.getGeneratedKeys();

        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
		return id_show;
	    }
	//*********************************************************************
	public static int modifGenreShow(int id_show ,String genre) {
		PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
            String sql = "UPDATE Show SET GENRE=? WHERE ID_show=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, genre);
        	pstmt.setInt(2, id_show);
        	pstmt.executeUpdate();
            // 4- Recupérer l'Id généré par le SGBD
        	rs = pstmt.getGeneratedKeys();

        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
		return id_show;
	    }
	//**********************************************************************************
	public static int modifIsFilm(int id_show,int is_film) {
		
		PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
            String sql = "UPDATE Show SET is_film=? WHERE ID_show=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, is_film);
        	pstmt.setInt(2, id_show);
        	pstmt.executeUpdate();
            // 4- Recupérer l'Id généré par le SGBD
        	rs = pstmt.getGeneratedKeys();

        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
		return id_show;
	}
	
//**************************************FindALL************************************
	public static List<Show> findAll() throws SQLException{
		
		Statement stmt = null;
	    ResultSet rs = null;
	    
		List<Show> Shows = new ArrayList<>();

        String SQL = "SELECT * FROM Show";
        try {
        	stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {

            	int id_show = rs.getInt(1);
                String titre_show = rs.getString(2);
                LocalDate annif_show=rs.getObject(3,LocalDate.class);
                String Pays_show = rs.getString(4);
                String langue_show = rs.getString(5);
                int is_film = rs.getInt(6);
                String genre_show= rs.getString(7);
                String affiche_show=rs.getString(8);
               

                Show act = new Show(id_show, titre_show, annif_show, Pays_show, langue_show, genre_show, is_film,affiche_show);
                Shows.add(act);
            }
        } catch (Exception e ) {};
        
        return Shows;
	}
//************************************Suppression Show*************************************
	public static int supprimerShow(int id_show) {
		int showId = 0;
		PreparedStatement pstmt = null;
	    ResultSet rs = null;
        
        try {
            String sql = "DELETE FROM Show WHERE ID_show=?";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1,id_show );
            pstmt.executeUpdate();
         //4- Recupérer l'Id généré par le SGBD
        	rs = pstmt.getGeneratedKeys();
            
            if(rs.next())
            	showId = rs.getInt(1);
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
		return id_show;
	}
	//***********************************************
		public static int findIdShow(String titre) {
			PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    int id=0;
		    try {
	            String sql = "SELECT ID_show FROM Show WHERE titre_show=?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, titre);
	            rs = pstmt.executeQuery();
	            // 4- RecupÃƒÂ©rer l'Id gÃƒÂ©nÃƒÂ©rÃƒÂ© par le SGBD
	            while (rs.next()) {
	            	 id = rs.getInt(1);
	            	}
	        }catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
		    return id;
		}
//******************************************************* 
 
 public static List<Show> findAll2() throws SQLException{
		
		Statement stmt = null;
	    ResultSet rs = null;
	    
		List<Show> Shows = new ArrayList<>();

     String SQL = " SELECT Titre_show,image FROM Show ";
     try {
     	stmt = conn.createStatement();
         rs = stmt.executeQuery(SQL);

         while (rs.next()){
        	 String titre_show = rs.getString(1);
             String image= rs.getString(2);
             Show act = new Show(titre_show,image);
             Shows.add(act);
         }
     } catch (Exception e ) {};
     
     return Shows;
	}
 //***************************************************************
 public static Show findShow(String titre,String image2) throws SQLException{
	 PreparedStatement pstmt = null;
	    ResultSet rs = null;
		/*Statement stmt = null;
	    ResultSet rs = null;*/
	    Show sh = new Show();
  try {
      String SQL = " SELECT Titre_show,image FROM Show titre_show=? and image=? ";

  	pstmt = conn.prepareStatement(SQL);
    pstmt.setString(1, titre);
    pstmt.setString(2, image2);
      rs = pstmt.executeQuery();

      while (rs.next()){
     	 String titre_show = rs.getString(1);
          String image= rs.getString(2);
          sh = new Show(titre_show,image);
         
      }
  } catch (Exception e ) {};
  
 

return sh;
	}
 
//***************************retourne le nom d un show a partir de son id *************************************
	
public static String ShowTitre(int id_show) throws SQLException{
	
	PreparedStatement pstmt = null;
   ResultSet rs = null;
   String titre="";
  // List<Show> show = new ArrayList<>();
   String SQL = "SELECT Titre_show FROM show  where id_show=?";
   try {
   	pstmt = conn.prepareStatement(SQL);
       pstmt.setInt(1, id_show);
       rs = pstmt.executeQuery();

       while (rs.next()) {
       		 titre= rs.getString(1);
       }
   } 
   catch (Exception e ) {};
   return titre;
}



//***************************retourne l id d un show a partir de son nom *************************************

public static int idTitre(String titre) throws SQLException{
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  int id = 0;
  String SQL = "SELECT id_show FROM show WHERE titre_show = ?";
  try {
      pstmt = conn.prepareStatement(SQL);
      pstmt.setString(1, titre);
      rs = pstmt.executeQuery();

      if (rs.next()) {
          id = rs.getInt(1);
      }
  } catch (SQLException e) {
      e.printStackTrace();
  } finally {
      if (rs != null) {
          rs.close();
      }
      if (pstmt != null) {
          pstmt.close();
      }
  }
  return id;
}
 
 
 
 
	}