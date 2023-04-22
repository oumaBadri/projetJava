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

import Dao.AvisDAO;
import Dao.SaisonDao;
import Dao.ShowDAO;
import Dao.UtilisateurDAO;
import Models.Show;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

    	scene = new Scene(loadFXML("login"),1000,790);
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
    	
    	//AvisDAO.modifCom(1, 0, 0, 2, "biiii");
    	/*Show s=new Show(123,"13 reasons why",LocalDate.of(2022,10,20),"aze0","azerty","Dramatique",0,"url");
    	Service.ShowService.addShow(s);
    	*/

    	//System.out.println(Service.ShowService.exitSerieWithId(17));
 //System.out.println(AvisDAO.ShowTitre(1));

    	//System.out.println("hello");

    	/*LocalDate date = LocalDate.of(2022,10,20);
    	Show s=new Show(125, "Wednesday ", date, "	United States", "English","Dramatique", 1, "url de l'image");
    	ShowDAO.ajouterShow(s);*/

      //launch();
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
//System.out.println(SaisonDao.getDescrip(1));
    //launch();
    	//UtilisateurDAO.supprimerUtilisateur(1);
    	//System.out.println(ShowDAO.getNombreSaisons(1));
    	//System.out.println(SaisonDao.getNbEp(1, 1));
    	//System.out.println(ShowDAO.findActeursByShow(1));
   
    }


}