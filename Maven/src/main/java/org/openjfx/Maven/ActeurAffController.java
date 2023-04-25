package org.openjfx.Maven;

import java.sql.SQLException;

import Dao.ActeurDAO;
import Dao.ActeurFavorisDao;
import Models.ActeurFavoris;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ActeurAffController {
	@FXML
    private ImageView affiche;

    @FXML
    private Label titre;
    
    
    public  void setData(String nom) {
    	Image image = new Image(getClass().getResourceAsStream("images/acteur.png"));
    	affiche.setImage(image);
    	titre.setText(nom);
    	}
    
    public void favoris() throws SQLException {
    	ProfileInterfaceControllerUser u= new ProfileInterfaceControllerUser();
    	//ActeurDAO.ajouterFavoriS(u.a.getId_user(), ActeurDAO.trouverIdActeurS(titre.getText()));
    	System.out.println(titre.getText()+"88888888888888888888");
    	String nomComplet = titre.getText();
    	String[] parties = nomComplet.split(" ");
    	String nom = parties[0];
    	System.out.println(nom);
    	ActeurFavoris a = new ActeurFavoris(u.a.getId_user(),ActeurDAO.trouverIdActeurS(nom));
    	System.out.println(a);
    	ActeurFavorisDao.ajouterActeurFavoris(a);
    	
    }
    
    
    
    
}
