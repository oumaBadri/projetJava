package org.openjfx.Maven;

import java.io.IOException;
import java.sql.SQLException;

import Controller.ControlSaisie;
import Dao.AdminDao;
import Models.Admin;
import Service.AdminService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginAdminController {

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
    void Login(ActionEvent event) throws IOException, SQLException {

    	
    	Boolean ChampValid=true;
    	
        if (ControlSaisie.ExisteEmailAd(email.getText())==false){
    		emailcor.setText("Email introuvable");
    		ChampValid=false;
    	}	
    	
    	if (ControlSaisie.ExisteMdpAd(mdp.getText())==false) {
    		mdpcor.setText("wrong Password");
    		ChampValid=false;
    	}
    	if (ChampValid==true) {
    		ProfileInterfaceControllerUser ii= new ProfileInterfaceControllerUser();
    		ImageController p= new ImageController();
    		DetailShowController di= new DetailShowController();
    	    Admin d= AdminDao.getAdministrateur(email.getText());
    	    System.out.println(d);
    		//System.out.println(d);
    	    
    	    
    	    ii.a.setNom_user(d.getNom_ad());
    		ii.a.setPrenom_user(d.getPrenom_ad());
    		ii.a.setId_user(d.getId_ad());
    		p.a.setId_user(d.getId_ad());
    		di.a.setId_user(d.getId_ad());
    		System.out.println("*****"+ii.a.getId_user());
    		AdminService.login(email.getText(),mdp.getText());
    		 App.setRoot("AdminHome");
    }
		
    }
	
    	@FXML
        private void switchToInscription() throws IOException {
            App.setRoot("InscriptionAdmin");
        }
	
	
	
}
