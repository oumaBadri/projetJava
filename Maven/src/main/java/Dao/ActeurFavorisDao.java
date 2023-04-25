package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Models.ActeurFavoris;
import utile.conxBD;


public class ActeurFavorisDao {

	
	private static Connection conn = conxBD.getInstance();

	
	//************************************ajouter role***************************
		 public static int ajouterActeurFavoris(ActeurFavoris role) throws SQLException {
		        PreparedStatement pstmt = null;
		        ResultSet rs = null;
		        int code = 0;
 
		        try {
		            String sql = "INSERT INTO ActeurFavoris VALUES (?,?)";
		            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		            pstmt.setInt(1, role.getId_user());
		            pstmt.setInt(2, role.getId_acteur());
		          
		         
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
		 public static int supprimerActeurFavoris(int id_p) {
				int ProId = 0;
				PreparedStatement pstmt = null;
			    ResultSet rs = null;
		        
		        try {
		            String sql = "DELETE FROM ActeurFavoris WHERE ID_acteur=?";
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
		 public static int modifIdUser(int id_show,int id_acteur) {
				
				PreparedStatement pstmt = null;
			    ResultSet rs = null;
			    try {
		            String sql = "UPDATE ActeurFavoris SET id_user=? WHERE ID_user=?,id_acteur=?";
		            pstmt = conn.prepareStatement(sql);
		            pstmt.setInt(1,id_show);
		        	pstmt.setInt(2,id_acteur);
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
		            String sql = "UPDATE ActeurFavoris SET id_acteur=? WHERE ID_user=?,id_acteur=?";
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
				public static List<ActeurFavoris> findAll() throws SQLException{
					
					Statement stmt = null;
				    ResultSet rs = null;
				    
					List<ActeurFavoris> roles = new ArrayList<>();
					String SQL = "SELECT * FROM roleprincipal";
			        try {
			        	stmt = conn.createStatement();
			            rs = stmt.executeQuery(SQL);

			            while (rs.next()) {
			            	
			            	int id_user = rs.getInt(1);
			                int id_ac= rs.getInt(2);
			               
			            	
			                ActeurFavoris rol = new ActeurFavoris(id_user, id_ac);
			                roles.add(rol);
			            }
			        } catch (Exception e ) {};
			        
			        return roles;
				}
	
	//********************************************************************************
	
}
