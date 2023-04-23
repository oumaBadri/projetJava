package org.openjfx.Maven;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import Dao.ActeurDAO;
import Dao.AvisDAO;
import Dao.ShowDAO;
import Models.Show;
import Models.Utilisateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class favorisFilmController implements Initializable{
		ObservableList<String> list= FXCollections.observableArrayList();
	
		static Utilisateur a= new Utilisateur();
		  @FXML
		    private ImageView retour;
		
		@FXML
	    private Button details;
		

	    @FXML
	    private Button supp;
	  @FXML
	    private ListView<String> filmList;
	  
	  
	  private void afficherlist() throws SQLException {
		  list.removeAll(list);
		 //AvisDAO.findAll2(1).stream().forEach(x->filmList.getItems().addAll(x.));
		  AvisDAO.findAll2(a.getId_user()).stream().forEach(x->{
			try {
				filmList.getItems().addAll(ShowDAO.ShowTitre(x));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		 //ActeurDAO.findAll().stream().forEach(x->filmList.getItems().addAll(x.toString()));
	  }


	  
	  
	  @FXML
	    void supprimer(ActionEvent event) throws SQLException {
		  
		        String selectedItem = filmList.getSelectionModel().getSelectedItem();
		        if (selectedItem != null) {
		        	AvisDAO.suppFavoriShow(ShowDAO.idTitre(selectedItem), (AvisDAO.findAvis(ShowDAO.idTitre(selectedItem), a.getId_user())).getNum_ep(), (AvisDAO.findAvis(ShowDAO.idTitre(selectedItem), a.getId_user())).getNum_saison(), a.getId_user());
		            filmList.getItems().remove(selectedItem);
		        }
		  }
	  

	    @FXML
	    void voirdetails(ActionEvent event) throws IOException {
	    	
	    	String selectedItem = filmList.getSelectionModel().getSelectedItem();
	    	int i=ShowDAO.findIdShow(selectedItem);
	    	Show show= ShowDAO.findShowParID(i);
	    	
	        if (selectedItem != null) {
	        	DetailShowController.s.setAffiche(show.getAffiche());
	     	   DetailShowController.s.setTitre_show(show.getTitre_show());
	     	   DetailShowController.s.setId_show(i);
	     	   Show q= ShowDAO.findShowParID(i);
	     	   
	     	   Object c=q.getDateOb();
	     	   DetailShowController.s.setDateOb(c);
	     	   DetailShowController.s.setGenre_show(q.getGenre_show());
	     	   DetailShowController.s.setLangue(q.getLangue());
	     	   DetailShowController.s.setPays(q.getPays());
	     	   DetailShowController.s.setIs_a_film(q.getIs_a_film());

	     	   App.setRoot("DetailShow");
	        }
	    	
	    	
	    	
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
