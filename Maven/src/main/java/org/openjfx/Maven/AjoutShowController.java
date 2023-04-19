
package org.openjfx.Maven;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
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
	    
	    @FXML
	    private TextField txt_poster;
	    
	    
	    //public ObservableList<Show> data=FXCollections.observableArrayList();
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
	    	
	    	int m=0;
	    	Show S=Dao.ShowDAO.findShowParID(Integer.parseInt(txt_searchId.getText()));
	    	txt_titre.setText(S.getTitre_show());
	    	txt_genre.setText(S.getGenre_show());
	    	
	    	if (S.getIs_a_film()==0) {
	    		txt_isAFilm.setText("True");
	    	}
	    	else {
	    		txt_isAFilm.setText("false");
	    	}
	 	   txt_langue.setText(S.getLangue());
	 	   txt_payer.setText(S.getPays());
	 	   txt_poster.setText(S.getAffiche());
	    	
	 	   //txt_NombreSaison (Ne5ou maand yosr l fonction bech naamelha f Dao b inner Join
	    }

	    @FXML
	    void updateShow() {

	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		showShow();
		
	}
	
	//pour voir la table de base de donnee
	public void showShow() {
		List<Show> shows=null;
		try {
			shows=Dao.ShowDAO.findAll();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		ObservableList<Show> observableList = FXCollections.observableList(shows);
		/*for(Show s:shows) {
			data.add(s.getId_show(),s.getTitre_show(),s.getDate_difussion_show(),s.getPays(),s.getGenre_show(),s.getIs_a_film(),s.getAffiche());
		}*/
		
		/*try {
			data=(ObservableList<Show>) Dao.ShowDAO.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		cln_id.setCellValueFactory(new PropertyValueFactory<Show,Integer>("id_show"));
		cln_titre.setCellValueFactory(new PropertyValueFactory<Show,String>("titre_show"));
		cln_dateDiff.setCellValueFactory(new PropertyValueFactory<Show,Date>("Date_diffusion"));
		cln_pays.setCellValueFactory(new PropertyValueFactory<Show,String>("pays"));
		cln_langue.setCellValueFactory(new PropertyValueFactory<Show,String>("langue"));
		cln_genre.setCellValueFactory(new PropertyValueFactory<Show,String>("genre_show"));
		cln_isAFilm.setCellValueFactory(new PropertyValueFactory<Show,Integer>("is_a_film"));
		cln_affiche.setCellValueFactory(new PropertyValueFactory<Show,String>("affiche"));
		table.setItems(observableList);
	}

}
