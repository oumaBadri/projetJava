package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Models.RolePrincipale;
import utile.conxBD;

public class RolePrincipaleDAO {

private static Connection conn = conxBD.getInstance();

	
//************************************ajouter role***************************
	 public static int ajouterRole(RolePrincipale role) throws SQLException {
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        int code = 0;

	        try {
	            String sql = "INSERT INTO roleprincipal VALUES (?,?,?)";
	            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	            pstmt.setInt(1, role.getId_show());
	            pstmt.setInt(2, role.getId_acteur());
	            pstmt.setInt(3, role.getNum_saison());
	         
	            pstmt.executeUpdate();

	            rs = pstmt.getGeneratedKeys();

	            if (rs.next()) {
	                code = rs.getInt(1);
	            }

	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        } 

	        return code;
	    }
//*******************************supprimer role*************************************************
	 public static int supprimerRoleP(int id_p) {
			int ProId = 0;
			PreparedStatement pstmt = null;
		    ResultSet rs = null;
	        
	        try {
	            String sql = "DELETE FROM roleprincipal WHERE ID_acteur=?";
	            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	            pstmt.setInt(1,id_p);
	            pstmt.executeUpdate();
	         // 4- RecupÃ©rer l'Id gÃ©nÃ©rÃ© par le SGBD
	        	rs = pstmt.getGeneratedKeys();
	            
	            if(rs.next())
	            	ProId = rs.getInt(1);
	            }catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
			return id_p;
		}
//********************************modifier***************************************************
	 public static int modifIdShow(int id_show,int id_acteur,int num_saison) {
			
			PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    try {
	            String sql = "UPDATE roleprincipal SET id_show=? WHERE ID_show=?,id_acteur=?,num_saison=?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1,id_show);
	        	pstmt.setInt(2,id_acteur);
	        	pstmt.setInt(3, num_saison);
	        	pstmt.executeUpdate();
	            // 4- Recupérer l'Id généré par le SGBD
	        	rs = pstmt.getGeneratedKeys();

	        }catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
			return id_show;
		}
	 
//*********************************************************************************************
	 public static int modifIdActeur(int id_show,int id_acteur,int num_saison) {
			
			PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    try {
	            String sql = "UPDATE roleprincipal SET id_acteur=? WHERE ID_show=?,id_acteur=?,num_saison=?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1,id_show);
	        	pstmt.setInt(2,id_acteur);
	        	pstmt.setInt(3, num_saison);
	        	pstmt.executeUpdate();
	            // 4- Recupérer l'Id généré par le SGBD
	        	rs = pstmt.getGeneratedKeys();

	        }catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
			return id_show;
		}
//*****************************************************************************************************************	 
	 public static int modifNumSaison(int id_show,int id_acteur,int num_saison) {
			
			PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    try {
	            String sql = "UPDATE roleprincipal SET num_saison=? WHERE ID_show=?,id_acteur=?,num_saison=?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1,id_show);
	        	pstmt.setInt(2,id_acteur);
	        	pstmt.setInt(3, num_saison);
	        	pstmt.executeUpdate();
	            // 4- Recupérer l'Id généré par le SGBD
	        	rs = pstmt.getGeneratedKeys();

	        }catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
			return id_show;
		}
//**********************************find all role*********************************
			public static List<RolePrincipale> findAll() throws SQLException{
				
				Statement stmt = null;
			    ResultSet rs = null;
			    
				List<RolePrincipale> roles = new ArrayList<>();
				String SQL = "SELECT * FROM roleprincipal";
		        try {
		        	stmt = conn.createStatement();
		            rs = stmt.executeQuery(SQL);

		            while (rs.next()) {
		            	
		            	int id_show = rs.getInt(1);
		                int id_ac= rs.getInt(2);
		                int numSaison = rs.getInt(3);
		            	
		                RolePrincipale rol = new RolePrincipale(id_show, id_ac, numSaison);
		                roles.add(rol);
		            }
		        } catch (Exception e ) {};
		        
		        return roles;
			}
}
