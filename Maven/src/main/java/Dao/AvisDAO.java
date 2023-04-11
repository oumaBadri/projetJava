package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Models.Avis;
import utile.conxBD;


public class AvisDAO {

private static Connection conn = conxBD.getInstance();
	


//**********************************Ajouter Avis************************************
	   public static int ajouterAvis(Avis Avis) {
			int AvisId = 0;
			System.out.println("-------connexion is "+conn);
			PreparedStatement pstmt = null;
		    ResultSet rs = null;
	        
	        try {
	        	String sql = "INSERT INTO Avis (id_user,id_show,note,commentaire,num_ep,num_saison) VALUES (?,?,?,?,?,?)";
	    		pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	        	System.out.println("coonexion is---------------------- "+conn);
	            pstmt.setInt(1,Avis.getId_user());
	        	pstmt.setInt(2,Avis.getId_show());
	        	pstmt.setInt(3,Avis.getNote());
	        	pstmt.setString(4,Avis.getCommantaire());
	            pstmt.setInt(5,Avis.getNum_ep());
	        	pstmt.setInt(6,Avis.getNum_saison());
	        	
	        	
	             int rs1 =pstmt.executeUpdate();
	        	
	            // 4- Recupérer l'Id généré par le SGBD
	        	rs = pstmt.getGeneratedKeys();
	            
	            if(rs.next())
	            	AvisId = rs.getInt(1);
	        } catch (SQLIntegrityConstraintViolationException ex) {
	            System.out.println("Cannot insert duplicate ID.");
	        }catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	            
	        }
			return AvisId;
		}

	 
	   
//******************************Modification******************************
		public static int modifNote(int id_Show,int num_ep,int num_saison,int id_user,int note) {
			
			PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    try {
	            String sql = "UPDATE Avis SET note=? WHERE ID_show=? And num_ep=? and num_saison=? and id_user=?" ;
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1,note);
	        	pstmt.setInt(2, id_Show);
	        	pstmt.setInt(3, num_ep);
	        	pstmt.setInt(4,num_saison);
	        	pstmt.setInt(5,id_user);
	        	pstmt.executeUpdate();
	            // 4- Recupérer l'Id généré par le SGBD
	        	rs = pstmt.getGeneratedKeys();
	        }catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
			return id_Show;
		}
		
	//**********************************************************************************
       public static int modifCom(int id_Show,int num_ep,int num_saison,int id_user,String com) {
			
			PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    try {
	            String sql = "UPDATE Avis SET commentaire=?"
	            		+ " WHERE ID_show=? AND num_ep=? AND num_saison=? AND id_user=? AND commentaire IS NOT NULL" ; 
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1,com);
	        	pstmt.setInt(2, id_Show);
	        	pstmt.setInt(3, num_ep);
	        	pstmt.setInt(4,num_saison);
	        	pstmt.setInt(5,id_user);
	        	pstmt.executeUpdate();
	            // 4- Recupérer l'Id généré par le SGBD
	        	rs = pstmt.getGeneratedKeys();
	        }catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
			return id_Show;
		}
//**************************************************************************************
       public static int modifFavoriShow(int id_Show,int num_ep,int num_saison,int id_user) {
			
			PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    try {
	            String sql = "UPDATE Avis SET favoris_show=1 WHERE ID_show=? And num_ep=? and num_saison=? and id_user=?" ;
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, id_Show);
	        	pstmt.setInt(2, num_ep);
	        	pstmt.setInt(3,num_saison);
	        	pstmt.setInt(4,id_user);
	        	pstmt.executeUpdate();
	            // 4- Recupérer l'Id généré par le SGBD
	        	rs = pstmt.getGeneratedKeys();
	        }catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
			return id_Show;
		}

     //************************************Suppression Show*************************************
			public static int supprimerNote(int id_Show,int num_ep,int num_saison,int id_user) {
				int showId = 0;
				PreparedStatement pstmt = null;
			    ResultSet rs = null;
		        
		        try {
		            String sql = "UPDATE Avis SET note=0 WHERE ID_show=? and Num_ep=? and num_saison=? and id_user=?";
		            pstmt = conn.prepareStatement(sql);
		            pstmt.setInt(1, id_Show);
		        	pstmt.setInt(2, num_ep);
		        	pstmt.setInt(3,num_saison);
		        	pstmt.setInt(4,id_user);
		        	pstmt.executeUpdate();
		            // 4- Recupérer l'Id généré par le SGBD
		        	rs = pstmt.getGeneratedKeys();
		        }catch (SQLException ex) {
		            System.out.println(ex.getMessage());
		        }
				return id_Show;
			}
	//*********************************************************************************************
			public static int supprimerCom(int id_Show,int num_ep,int num_saison,int id_user) {
				int showId = 0;
				PreparedStatement pstmt = null;
			    ResultSet rs = null;
		        
		        try {
		            String sql = "UPDATE Avis SET commentaire=null WHERE ID_show=? and Num_ep=? and num_saison=? and id_user=?";
		            pstmt = conn.prepareStatement(sql);
		        	pstmt.setInt(1, id_Show);
		        	pstmt.setInt(2, num_ep);
		        	pstmt.setInt(3,num_saison);
		        	pstmt.setInt(4,id_user);
		        	pstmt.executeUpdate();
		            // 4- Recupérer l'Id généré par le SGBD
		        	rs = pstmt.getGeneratedKeys();
		        }catch (SQLException ex) {
		            System.out.println(ex.getMessage());
		        }
				return id_Show;
			}
	
	
}
