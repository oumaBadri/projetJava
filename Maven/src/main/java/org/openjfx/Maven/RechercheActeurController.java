package org.openjfx.Maven;

import java.io.IOException;
import java.util.List;

import Dao.ShowDAO;
import Dao.UtilisateurDAO;
import Models.Acteur;
import Models.Show;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RechercheActeurController {

	@FXML
    private HBox Hbox;
	@FXML
	    private  TextField recherche;

	 @FXML
	    void retour() throws IOException {
		 App.setRoot("UserHome");

	    }
		
	    public void search() {
	    	try {
	    		
				List<Acteur> acteurs =UtilisateurDAO.RechercherActeur(recherche.getText());
				
				if(acteurs.isEmpty()) {
		    		Alert alert = new Alert(AlertType.ERROR);
	     	         alert.setTitle("Erreur");
	     	         alert.setHeaderText("Pas de show Avec cet acteurs");
	     	         alert.showAndWait();
	     	         return;
		    	}
		    	else {
				
				for(Acteur acteur :acteurs){
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("Acteuraff.fxml"));
				VBox image  = fxmlLoader.load();
				ActeurAffController affController = fxmlLoader.getController();
				if (affController != null) {
					String s= acteur.getNom_ac()+acteur.getPrenom_ac();
				    affController.setData(s);
				    }
				Hbox.getChildren().clear();

				Hbox.getChildren().add(image);
				
				}
			}}catch(IOException e) {
				e.printStackTrace();
			}
	    	
			}
	
	
	
	
	
	
	
	
	
}
