package org.openjfx.Maven;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Dao.ClassementDao;
import Dao.ShowDAO;
import Models.Show;
import Service.ShowService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ClassementMoisController implements Initializable{
	
	@FXML
    private HBox Hbox22;
	/*@FXML
	    private Label Hbox;*/
    @FXML
    private ChoiceBox<Integer> choicebox;
    
     static Show s= new Show();
    
    
    
    private   List<Integer> createListe() throws SQLException {
    	List<Integer> mois = new ArrayList<Integer>();
    	for (int i = 1; i <= 12; i++) {
    	    mois.add(i);
    	}
    	return mois;
	    }

    
    
    
    
    
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Hbox22.getChildren().clear();
		List<Integer> moisliste=new ArrayList<>();
		try {
			moisliste = createListe();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	    choicebox.getItems().addAll(moisliste);
	    choicebox.setOnAction(d->{
	    	Hbox22.getChildren().clear();
	    //pour l affiche de classement des series par image 
	    List<Show> show1 =ShowDAO.findShowParTitre(s.getTitre_show()); //show eli enne jibtouu eli chnaamlou classement
	    try {
			List<Show> all=ShowDAO.findAll2();  //all fiha les shows lkol
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    List<Integer> a =ClassementDao.IdByVueBymois(choicebox.getValue());
	    List<Show> showclassement=new ArrayList<>();
	    List<String> classementlist=new ArrayList<>();
    	for(Integer i:a) {
    		try {
			classementlist.add(ShowDAO.ShowTitre(i)); //les show bel titre mnadhmin 7asb el mois
		//showclassement.add(ShowDAO.findShowParID(i));//les show mndhmin emme listes des show 7asb el mois			
			showclassement.addAll(ShowDAO.findShowParTitre(ShowDAO.ShowTitre(i)));//les show mndhmin emme listes des show 7asb el mois
    		
    		
    		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
	    
	    System.out.println(showclassement);
	    
    	try {
			for(Show show :showclassement){
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("affiche.fxml"));
			VBox image  = fxmlLoader.load();
			AfficheController imageController = fxmlLoader.getController();
			if (imageController != null) {
			    imageController.setData2(show.getAffiche());
			}
			
			Hbox22.getChildren().add(image);
			
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	    
	    });
	    
	    
	    
	    
	    
	    
	    
	    
}
	 @FXML
	    void switchToHome() throws IOException {
		 App.setRoot("AdminHome");
	    }
	
	

	
	
}
