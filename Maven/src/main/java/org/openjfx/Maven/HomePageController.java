package org.openjfx.Maven;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Models.Show;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HomePageController implements Initializable{
	
	
	   @FXML
	    private HBox Hbox;
	
	private List<Show> recentlyAdded;
	private Show show ;
	
	@FXML
    private void SwithtoInterfaceProfil() throws IOException {
        App.setRoot("ProfileInterface");
    }
	
	private List<Show>  recentlyAdded(){
		List<Show> sh = new ArrayList<>();
		Show show =  new Show();
		show.setTitre_show("wednesday");
		show.setAffiche("images/Wednesday-2.jpg");
		sh.add(show);
		
		show.setTitre_show("wednesday");
		show.setAffiche("images/Wednesday-2.jpg");
		sh.add(show);
		
		show.setTitre_show("wednesday");
		show.setAffiche("images/Wednesday-2.jpg");
		sh.add(show);
		
		return sh;
		
	}

	
	@Override
	public void initialize(URL location, java.util.ResourceBundle resources) {
	 recentlyAdded = new ArrayList<>(recentlyAdded());
	   
		
		try {
		for(Show show :recentlyAdded) {
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
		
	
	}catch(IOException e) {
		e.printStackTrace();
	}
		
	
	}
	
	
}
