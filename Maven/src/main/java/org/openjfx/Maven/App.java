package org.openjfx.Maven;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;

import Dao.ProducteurDAO;
import Dao.UtilisateurDAO;
import Models.Acteur;
import Models.Producteur;
import Models.Utilisateur;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        scene = new Scene(loadFXML("AjoutShow"),1000,790);

        scene = new Scene(loadFXML("ProfileInterface"),1000,790);

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
    	//System.out.println("hello");

        //launch();

        //launch();
    	

    	/*Connection cnx = utile.conxBD.getInstance();
    	System.out.println("la connection is "+cnx);*/
    /*  LocalDate date = LocalDate.of(20,10,20);
      Utilisateur u = new Utilisateur(20, "hamoudaa", "badrii",date,"hamouda@gamail.com" ,"12345678");
      UtilisateurDAO.ajouterUtilisateur(u);*/
      /*  Producteur p =new Producteur(20, "heelloo", "baadroo", "badri@gmail", "12345678",date);
        ProducteurDAO.ajouterProducteur(p);*/
        //hello world
    	//test
    	LocalDate date=LocalDate.of(2002,06, 18);
    	Acteur a=new Acteur(12,"malak","bendhia","bendhia@gmail.com","1236457",date);
    	Dao.ActeurDAO.ajouterActeur(a);
    }

}