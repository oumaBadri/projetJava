package org.openjfx.Maven;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Models.Admin;
import Models.Utilisateur;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ProfileInterfaceControllerAdmin implements Initializable {
	static Admin a= new Admin();

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
	    	App.setRoot("AdminHome");
	    }
		@FXML
	    private void switchToProfileSettings() throws IOException {
	        App.setRoot("ProfileSettingsAdmin");
	    }
		 @FXML
		    void switchToLogin() throws IOException {
		        App.setRoot("logInTypee");
		    }
		@FXML
	    private void switchToInscription() throws IOException {
	        App.setRoot("InscriptionAdmin");
	    }
		
		
		
		
		@FXML
	    private void supprimer() throws IOException {
	        App.setRoot("ConfirmSupprAdmin");
	    }
		
		
		public void setlog(String log) {
	    	profileN.setText(log);
	    }
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			System.out.println(a.getNom_ad()+" "+a.getPrenom_ad());
			setlog(a.getNom_ad()+" "+a.getPrenom_ad());
		}

}
