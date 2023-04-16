package org.openjfx.Maven;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Controller.ControlSaisie;
import Models.Acteur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ChangerMdpController implements Initializable{
	
	   @FXML
	    private Label update;

    @FXML
    private PasswordField AncienMdpAc;

    @FXML
    private Label ancienMdpCor;

    @FXML
    private Button enrgModifBtn;

    @FXML
    private TextField idAc;

    @FXML
    private Label idcor;

    @FXML
    private Button mdpAc;

    @FXML
    private PasswordField nvMdpAc;

    @FXML
    private Label nvMdpCor;

    @FXML
    private Button profileAc;

    @FXML
    private ImageView back;
    
    static Acteur a= new Acteur();
    
    @FXML
    private void back() throws IOException {
        App.setRoot("ProfileInterface");
    }

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
    	
    	if (ControlSaisie.validMdp(AncienMdpAc.getText())==false) {
    		ancienMdpCor.setText("password invalide : champ obligatoire doit contenir au moins 8 symbols");
    		ChampValid=false;
    	}
    	
    	if (ControlSaisie.validAncienMdp(Integer.parseInt(idAc.getText()),AncienMdpAc.getText())==false) {
    		ancienMdpCor.setText("password invalide");
    		ChampValid=false;
    	}
    	
    	if (ControlSaisie.validMdp(nvMdpAc.getText())==false) {
    		nvMdpCor.setText("password invalide : champ obligatoire doit contenir au moins 8 symbols");
    		ChampValid=false;
    	}
    	
    	if (ChampValid==true) {
    		Service.ActeurService.modifMdpActeur(Integer.parseInt(idAc.getText()), nvMdpAc.getText());
    		update.setText("modification enregistrée");

    	}

    }

    public void setId(String id) {
        idAc.setText(id);
    }
    @FXML
    private void switchToProfl() throws IOException {
        App.setRoot("ProfileSettings");
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setId(String.valueOf(a.getId_acteur()));
	}
    
}
