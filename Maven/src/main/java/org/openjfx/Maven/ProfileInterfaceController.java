package org.openjfx.Maven;



import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ProfileInterfaceController {

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
        App.setRoot("Inscription");
    }
	
	
	@FXML
    private void switchToLogin() throws IOException {
        App.setRoot("login");
    }
	
	@FXML
    private void supprimer() throws IOException {
        App.setRoot("ConfirmSuppr");
    }
	

}
