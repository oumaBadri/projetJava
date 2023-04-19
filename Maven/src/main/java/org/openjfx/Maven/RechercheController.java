package org.openjfx.Maven;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class RechercheController implements Initializable{

	

    @FXML
    private ComboBox<String> choicebox;
    
    private String[] recherche={"Recherche par annee","Recherche par titre","Recherche par langue","Recherche par pays","Recherche par acteurs"};


	public void initialize(URL location, ResourceBundle resources) {
		choicebox.getItems().addAll(recherche);
		//choicebox.setOnAction
		
		
	}
    	
    
    
    
    
    
	
}
