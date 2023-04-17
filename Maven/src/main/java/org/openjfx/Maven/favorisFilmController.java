package org.openjfx.Maven;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import Dao.ActeurDAO;
import Dao.AvisDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class favorisFilmController implements Initializable{
		ObservableList<String> list= FXCollections.observableArrayList();
	
	
	  @FXML
	    private ListView<String> filmList;
	  
	  
	  private void afficherlist() throws SQLException {
		  list.removeAll(list);
		 //AvisDAO.findAll2(1).stream().forEach(x->filmList.getItems().addAll(x.));
		  AvisDAO.findAll2(1).stream().forEach(x->{
			try {
				filmList.getItems().addAll(AvisDAO.ShowTitre(x));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		 //ActeurDAO.findAll().stream().forEach(x->filmList.getItems().addAll(x.toString()));
	  }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		try {
			afficherlist();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
