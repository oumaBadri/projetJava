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
    		//ImageController p= new ImageController();
    		//DetailShowController di= new DetailShowController();
    		System.out.println(email.getText());
    	    Admin d=new Admin(); 
    	    		d=AdminDao.getAdministrateur(email.getText());
    	    System.out.println(d);
    		//System.out.println(d);
    		ProfileInterfaceControllerAdmin ii= new ProfileInterfaceControllerAdmin();

    	    ii.a.setDate_naissance_ad(d.getDate_naissance_ad());
    	    ii.a.setNom_ad(d.getNom_ad());
    		ii.a.setPrenom_ad(d.getPrenom_ad());
    		ii.a.setId_ad(d.getId_ad());
    		//p.a.setId_user(d.getId_ad());
    		//di.a.setId_user(d.getId_ad());
    		System.out.println("*****"+ii.a.getId_ad());
    		AdminService.login(email.getText(),mdp.getText());
    		 App.setRoot("AdminHome");
    }
		
    }
	
    	@FXML
        private void switchToInscription() throws IOException {
            App.setRoot("InscriptionAdmin");
        }
	
	
	
}
