package org.openjfx.Maven;


import java.sql.SQLException;

import Controller.ControlSaisie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ProfileSettingsController {
	
	@FXML
    private Label update;
	 @FXML
	    private Label idcor;
	   @FXML
	    private Label nomcor;
	   @FXML
	    private Label prenomcor;

    @FXML
    private Button enrgModifAcBtn;

    @FXML
    private TextField idAc;

    @FXML
    private Button mdpAc;

    @FXML
    private TextField nomAc;

    @FXML
    private TextField prenomAc;

    @FXML
    private Button profileAc;

    @FXML
    void enregistrer(ActionEvent event) throws NumberFormatException, SQLException {
    	
Boolean ChampValid=true;
    
    	
    	try {
    		Integer.parseInt(idAc.getText());
    	}catch(NumberFormatException e) {
    		idcor.setText("Veuillez entrer que des chiffres");
    		ChampValid=false;
    	}
    	
    	if (ControlSaisie.validId(Integer.parseInt(idAc.getText()))==false) {
    		idcor.setText("Id n existe pas");
    		ChampValid=false;
    	}
    	
    	
    	if (ControlSaisie.validName(nomAc.getText())==false) {
			nomcor.setText("nom invalid: champ obligatoire doit contenir que des alphabets");
			ChampValid=false;
	}else {
		Service.ActeurService.modifNomActeur(Integer.parseInt(idAc.getText()), nomAc.getText());
	}

	if (ControlSaisie.validName(prenomAc.getText())==false) {
			prenomcor.setText("prenom invalide: champ obligatoire doit contenir que des alphabet");
			ChampValid=false;
	}else {
		Service.ActeurService.modifPrenomActeur(Integer.parseInt(idAc.getText()), prenomAc.getText());
	}
	
	if (ChampValid==true)
		update.setText("modifications enregistrées");
		
    }

}

