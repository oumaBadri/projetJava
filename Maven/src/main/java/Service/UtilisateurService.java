package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import Dao.ActeurDAO;
import Dao.UtilisateurDAO;
import Models.Acteur;
import Models.Producteur;
import Models.Utilisateur;
import utile.conxBD;

public class UtilisateurService {
	private static Connection conn = conxBD.getInstance();

	public static int AjoutUtilisateur(Utilisateur user ) {
		int idpro=0;
		idpro=UtilisateurDAO.ajouterUtilisateur(user);
		return idpro;
		}
	
//-----si l'email exist --> return true
		public static boolean exitUtilisateurWithEmail(String email) {
			List<Utilisateur> User=null;
			try {
				User=UtilisateurDAO.findAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			boolean result = User.stream()
	                .anyMatch(str -> str.getEmail_user().equals(email));
			return result;
		}
		public static boolean exitUtilisateurWithMdp(String email) {
			List<Utilisateur> User=null;
			try {
				User=UtilisateurDAO.findAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			boolean result = User.stream()
	                .anyMatch(str -> str.getMdp_user().equals(email));
			return result;
		}
		
		
		public static boolean login(String email, String mdp) {
			boolean iduser;
			iduser=UtilisateurDAO.login(email, mdp);
			return iduser;
			
		}
	
	
	
	
		//***********************Modification***********************
		
	    public static int modifNomUser(int id, String nom) {
	    	if(Dao.UtilisateurDAO.verifierId(id)) {
	        return UtilisateurDAO.modifNomUtilisateur(id, nom);
	    }
	    	else {
	    		System.out.println("Id n existe pas");
	    		return 0;
	    	}
	    }


//********************************************
	    public static int modifPrenomUser(int id, String prenom) {
	    	if(Dao.UtilisateurDAO.verifierId(id)) {
	        return UtilisateurDAO.modifPrenomUtilisateur(id, prenom);
	    }
	    	else {
	    		System.out.println("Id n existe pas");
	    		return 0;
	    	}
	    }
	  //********************************************
	    public static int modifMdpUser(int id, String mdp) {
	    	if(Dao.UtilisateurDAO.verifierId(id)) {
	        return UtilisateurDAO.modifMdpUtilisateur(id, mdp);
	    }
	    	else {
	    		System.out.println("Id n existe pas");
	    		return 0;
	    	}
	    }
	    
	  //********************************************
	    public static int modifAnnifUser(int id, LocalDate annif) {
	    	if(Dao.UtilisateurDAO.verifierId(id)) {
	        return UtilisateurDAO.modifAnnifUser(id, annif);
	    }
	    	else {
	    		System.out.println("Id n existe pas");
	    		return 0;
	    	}
	    }	
	    
	    
	    //*******************Supprimer user********************
	    public static int supprimerUser(int id_Ac) {
	    	if(Dao.UtilisateurDAO.verifierId(id_Ac)) {
	    		return UtilisateurDAO.supprimerUtilisateur(id_Ac);
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
	            String sql= "SELECT * FROM UTILISATEUR WHERE ID_USER=? AND MDP_USER=?";
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

	    //*****verif id****************
		  //-----si l'email exist --> return true
			public static boolean verifId(int id) {
				List<Utilisateur> acteurs=null;
				try {
					acteurs=Dao.UtilisateurDAO.findAll();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				boolean result = acteurs.stream()
		                .anyMatch(str -> str.getId_user()==id);
				return result;
			}
	
	
	
	
	
}
