package org.openjfx.Maven;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Dao.AvisDAO;
import Dao.ClassementDao;
import Dao.SaisonDao;
import Dao.ShowDAO;
import Models.Avis;
import Models.Show;
import Models.classement;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

public class ClassementController {
	@FXML
    private TableColumn<Avis, Integer> note;
	@FXML
    private TableColumn<Avis, Integer> saisonnote;
	@FXML
    private TableColumn<Avis, Integer> episodenote;
	  @FXML
	    private TextField nb;
	  
	  @FXML
	    private TextArea classementarea;
	  
	@FXML
    private  Label nbep;
	@FXML
    private TableColumn<Show, String> titre;
	@FXML
    private TableColumn<classement, Integer> nbvues;
	@FXML
    private ChoiceBox<Integer> Choicebox;
	@FXML
    private Label nbreVotants;
	@FXML
    private TableColumn<Show, String> titrev;
    @FXML
    private TableColumn<?, ?> nbvotant;
	 @FXML
	    private Label Hbox;
	 @FXML
	    private ImageView search;
	    @FXML
	    private ChoiceBox<Integer> choicebox;
	    @FXML
	    private TextField rechercheTitre;
	    @FXML
	    private TableView<Avis> tablenote;
	    @FXML
	    private TableView<classement> tablevue;
	    @FXML
	    private TableView<classement> tablevote;
	    
	
	    public void search() throws SQLException, IOException {
	    	//List<Show> show1 =ShowDAO.findShowParTitre(rechercheTitre.getText());
	    	
	    	
	    	List<Show> show22 = ShowDAO.findShowParTitre(rechercheTitre.getText());
	    	List<Show> show1 = show22.stream()
	    	                         .filter(e -> e.getTitre_show().equals(rechercheTitre.getText()))
	    	                         .collect(Collectors.toList());
	    	if(show1.isEmpty()) {
	    		Alert alert = new Alert(AlertType.ERROR);
     	         alert.setTitle("Erreur");
     	         alert.setHeaderText("Pas de show avec ce titre");
     	         alert.showAndWait();
     	         return;
	    	}
	    	else {
	    	for(Show show:show1) {
	    		
	    		//*********classement**********
		    	List<String> classementlist=new ArrayList<>();
		    	List<Integer> a= ClassementDao.IdByVue();
		    	for(Integer i:a) {
		    		classementlist.add(ShowDAO.ShowTitre(i));
		    	}
		    	classementarea.setText(classementlist.toString());
				
				//*************table note
					tablenote.getItems().clear();
					List<Avis> avis2=AvisDAO.findAvis2(show.getId_show());
					ObservableList<Avis> observableList2 = FXCollections.observableList(avis2);
					episodenote.setCellValueFactory(new PropertyValueFactory<Avis,Integer>("num_ep"));
					saisonnote.setCellValueFactory(new PropertyValueFactory<Avis,Integer>("num_saison"));
					note.setCellValueFactory(new PropertyValueFactory<Avis,Integer>("note"));
					tablenote.setItems(observableList2);
					
				//**********table vue	
					
					 tablevue.getItems().clear();
					    //List<Pair<String,Integer>> avis3 = ClassementDao.getshowVue();
					    List<Pair<String,Integer>> avis3 = ClassementDao.getshowVueByTitle(show.getTitre_show());

					    ObservableList<classement> observableList3 = FXCollections.observableArrayList();
					    for (Pair<String,Integer> pair : avis3) {
					    	System.out.println(pair.getKey()+"*********/"+pair.getValue());
					        String titre = pair.getKey();
					        int nb_vues = pair.getValue();
					        
					        observableList3.add(new classement(titre, nb_vues,0));
					        System.out.println(observableList3);
					    
					    }
					    
					    titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
					    nbvues.setCellValueFactory(new PropertyValueFactory<>("nb_vues"));
					    tablevue.setItems(observableList3);
					
					
					    
					    //table votant 
					    tablevote.getItems().clear();
					   // List<Pair<String,Integer>> avis4 = ClassementDao.getshowVote();
					    List<Pair<String,Integer>> avis4 = ClassementDao.getshowVoteByTitle(show.getTitre_show());

					    ObservableList<classement> observableList4 = FXCollections.observableArrayList();
					    for (Pair<String,Integer> pair : avis4) {
					    	System.out.println(pair.getKey()+"*********/"+pair.getValue());
					        String titre = pair.getKey();
					        int nb_vote = pair.getValue();
					        
					        observableList4.add(new classement(titre,0, nb_vote));
					        System.out.println(observableList4);
					    
					    }
					    
					    titrev.setCellValueFactory(new PropertyValueFactory<>("titre"));
					    nbvotant.setCellValueFactory(new PropertyValueFactory<>("nb_votant"));
					    tablevote.setItems(observableList4);
					
					    
					    
					    
					    
	//******************creation de choicebox*****************************	    
				
				List<Integer> saisonliste=new ArrayList<>();
				try {
					saisonliste = createListe();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			    Choicebox.getItems().addAll(saisonliste);
			    Choicebox.setOnAction((ev)->{
						try {
							EpSaison(show.getId_show(), Choicebox.getValue());
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							
						}
				});
	    	}

	    	}
	    	}
	    	
	    
	    
	    
	    
	    


	    
	    
	    
	    public void EpSaison(int id_show, int num_saison) throws SQLException {
	  	 int ep=  SaisonDao.getNbEp(id_show, num_saison);
	  	nb.setText(String.valueOf(ep));
	  	System.out.println(ep);

	  	
	  	}
	
	public static List<String> ShowTitreByvue() throws SQLException{
	    List<String> titre = new ArrayList<>();
		List<Integer> id= ClassementDao.IdByVue();
		for(Integer id_show:id) {
	    titre.add(ShowDAO.ShowTitre(id_show));
		}
		return titre;
	
		}
	
	
	
	private  List<Integer> createListe() throws SQLException {
	    List<Integer> saisons= new ArrayList<>();	
		List<Show> show1 =ShowDAO.findShowParTitre(rechercheTitre.getText());
		for(Show show:show1) {
	     int nb= ShowDAO.getNombreSaisons(show.getId_show());
	    
	    for(int i=0;i<nb;i++) 
	    {int f=i+1;
	    	saisons.add(f);
	       
	    }
		}
	    return saisons;
	    }
	
	
	 @FXML
	    void goToClassement(ActionEvent event) throws IOException {
		 
		 ClassementMoisController d= new ClassementMoisController();
		d.s.setTitre_show(rechercheTitre.getText());
		//d.s.setAffiche(null);
		 //System.out.println(d.s.getTitre_show()+"555555");*/
		 App.setRoot("Classement");
	    }
	
	 @FXML
	    void switchToHome() throws IOException {
		 App.setRoot("AdminHome");
	    }
	
	
		
	
}
	

	
	
	
	

