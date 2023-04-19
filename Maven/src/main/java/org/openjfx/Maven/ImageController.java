package org.openjfx.Maven;



import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.AvisDAO;
import Dao.EpisodeDAO;
import Dao.ShowDAO;
import Models.Avis;
import Models.Episode;
import Models.Show;
import Models.Utilisateur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import utile.conxBD;
import javafx.scene.image.Image;

public class ImageController {
	


	@FXML
    private  ImageView affiche;

    @FXML
    private Button like;

    @FXML
    private Button play;

    @FXML
    private Button show;

    @FXML
    private  Label titre;
    
    static Utilisateur a = new Utilisateur();
    
    
      
   public  void setData(Show show) {
	Image image = new Image(getClass().getResourceAsStream(show.getAffiche()));
	affiche.setImage(image);
	titre.setText(show.getTitre_show());
	}
    
    
   

   
   
   public static String getRelativeImagePath(String path) {
	    int index = path.indexOf("images/");
	    if (index >= 0) {
	        return path.substring(index);
	    } else {
	        return "";
	    }
	}
   

   

   
   
   public void AjoutFavoris() throws SQLException {
		  System.out.println(affiche.getImage().getUrl()+"++++++");

	 Show sh=ShowDAO.findShow(titre.getText(),getRelativeImagePath(affiche.getImage().getUrl()));
	 Avis avis=new Avis(a.getId_user(),sh.getId_show(),0, null);
	 AvisDAO.ajouterAvis(avis);
	 AvisDAO.modifFavoriShow(sh.getId_show(),a.getId_user());
	   
	   
   }
   
   



    
}
