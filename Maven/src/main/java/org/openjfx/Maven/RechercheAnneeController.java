package org.openjfx.Maven;

import java.io.IOException;
import java.util.List;

import Dao.ShowDAO;
import Dao.UtilisateurDAO;
import Models.Show;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RechercheAnneeController {

	
	
	@FXML
    private HBox Hbox;

	
	 @FXML
	    private  TextField recherche;

	 @FXML
	    void retour() throws IOException {
		 App.setRoot("UserHome");

	    }
		
	    public void search() {
	    	List<Show> show1 = UtilisateurDAO.RechercherParAnnee(Integer.parseInt(recherche.getText()));
	    	
	    	if(show1.isEmpty()) {
	    		Alert alert = new Alert(AlertType.ERROR);
     	         alert.setTitle("Erreur");
     	         alert.setHeaderText("Pas de show Avec cette année");
     	         alert.showAndWait();
     	         return;
	    	}
	    	else {
	    	
	    	try {
				for(Show show :show1){
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("image.fxml"));
				VBox image  = fxmlLoader.load();
				ImageController imageController = fxmlLoader.getController();
				if (imageController != null) {
				    imageController.setData(show);
				}
				Hbox.getChildren().clear();

				Hbox.getChildren().add(image);
				
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
			
	    	}
	    	}
	
	
}
