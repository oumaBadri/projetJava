package org.openjfx.Maven;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Models.Episode;
import Models.Show;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AjoutActeurController implements Initializable {

	static Show s=new Show();
	static Episode ep=new Episode();
	@FXML
    private HBox Hbox;

    @FXML
    private ChoiceBox<Integer> choicebox;

    @FXML
    private TextField textActeur;
	
	
	


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		AjoutEpisodeController e3 = new AjoutEpisodeController();
		List<Integer> saisonliste=new ArrayList<>();
		try {
			saisonliste = createListe();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	    choicebox.getItems().addAll(saisonliste);
	    choicebox.setOnAction((e)-> {try {
			displayAc(choicebox.getValue());
			e3.ep.setNum_saison(choicebox.getValue());
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      });
		
		
		
		
	}
	
	private  List<Integer> createListe() throws SQLException {
	    List<Integer> saisons= new ArrayList<>();	
	     //int nb=ShowDAO.getNombreSaisons();
	    int nb=Integer.parseInt(textActeur.getText());
	     System.out.println(nb);
	    for(int i=0;i<nb;i++) {
	    	int f=i+1;
	    	saisons.add(f);	
	    }
	    return saisons;
	    }
	
	
	public void displayAc(int numActeur) throws NumberFormatException, SQLException {
        int n=0;
        try { 
            n = Integer.parseInt(textActeur.getText()) ;
            } catch (NumberFormatException e) {
            // handle the exception
        }
        
        VBox vbox = new VBox();
        
        for (int i = 0; i < n; i++) {
            try {
            	Hbox.getChildren().clear();
            	
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DisplayActeur.fxml"));
                HBox display = fxmlLoader.load();
             
                vbox.getChildren().add(display);
                vbox.getChildren().add(new Separator(Orientation.HORIZONTAL)); // ajoute une ligne de séparation après chaque épisode
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        Hbox.getChildren().add(vbox);
    }

	
	
	
}
