package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Models.Saison;
import Models.Show;
import utile.conxBD;


public class SaisonDao {

	private static Connection conn = conxBD.getInstance();
	
//****************************Ajouter Saison************************************
   public static int ajouterSaison(Saison Saison) {
		int SaisonId = 0;
		System.out.println("-------connexion is "+conn);
		PreparedStatement pstmt = null;
	    ResultSet rs = null;
        
        try {
        	String sql = "INSERT INTO Saison VALUES (?,?,?,?,?,?)";
    		pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        	System.out.println("coonexion is---------------------- "+conn);
        	pstmt.setInt(1, Saison.getId_show());
        	pstmt.setString(2, Saison.getTitre_saison());
        	pstmt.setInt(3, Saison.getNbEpisode());
        	pstmt.setInt(4, Saison.getNumSaison());
        	pstmt.setObject(5, Saison.getDate_diffusion());
        	pstmt.setString(6, Saison.getDesc_saison());
           
        
        	pstmt.executeUpdate();
        	
            // 4- Recupérer l'Id généré par le SGBD
        	rs = pstmt.getGeneratedKeys();
            
            if(rs.next())
            	SaisonId = rs.getInt(1);
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
		return SaisonId;
	}
//*****************************Modification******************************
	public static int modifTitreSaison(int id_Show,int num_saison,String titre) {
		
		PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
            String sql = "UPDATE Saison SET titre_Saison=? WHERE ID_show=? And num_saison=?" ;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, titre);
        	pstmt.setInt(2, id_Show);
        	pstmt.setInt(3, num_saison);
        	pstmt.executeUpdate();
            // 4- Recupérer l'Id généré par le SGBD
        	rs = pstmt.getGeneratedKeys();

        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
		return id_Show;
	}
	
//**********************************************************************************
	public static int modifNbrEpisode(int id_Show,int num_saison,int nbr) {
	
		PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
            String sql = "UPDATE Saison SET nb_ep_s=? WHERE ID_Show=? and num_saison=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,nbr);
        	pstmt.setInt(2,id_Show);
        	pstmt.setInt(3,num_saison);
        	pstmt.executeUpdate();
            // 4- Recupérer l'Id généré par le SGBD
        	rs = pstmt.getGeneratedKeys();

        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
		return id_Show;
	}

//**************************************************************************************
public static int modifNumSaison(int id_Show,int num_saison,int num) {

PreparedStatement pstmt = null;
ResultSet rs = null;
try {
    String sql = "UPDATE Saison SET num_saison=? WHERE ID_Show=? and num_saison=?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setInt(1,num);
	pstmt.setInt(2,id_Show);
	pstmt.setInt(3,num_saison);
	pstmt.executeUpdate();
    // 4- Recupérer l'Id généré par le SGBD
	rs = pstmt.getGeneratedKeys();

}catch (SQLException ex) {
    System.out.println(ex.getMessage());
}
return id_Show ;
}

//*******************************************************************
public static int modifdateSaison(int id_Show,int num_saison,LocalDate annif) {

PreparedStatement pstmt = null;
ResultSet rs = null;
try {
    String sql = "UPDATE Saison SET DATE_DIFF=? WHERE ID_Show=?,num_saison=?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setObject(1, annif);
	pstmt.setInt(2, id_Show);
	pstmt.setInt(3, num_saison);
	pstmt.executeUpdate();
    // 4- Recupérer l'Id généré par le SGBD
	rs = pstmt.getGeneratedKeys();

}catch (SQLException ex) {
    System.out.println(ex.getMessage());
}
return id_Show;
}
//*********************************************************************
public static int modifDescrip(int id_Show,int num_saison ,String desc) {
PreparedStatement pstmt = null;
ResultSet rs = null;
try {
    String sql = "UPDATE Saison SET desc_saison_s=? WHERE ID_Show=?,num_saison=?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1,desc);
	pstmt.setInt(2,id_Show);
	pstmt.setInt(3,num_saison);
	pstmt.executeUpdate();
    // 4- Recupérer l'Id généré par le SGBD
	rs = pstmt.getGeneratedKeys();

}catch (SQLException ex) {
    System.out.println(ex.getMessage());
}
return id_Show;
}
//**************************************FindALL************************************
	public static List<Saison> findAll() throws SQLException{
		
		Statement stmt = null;
	    ResultSet rs = null;
	    
		List<Saison> Shows = new ArrayList<>();

      String SQL = "SELECT * FROM Saison";
      try {
      	stmt = conn.createStatement();
          rs = stmt.executeQuery(SQL);

          while (rs.next()) {

          	int id_show = rs.getInt(1);
              String titre_show = rs.getString(2);
              
              int Pays_show = rs.getInt(3);
              int langue_show = rs.getInt(4);
              LocalDate annif_show=rs.getObject(5,LocalDate.class);
              String genre_show= rs.getString(6);
              Saison act = new Saison(id_show, titre_show, Pays_show, langue_show, annif_show, genre_show);
              Shows.add(act);
          }
      } catch (Exception e ) {};
      
      return Shows;
	}
//************************************Suppression Show*************************************
		public static int supprimerSaison(int id_show,int num_saison) {
			int showId = 0;
			PreparedStatement pstmt = null;
		    ResultSet rs = null;
	        
	        try {
	            String sql = "DELETE FROM Show WHERE ID_show=?,Num_Saison=?";
	            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	            pstmt.setInt(1,id_show );
	            pstmt.setInt(2,num_saison);
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
	
	
		//**************************************description de saison 1 cad film************************************
		public static String getDescrip(int id) throws SQLException {
		    String SQL = "SELECT DESC_SAISON_S FROM Saison WHERE ID_SHOW=? AND Num_SAISON=1";
		    String descp = "";
		    
		    try (PreparedStatement stmt = conn.prepareStatement(SQL)) {
		        stmt.setInt(1, id);
		        ResultSet rs = stmt.executeQuery();

		        if (rs.next()) {
		            descp = rs.getString(1);
		        }
		    } catch (SQLException e) {
		        throw e;
		    } 
		    
		    
		    return descp;
		}

	
}
