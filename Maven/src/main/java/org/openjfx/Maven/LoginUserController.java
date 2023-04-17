package org.openjfx.Maven;

import java.io.IOException;
import java.sql.SQLException;

import Controller.ControlSaisie;
import Dao.ActeurDAO;
import Dao.UtilisateurDAO;
import Models.Acteur;
import Models.Utilisateur;
import Service.ActeurService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginUserController {

	@FXML
    private Button CreateAcountUS;

    @FXML
    private TextField emailUS;

    @FXML
    private Label emailcorUS;


    @FXML
    private Button loginUS;


    @FXML
    private TextField mdpUS;

    @FXML
    private Label mdpcorUS;

	
	
	
	
	@FXML
    void Login(ActionEvent event) throws IOException, SQLException {
    	
    	//Acteur p= new Acteur();
    	Boolean ChampValid=true;
		//ProfileSettingsController pic= new ProfileSettingsController();

        if (ControlSaisie.ExisteEmaiUS(emailUS.getText())==false){
    		emailcorUS.setText("Email introuvable");
    		ChampValid=false;
    	}	
    	
    	if (ControlSaisie.ExisteMdpAc(mdpUS.getText())==false) {
    		mdpcorUS.setText("wrong Password");
    		ChampValid=false;
    	}
    	if (ChampValid==true) {
    		
    		ImageController p= new ImageController();
    		
    
    		Utilisateur d= UtilisateurDAO.getUser(emailUS.getText());
    		//System.out.println(d);
    		
    		p.a.setId_user(d.getId_user());
    		
    		ActeurService.login(emailUS.getText(),mdpUS.getText());
    		App.setRoot("ProfileInterface");
    		}
		
    }
	
	
	
	
	
	
	
}
