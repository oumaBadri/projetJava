package org.openjfx.Maven;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Models.Utilisateur;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ProfileInterfaceControllerUser implements Initializable {
static Utilisateur a= new Utilisateur();

	

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
    private void switchToProfileSettings() throws IOException {
        App.setRoot("ProfileSettingsUser");
    }
	
	@FXML
    private void switchToInscription() throws IOException {
        App.setRoot("Inscription");
    }
	
	
	@FXML
    private void switchToLogin() throws IOException {
        App.setRoot("login");
    }
	
	@FXML
    private void supprimer() throws IOException {
        App.setRoot("ConfirmSupprUser");
    }
	
	
	public void setlog(String log) {
    	profileN.setText(log);
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		setlog(a.getNom_user()+" "+a.getPrenom_user());
	}

}
