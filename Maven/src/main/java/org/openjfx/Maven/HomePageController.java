package org.openjfx.Maven;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Dao.ShowDAO;
import Models.Show;
import Models.Utilisateur;
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

public class HomePageController implements Initializable{
	   @FXML
       private ImageView notificationbtn;
	   @FXML
	    private Button profilebtn;
	   @FXML
	    private HBox Hbox;
	   @FXML
	    private Button myList;
	   @FXML
	    private ComboBox<String> choicebox;
	    
	   @FXML
	    private ImageView profile;
	   
	@FXML
    private void SwithtoInterfaceProfil() throws IOException {
        App.setRoot("ProfileInterface");
    }
	
	
	@FXML
    private void SwithtoMyList() throws IOException {
        App.setRoot("favorisFilm");
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
	    void goToNotif(MouseEvent event) throws IOException {
      App.setRoot("notification");

	    }
<<<<<<< HEAD
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
	    @FXML
	    void goToProfil(MouseEvent event) throws IOException {
	        App.setRoot("ProfileInterfaceUser");

	    }
	 

	 
	@Override
	public void initialize(URL location, java.util.ResourceBundle resources){
	  try {
		List<Show> show1 =ShowService.Findall2();
		for(Show show :show1){
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("image.fxml"));
		VBox image  = fxmlLoader.load();
		ImageController imageController = fxmlLoader.getController();
		if (imageController != null) {
		    imageController.setData(show);
		}
		//imageController.setData(show);
		Hbox.getChildren().add(image);
		
		}
	}catch(IOException | SQLException e) {
		e.printStackTrace();
	}
		
	
	}
	
	
}
