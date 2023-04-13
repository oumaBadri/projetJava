package org.openjfx.Maven;
import java.io.IOException;
import java.sql.SQLException;

import Controller.ControlSaisie;
import Dao.ActeurDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ConfirmSupprController {
	 @FXML
	    private Button annulerBtn;

	    @FXML
	    private Button confirmerBtn;

	    @FXML
	    private TextField idac;

	    @FXML
	    private PasswordField mdpac;
	    
	    @FXML
	    private Text mdpcor;
	    
	    @FXML
	    private Text idcor;
	    
	    @FXML
	    private void annuler() throws IOException {
	        App.setRoot("ProfileInterface");
	    }
	    
	    
	    @FXML
	    void confirmer(ActionEvent event) throws NumberFormatException, SQLException {
	    	
	Boolean ChampValid=true;
	    
	    	
	    	try {
	    		Integer.parseInt(idac.getText());
	    	}catch(NumberFormatException e) {
	    		idcor.setText("Veuillez entrer que des chiffres");
	    		ChampValid=false;
	    	}
	    	
	    	if (ControlSaisie.validId(Integer.parseInt(idac.getText()))==false) {
	    		idcor.setText("Id n existe pas");
	    		ChampValid=false;
	    	}
	    	
	    	
	    	if (ControlSaisie.validMdp(mdpac.getText())==false) {
	    		mdpcor.setText("password invalide : champ obligatoire doit contenir au moins 8 symbols");
	    		ChampValid=false;
	    	}
		
		if (ChampValid==true)
			ActeurDAO.supprimerActeur(Integer.parseInt(idac.getText()));
			
	    }
	    
	    

}
