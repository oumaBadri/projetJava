package org.openjfx.Maven;
import java.io.IOException;

import Controller.ControlSaisie;
import Models.Producteur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class InscriptionProController {
	@FXML
    private TextField id;

    @FXML
    private Label cincor;
	
    @FXML
    private DatePicker date;

    @FXML
    private TextField mail_p;

    @FXML
    private Label emailcor;

    @FXML
    private Label label41;

    @FXML
    private AnchorPane layer1;

    @FXML
    private AnchorPane layer2;

    @FXML
    private TextField nom;

    @FXML
    private Label nomcor;

    @FXML
    private PasswordField password;

    @FXML
    private Label passwordcor;

    @FXML
    private TextField prenom;

    @FXML
    private Label prenomcor;

    @FXML
    private Button signInBTN;
    
    
    @FXML
   
    void signIN() throws IOException {
    	Producteur p;
    	Boolean ChampValid=true;
   
    	try {
    		Integer.parseInt(id.getText());
    	}catch(NumberFormatException e) {
    		cincor.setText("Veuillez entrer que des chiffres");
    		ChampValid=false;
    	}
    	
    	if (ControlSaisie.validName(nom.getText())==false) {
    			nomcor.setText("nom invalid: champ obligatoire doit contenir que des alphabets");
    			ChampValid=false;
    	}

    	if (ControlSaisie.validName(prenom.getText())==false) {
    			prenomcor.setText("prenom invalide: champ obligatoire doit contenir que des alphabet");
    			ChampValid=false;
    	}
    		
    	if (ControlSaisie.validEmailproducteur(mail_p.getText())==false){
    		emailcor.setText("email invalide");
    		ChampValid=false;
    	}	
    	
    	if (ControlSaisie.validMdp(password.getText())==false) {
    		passwordcor.setText("password invalide : champ obligatoire doit contenir au moins 8 symbols");
    		ChampValid=false;
    	}
    	if (ChampValid==true) {
    		p=new Producteur(Integer.parseInt(id.getText()),nom.getText(),prenom.getText(),mail_p.getText(),password.getText(),date.getValue());
    		Service.ProducteurService.ajouterProducteur(p);
    		App.setRoot("ProHome");
    	}
    	
    }
}
