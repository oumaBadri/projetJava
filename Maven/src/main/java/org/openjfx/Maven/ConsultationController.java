package org.openjfx.Maven;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
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
import javafx.event.ActionEvent;
  
public class ConsultationController {
	@FXML
    private Button parmois;
	  @FXML
	    private Button ProfilID;

	    @FXML
	    private ImageView ShowAffiche;

	    @FXML
	    private TextField rechercheTitre;

	   
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
	    @FXML
	    private ChoiceBox<Integer> Choicebox;

	    @FXML
	    private Label score;

	    @FXML
	    private Label scoreSaison;
        public void search(MouseEvent event) throws SQLException, IOException {
	    	List<Show> show1 =ShowDAO.findShowParTitre(rechercheTitre.getText());
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
				List<Integer> saisonliste=new ArrayList<>();
				try {
					saisonliste = createListe();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			    Choicebox.getItems().addAll(saisonliste);
			    Choicebox.setOnAction((e)-> {calculScoreSaison(show.getId_show(),Choicebox.getValue());
			      });
			    double s=AvisDAO.CalculScore(show.getId_show());
			    score.setText(String.valueOf(s));
		
				}
				}	
	   

	   private  List<Integer> createListe() throws SQLException {
		    List<Integer> saisons= new ArrayList<>();	
			List<Show> show1 =ShowDAO.findShowParTitre(rechercheTitre.getText());
			for(Show show:show1) {
		     int nb= ShowDAO.getNombreSaisons(show.getId_show());
		    
		    for(int i=0;i<nb;i++) 
		    {int f=i+1;
		    	saisons.add(f);
		       
		    }
			}
		    return saisons;
		    }
	private void calculScoreSaison(int id_show, int num_saison) {
	  double score=AvisDAO.CalculScoreSaison(id_show, num_saison);
	    scoreSaison.setText(String.valueOf(score));
	}

		
	
	
	 @FXML
	    void goToClassement() throws IOException {
		   App.setRoot("Classement");
	    }
	
	
}	
	
	
	
	
	
	

