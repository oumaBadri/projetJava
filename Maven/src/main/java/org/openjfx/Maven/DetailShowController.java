package org.openjfx.Maven;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import Dao.AvisDAO;
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
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
    private ChoiceBox<String> choice;
	
	@FXML
    private Label tit;
	@FXML
	private FlowPane acteursFlowPane;
	
	  @FXML
	    private HBox Hbox2;
	  @FXML
	    private Label date;
	  @FXML
	    private Label genre;

    @FXML
    private ImageView affiche;

    @FXML
    private TextArea description;
    @FXML
    private HBox Hbox;
    @FXML
    private Label langue;

    @FXML
    private Label nbep;

    @FXML
    private Label pays;

    @FXML
    private Button play;
    
    

    @FXML
    void addFav(MouseEvent event) {
    	 int sh=ShowDAO.findIdShow(tit.getText());
         Avis avis=new Avis(a.getId_user(),sh);
         avis.setNum_ep(1);
    	 AvisDAO.ajouterAvis(avis);
    	 AvisDAO.modifFavoriShow(sh,a.getId_user());
    }
    
    
    
    private  List<String> createListe() throws SQLException {
    List<String> saisons=null;	
     int nb= ShowDAO.getNombreSaisons(s.getId_show());
    for(int i=0;i<nb;i++) 
    {saisons.add("saison "+i);	
    }
    return saisons;
    }
    
    
    
    
    public void displayEp(String numSaison) {
    
    }
    
   
 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
//*****************pour le choiceBox*******************
		List<String> saisonliste=null;
		
			try {
				saisonliste = createListe();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		
		choice.getItems().addAll(saisonliste);
		
		
		
		//********display affiche*****************
	try {
	Show show1 =ShowDAO.findShowParID(s.getId_show());
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
	

		
	tit.setText(s.getTitre_show());
		langue.setText(s.getLangue());
		pays.setText(s.getPays());
		genre.setText(s.getGenre_show());
		date.setText(ShowDAO.getDateOnly(s.getDateOb()));
		try {
			description.setText(SaisonDao.getDescrip(s.getId_show()));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
			
		try {
			List<Acteur> acteurs =ShowDAO.findActeursByShow(s.getId_show());
			for(Acteur acteur :acteurs){
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("Acteuraff.fxml"));
			VBox image  = fxmlLoader.load();
			ActeurAffController affController = fxmlLoader.getController();
			if (affController != null) {
				String s= acteur.getNom_ac()+acteur.getPrenom_ac();
			    affController.setData(s);
			}
			Hbox.getChildren().add(image);
			
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
