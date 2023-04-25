package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Models.Acteur;
import Models.Admin;
import Models.Producteur;
import utile.conxBD;


public class ProducteurDAO {
	
	// Connection
				private static Connection conn = conxBD.getInstance();
				
				//login
				public static boolean login(String mail, String mdp) {
				    PreparedStatement pstmt = null;
				    ResultSet rs = null;
				    try {
				        String sql= "SELECT * FROM PRODUCTEUR WHERE EMAIL=? AND MDP=?";
				        pstmt = conn.prepareStatement(sql);
				        pstmt.setString(1, mail);
				        pstmt.setString(2, mdp);
				        rs = pstmt.executeQuery();
				        if (rs.next()) {
				            System.out.println("Login avec succÃ¨s");
				            return true;
				        } else {
				            System.out.println("Veuillez vÃ©rifier vos coordonnÃ©es!");
				            return false;
				        }
				    } catch (SQLException ex) {
				        System.out.println(ex.getMessage());
				        return false;
				    } 
				} 
				
				///login
				
				
				
				////************************Ajouter Producteur*********************************
				public static int ajouterProducteur(Producteur producteur) {
					int ProducteurId = 0;
					System.out.println("-------connexion is "+conn);
					PreparedStatement pstmt = null;
				    ResultSet rs = null;
			        
			        try {
			        	String sql = "INSERT INTO PRODUCTEUR VALUES (?,?,?,?,?,?)";
		        		pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			        	System.out.println("coonexion is---------------------- "+conn);
			        	pstmt.setInt(1, producteur.getId_p());
			        	pstmt.setString(2, producteur.getNom_p());
			        	pstmt.setString(3, producteur.getPrenom_p());
			        	pstmt.setObject(4, producteur.getDate_naissance_ac());
			        	pstmt.setString(5, producteur.getEmail());
			        	pstmt.setString(6, producteur.getMdp());
			        	pstmt.executeUpdate();
			        	
			            // 4- RecupÃ©rer l'Id gÃ©nÃ©rÃ© par le SGBD
			        	rs = pstmt.getGeneratedKeys();
			            
			            if(rs.next())
			            	ProducteurId = rs.getInt(1);
			            
			        }catch (SQLException ex) {
			            System.out.println(ex.getMessage());
			        }
					return ProducteurId;
				}
				
				
				//****************************************************************************
				//Modification Acteurr
				public static int modifNomProducteur(int id_P,String nom) {
					int ProId = 0;
					PreparedStatement pstmt = null;
				    ResultSet rs = null;
				    try {
			            String sql = "UPDATE PRODUCTEUR SET NOM_P=? WHERE ID_P=?";
			            pstmt = conn.prepareStatement(sql);
			            pstmt.setString(1, nom);
			        	pstmt.setInt(2, id_P);
			        	pstmt.executeUpdate();
			            // 4- RecupÃ©rer l'Id gÃ©nÃ©rÃ© par le SGBD
			        	rs = pstmt.getGeneratedKeys();
			        	return id_P;
			        }catch (SQLException ex) {
			            System.out.println(ex.getMessage());
			            return ProId ;
			        }
					
				}
				
				
				
				
				//********************verifier id**************************
				 public static boolean verifierId(int id) {
				        boolean existe = false;
				        PreparedStatement pstmt = null;
				        ResultSet rs = null;
				        try {
				            String sql = "SELECT * FROM Producteur WHERE ID_P=?";
				            pstmt = conn.prepareStatement(sql);
				            pstmt.setInt(1, id);
				            rs = pstmt.executeQuery();
				            if (rs.next()) {
				                existe = true;
				            }
				        } catch (SQLException ex) {
				            System.out.println(ex.getMessage());
				        }
				        return existe;
				    }
				
				
				
				//****************************************************************
				public static int modifPrenomProducteur(int id_P,String prenom) {
					int ProId = 0;
					PreparedStatement pstmt = null;
				    ResultSet rs = null;
				    try {
			            String sql = "UPDATE PRODUCTEUR SET PRENOM_P=? WHERE ID_P=?";
			            pstmt = conn.prepareStatement(sql);
			            pstmt.setString(1, prenom);
			        	pstmt.setInt(2, id_P);
			        	pstmt.executeUpdate();
			            // 4- RecupÃ©rer l'Id gÃ©nÃ©rÃ© par le SGBD
			        	rs = pstmt.getGeneratedKeys();
			        	return id_P;

			        }catch (SQLException ex) {
			            System.out.println(ex.getMessage());
			        }
					return ProId;
				}
				
				
				//**********************************************************
				public static int modifMdpProducteur(int id_P,String mdp) {
					int ProId = 0;
					PreparedStatement pstmt = null;
				    ResultSet rs = null;
				    try {
			            String sql = "UPDATE PRODUCTEUR SET MDP=? WHERE ID_P=?";
			            pstmt = conn.prepareStatement(sql);
			            pstmt.setString(1, mdp);
			        	pstmt.setInt(2,id_P);
			        	pstmt.executeUpdate();
			            // 4- RecupÃ©rer l'Id gÃ©nÃ©rÃ© par le SGBD
			        	rs = pstmt.getGeneratedKeys();
			        	return id_P;
			        }catch (SQLException ex) {
			            System.out.println(ex.getMessage());
			        }
					return ProId;
				}
				
				//************************************************************
				public static int modifAnnifProducteur(int id_P,LocalDate annif) {
					int ProId = 0;
					PreparedStatement pstmt = null;
				    ResultSet rs = null;
				    try {
			            String sql = "UPDATE PRODUCTEUR SET DATE_NAISSANCE_P=? WHERE ID_ACTEUR=?";
			            pstmt = conn.prepareStatement(sql);
			            pstmt.setObject(1, annif);
			        	pstmt.setInt(2, id_P);
			        	pstmt.executeUpdate();
			            // 4- RecupÃ©rer l'Id gÃ©nÃ©rÃ© par le SGBD
			        	rs = pstmt.getGeneratedKeys();
			        	return id_P;
			        }catch (SQLException ex) {
			            System.out.println(ex.getMessage());
			        }
					return ProId;
				    }
				
				
			
				
				//FindALL
				public static List<Producteur> findAll() throws SQLException{
					
					Statement stmt = null;
				    ResultSet rs = null;
				    
					List<Producteur> producteurs = new ArrayList<>();

			        String SQL = "SELECT id_p,nom_p,prenom_p,date_naissance_p,email,mdp FROM PRODUCTEUR";
			        try {
			        	stmt = conn.createStatement();
			            rs = stmt.executeQuery(SQL);

			            while (rs.next()) {

			            	int id_p = rs.getInt(1);
			                String Nom_p = rs.getString(2);
			                String Prenom_p = rs.getString(3);
			                String email = rs.getString(5);
			                String mdp = rs.getString(6);
			                LocalDate annif_p=rs.getObject(4,LocalDate.class);
			               

			                Producteur prod = new Producteur(id_p, Nom_p, Prenom_p,email,mdp,annif_p);
			                producteurs.add(prod);
			            }
			        } catch (Exception e ) {};
			        
			        return producteurs;
				}
		
				
				
				
				//Suppression Acteur
				public static int supprimerProducteur(int id_p) {
					int ProId = 0;
					PreparedStatement pstmt = null;
				    ResultSet rs = null;
			        
			        try {
			            String sql = "DELETE FROM PRODUCTEUR WHERE ID_P=?";
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

				
				
				public static  Producteur getPro(String mail) {
					//Statement stmt = null;
					Producteur ab= new Producteur();
					//int id=0;
				    ResultSet rs = null;
				    PreparedStatement pstmt = null;

			        String SQL = "SELECT id_p,nom_p,prenom_p,date_naissance_p FROM Producteur WHERE EMAIL=?";
			        try {
			        	System.out.println("+++++++++++++");
			        	pstmt = conn.prepareStatement(SQL);
				        pstmt.setString(1,mail);
				        rs = pstmt.executeQuery();
				        
				       while (rs.next()) {
				        	int id = rs.getInt(1);
			                String nom = rs.getString(2);
			                String prenom = rs.getString(3);
			                LocalDate annif=rs.getObject(4,LocalDate.class);
			                System.out.println("**********");
				          //  ab = new Admin(id, nom, prenom,annif);
			              ab.setId_p(id);
			              ab.setNom_p(nom);
			              ab.setPrenom_p(prenom);
			              ab.setDate_naissance_ac(annif);
			             }
				        
				      
				    } catch (SQLException ex) {
				        System.out.println(ex.getMessage());
			        }
					return ab;
			       }
				
				
		
		
		
}
