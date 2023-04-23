package org.openjfx.Maven;

import java.net.URL;
import java.util.ResourceBundle;

import Models.Show;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CombienDEpisodeController implements Initializable {
		static Show s=new Show();
	
	  	@FXML
	    private Button btnAjouterEpisode;

	    @FXML
	    private Button btnPageAcceuil;

	    @FXML
	    private TextField nbrEpisode_txtField;

	    @FXML
	    private Label numeroSaison_label;

	    @FXML
	    private TextField titreShow;

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			System.out.println("hellooo");
			titreShow.setText(s.getTitre_show());
			System.out.println(s.getTitre_show()+"---------------------");
		}

	    
	    
}
