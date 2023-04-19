package org.openjfx.Maven;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Dao.AvisDAO;
import Models.Utilisateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class NotifController implements Initializable{
	
	@FXML
    private ImageView retour;
	
	 @FXML
	    private ListView<String> notif;
	
	 
		ObservableList<String> list= FXCollections.observableArrayList();
		
		static Utilisateur a= new Utilisateur();

	
	  
	  private void afficherlist() throws SQLException {
		  list.removeAll(list);
		 //notif.getItems().addAll(AvisDAO.ShowTitre(x));
			notif.getItems().addAll( AvisDAO.envoyerNotif(a.getId_user()));
		};
		 //ActeurDAO.findAll().stream().forEach(x->filmList.getItems().addAll(x.toString()));
	  //}

		
		
		
		 @FXML
		    void retour(MouseEvent event) throws IOException {
			 App.setRoot("UserHome");

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

//}
