package org.openjfx.Maven;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Controller.ControlSaisie;
import Models.Acteur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ProfileSettingsController implements Initializable{
	
	

    @FXML
    private TextField profileN;
	@FXML
    private Label update;
	 @FXML
	    private Label idcor;
	   @FXML
	    private Label nomcor;
	   @FXML
	    private Label prenomcor;
	   
	   @FXML
	    private DatePicker dateAc;
	   
    @FXML
    private Button enrgModifAcBtn;

    @FXML
    private TextField idAc;

    @FXML
    private Button mdpAc;

    @FXML
    private TextField nomAc;

    @FXML
    private TextField prenomAc;

    @FXML
    private Button profileAc;
    
    @FXML
    private ImageView back;
    
    
    static Acteur a= new Acteur();
    
    @FXML
    private void back() throws IOException {
        App.setRoot("ProfileInterface");
    }

    @FXML
    void enregistrer(ActionEvent event) throws NumberFormatException, SQLException {
    	
Boolean ChampValid=true;
    
    	
    /*	try {
    		Integer.parseInt(idAc.getText());
    	}catch(NumberFormatException e) {
    		idcor.setText("Veuillez entrer que des chiffres");
    		ChampValid=false;
    	}
    	
    	if (ControlSaisie.validId(Integer.parseInt(idAc.getText()))==false) {
    		idcor.setText("Id n existe pas");
    		ChampValid=false;
    	}*/
    	
    	
    	if (ControlSaisie.validName(nomAc.getText())==false) {
			nomcor.setText("nom invalid: champ obligatoire doit contenir que des alphabets");
			ChampValid=false;
	}else {
		Service.ActeurService.modifNomActeur(Integer.parseInt(idAc.getText()), nomAc.getText());
	}

	if (ControlSaisie.validName(prenomAc.getText())==false) {
			prenomcor.setText("prenom invalide: champ obligatoire doit contenir que des alphabet");
			ChampValid=false;
	}else {
		Service.ActeurService.modifPrenomActeur(Integer.parseInt(idAc.getText()), prenomAc.getText());
	}
	///edhii taa3 date mich mrigllla maal9itiich el conditionn
	/*if(dateAc
		Service.ActeurService.modifAnnifActeur(Integer.parseInt(idAc.getText()), dateAc.getValue());*/
		if (a.getDate_naissance_ac().equals(dateAc.getValue())==false)
			Service.ActeurService.modifAnnifActeur(Integer.parseInt(idAc.getText()), dateAc.getValue());

	
	if (ChampValid==true)
		update.setText("modifications enregistrées");
		
    }
    
    
    
    
    public void setNom(String nom) {
        nomAc.setText(nom);
    }
    
    public void setPreom(String prenom) {
        prenomAc.setText(prenom);
    }
    
    public void setDate(String date) {
        dateAc.setPromptText(date);
    }
    
    public void setId(String id) {
        idAc.setText(id);
    }
    
    public void setlog(String log) {
    	profileN.setText(log);
    }
    
    
    @FXML
    private void switchToMdp() throws IOException {
        App.setRoot("PasswordSettings");
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setNom(a.getNom_ac());
		setDate(a.getDate_naissance_ac().toString());
		setPreom(a.getPrenom_ac());
		setId(String.valueOf(a.getId_acteur()));
		setlog(a.getNom_ac()+" "+a.getPrenom_ac());
	}
		
	

}

