package org.openjfx.Maven;



import java.net.URL;
import java.sql.SQLException;

import Dao.AvisDAO;
import Dao.EpisodeDAO;
import Dao.ShowDAO;
import Models.Avis;
import Models.Episode;
import Models.Show;
import Models.Utilisateur;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class ImageController {

	@FXML
    private ImageView affiche;

    @FXML
    private Button like;

    @FXML
    private Button play;

    @FXML
    private Button show;

    @FXML
    private Label titre;
    
    Utilisateur a = new Utilisateur();
      
   public  void setData(Show show) {
	Image image = new Image(getClass().getResourceAsStream(show.getAffiche()));
	affiche.setImage(image);
	titre.setText(show.getTitre_show());
	}
   
   
   public void AjoutFavoris() throws SQLException {
	  
	 Show sh=ShowDAO.findShow(titre.getText(),affiche.getImage().getUrl());
	 Episode ep =EpisodeDAO.FindEp(sh.getId_show());	
	 Avis a =new Avis(a.getId_user(),sh.getId_show(),0, null,ep.getNum_ep(),ep.getNum_saison());
	 AvisDAO.ajouterAvis(a);
	 AvisDAO.modifFavoriShow(sh.getId_show(),ep.getNum_ep(),ep.getNum_saison(),a.getId_user());
	   
	   
   }
    
}
