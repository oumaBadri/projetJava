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

import Dao.AdminDao;
import Dao.AvisDAO;
import Dao.ClassementDao;
import Dao.SaisonDao;
import Dao.ShowDAO;


import Dao.UtilisateurDAO;
import Models.Acteur;
import Models.Admin;
import Models.Avis;
import Dao.UtilisateurDAO;

import Models.Show;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

    	scene = new Scene(loadFXML("LoginAd"),1000,790);

    	//scene = new Scene(loadFXML("Consultation"),1000,790);



        //scene = new Scene(loadFXML("AjoutShow"),1000,790);

    	//scene = new Scene(loadFXML("AjoutShow"),1000,790);


    	//scene = new Scene(loadFXML("login"),1000,790);

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
    	

  
    }

}    	
    	



