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

<<<<<<< HEAD

    	scene = new Scene(loadFXML("LoginPro"),1000,790);
    //	scene = new Scene(loadFXML("loginUser"),1000,790);


=======
    	scene = new Scene(loadFXML("LoginAd"),1000,790);
        scene = new Scene(loadFXML("AjoutShow"),1000,790);
>>>>>>> branch 'master' of https://github.com/oumaBadri/projetJava
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
<<<<<<< HEAD
//System.out.println(ClassementDao.getshowVote());
    	//System.out.println(AdminDao.findAll().stream().filter(a->a.getEmail().equals("y@gmail.com")));
    	/*System.out.println(AdminDao.getAdministrateur("y@gmail.com"));
    	LocalDate date = LocalDate.of(2022,10,20);
    	Admin a = new Admin(3, "nilsen","youssef", "n@gmail.com", "741852963", date);
    	System.out.println(AdminDao.ajouterAdministrateur(a));*/
    	//System.out.println(AdminDao.getAdministrateur("n@gmail.com"));
      launch();
    	//System.out.println(ControlSaisie.ExisteEmailAd("y@gmail.com"));
    	//System.out.println(AdminService.login("y@gmail.com", "123456789"));

	    
    	//System.out.println(ClassementMoisController.createListe());
    	/*System.out.println(ClassementDao.IdByVueBymois(4));
    	List<String> classementlist=new ArrayList<>();
    	List<Integer> a= ClassementDao.IdByVueBymois(4);
    	for(Integer i:a) {
    		classementlist.add(ShowDAO.ShowTitre(i));
    	}
    	System.out.println(classementlist.toString());*/
    /*	List<String> classementlist=new ArrayList<>();
    	List<Integer> a= ClassementDao.IdByVue();
    	for(Integer i:a) {
    		classementlist.add(ShowDAO.ShowTitre(i));
    	}
    	System.out.println(classementlist);*/
    /*List<Admin> a=   AdminDao.findAll();
 System.out.println(a);
    	/*Avis a= new Avis(20, 1, 0,"hello",1, 1);
    	AvisDAO.ajouterAvis(a);*/
    //launch();
    	//ClassementDao.save_view(10,50,4);
    	//System.out.println(ClassementController.ShowTitreByvue());
    	
    	//System.out.println(ClassementDao.getshowVue());
  /*  double s=	AvisDAO.CalculScore(10);
    	System.out.println(s);
    	
    	/*double s=AvisDAO.CalculScoreSaison(10, 1);
    	System.out.println(s);*/
    	
    	
    	//launch();

    	//helloooo
    	//System.out.println(Dao.ShowDAO.findShowParID(13));

    	//System.out.println(AvisDAO.envoyerNotif(2));
    	//AvisDAO.modifCom(1, 0, 0, 2, "biiii");

    	/*Show s=new Show(123,"13 reasons why",LocalDate.of(2022,10,20),"aze0","azerty","Dramatique",0,"url");
    	Service.ShowService.addShow(s);
    	*/
    	/*List<Avis> avis=AvisDAO.findAvis2(10);
    	System.out.println(avis);*/
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
=======
        launch();
        //hello
>>>>>>> branch 'master' of https://github.com/oumaBadri/projetJava
        
  }

    



}    	
    	



