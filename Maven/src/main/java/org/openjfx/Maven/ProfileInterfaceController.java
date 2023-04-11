package org.openjfx.Maven;



import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ProfileInterfaceController {
	
	@FXML
    private void switchToProfileSettings() throws IOException {
        App.setRoot("ProfileSettings");
    }

	

}
