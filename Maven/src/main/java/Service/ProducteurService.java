package Service;

import java.sql.SQLException;
import java.util.List;

import Dao.ProducteurDAO;
import Dao.UtilisateurDAO;
import Models.Producteur;
import Models.Utilisateur;
import javafx.event.ActionEvent;

public class ProducteurService {
	
	public static int ajouterProducteur(Producteur producteur) {
		int idpro=0;
		idpro=Dao.ProducteurDAO.ajouterProducteur(producteur);
		return idpro;	
	}

	public static boolean exitProducteurWithEmail(String email) {
		List<Producteur> producteurs=null;
		try {
			producteurs=Dao.ProducteurDAO.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		boolean result = producteurs.stream()
                .anyMatch(str -> str.getEmail().equals(email));
		return result;
	}
}