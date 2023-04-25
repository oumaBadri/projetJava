package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import Dao.AdminDao;
import Dao.ProducteurDAO;
import Dao.UtilisateurDAO;
import Models.Admin;
import Models.Producteur;
import Models.Utilisateur;
import javafx.event.ActionEvent;
import utile.conxBD;

public class ProducteurService {
	
	private static Connection conn = conxBD.getInstance();

	//*****ajout pro********************
	public static int ajouterProducteur(Producteur producteur) {
		int idpro=0;
		idpro=Dao.ProducteurDAO.ajouterProducteur(producteur);
		return idpro;	
	}
//*******pro with email**********
	/*public static boolean exitProducteurWithEmail(String email) {
		List<Producteur> producteurs=null;
		try {
			producteurs=Dao.ProducteurDAO.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		boolean result = producteurs.stream()
                .anyMatch(str -> str.getEmail().equals(email));
		return result;
	}*/
	
	
	
	//*************************loginn***********************
		public static boolean login(String email, String mdp) {
			boolean iduser;
			iduser=ProducteurDAO.login(email, mdp);
			return iduser;
			
		}
		
		
		//***********************Modification***********************
		
	    public static int modifNomPro(int id, String nom) {
	    	if(ProducteurDAO.verifierId(id)) {
	        return ProducteurDAO.modifNomProducteur(id, nom);
	    }
	    	else {
	    		System.out.println("Id n existe pas");
	    		return 0;
	    	}
	    }


//********************************************
	    public static int modifPrenomPro(int id, String prenom) {
	    	if(ProducteurDAO.verifierId(id)) {
	        return ProducteurDAO.modifPrenomProducteur(id, prenom);
	    }
	    	else {
	    		System.out.println("Id n existe pas");
	    		return 0;
	    	}
	    }
	  //********************************************
	    public static int modifMdpPro(int id, String mdp) {
	    	if(ProducteurDAO.verifierId(id)) {
	        return ProducteurDAO.modifMdpProducteur(id, mdp);
	    }
	    	else {
	    		System.out.println("Id n existe pas");
	    		return 0;
	    	}
	    }
	    
	  //********************************************
	    public static int modifAnnifPro(int id, LocalDate annif) {
	    	if(ProducteurDAO.verifierId(id)) {
	        return ProducteurDAO.modifAnnifProducteur(id, annif);
	    }
	    	else {
	    		System.out.println("Id n existe pas");
	    		return 0;
	    	}
	    }	
	    
	    
	    //*******************Supprimer Admin********************
	    public static int supprimerPro(int id_Ac) {
	    	if(ProducteurDAO.verifierId(id_Ac)) {
	    		return ProducteurDAO.supprimerProducteur(id_Ac);
	    	}
	    	else {
	    		System.out.println("Id n existe pas");
	    		return 0;
	    	}
	    }
	    
	    //******verif ancien mdp*********
	    public static boolean verifAncienMDP(int id, String ancienMDP) {
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        boolean result = false;
	        try {
	            String sql= "SELECT * FROM producteur WHERE ID_p=? AND MDP=?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, id);
	            pstmt.setString(2, ancienMDP);
	            rs = pstmt.executeQuery();
	            if (rs.next()) {
	                System.out.println("Ancien mot de passe correct");
	                result = true;
	            } else {
	                System.out.println("Ancien mot de passe incorrect");
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        } 
	        return result;
	    }

	    
	    
	    
	    ///**********************
	    public static boolean exitProWithEmail(String email) {
			List<Producteur> User=null;
			try {
				User=ProducteurDAO.findAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			boolean result = User.stream()
	                .anyMatch(str -> str.getEmail().equals(email));
			
			
			return result;
		}
	    
	    
		public static boolean exitProWithMdp(String email) {
			List<Producteur> User=null;
			try {
				User=ProducteurDAO.findAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			boolean result = User.stream()
	                .anyMatch(str -> str.getMdp().equals(email));
			return result;
		}
		
	

		//*****verif id****************
	  //-----si l'email exist --> return true
		public static boolean verifId(int id) {
			List<Producteur> Admins=null;
			try {
				Admins=ProducteurDAO.findAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			boolean result = Admins.stream()
	                .anyMatch(str -> str.getId_p()==id);
			return result;
		}
		
}