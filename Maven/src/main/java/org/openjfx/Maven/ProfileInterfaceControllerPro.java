package org.openjfx.Maven;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Models.Admin;
import Models.Producteur;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ProfileInterfaceControllerPro implements Initializable{
	
	static Producteur a= new Producteur();

	@FXML
	private Button backBtn;

	    @FXML
	    private TextField profileN;
	    @FXML
	    private Button ajouterCmptBtn;

	    @FXML
	    private Button deconnexionBtn;

	    @FXML
	    private Button editerProfilBtn;

	    @FXML
	    private Button suppBtn;
		
	    
	    
	    @FXML
	    void back(MouseEvent event) throws IOException {
	    	App.setRoot("ProHome");
	    }
		@FXML
	    private void switchToProfileSettings() throws IOException {
	        App.setRoot("ProfileSettingsPro");
	    }
		 @FXML
		    void switchToLogin() throws IOException {
		        App.setRoot("logInTypee");
		    }
		@FXML
	    private void switchToInscription() throws IOException {
	        App.setRoot("InscriptionPro");
	    }
		
		
		
		
		@FXML
	    private void supprimer() throws IOException {
	        App.setRoot("ConfirmSupprPro");
	    }
		
		
		public void setlog(String log) {
	    	profileN.setText(log);
	    }
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			System.out.println(a.getNom_p()+" "+a.getPrenom_p());
		
			setlog(a.getNom_p()+" "+a.getPrenom_p());
		}

}
