 package org.openjfx.Maven;



import java.io.IOException;
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
import javafx.scene.input.MouseEvent;
import utile.conxBD;
import javafx.scene.image.Image;

public class ImageController {
	

   
	
	@FXML
    private ImageView detail;
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
	 int sh=ShowDAO.findIdShow(titre.getText());
     Avis avis=new Avis(a.getId_user(),sh);
	 AvisDAO.ajouterAvis(avis);
	 AvisDAO.modifFavoriShow(sh,a.getId_user());
   }
   
   

   @FXML
   void voirDetail(MouseEvent event) throws IOException {
	   
	   DetailShowController.s.setAffiche(affiche.getImage().getUrl());
	   DetailShowController.s.setTitre_show(titre.getText());
	   int x =ShowDAO.findIdShow(titre.getText());
	   DetailShowController.s.setId_show(x);
	   Show q= ShowDAO.findShowParID(x);
	   
	   Object c=q.getDateOb();
	   DetailShowController.s.setDateOb(c);
	   DetailShowController.s.setGenre_show(q.getGenre_show());
	   DetailShowController.s.setLangue(q.getLangue());
	   DetailShowController.s.setPays(q.getPays());
	   DetailShowController.s.setIs_a_film(q.getIs_a_film());

	   
	   App.setRoot("DetailShow");

   }

    
}
