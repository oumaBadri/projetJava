package org.openjfx.Maven;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Dao.ShowDAO;
import Models.Show;
import Service.ShowService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RechercheTitreController {
	
	@FXML
    private HBox Hbox;

    @FXML
    private TextField recherche;

    @FXML
    void retour() throws IOException {
	 App.setRoot("UserHome");

    }
	
    public void search() {
    	List<Show> show1 =ShowDAO.findShowParTitre(recherche.getText());
    	try {
			for(Show show :show1){
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("image.fxml"));
			VBox image  = fxmlLoader.load();
			ImageController imageController = fxmlLoader.getController();
			if (imageController != null) {
			    imageController.setData(show);
			}
			Hbox.getChildren().add(image);
			
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		}
    
    
   /* @Override
	public void initialize(URL location, ResourceBundle resources) {

			List<Show> show1 =search();
			try {
			for(Show show :show1){
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("image.fxml"));
			VBox image  = fxmlLoader.load();
			ImageController imageController = fxmlLoader.getController();
			if (imageController != null) {
			    imageController.setData(show);
			}
			Hbox.getChildren().add(image);
			
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
}*/
	
}	
	

   	
    

