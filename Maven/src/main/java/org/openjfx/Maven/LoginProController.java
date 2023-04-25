package org.openjfx.Maven;

    import java.io.IOException;
    import Controller.ControlSaisie;
	import Dao.ActeurDAO;
import Dao.ProducteurDAO;
import Dao.UtilisateurDAO;
	import Models.Acteur;
import Models.Producteur;
import Models.Utilisateur;
import Service.ProducteurService;
import Service.UtilisateurService;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.scene.control.Button;
	import javafx.scene.control.Label;
	import javafx.scene.control.TextField;
	import javafx.scene.image.ImageView;
	import javafx.scene.input.MouseEvent;

	public class LoginProController {
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
        	System.out.println(email.getText());

	    	
	    	Boolean ChampValid=true;
	    	
	        if (ControlSaisie.ExisteEmailPro(email.getText())==false){
	    		emailcor.setText("Email introuvable");
	    		ChampValid=false;
	    	}	
	    	
	    	if (ControlSaisie.ExisteMdpPro(mdp.getText())==false) {
	    		mdpcor.setText("wrong Password");
	    		ChampValid=false;
	    	}
	    	if (ChampValid==true) {
	    		
	    		//ImageController p= new ImageController();
	    		//favorisFilmController i= new favorisFilmController();
	    		//NotifController f= new NotifController();
	    		//DetailShowController di= new DetailShowController();
	    	    Producteur d= ProducteurDAO.getPro(email.getText());
	    	    System.out.println(d+"222222222222222");
	    		ProfileInterfaceControllerPro ii= new ProfileInterfaceControllerPro();

	    		ii.a.setDate_naissance_ac(d.getDate_naissance_ac());
	    	    ii.a.setNom_p(d.getNom_p());
	    		ii.a.setPrenom_p(d.getPrenom_p());
	    		ii.a.setId_p(d.getId_p());
	    		System.out.println("*****"+ii.a.getId_p());
	    		ProducteurService.login(email.getText(),mdp.getText());
	    		 App.setRoot("ProHome");
	    }
			
	    }
		
	    	@FXML
	        private void switchToInscription() throws IOException {
	            App.setRoot("InscriptionPro");
	        }
	    	
	    	
	    	
	}


