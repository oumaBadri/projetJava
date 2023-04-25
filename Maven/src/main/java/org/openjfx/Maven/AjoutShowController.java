
package org.openjfx.Maven;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import Controller.ControlSaisie;
import Dao.EpisodeDAO;
import Models.Producteur;
import Models.Show;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class AjoutShowController implements Initializable{
		CombienDEpisodeController combienEp=new CombienDEpisodeController();
	 	@FXML
	    private Button btn_add;

	    @FXML
	    private Button btn_delete;

	    @FXML
	    private Button btn_next;

	    @FXML
	    private Button btn_update;

	    @FXML
	    private TableColumn<Show, String> cln_affiche;

	    @FXML
	    private TableColumn<Show,LocalDate > cln_dateDiff;

	    @FXML
	    private TableColumn<Show, String> cln_genre;

	    @FXML
	    private TableColumn<Show, Integer> cln_id;

	    @FXML
	    private TableColumn<Show, Integer> cln_isAFilm;

	    @FXML
	    private TableColumn<Show, String> cln_langue;

	    @FXML
	    private TableColumn<Show, String> cln_pays;

	    @FXML
	    private TableColumn<Show, String> cln_titre;


	    @FXML
	    private ImageView imageView_search;

	    @FXML
	    private TableView<Show> table;

	    @FXML
	    private TextField txt_NombreSaison;

	    @FXML
	    private TextField txt_genre;

	    @FXML
	    private TextField txt_isAFilm;

	    @FXML
	    private TextField txt_langue;

	    @FXML
	    private TextField txt_payer;

	    @FXML
	    private TextField txt_searchId;

	    @FXML
	    private TextField txt_titre;
	    
	    @FXML
	    private TextField txt_poster;
	    
	    @FXML
	    private TextField txt_nbrSaison;
	    
	    @FXML
	    private DatePicker datePocker;
	   
	   
	    @FXML
	    private TextField txt_dateDiff;
	    
	    @FXML
	    void addShow() {
	    	Show s=null;
	    	if (!txt_searchId.getText().isEmpty()) {
	    		int id = Integer.parseInt(txt_searchId.getText());
		    	 try {
		    		 Show show = Dao.ShowDAO.findShowParID(id);
		    	     if (show != null) {
		    	    	 Alert alert = new Alert(AlertType.ERROR);
		    	         alert.setTitle("Erreur");
		    	         alert.setHeaderText("Un SHOW avec cet ID existe déjà");
		    	         alert.showAndWait();
		    	         return;
		    	     	}
		    	    } catch (Exception e) {
		    	        e.printStackTrace();
		    	        Alert alert = new Alert(AlertType.ERROR);
		    	        alert.setTitle("Erreur");
		    	        alert.setHeaderText("Une erreur s'est produite lors de la recherche du SHOW");
		    	        alert.showAndWait();
		    	        return;
		    	    }
		        String titre = txt_titre.getText();
		        String genre = txt_genre.getText();
		        String langue = txt_langue.getText();
		        String pays = txt_payer.getText();
		        String affiche = txt_poster.getText();
		        String isAFilmText = txt_isAFilm.getText();
		        String nbrSaisonText = txt_nbrSaison.getText();
		        
		        LocalDate dateDiff = datePocker.getValue();
		        
		        if (txt_searchId.getText().isEmpty()|| titre.isEmpty() || genre.isEmpty() || langue.isEmpty() || pays.isEmpty() ||
		                affiche.isEmpty() || isAFilmText.isEmpty() || nbrSaisonText.isEmpty() || dateDiff == null) {
		            Alert alert = new Alert(AlertType.ERROR, "Tous les champs sont obligatoires!");
		            alert.showAndWait();
		            return;
		        }
		        int isAFilm, nbrSaison;
		        try {
		            isAFilm = Integer.parseInt(isAFilmText);
		            nbrSaison = Integer.parseInt(nbrSaisonText);
		        } catch (NumberFormatException e) {
		            Alert alert = new Alert(AlertType.ERROR, "Veuillez entrer des valeurs valides pour 'isAFilm' et 'nbrSaison'.");
		            alert.showAndWait();
		            return;
		        }
		        if (!genre.equals("Comédie") && !genre.equals("Dramatique")  && !genre.equals("Policier")&& !genre.equals("Action")&& !genre.equals("Historique")&& !genre.equals("Science-Fiction")) {
		            Alert alert = new Alert(AlertType.ERROR, "Le genre doit être soit 'Comédie' ou 'Dramatique' ou 'Policier' ou 'Action' ou 'Historique' ou 'Science-Fiction'.");
		            alert.showAndWait();
		            return;
		        }
		        if (isAFilm != 0 && isAFilm != 1) {
		            Alert alert = new Alert(AlertType.ERROR, "Mettre 1 si c'est un film ou 0 si c'est une serie");
		            alert.showAndWait();
		            return;
		        }
		        Show show = new Show(Integer.parseInt(txt_searchId.getText()),titre , dateDiff , pays , langue, genre, isAFilm, affiche);
		        
		        Dao.ShowDAO.ajouterShow(show);
		        
		        txt_titre.clear();
		        txt_genre.clear();
		        txt_langue.clear();
		        txt_payer.clear();
		        txt_poster.clear();
		        txt_isAFilm.clear();
		        txt_nbrSaison.clear();
		        datePocker.setValue(null);
		       
		        Alert alert = new Alert(AlertType.INFORMATION, "Le SHOW a été ajouté avec succès!");
		        alert.showAndWait();
		        showShow();
	    		
	    	}else {
	    		Alert alert = new Alert(AlertType.ERROR, "Remplir le champ id");
	            alert.showAndWait();
	            return;
	    		
	    	}
	    	 
	    }
	    
	    
	    @FXML
	    void deleteShow() {
	    	 try {
	    	        int id = Integer.parseInt(txt_searchId.getText());
	    	        if (Dao.ShowDAO.findShowParID(id) == null) {
	    	            Alert alert = new Alert(AlertType.ERROR);
	    	            alert.setTitle("Show introuvable");
	    	            alert.setHeaderText("Le show avec l'identifiant " + id + " n'existe pas.");
	    	            alert.showAndWait();
	    	            return;
	    	        }
	    	        Alert alert = new Alert(AlertType.CONFIRMATION);
	    	        alert.setTitle("Confirmation de suppression");
	    	        alert.setHeaderText("Êtes-vous sûr de vouloir supprimer le show avec l'identifiant " + id + " ?");
	    	        Optional<ButtonType> result = alert.showAndWait();
	    	        if (result.get() == ButtonType.OK) {
	    	            Dao.ShowDAO.supprimerShow(id);
	    	            showShow();
	    	            txt_titre.clear();
	    		        txt_genre.clear();
	    		        txt_langue.clear();
	    		        txt_payer.clear();
	    		        txt_poster.clear();
	    		        txt_isAFilm.clear();
	    		        txt_nbrSaison.clear();
	    		        datePocker.setValue(null);
	    	        }
	    	    } catch (NumberFormatException e) {
	    	    	Alert alert = new Alert(AlertType.ERROR);
	    	        alert.setTitle("Erreur de saisie");
	    	        alert.setHeaderText("L'identifiant saisi doit être un entier.");
	    	        alert.showAndWait();
	    	    }

	    }

	    @FXML
	    void next() throws IOException {
	    	if (txt_searchId.getText().equals("")) {
	    		Alert alert = new Alert(AlertType.WARNING, "Veuillez indiquer l'ID_Show dont vous voulez l'ajouter episode ", javafx.scene.control.ButtonType.OK);
    	        alert.showAndWait();
	    		
	    	}
	    	else {
	    		CombienDEpisodeController  c= new CombienDEpisodeController();
		    	c.s.setTitre_show(Dao.ShowDAO.findShowParID(Integer.parseInt(txt_searchId.getText())).getTitre_show());
		    	
		    	//System.out.println(c.s.getTitre_show() +"************************");
		    	c.ep.setId_show(Integer.parseInt(txt_searchId.getText()));
		    	App.setRoot("CombienDEpisode");
	    	}
	    	
	    }

	    @FXML
	    void searchShow() {
	    	if (txt_searchId.getText().equals("")) {
	    		Alert alert = new Alert(AlertType.WARNING, "Veuillez indiquer l'ID_Show ", javafx.scene.control.ButtonType.OK);
    	        alert.showAndWait();
	    		
	    	}else {
		    	int m=0;
		    	try {
		    	    Show S = Dao.ShowDAO.findShowParID(Integer.parseInt(txt_searchId.getText()));
		    	    txt_titre.setText(S.getTitre_show());
		    	    txt_genre.setText(S.getGenre_show());

		    	    if (S.getIs_a_film() == 0) {
		    	        txt_isAFilm.setText("serie");
		    	    } else {
		    	        txt_isAFilm.setText("film");
		    	    }
		    	    
		    	    txt_langue.setText(S.getLangue());
		    	    txt_payer.setText(S.getPays());
		    	    txt_poster.setText(S.getAffiche());
		    	    m = 1;
		    	    txt_nbrSaison.setText(String.valueOf(Service.ShowService.getNombreSaison(Integer.parseInt(txt_searchId.getText()))));
		    	    //datePocker.setPromptText(Dao.ShowDAO.getDateOnly(S.getDateOb()));
		    	    if (datePocker == null) {
		    	        datePocker = new DatePicker();
		    	    }
		    	  //  datePocker.setPromptText(Dao.ShowDAO.getDateOnly(S.getDateOb()));
		    	    //setPromptText(Dao.ShowDAO.getDateOnly(S.getDateOb()));
		    	    //
		    	    //System.out.println(datePocker.getPromptText());
		    	    
		    	    
		    	} catch (NumberFormatException e) {
		    		e.printStackTrace();
		    	    /*Alert alert = new Alert(AlertType.ERROR, "Le format d'entrée est incorrect. Veuillez entrer un identifiant valide.", javafx.scene.control.ButtonType.OK);
		    	    alert.showAndWait();*/
		    	} catch (Exception e) {
		    		e.printStackTrace();
		    	    /*Alert alert = new Alert(AlertType.ERROR, "Une erreur s'est produite lors de la recherche du spectacle.", javafx.scene.control.ButtonType.OK);
		    	    alert.showAndWait();*/
		    	}
		    	if (m == 0) {
	    	        Alert alert = new Alert(AlertType.ERROR, "Aucun Show trouvee avec ce Id", javafx.scene.control.ButtonType.OK);
	    	        alert.showAndWait();
	    	        }
	    		
	    	}
	    	
	    	
	    }

	    @FXML
	    void updateShow() {
	    	try {
	            int id = Integer.parseInt(txt_searchId.getText());
	            String titre = txt_titre.getText();
	            String genre = txt_genre.getText();
	            String langue = txt_langue.getText();
	            String pays = txt_payer.getText();
	            int isAFilm = Integer.parseInt(txt_isAFilm.getText());
	            String affiche = txt_poster.getText();
	            LocalDate dateDiff = datePocker.getValue();
	            int nbrSaison = Integer.parseInt(txt_nbrSaison.getText());
	            if(titre.isEmpty() || genre.isEmpty() || langue.isEmpty() || pays.isEmpty() 
	               || txt_isAFilm.getText().isEmpty() || affiche.isEmpty() || dateDiff == null
	               || txt_nbrSaison.getText().isEmpty()) {
	                Alert alert = new Alert(AlertType.ERROR);
	                alert.setTitle("Erreur");
	                alert.setHeaderText("Certains champs sont vides");
	                alert.setContentText("Veuillez remplir tous les champs");
	                alert.showAndWait();
	                return;
	            }
	            if(!genre.equals("Comédie") && !genre.equals("Dramatique")  && !genre.equals("Policier")&& !genre.equals("Action")&& !genre.equals("Historique")&& !genre.equals("Science-Fiction")) {
	                Alert alert = new Alert(AlertType.ERROR);
	                alert.setTitle("Erreur");
	                alert.setHeaderText("Genre invalide");
	                alert.setContentText("Le genre doit être soit 'Comédie' ou 'Dramatique' ou 'Policier' ou 'Action' ou 'Historique' ou 'Science-Fiction'.");
	                alert.showAndWait();
	                return;
	            }
	            if(isAFilm != 0 && isAFilm != 1) {
	                Alert alert = new Alert(AlertType.ERROR);
	                alert.setTitle("Erreur");
	                alert.setHeaderText("Valeur invalide pour 'isAFilm'");
	                alert.setContentText("Mettre 1 si c'est un film ou 0 si c'est une serie");
	                alert.showAndWait();
	                return;
	            }
	            if(Service.ShowService.exitSerieWithId(id)) {
	                Alert alert = new Alert(AlertType.ERROR);
	                alert.setTitle("Erreur");
	                alert.setHeaderText("ID invalide");
	                alert.setContentText("L'ID " + id + " n'existe pas dans la table");
	                alert.showAndWait();
	                return;
	            }
	            Dao.ShowDAO.modifShow(id, titre, dateDiff, genre, langue, pays, isAFilm, affiche);
	            
	            Alert alert = new Alert(AlertType.CONFIRMATION);
	            alert.setTitle("Confirmation");
	            alert.setHeaderText("Mise à jour réussie");
	            alert.setContentText("Le show a été mis à jour avec succès");
	            alert.showAndWait();
	        } catch (NumberFormatException e) {
	            Alert alert = new Alert(AlertType.ERROR);
	            alert.setTitle("Erreur");
	            alert.setHeaderText("Valeur invalide");
	            alert.setContentText("Veuillez entrer une valeur numérique valide");
	            alert.showAndWait();
	        }

	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		showShow();
		
	}
	
	//pour voir la table de base de donnee
	public void showShow() {
		table.getItems().clear();
		List<Show> shows=null;
		try {
			shows=Dao.ShowDAO.findAll();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		ObservableList<Show> observableList = FXCollections.observableList(shows);
		//System.out.println(observableList);
		/*for(Show s:shows) {
			data.add(s.getId_show(),s.getTitre_show(),s.getDate_difussion_show(),s.getPays(),s.getGenre_show(),s.getIs_a_film(),s.getAffiche());
		}*/
		
		/*try {
			data=(ObservableList<Show>) Dao.ShowDAO.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		cln_id.setCellValueFactory(new PropertyValueFactory<Show,Integer>("id_show"));
		cln_titre.setCellValueFactory(new PropertyValueFactory<Show,String>("titre_show"));
		cln_dateDiff.setCellValueFactory(new PropertyValueFactory<Show,LocalDate>("Date_difussion_show"));
		cln_pays.setCellValueFactory(new PropertyValueFactory<Show,String>("pays"));
		cln_langue.setCellValueFactory(new PropertyValueFactory<Show,String>("langue"));
		cln_genre.setCellValueFactory(new PropertyValueFactory<Show,String>("genre_show"));
		cln_isAFilm.setCellValueFactory(new PropertyValueFactory<Show,Integer>("is_a_film"));
		cln_affiche.setCellValueFactory(new PropertyValueFactory<Show,String>("affiche"));
		table.setItems(observableList);
	}
	
	@FXML
	void tableEvent() {
	        Show selectedShow = table.getSelectionModel().getSelectedItem(); // récupère l'objet Show sélectionné
	        if (selectedShow != null) { 
	            txt_searchId.setText(String.valueOf(selectedShow.getId_show()));
	            txt_titre.setText(selectedShow.getTitre_show());
	            txt_payer.setText(selectedShow.getPays());
	            txt_langue.setText(selectedShow.getLangue());
	            txt_genre.setText(selectedShow.getGenre_show());
	            //txt_nbrSaison.setText(String.valueOf(selectedShow.getNombre_saisons()));
	            txt_isAFilm.setText(String.valueOf(selectedShow.getIs_a_film()));
	            datePocker.setValue(selectedShow.getDate_difussion_show());
	        
	          /*  String posterUrl = selectedShow.getAffiche();
	            if (posterUrl != null && !posterUrl.isEmpty()) {
	                File posterFile = new File(posterUrl);
	                Image posterImage = new Image(posterFile.toURI().toString());
	                imageView_search.setImage(posterImage);*/
	            }
	        }
	    }
		
		
	
	


