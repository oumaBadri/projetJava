package org.openjfx.Maven;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import Models.Utilisateur;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

public class GenreController  {

   static Utilisateur u = new Utilisateur();
    
    @FXML
    private CheckBox action;

    @FXML
    private CheckBox comedie;

    @FXML
    private CheckBox dramatique;

    @FXML
    private CheckBox historique;

    @FXML
    private CheckBox policien;

    @FXML
    private CheckBox romance;
   
    
    public void actionPerformed() throws IOException {
        
            // Récupération des choix de l'utilisateur à partir des cases à cocher
            if (dramatique.isSelected()) {
              Dao.GenreDao.ajouterGenre(u.getId_user(), "Dramatique");
              System.out.println(u.getId_user()+"********************");
            }
            if (policien.isSelected()) {
            	 Dao.GenreDao.ajouterGenre(u.getId_user(), "Policier");
            }
            if (action.isSelected()) {
            	 Dao.GenreDao.ajouterGenre(u.getId_user(), "Action");
            }
            if (romance.isSelected()) {
            	 Dao.GenreDao.ajouterGenre(u.getId_user(), "Romance");
            }
            if (historique.isSelected()) {
            	 Dao.GenreDao.ajouterGenre(u.getId_user(), "Historique");
            }
            if (comedie.isSelected()) {
            	 Dao.GenreDao.ajouterGenre(u.getId_user(), "Comédie");
            }
            App.setRoot("UserHome");
	  
    }
}
