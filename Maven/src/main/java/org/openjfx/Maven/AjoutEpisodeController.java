package org.openjfx.Maven;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import Models.Episode;
import Models.Show;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class AjoutEpisodeController implements Initializable{

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_next;

    @FXML
    private Button btn_update;

    @FXML
    private TableColumn<Episode, LocalDate> cln_dateDiff;

    @FXML
    private TableColumn<Episode, String> cln_description;

    @FXML
    private TableColumn<Episode, Integer> cln_id;

    @FXML
    private TableColumn<Episode, String> cln_nom;

    @FXML
    private TableColumn<Episode, Integer> cln_numero;

    @FXML
    private TableColumn<Episode, Integer> cln_numeroSaison;

    @FXML
    private DatePicker datePIcker;

    @FXML
    private ImageView imageView_search;

    @FXML
    private TableView<Episode> table;

    @FXML
    private TextArea txt_description;

    @FXML
    private TextField txt_nbrSaison;

    @FXML
    private TextField txt_searchId;

    @FXML
    private TextField txt_numSaison;
    
    @FXML
    private TextField txt_titre;

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
		int idShow=0;//hedhom lezim ne5edhhom min illi 9bel
		int numSaison=0;
    	ShowEpisode(idShow,numSaison);
		
	}
    
    
    public void ShowEpisode(int idShow, int numSaison ) {
    	//--------????????????????????????????????------------------------
    	//hneya zeda lezim n7ot f textfield mtaa isShow w numSaison
    	table.getItems().clear();
    	
    	List<Episode> episodes=null;
    	try {
			episodes=Dao.EpisodeDAO.FindAllParIdShowNumSaison(idShow, numSaison);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	ObservableList<Episode> observableList = FXCollections.observableList(episodes);
    	cln_id.setCellValueFactory(new PropertyValueFactory<Episode,Integer>("id_show"));
    	cln_numeroSaison.setCellValueFactory(new PropertyValueFactory<Episode,Integer>("num_saison"));
    	cln_nom.setCellValueFactory(new PropertyValueFactory<Episode,String>("titre_ep"));
    	cln_numero.setCellValueFactory(new PropertyValueFactory<Episode,Integer>("num_ep"));
    	cln_description.setCellValueFactory(new PropertyValueFactory<Episode,String>("desc_ep"));
    	cln_dateDiff.setCellValueFactory(new PropertyValueFactory<Episode,LocalDate>("Date_diff"));
    	table.setItems(observableList);
    }
    
    @FXML
    void searchEpisode() {
    	if (txt_searchId.getText().equals("")) {
    		Alert alert = new Alert(AlertType.WARNING, "Veuillez indiquer l'ID_Show ", javafx.scene.control.ButtonType.OK);
	        alert.showAndWait();
    		
    	}else {
    		int m=0;
    		try {
    			//-----------?????????????????----------------------
    			Episode e=Dao.EpisodeDAO.FindEpParIdShowNumSaison(?, ?,Integer.parseInt(txt_numSaison.getText()));//hneiya zeda lezimni idShow et num Saison
    			txt_titre.setText(e.getTitre_ep());
    			txt_description(e.getDesc_ep());
    			//-----------????????????????????----
    			//probleme de date zeda ken mchee b dateOb lezimni nzidha f classe .. naarach ken f base titzedd wala
    			/* 
    			if (datePIcker == null) {
		    	        datePIcker = new DatePicker();
		    	    }
		    	    datePicker.setPromptText(Dao.ShowDAO.getDateOnly(e.getDateOb()));
    		} catch (NumberFormatException e) {
	    		e.printStackTrace();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	if (m == 0) {
    	        Alert alert = new Alert(AlertType.ERROR, "Aucun Show trouvee avec ce Id", javafx.scene.control.ButtonType.OK);
    	        alert.showAndWait();
    	        }
    		
    	}
    	
    
	
	
    @FXML
    void addEpisode() {
    	Episode e=null;
    	int numEp = Integer.parseInt(txt_searchId.getText());
	    	 try {
	    		 Episode e = Dao.Episode.findShowParID(id);
	    	     if (show != null) {
	    	    	 Alert alert = new Alert(AlertType.ERROR);
	    	         alert.setTitle("Erreur");
	    	         alert.setHeaderText("Un SHOW avec cet ID existe déjà");
	    	         alert.showAndWait();
	    	         return;
	    	     	}
	    	    } catch (Exception e) {
	    	        e.printStackTrace();
	    	        Alert alert = new Alert(AlertType.ERROR);
	    	        alert.setTitle("Erreur");
	    	        alert.setHeaderText("Une erreur s'est produite lors de la recherche du SHOW");
	    	        alert.showAndWait();
	    	        return;
	    	    }

        }

        

     @FXML
     void deleteEpisode() {

        }

       

        

     @FXML
     void updateEpisode() {

        }

      
    
}
