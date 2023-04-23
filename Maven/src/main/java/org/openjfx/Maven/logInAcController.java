package org.openjfx.Maven;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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

public class logInAcController {
	@FXML
    private Button CreateAcountAc;

    @FXML
    private TextField emailAc;

    @FXML
    private Label emailcorAc;


    @FXML
    private Button loginAc;


    @FXML
    private TextField mdpAc;

    @FXML
    private Label mdpcorAc;

	//Acteur p= new Acteur();


    @FXML
    void Login(ActionEvent event) throws IOException, SQLException {
    	
    	//Acteur p= new Acteur();
    	Boolean ChampValid=true;
		//ProfileSettingsController pic= new ProfileSettingsController();

        if (ControlSaisie.ExisteEmailAc(emailAc.getText())==false){
    		emailcorAc.setText("Email introuvable");
    		ChampValid=false;
    	}	
    	
    	if (ControlSaisie.ExisteMdpAc(mdpAc.getText())==false) {
    		mdpcorAc.setText("wrong Password");
    		ChampValid=false;
    	}
    	if (ChampValid==true) {
    		
    		ProfileSettingsController  p= new ProfileSettingsController();
    		ChangerMdpController c= new ChangerMdpController();
    		ConfirmSupprController n= new ConfirmSupprController();
    		ProfileInterfaceController i= new ProfileInterfaceController();
    
    		Acteur d= ActeurDAO.getActeur(emailAc.getText());
    		//System.out.println(d);
    		i.a.setNom_ac(d.getNom_ac());
    		i.a.setPrenom_ac(d.getPrenom_ac());
    		n.a.setId_acteur(d.getId_acteur());
    		c.a.setId_acteur(d.getId_acteur());
    		c.a.setNom_ac(d.getNom_ac());
    		c.a.setPrenom_ac(d.getPrenom_ac());
    		p.a.setId_acteur(d.getId_acteur());
    		p.a.setNom_ac(d.getNom_ac());
    		p.a.setDate_naissance_ac(d.getDate_naissance_ac());
    		p.a.setPrenom_ac(d.getPrenom_ac());
    		
    		ActeurService.login(emailAc.getText(),mdpAc.getText());
    		App.setRoot("ProfileInterface");
    		}
		
    }
	
    	@FXML
        private void switchToInscription() throws IOException {
            App.setRoot("Inscription");
        }
}

