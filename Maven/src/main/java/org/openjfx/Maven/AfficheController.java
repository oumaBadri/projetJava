package org.openjfx.Maven;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AfficheController {
	 @FXML
	    private ImageView affiche3;
	 
	 
	 public  void setData2(String show) {
	    	Image image = new Image(getClass().getResourceAsStream(show));
	    	affiche3.setImage(image);
	    
	    	}
	    
}
