package org.openjfx.Maven;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Controller.ControlSaisie;
import Dao.ActeurDAO;
import Dao.AdminDao;
import Dao.AvisDAO;
import Dao.ClassementDao;
import Dao.ProducteurDAO;
import Dao.SaisonDao;
import Dao.ShowDAO;


import Dao.UtilisateurDAO;
import Models.Acteur;
import Models.Admin;
import Models.Avis;
import Dao.UtilisateurDAO;

import Models.Show;
import Service.AdminService;
import Service.ProducteurService;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
    	scene = new Scene(loadFXML("logInTypee"),1000,790);
        stage.setScene(scene);
        stage.show();
        }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }


    public static void main(String[] args) throws SQLException {

    	launch();
    //	System.out.println(ShowDAO.supprimerShow(3));
/*List<String> s= new ArrayList<>();
    	List<Integer> a=ActeurDAO.findAllfavAc(1);
    	for (int id:a) {
    		s.add(ActeurDAO.trouverNomActeurbyId(id));
    	}
    	System.out.println(s);*/
  }

    



}    	
    	



