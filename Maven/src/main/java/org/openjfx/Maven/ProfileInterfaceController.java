package org.openjfx.Maven;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Models.Acteur;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ProfileInterfaceController implements Initializable{

    static Acteur a= new Acteur();

	

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
        App.setRoot("ProfileSettings");
    }
	
	@FXML
    private void switchToInscription() throws IOException {
        App.setRoot("InscriptionActeur");
    }
	
	
	@FXML
    private void switchToLogin() throws IOException {
        App.setRoot("AcLogin");
    }
	 @FXML
	    void switchToHome() throws IOException {
		 App.setRoot("ActeurHome");
	    }
	@FXML
    private void supprimer() throws IOException {
        App.setRoot("ConfirmSuppr");
    }
	
	
	public void setlog(String log) {
    	profileN.setText(log);
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		setlog(a.getNom_ac()+" "+a.getPrenom_ac());
	}

}
