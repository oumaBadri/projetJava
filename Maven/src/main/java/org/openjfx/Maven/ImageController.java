package org.openjfx.Maven;



import Models.Show;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class ImageController {

	@FXML
    private ImageView affiche;

    @FXML
    private Button like;

    @FXML
    private Button play;

    @FXML
    private Button show;

    @FXML
    private Label titre;
    
      
   public  void setData(Show show) {
	Image image = new Image(getClass().getResourceAsStream(show.getAffiche()));
	affiche.setImage(image);
	titre.setText(show.getTitre_show());
	}
    
}
