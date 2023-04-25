package org.openjfx.Maven;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Controller.ControlSaisie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ProfileSettingsControllerAdmin implements Initializable {
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
    
    
    //static Utilisateur a= new Utilisateur();
    static ProfileInterfaceControllerAdmin pu= new ProfileInterfaceControllerAdmin();
    
    @FXML
    private void back() throws IOException {
        App.setRoot("ProfileInterfaceAdmin");
    }

    @FXML
    void enregistrer(ActionEvent event) throws NumberFormatException, SQLException {
    	
Boolean ChampValid=true;
    
    	
    	
    	if (ControlSaisie.validName(nomAc.getText())==false) {
			nomcor.setText("nom invalid: champ obligatoire doit contenir que des alphabets");
			ChampValid=false;
	}else {
		Service.AdminService.modifNomAdmin(Integer.parseInt(idAc.getText()), nomAc.getText());
	}

	if (ControlSaisie.validName(prenomAc.getText())==false) {
			prenomcor.setText("prenom invalide: champ obligatoire doit contenir que des alphabet");
			ChampValid=false;
	}else {
		Service.AdminService.modifPrenomAdmin(Integer.parseInt(idAc.getText()), prenomAc.getText());
	}
	///edhii taa3 date mich mrigllla maal9itiich el conditionn
	/*if(dateAc
		Service.ActeurService.modifAnnifActeur(Integer.parseInt(idAc.getText()), dateAc.getValue());*/
		if (pu.a.getDate_naissance_ad().equals(dateAc.getValue())==false)
			Service.AdminService.modifAnnifAdmin(Integer.parseInt(idAc.getText()), dateAc.getValue());

	
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
        App.setRoot("PasswordSettingsAdmin");
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setNom(pu.a.getNom_ad());
		setDate(pu.a.getDate_naissance_ad().toString());
		setPreom(pu.a.getPrenom_ad());
		setId(String.valueOf(pu.a.getId_ad()));
		setlog(pu.a.getNom_ad()+" "+pu.a.getPrenom_ad());
	}
}
