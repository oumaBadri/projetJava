package org.openjfx.Maven;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Controller.ControlSaisie;
import Dao.AvisDAO;
import Dao.ClassementDao;
import Dao.SaisonDao;
import Dao.ShowDAO;
import Models.Acteur;
import Models.Avis;
import Models.Show;
import Models.Utilisateur;
import Service.ShowService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DetailShowController implements Initializable {
	
	static Show s= new Show();
	
	static Utilisateur a= new Utilisateur();
	@FXML
    private ChoiceBox<Integer> choice;
	@FXML
    private HBox boucle;
	@FXML
    private Label tit;
	@FXML
    private Label notecor;
	
	 @FXML
	 private TextField note;
	@FXML
	private FlowPane acteursFlowPane;
	@FXML
    private Button avisbtn;
	
	@FXML
	private HBox Hbox2;
	  @FXML
	    private Label date;
	  @FXML
	    private Label genre;
	  @FXML
	    private TextArea avis;

    @FXML
    private ImageView affiche;

    @FXML
    private TextArea description;
    @FXML
    private HBox Hbox;
    @FXML
    private Label langue;
    @FXML
    private Label savemsg;
    @FXML
    private Label nbep;

    @FXML
    private Label pays;

    @FXML
    private Button play;
    
    @FXML
    private Button backbtn;
    
    
    //*********pour cree liste de choicebox*****************
    private  List<Integer> createListe() throws SQLException {
    List<Integer> saisons= new ArrayList<>();	
     int nb= ShowDAO.getNombreSaisons(s.getId_show());
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
            n = SaisonDao.getNbEp(s.getId_show(), choice.getValue());
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
                label.setText(String.valueOf(i+1));
               
                
                vbox.getChildren().add(display);
                vbox.getChildren().add(new Separator(Orientation.HORIZONTAL)); // ajoute une ligne de séparation après chaque épisode
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        boucle.getChildren().add(vbox);
         }
///***********retour home page***************
    @FXML
    void back() throws IOException {
    	App.setRoot("UserHome");
    }
    //***********donner avis*************
    @FXML
    void saveAvis(ActionEvent event) {
    	
    	Boolean ChampValid=true;
    	
    	 if (ControlSaisie.validNote(Integer.parseInt(note.getText()))==false){
     		notecor.setText("Number between 0 and 10");
     		ChampValid=false;
     	}
    	
    	if (ChampValid) {
    	Avis av=new Avis();
    	savemsg.setText("comment added");
    	av.setNote(Integer.parseInt(note.getText()));
    	av.setCommantaire(avis.getText());
    	av.setId_show(s.getId_show());
    	av.setNum_ep(0);
    	av.setId_user(a.getId_user());
    	System.out.println(av);
    	System.out.println(av.getNote());
    	System.out.println(av.getCommantaire());
    	System.out.println(a.getId_user());
    	AvisDAO.ajouterCmn(av);
    	}
    }
   
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		

//*****************pour le choiceBox*******************

		List<Integer> saisonliste=new ArrayList<>();

			try {
				saisonliste = createListe();
				
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		
		choice.getItems().addAll(saisonliste);
		
		if(!saisonliste.isEmpty()){
		    choice.setValue(saisonliste.get(0));
		    try {
				displayEp(choice.getValue());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//choice.setValue(1);
		//choice.setOnAction(this::displayEp);
		 choice.setOnAction((event) -> {
		        try {
		        	
		           displayEp(choice.getValue());
		        } catch (NumberFormatException | SQLException e) {
		            e.printStackTrace();
		        }
		    });
		
		//********display affiche*****************
	try {
	Show show1 =ShowDAO.findShowParID(s.getId_show());
	System.out.println(show1);
	FXMLLoader fxmlLoader = new FXMLLoader();
	fxmlLoader.setLocation(getClass().getResource("affiche.fxml"));
	VBox image  = fxmlLoader.load();
	AfficheController afficheController = fxmlLoader.getController();
	if (afficheController != null) {
	    afficheController.setData2(show1.getAffiche());
	}
	//imageController.setData(show);
	Hbox2.getChildren().add(image);
	
	
}catch(IOException e) {
	e.printStackTrace();
}
	
//*******display les autes info *************
		
	tit.setText(s.getTitre_show());
		langue.setText(s.getLangue());
		pays.setText(s.getPays());
		genre.setText(s.getGenre_show());
		
  	   s.setDate_difussion_show(ShowDAO.getDateOnly2(s.getDateOb().toString()));
		date.setText(s.getDate_difussion_show().toString());
		//date.setText(ShowDAO.getDateOnly(s.getDateOb()));
		try {
			description.setText(SaisonDao.getDescrip(s.getId_show()));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
	//******display les acteurs***************	
		try {
			List<Acteur> acteurs =ShowDAO.findActeursByShow(s.getId_show());
			System.out.println();
			for(Acteur acteur :acteurs){
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("Acteuraff.fxml"));
			VBox image  = fxmlLoader.load();
			ActeurAffController affController = fxmlLoader.getController();
			if (affController != null) {
				String s= acteur.getNom_ac()+" "+acteur.getPrenom_ac();
			    affController.setData(s);
			}
			Hbox.getChildren().add(image);
			
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void addview() {
		LocalDate dateActuelle = LocalDate.now();
		ClassementDao.save_view(s.getId_show(),1,dateActuelle.getMonthValue());
		
		
	}

	 

}
