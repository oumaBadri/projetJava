package org.openjfx.Maven;

import java.io.IOException;

import javafx.fxml.FXML;

public class HomePageController {

	
	@FXML
    private void SwithtoInterfaceProfil() throws IOException {
        App.setRoot("ProfileInterface");
    }
	
	
}
