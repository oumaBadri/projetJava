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
import Service.ShowService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HomePageController implements Initializable{
	
	
	   @FXML
	    private HBox Hbox;
	
	
	@FXML
    private void SwithtoInterfaceProfil() throws IOException {
        App.setRoot("ProfileInterface");
    }
	
	/*private void  recentlyAdded(List<Show> liste ,Stream<Show> source ) {
		List<Show> sh = new ArrayList<>();
		Show show =  new Show();
		
		source.collect(Collectors.toCollection(()->liste));
		
		/*show.setTitre_show("wednesday");
		show.setAffiche("images/Wednesday-2.jpg");
		sh.add(show);
		show.setTitre_show("wednesday");
		show.setAffiche("images/Wednesday-2.jpg");
		sh.add(show);
		show.setTitre_show("wednesday");
		show.setAffiche("images/Wednesday-2.jpg");
		sh.add(show);
		sh=ShowDAO.findAll();
		sh.stream().
		
		
		
		}*/

	
	
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
