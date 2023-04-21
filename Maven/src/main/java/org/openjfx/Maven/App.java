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
import Models.Show;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
    	scene = new Scene(loadFXML("AcLogin"),1000,790);
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
//System.out.println(SaisonDao.getDescrip(1));
    launch();
    	//System.out.println(ShowDAO.getNombreSaisons(1));
    	//System.out.println(SaisonDao.getNbEp(1, 1));
    	//System.out.println(ShowDAO.findActeursByShow(1));
   
    }


}