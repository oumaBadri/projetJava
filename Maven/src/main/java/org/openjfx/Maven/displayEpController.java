package org.openjfx.Maven;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

public class displayEpController {
	
	
	  @FXML
	    private Label numEp;

	    @FXML
	    private Button play;
	    
	    public  void setData(int n) {
	    	numEp.setText(String.valueOf(n));
	    	}
	    
	    
	    
	    
	  /* @FXML
	    void play(ActionEvent event) throws IOException {
App.setRoot("Playing");
	    }*/
}
