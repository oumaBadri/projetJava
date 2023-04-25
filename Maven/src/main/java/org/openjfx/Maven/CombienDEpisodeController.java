package org.openjfx.Maven;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Dao.SaisonDao;
import Dao.ShowDAO;
import Models.Episode;
import Models.Saison;
import Models.Show;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CombienDEpisodeController implements Initializable {
		static Show s=new Show();
		
		static Episode ep=new Episode();
		//AjoutEpisodeController ajoutEp=new AjoutEpisodeController();
		
		@FXML
	    private HBox boucle;
	
	  	@FXML
	    private Button btnAjouterEpisode;

	    @FXML
	    private Button btnPageAcceuil;

	    @FXML
	    private TextField nbrEpisode_txtField;
	    @FXML
	    private TextField nmrSaison_txtField;

	    @FXML
	    private TextField titreShow;
	    @FXML
	    private ChoiceBox<Integer> choicebox;

	    @FXML
	    private TextField titreSaison;
	    @FXML
	    private TextField dateSaison;
	    @FXML
	    private TextArea Description;
	    @FXML
	    private DatePicker DateDiffusion;
	    
	    


		@Override
		public void initialize(URL location, ResourceBundle resources) {
			titreShow.setText(s.getTitre_show());
			AjoutEpisodeController e3 = new AjoutEpisodeController();
			AjoutActeurController ac = new AjoutActeurController();
			
	
			List<Integer> saisonliste=new ArrayList<>();
			try {
				saisonliste = createListe();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		    choicebox.getItems().addAll(saisonliste);
		    choicebox.setOnAction((e)-> {try {
				displayEp(choicebox.getValue());
				e3.ep.setNum_saison(choicebox.getValue());
				ac.ep.setNum_saison(choicebox.getValue());
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		      });
			
			
			}
		
			
		

		 //*********pour cree liste de choicebox*****************
	    private  List<Integer> createListe() throws SQLException {
	    List<Integer> saisons= new ArrayList<>();	
	     //int nb=ShowDAO.getNombreSaisons();
	    int nb=s.getNb_Saison();
	     System.out.println(nb);
	    for(int i=0;i<nb;i++) {
	    	int f=i+1;
	    	saisons.add(f);	
	    }
	    return saisons;
	    }
	    
	    
	//********pour le display de hbox*************
	 
	    public void displayEp(int numSaison) throws NumberFormatException, SQLException {
	        int n=0;
	        try { 
	            n = Integer.parseInt(nbrEpisode_txtField.getText()) ;
	            } catch (NumberFormatException e) {
	            // handle the exception
	        }
	        
	        VBox vbox = new VBox();
	        
	        for (int i = 0; i < n; i++) {
	            try {
	            	boucle.getChildren().clear();
	            	
	                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjoutEp.fxml"));
	                HBox display = fxmlLoader.load();
	                Label label = (Label) display.lookup("#numEp");
	                Button button = (Button) display.lookup("#play");
	                label.setText(String.valueOf(i+1));
	                vbox.getChildren().add(display);
	                vbox.getChildren().add(new Separator(Orientation.HORIZONTAL)); // ajoute une ligne de séparation après chaque épisode
	                
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        
	        boucle.getChildren().add(vbox);
	    }


	//***********************************************************************************
	    
	   public  void AjoutDetailSaison()
	   {
		 Saison a = new Saison(s.getId_show(),titreSaison.getText(),Integer.parseInt(nbrEpisode_txtField.getText()),choicebox.getValue(),DateDiffusion.getValue(),Description.getText());
		 SaisonDao.ajouterSaison(a); 
		}
	   
	   public void Acteur() throws IOException {
		   App.setRoot("AjoutActeur");
	   }
	   
		} 

	    
	    
