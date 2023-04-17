package org.openjfx.Maven;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import Models.Show;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class AjoutShowController implements Initializable{
	 	@FXML
	    private Button btn_add;

	    @FXML
	    private Button btn_delete;

	    @FXML
	    private Button btn_next;

	    @FXML
	    private Button btn_update;

	    @FXML
	    private TableColumn<Show, String> cln_affiche;

	    @FXML
	    private TableColumn<Show,Date > cln_dateDiff;

	    @FXML
	    private TableColumn<Show, String> cln_genre;

	    @FXML
	    private TableColumn<Show, Integer> cln_id;

	    @FXML
	    private TableColumn<Show, Integer> cln_isAFilm;

	    @FXML
	    private TableColumn<Show, String> cln_langue;

	    @FXML
	    private TableColumn<Show, String> cln_pays;

	    @FXML
	    private TableColumn<Show, String> cln_titre;

	    @FXML
	    private DatePicker dateDiff;

	    @FXML
	    private ImageView imageView_search;

	    @FXML
	    private TableView<Show> table;

	    @FXML
	    private TextField txt_NombreSaison;

	    @FXML
	    private TextField txt_genre;

	    @FXML
	    private TextField txt_isAFilm;

	    @FXML
	    private TextField txt_langue;

	    @FXML
	    private TextField txt_payer;

	    @FXML
	    private TextField txt_searchId;

	    @FXML
	    private TextField txt_titre;
	    
	    
	    public ObservableList<Show> data=FXCollections.observableArrayList();
	    @FXML
	    void addShow() {

	    }

	    @FXML
	    void deleteShow() {

	    }

	    @FXML
	    void next() {

	    }

	    @FXML
	    void searchShow() {

	    }

	    @FXML
	    void updateShow() {

	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	public void showShow() {
		cln_id.setCellValueFactory(new PropertyValueFactory<Show,Integer>("id_show"));
		cln_titre.setCellValueFactory(new PropertyValueFactory<Show,String>("id_titre"));
		cln_dateDiff.setCellValueFactory(new PropertyValueFactory<Show,Date>("id_show"));
		cln_pays.setCellValueFactory(new PropertyValueFactory<Show,String>("id_show"));
		cln_langue.setCellValueFactory(new PropertyValueFactory<Show,String>("id_show"));
		cln_genre.setCellValueFactory(new PropertyValueFactory<Show,String>("id_show"));
		cln_isAFilm.setCellValueFactory(new PropertyValueFactory<Show,Integer>("id_show"));
		
	}

}
