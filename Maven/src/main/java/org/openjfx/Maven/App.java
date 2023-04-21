package org.openjfx.Maven;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import Dao.SaisonDao;
import Dao.ShowDAO;

import Dao.UtilisateurDAO;
import Models.Acteur;
import Models.Show;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
    	scene = new Scene(loadFXML("RechercheActeur"),1000,790);
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

    public static void main(String[] args) {

    	launch(); 
    	//List<Acteur> acteurs =UtilisateurDAO.RechercherActeur("ouma");
    	//for(Acteur acteur :acteurs){
    		//System.out.println(acteur.getNom_ac());
    		//System.out.println(acteur.getPrenom_ac());
    	}
    	
    }


