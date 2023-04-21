package org.openjfx.Maven;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ActeurAffController {
	@FXML
    private ImageView affiche;

    @FXML
    private Label titre;
    
    
    public  void setData(String nom) {
    	Image image = new Image(getClass().getResourceAsStream("images/acteur.png"));
    	affiche.setImage(image);
    	titre.setText(nom);
    	}
}
