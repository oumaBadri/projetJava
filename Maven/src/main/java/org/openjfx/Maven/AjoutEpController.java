package org.openjfx.Maven;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AjoutEpController {

	   @FXML
	    private Label numEp;
	   
	   
	   
	 @FXML
	    void AjoutEp() throws IOException {
	    	
	    	AjoutEpisodeController e= new AjoutEpisodeController();
	    	e.ep.setNum_ep(Integer.parseInt(numEp.getText()));
	    	App.setRoot("AjoutEpisode");
	    }
	
	
	
}
