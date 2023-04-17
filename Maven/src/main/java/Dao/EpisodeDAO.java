
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Models.Episode;
import utile.conxBD;


public class EpisodeDAO {

	
	private static Connection conn = conxBD.getInstance();
	
	
	//****************************Ajouter Episode************************************
	   public static int ajouterEpisode(Episode Episode) {
			int EpisodeId = 0;
			System.out.println("-------connexion is "+conn);
			PreparedStatement pstmt = null;
		    ResultSet rs = null;
	        
	        try {
	        	String sql = "INSERT INTO Episode VALUES (?,?,?,?,?,?)";
	    		pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	        	System.out.println("coonexion is---------------------- "+conn);
	        	pstmt.setInt(1, Episode.getId_show());
	        	pstmt.setInt(2, Episode.getNum_saison());
	        	pstmt.setString(3, Episode.getTitre_ep());
	        	pstmt.setInt(4, Episode.getNum_ep());
	        	pstmt.setString(5, Episode.getDesc_ep());
	        	pstmt.setObject(6 , Episode.getDate_diff());
	        	
	          
	        
	        	pstmt.executeUpdate();
	        	
	            // 4- Recupérer l'Id généré par le SGBD
	        	rs = pstmt.getGeneratedKeys();
	            
	            if(rs.next())
	            	EpisodeId = rs.getInt(1);
	            
	        }catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	            
	        }
			return EpisodeId;
		}
	//*****************************Modification******************************
		public static int modifTitreEpisode(int id_Show,int num_Episode,int num_saison,String titre) {
			
			PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    try {
	            String sql = "UPDATE Episode SET nom_Ep=? WHERE ID_show=? And num_Episode=? and num_saison=?" ;
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, titre);
	        	pstmt.setInt(2, id_Show);
	        	pstmt.setInt(3, num_Episode);
	        	pstmt.setInt(4,num_saison);
	        	pstmt.executeUpdate();
	            // 4- Recupérer l'Id généré par le SGBD
	        	rs = pstmt.getGeneratedKeys();
	        }catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
			return id_Show;
		}
		
	//**********************************************************************************
		public static int modifNumEpisode(int id_Show,int num_Episode,int num_saison,int nbr) {
		
			PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    try {
	            String sql = "UPDATE Episode SET num_ep=? WHERE ID_Show=? and num_Episode=?,num_saison=?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1,nbr);
	        	pstmt.setInt(2,id_Show);
	        	pstmt.setInt(3,num_Episode);
	        	pstmt.setInt(4,num_saison);
	        	pstmt.executeUpdate();
	            // 4- Recupérer l'Id généré par le SGBD
	        	rs = pstmt.getGeneratedKeys();

	        }catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
			return id_Show;
		}
//**************************************************************************************
	public static int modifNumSaison(int id_Show,int num_Episode,int num_saison,int num) {

	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
	    String sql = "UPDATE Episode SET num_saison=? WHERE ID_Show=? and num_Episode=?,num_saison=?";
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setInt(1,num);
		pstmt.setInt(2,id_Show);
		pstmt.setInt(3,num_Episode);
		pstmt.setInt(4,num_saison);
		pstmt.executeUpdate();
	    // 4- Recupérer l'Id généré par le SGBD
		rs = pstmt.getGeneratedKeys();

	}catch (SQLException ex) {
	    System.out.println(ex.getMessage());
	}
	return id_Show ;
	}

//*******************************************************************
	public static int modifdateEpisode(int id_Show,int num_Episode,int num_saison,LocalDate annif) {

	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
	    String sql = "UPDATE Episode SET DATE_DIFF=? WHERE ID_Show=?,num_Episode=?,num_saison=?";
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setObject(1, annif);
		pstmt.setInt(2, id_Show);
		pstmt.setInt(3, num_Episode);
		pstmt.setInt(4, num_saison);
		pstmt.executeUpdate();
	    // 4- Recupérer l'Id généré par le SGBD
		rs = pstmt.getGeneratedKeys();

	}catch (SQLException ex) {
	    System.out.println(ex.getMessage());
	}
	return id_Show;
	}
	//*********************************************************************
	public static int modifDescrip(int id_Show,int num_Episode ,String desc) {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
	    String sql = "UPDATE Episode SET desc_Episode_s=? WHERE ID_Show=?,num_Episode=?";
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1,desc);
		pstmt.setInt(2,id_Show);
		pstmt.setInt(3,num_Episode);
		pstmt.executeUpdate();
	    // 4- Recupérer l'Id généré par le SGBD
		rs = pstmt.getGeneratedKeys();

	}catch (SQLException ex) {
	    System.out.println(ex.getMessage());
	}
	return id_Show;
	}
	//***********************************FindALL************************************
		public static List<Episode> findAll() throws SQLException{
			
			Statement stmt = null;
		    ResultSet rs = null;
		    
			List<Episode> Shows = new ArrayList<>();

	      String SQL = "SELECT * FROM Episode";
	      try {
	      	stmt = conn.createStatement();
	          rs = stmt.executeQuery(SQL);

	          while (rs.next()) {

	          	  int id_show = rs.getInt(1);
	          	  int Pays_show = rs.getInt(2);
	              String titre_show = rs.getString(3);
	              int langue_show = rs.getInt(4);
	              String genre_show= rs.getString(5);
	              LocalDate annif_show=rs.getObject(6,LocalDate.class);
	              
	              Episode act = new Episode(id_show, Pays_show, titre_show, langue_show, genre_show, annif_show);
	              Shows.add(act);
	          }
	      } catch (Exception e ) {};
	      
	      return Shows;
		}
	//************************************Suppression Show*************************************
			public static int supprimerEpisode(int id_show,int num_Episode,int num_saison) {
				int showId = 0;
				PreparedStatement pstmt = null;
			    ResultSet rs = null;
		        
		        try {
		            String sql = "DELETE FROM episode WHERE ID_show=?,Num_Episode=?,num_saisom=?";
		            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		            pstmt.setInt(1,id_show );
		            pstmt.setInt(2,num_Episode);
		            pstmt.setInt(3,num_saison);
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
	//*****************************************************************************************
			public static Episode FindEp(int id_show) throws SQLException{
				
				Statement stmt = null;
			    ResultSet rs = null;
			    
				Episode EP = new Episode();

		      String SQL = "SELECT num_ep,num_saison FROM Episode where id_show=?";
		      try {
		      	stmt = conn.createStatement();
		          rs = stmt.executeQuery(SQL);

		          while (rs.next()) {
		        	  int num_ep = rs.getInt(1);
			           int num_saison = rs.getInt(2);
		              EP=new Episode( num_saison, num_ep);
		          }
		      } catch (Exception e ) {};
		      
		      return EP;
			}
	
	
	
}
