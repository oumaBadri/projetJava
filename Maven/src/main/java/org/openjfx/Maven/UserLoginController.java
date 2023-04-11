package org.openjfx.Maven;

import java.io.IOException;

import Controller.ControlSaisie;
import Models.Utilisateur;
import Service.UtilisateurService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UserLoginController {
	@FXML
    private Button CreateAcount;

    @FXML
    private TextField email;

    @FXML
    private Label emailcor;


    @FXML
    private Button login;


    @FXML
    private TextField mdp;

    @FXML
    private Label mdpcor;

   

    @FXML
    void Login(ActionEvent event) throws IOException {

    	Utilisateur p;
    	Boolean ChampValid=true;
    	
        if (ControlSaisie.ExisteEmail(email.getText())==false){
    		emailcor.setText("Email introuvable");
    		ChampValid=false;
    	}	
    	
    	if (ControlSaisie.ExisteMdp(mdp.getText())==false) {
    		mdpcor.setText("wrong Password");
    		ChampValid=false;
    	}
    	if (ChampValid==true) {
    		UtilisateurService.login(email.getText(),mdp.getText());
    		 App.setRoot("Inscription");
    }
		
    }
	
    	@FXML
        private void switchToInscription() throws IOException {
            App.setRoot("Inscription");
        }
}
