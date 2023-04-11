package Service;

import java.sql.SQLException;
import java.util.List;

import Dao.UtilisateurDAO;
import Models.Producteur;
import Models.Utilisateur;

public class UtilisateurService {

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
	
	
	
	
	
	
	
	
	
	
}
