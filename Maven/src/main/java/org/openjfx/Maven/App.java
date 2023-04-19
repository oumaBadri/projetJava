package org.openjfx.Maven;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import Dao.ActeurDAO;
import Dao.AvisDAO;
import Dao.EpisodeDAO;
import Dao.ProducteurDAO;
import Dao.ShowDAO;
import Dao.UtilisateurDAO;
import Models.Acteur;
import Models.Avis;
import Models.Episode;
import Models.Producteur;
import Models.Show;
import Models.Utilisateur;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        scene = new Scene(loadFXML("image"),1000,790);
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

    	/*Avis a= new Avis(20, 1, 0,"hello",1, 1);
    	AvisDAO.ajouterAvis(a);*/
    	launch();
    	

    }


}