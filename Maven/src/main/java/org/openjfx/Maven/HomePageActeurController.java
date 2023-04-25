package org.openjfx.Maven;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

import Models.Show;
import Service.ShowService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HomePageActeurController implements Initializable{

	
	   @FXML
	    private HBox Hbox;
	   @FXML
	    private Button myList;
	   @FXML
	    private ComboBox<String> choicebox;
	    
	  
	   
	   @FXML
	    void switchToHome() throws IOException {
		   App.setRoot("ActeurHome");
	    }
	   
	@FXML
  private void SwithtoInterfaceProfil() throws IOException {
      App.setRoot("ProfileInterface");
  }
	
	
	@FXML
  private void SwithtoMyList() throws IOException {
      App.setRoot("Consultation");
  }
	@FXML
  private void SwithtoMyShow() throws IOException {
      App.setRoot("TvShow");
  }
	@FXML
  private void SwithtoMyMovie() throws IOException {
      App.setRoot("Movie");
  }
	
	 
	 @FXML
	    void RechercheTitre() throws IOException {
          App.setRoot("RechercheTitre");

	    }
	 @FXML
	    void RechercheAnnee() throws IOException {
 App.setRoot("RechercheAnnee");

	    }
	 @FXML
	    void RecherchePays() throws IOException {
 App.setRoot("RecherchePays");

	    }
	 @FXML
	    void RechercheLangue() throws IOException {
 App.setRoot("RechercheLangue");

	    }
	 
	 @FXML
	    void RechercheGenre() throws IOException {
 App.setRoot("RechercheGenre");

	    }
	 
	 
	 @FXML
	    void RechercheActeur() throws IOException {
 App.setRoot("RechercheActeur");

	    }
	 
	@Override
	public void initialize(URL location, java.util.ResourceBundle resources){
	  try {
		List<Show> show1 =ShowService.Findall2();
		for(Show show :show1){
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("affiche.fxml"));
		VBox image  = fxmlLoader.load();
		AfficheController imageController = fxmlLoader.getController();
		if (imageController != null) {
		    imageController.setData2(show.getAffiche());
		}
		//imageController.setData(show);
		Hbox.getChildren().add(image);
		
		}
	}catch(IOException | SQLException e) {
		e.printStackTrace();
	}
		
	
	}
	
	
}
