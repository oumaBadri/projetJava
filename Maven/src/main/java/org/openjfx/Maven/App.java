package org.openjfx.Maven;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
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


        scene = new Scene(loadFXML("AjoutShow"),1000,790);

       // scene = new Scene(loadFXML("login"),1000,790);

       // scene = new Scene(loadFXML("ProfileInterface"),1000,790);

      //  scene = new Scene(loadFXML("ProfileInterface"),1000,790);

       // scene = new Scene(loadFXML("UserHome"),1000,790);
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



 //System.out.println(AvisDAO.ShowTitre(1));

    	//System.out.println("hello");

    	/*LocalDate date = LocalDate.of(2022,10,20);
    	Show s=new Show(125, "Wednesday ", date, "	United States", "English","Dramatique", 1, "url de l'image");
    	ShowDAO.ajouterShow(s);*/

      launch();
    //	System.out.println(AvisDAO.findAll2(1));
    //	System.out.println(AvisDAO.ShowTitre(1));
    	//Avis a= new Avis(1, 1, 10, "jaime", 1, 1);
    	//AvisDAO.ajouterAvis(a);
    	/*LocalDate date = LocalDate.of(20,10,20);

    	Utilisateur a= new Utilisateur(2, "rahma", "bl", date, "r@gmail.com","741852963" );
    	UtilisateurDAO.ajouterUtilisateur(a);*/
    	//LocalDate date = LocalDate.of(20,10,20);

    	//Episode a= new Episode(1, 1,"loula", 1, "hhhhhh", date);
    	//EpisodeDAO.ajouterEpisode(a);
    	//ActeurDAO.modifAnnifActeur(1, date);
       
    	/*
<<<<<<< HEAD
      launch();
      /* LocalDate date = LocalDate.of(20,10,20);

    	Acteur a= new Acteur(2, "rahma", "bl", "r@gmail.com", "741852963",date );
    	ActeurDAO.ajouterActeur(a);*/
//=======
/*
        //launch();

        //launch();
>>>>>>> branch 'master' of https://github.com/oumaBadri/projetJava*/

     /* Utilisateur u = new Utilisateur(20, "ouma", "Badri",date,"badri@gmail.com" ,"12345678","");
=======
    /*  Utilisateur u = new Utilisateur(20, "hamoudaa", "badrii",date,"hamouda@gamail.com" ,"12345678");
>>>>>>> branch 'master' of https://github.com/oumaBadri/projetJava.git
      UtilisateurDAO.ajouterUtilisateur(u);*/
     /* Show sh = new Show(12, "Suits", date,"uk","english","Comédie",0,"images/Suits.jpg");
      ShowDAO.ajouterShow(sh);*/
      /*Producteur p =new Producteur(20, "heelloo", "baadroo", "badri@gmail", "12345678",date);
        ProducteurDAO.ajouterProducteur(p);*/
        //hello world
    /*	List<Show> sh= ShowDAO.findAll2();
    	System.out.println(sh);*/
        
       //System.out.println(Dao.ShowDAO.findShowParID(12));
    	
       
       
    	//test
    	/*LocalDate date=LocalDate.of(2002,06, 18);
    	Acteur a=new Acteur(12,"malak","bendhia","bendhia@gmail.com","1236457",date);
    	Dao.ActeurDAO.ajouterActeur(a);*/
    	
    	/*try {
			int n=Dao.ShowDAO.getNombreSaisons(12);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
    }


}