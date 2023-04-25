package org.openjfx.Maven;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Dao.EpisodeDAO;
import Dao.SaisonDao;
import Dao.ShowDAO;
import Models.Episode;
import Models.Show;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AjoutEpisodeController{
	CombienDEpisodeController episode=new CombienDEpisodeController();
	static Episode ep= new Episode();

  
    @FXML
    private TextField TitreEp;

    @FXML
    private Button btn_add;
    @FXML
    private DatePicker DateEp;

    @FXML
    private TextArea descriptionEp;
    
   
	public  void AjoutEp() {
		Episode e = new Episode(ep.getId_show(),ep.getNum_saison(),TitreEp.getText(),ep.getNum_ep(),descriptionEp.getText(),DateEp.getValue());
		System.out.println(e);
	    EpisodeDAO.ajouterEpisode(e);
	}
	
	@FXML
    void Retour() throws IOException {
	   App.setRoot("CombienDEpisode");
    }
    
	
}
