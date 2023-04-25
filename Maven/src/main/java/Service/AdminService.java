package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import Controller.ActeurControl;
import Dao.AdminDao;
import Dao.UtilisateurDAO;
import Models.Admin;
import utile.conxBD;

public class AdminService {


	private static Connection conn = conxBD.getInstance();
	
	public static void ajouterAdmin(Admin Admin) throws SQLException {
		 String l=Admin.getEmail();
		if( AdminDao.RechercherParEmail(l)!=0) {
			System.out.println("Compte deja existant");
			return ;
			}
		else {
				if(ActeurControl.verifierMdp(Admin.getMdp())){
					AdminDao.ajouterAdministrateur(Admin);
			System.out.println("Ajout avec succés");
		}
		
		}
		
	}
	
	
	//*************************loginn***********************
	public static boolean login(String email, String mdp) {
		boolean iduser;
		iduser=AdminDao.login(email, mdp);
		return iduser;
		
	}
	
	
	
	//***********************Modification***********************
	
	    public static int modifNomAdmin(int id, String nom) {
	    	if(AdminDao.verifierId(id)) {
	        return AdminDao.modifNomAdministrateur(id, nom);
	    }
	    	else {
	    		System.out.println("Id n existe pas");
	    		return 0;
	    	}
	    }


//********************************************
	    public static int modifPrenomAdmin(int id, String prenom) {
	    	if(AdminDao.verifierId(id)) {
	        return AdminDao.modifPrenomAdministrateur(id, prenom);
	    }
	    	else {
	    		System.out.println("Id n existe pas");
	    		return 0;
	    	}
	    }
	  //********************************************
	    public static int modifMdpAdmin(int id, String mdp) {
	    	if(AdminDao.verifierId(id)) {
	        return AdminDao.modifMdpAdministrateur(id, mdp);
	    }
	    	else {
	    		System.out.println("Id n existe pas");
	    		return 0;
	    	}
	    }
	    
	  //********************************************
	    public static int modifAnnifAdmin(int id, LocalDate annif) {
	    	if(AdminDao.verifierId(id)) {
	        return AdminDao.modifAnnifAdministrateur(id, annif);
	    }
	    	else {
	    		System.out.println("Id n existe pas");
	    		return 0;
	    	}
	    }	
	    
	    
	    //*******************Supprimer Admin********************
	    public static int supprimerAdmin(int id_Ac) {
	    	if(AdminDao.verifierId(id_Ac)) {
	    		return AdminDao.supprimerAdministrateur(id_Ac);
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
	            String sql= "SELECT * FROM Admin WHERE ID_Admin=? AND MDP=?";
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
	    public static boolean exitAdminWithEmail(String email) {
			List<Admin> User=null;
			try {
				User=AdminDao.findAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			boolean result = User.stream()
	                .anyMatch(str -> str.getEmail().equals(email));
			return result;
		}
	    
	    
		public static boolean exitAdminWithMdp(String email) {
			List<Admin> User=null;
			try {
				User=AdminDao.findAll();
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
			List<Admin> Admins=null;
			try {
				Admins=AdminDao.findAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			boolean result = Admins.stream()
	                .anyMatch(str -> str.getId_ad()==id);
			return result;
		}
}
