package org.openjfx.Maven;

import java.io.IOException;


import Controller.ControlSaisie;
import Dao.ActeurDAO;
import Dao.UtilisateurDAO;
import Models.Acteur;
import Models.Utilisateur;
import Service.UtilisateurService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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

    	
    	Boolean ChampValid=true;
    	
        if (ControlSaisie.ExisteEmaiUS(email.getText())==false){
    		emailcor.setText("Email introuvable");
    		ChampValid=false;
    	}	
    	
    	if (ControlSaisie.ExisteMdp(mdp.getText())==false) {
    		mdpcor.setText("wrong Password");
    		ChampValid=false;
    	}
    	if (ChampValid==true) {
    		
    		ImageController p= new ImageController();
    		favorisFilmController i= new favorisFilmController();
    		NotifController f= new NotifController();
    		
    	    Utilisateur d= UtilisateurDAO.getUser(email.getText());
    	    System.out.println(d);
    		//System.out.println(d);
    		f.a.setId_user(d.getId_user());
    		p.a.setId_user(d.getId_user());
    		i.a.setId_user(d.getId_user());
    		System.out.println("*****"+i.a.getId_user());
    		UtilisateurService.login(email.getText(),mdp.getText());
    		 App.setRoot("UserHome");
    }
		
    }
	
    	@FXML
        private void switchToInscription() throws IOException {
            App.setRoot("Inscription");
        }
    	
    	
    	
}
