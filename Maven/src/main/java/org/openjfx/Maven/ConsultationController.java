package org.openjfx.Maven;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import Dao.AvisDAO;
import Dao.ShowDAO;
import Models.Avis;
import Models.Show;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
  
public class ConsultationController {

	  @FXML
	    private Button ProfilID;

	    @FXML
	    private ImageView ShowAffiche;

	    @FXML
	    private TextField rechercheTitre;

	    @FXML
	    private Label score;

	    @FXML
	    private Label title;
	    @FXML
	    private HBox Hbox;
	    @FXML
	    private TableView<Avis> tablecom;

	    @FXML
	    private TableView<Avis> tablenote;

	    @FXML
	    private TableColumn<Avis,String> com;

	    @FXML
	    private TableColumn<Avis,Integer> episodecom;

	    @FXML
	    private TableColumn<Avis,Integer> episodenote;

	    @FXML
	    private TableColumn<Avis,Integer> note;


	    @FXML
	    private TableColumn<Avis,Integer> saisoncom;

	    @FXML
	    private TableColumn<Avis,Integer > saisonnote;

	   public void search(MouseEvent event) throws SQLException {
	    	List<Show> show1 =ShowDAO.findShowParTitre(rechercheTitre.getText());
	    	
	    	try {
				for(Show show:show1) {
				//	Hbox.clearConstraints(Hbox);
					Hbox.getChildren().clear();
				    tablecom.getItems().clear();
					List<Avis> avis=AvisDAO.findAvis2(show.getId_show());
					ObservableList<Avis> observableList1 = FXCollections.observableList(avis);
					episodecom.setCellValueFactory(new PropertyValueFactory<Avis,Integer>("num_ep"));
					saisoncom.setCellValueFactory(new PropertyValueFactory<Avis,Integer>("num_saison"));
					com.setCellValueFactory(new PropertyValueFactory<Avis,String>("commantaire"));
					tablecom.setItems(observableList1);
				
					tablenote.getItems().clear();
					List<Avis> avis2=AvisDAO.findAvis2(show.getId_show());
					ObservableList<Avis> observableList2 = FXCollections.observableList(avis2);
					episodenote.setCellValueFactory(new PropertyValueFactory<Avis,Integer>("num_ep"));
					saisonnote.setCellValueFactory(new PropertyValueFactory<Avis,Integer>("num_saison"));
					note.setCellValueFactory(new PropertyValueFactory<Avis,Integer>("note"));
					tablenote.setItems(observableList2);
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("affiche.fxml"));
				VBox image  = fxmlLoader.load();
				AfficheController imageController = fxmlLoader.getController();
				if (imageController != null) {
				    imageController.setData2(show.getAffiche());
				}
				Hbox.getChildren().add(image);
			}
			}catch(IOException e) {
				e.printStackTrace();
			}
	   }
}

		

		
	
	
	
	
	
	
	
	
	
	
	

