package org.openjfx.Maven;

import java.sql.SQLException;
import java.time.LocalDate;

import Models.Episode;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class AjoutEpisodeController {

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
    private TextField txt_payer;

    @FXML
    private TextField txt_searchId;

    @FXML
    private TextField txt_titre;

    
    @FXML
    void ShowEpisode() {
    	int idShow;
    	int numSaison;
    	
    	try {
			Dao.EpisodeDAO.FindEpParIdShowNumSaison(idShow, numSaison);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    }
	
    @FXML
    void addEpisode() {

        }

        

     @FXML
     void deleteEpisode() {

        }

       

        

     @FXML
     void updateEpisode() {

        }

      
    
}
