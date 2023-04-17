
package org.openjfx.Maven;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
	    private TableColumn<?, ?> cln_affiche;

	    @FXML
	    private TableColumn<?, ?> cln_dateDiff;

	    @FXML
	    private TableColumn<?, ?> cln_genre;

	    @FXML
	    private TableColumn<?, ?> cln_id;

	    @FXML
	    private TableColumn<?, ?> cln_isAFilm;

	    @FXML
	    private TableColumn<?, ?> cln_langue;

	    @FXML
	    private TableColumn<?, ?> cln_pays;

	    @FXML
	    private TableColumn<?, ?> cln_titre;

	    @FXML
	    private DatePicker dateDiff;

	    @FXML
	    private ImageView imageView_search;

	    @FXML
	    private TableView<?> table;

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

}
