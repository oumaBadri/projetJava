package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import Dao.ActeurDAO;
import Dao.AdminDao;
import Dao.UtilisateurDAO;
import Models.Acteur;
import Models.Utilisateur;
import utile.conxBD;

public class ActeurService {
	
	private static Connection conn = conxBD.getInstance();
	public static void ajouterActeur(Acteur acteur) throws SQLException {
		 String l=acteur.getMail_ac();
		if( Dao.ActeurDAO.RechercherParEmail(l)!=0) {
			System.out.println("Compte deja existant");
			return ;
			}
		else {
				if(Controller.ActeurControl.verifierMdp(acteur.getMdp_ac())){
			Dao.ActeurDAO.ajouterActeur(acteur);
			System.out.println("Ajout avec succés");
		}
		
		}
		
	}
	
	
	//*************************loginn***********************
	public static  boolean login(String mail, String mdp) throws SQLException {
	    
	    boolean iduser;
		iduser=ActeurDAO.login(mail, mdp);
		return iduser;
	}
	
	
	
	//***********************Modification***********************
	
	    public static int modifNomActeur(int id, String nom) {
	    	if(Dao.ActeurDAO.verifierId(id)) {
	        return ActeurDAO.modifNomActeur(id, nom);
	    }
	    	else {
	    		System.out.println("Id n existe pas");
	    		return 0;
	    	}
	    }


//********************************************
	    public static int modifPrenomActeur(int id, String prenom) {
	    	if(Dao.ActeurDAO.verifierId(id)) {
	        return ActeurDAO.modifPrenomActeur(id, prenom);
	    }
	    	else {
	    		System.out.println("Id n existe pas");
	    		return 0;
	    	}
	    }
	  //********************************************
	    public static int modifMdpActeur(int id, String mdp) {
	    	if(Dao.ActeurDAO.verifierId(id)) {
	        return ActeurDAO.modifMdpActeur(id, mdp);
	    }
	    	else {
	    		System.out.println("Id n existe pas");
	    		return 0;
	    	}
	    }
	    
	  //********************************************
	    public static int modifAnnifActeur(int id, LocalDate annif) {
	    	if(Dao.ActeurDAO.verifierId(id)) {
	        return ActeurDAO.modifAnnifActeur(id, annif);
	    }
	    	else {
	    		System.out.println("Id n existe pas");
	    		return 0;
	    	}
	    }	
	    
	    
	    //*******************Supprimer acteur********************
	    public static int supprimerActeur(int id_Ac) {
	    	if(Dao.ActeurDAO.verifierId(id_Ac)) {
	    		return ActeurDAO.supprimerActeur(id_Ac);
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
	            String sql= "SELECT * FROM ACTEUR WHERE ID_ACTEUR=? AND MDP=?";
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
	    public static boolean exitActeurWithEmail(String email) {
			List<Acteur> User=null;
			try {
				User=ActeurDAO.findAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			boolean result = User.stream()
	                .anyMatch(str -> str.getMail_ac().equals(email));
			return result;
		}
	    
	    
		public static boolean exitActeurWithMdp(String email) {
			List<Acteur> User=null;
			try {
				User=ActeurDAO.findAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			boolean result = User.stream()
	                .anyMatch(str -> str.getMdp_ac().equals(email));
			return result;
		}
		
	    
	    //*****verif id****************
	  //-----si l'email exist --> return true
		public static boolean verifId(int id) {
			List<Acteur> acteurs=null;
			try {
				acteurs=Dao.ActeurDAO.findAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			boolean result = acteurs.stream()
	                .anyMatch(str -> str.getId_acteur()==id);
			return result;
		}
	
	
	
	
	

}

