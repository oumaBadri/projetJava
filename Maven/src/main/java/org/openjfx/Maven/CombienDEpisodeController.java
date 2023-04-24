package org.openjfx.Maven;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Dao.SaisonDao;
import Dao.ShowDAO;
import Models.Episode;
import Models.Show;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
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

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			titreShow.setText(s.getTitre_show());
			
			/*try {
				i = Dao.ShowDAO.getNombreSaisons(s.getId_show());
			} catch (SQLException e) {*/
				//titreShow.setText(s.getTitre_show());
				//e.printStackTrace();
			//}
			
			//titreShow.setText(s.getTitre_show());
			
			
			}
		
		/*
		@FXML
		public void ajouter() {
			ep.setNum_saison(nmrSaison_txtField.getText());
		}*/
			
		

		 //*********pour cree liste de choicebox*****************
	    private  List<Integer> createListe() throws SQLException {
	    List<Integer> saisons= new ArrayList<>();	
	     int nb= ShowDAO.getNombreSaisons(ep.getId_show());
	    for(int i=0;i<nb;i++) 
	    {int f=i+1;
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
	            	
	                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("displayEp.fxml"));
	                HBox display = fxmlLoader.load();
	                Label label = (Label) display.lookup("#numEp");
	                Button button = (Button) display.lookup("#play");
	                label.setText(String.valueOf(i+1));
	                button.setOnAction(e -> {
	                    // action à effectuer lors du clic sur le bouton "Regarder"
	                	
							//App.setRoot("Playing");
						
	                });
	                
	                vbox.getChildren().add(display);
	                vbox.getChildren().add(new Separator(Orientation.HORIZONTAL)); // ajoute une ligne de séparation après chaque épisode
	                
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        
	        boucle.getChildren().add(vbox);
	    }


		}

	    
	    
