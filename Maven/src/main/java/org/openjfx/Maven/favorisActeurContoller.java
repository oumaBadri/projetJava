package org.openjfx.Maven;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;


import Service.ActeurService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class favorisActeurContoller implements Initializable{
	 @FXML
	    private ListView<String> acteurList= new ListView<>();
		ObservableList<String> list= FXCollections.observableArrayList();
		ProfileInterfaceControllerUser ii=new ProfileInterfaceControllerUser();
	  
	  private void afficherlist() throws SQLException {
		  list.removeAll(list);
		  List<String> c=ActeurService.nomById(ii.a.getId_user());
			  c.stream().forEach(x->{
				acteurList.getItems().add(x);
			});
			  
	  }

	  
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
