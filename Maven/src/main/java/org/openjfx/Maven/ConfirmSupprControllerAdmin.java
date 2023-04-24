package org.openjfx.Maven;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Controller.ControlSaisie;
import Dao.AdminDao;
import Dao.UtilisateurDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ConfirmSupprControllerAdmin implements Initializable {
	 @FXML
	    private Button annulerBtn;

	    @FXML
	    private Button confirmerBtn;

	    @FXML
	    private TextField idac;

	    @FXML
	    private PasswordField mdpac;
	    
	    @FXML
	    private Text mdpcor;
	    
	    @FXML
	    private Text idcor;
	    
	    //static Utilisateur a=new Utilisateur();
	    static ProfileInterfaceControllerAdmin pu= new ProfileInterfaceControllerAdmin();
	    
	    @FXML
	    private void annuler() throws IOException {
	        App.setRoot("ProfileInterfaceAdmin");
	    }
	    
	    
	    @FXML
	    void confirmer(ActionEvent event) throws NumberFormatException, SQLException, IOException {
	    	
	//Boolean ChampValid=true;
	    
	    	
	    /*	try {
	    		Integer.parseInt(idac.getText());
	    	}catch(NumberFormatException e) {
	    		idcor.setText("Veuillez entrer que des chiffres");
	    		ChampValid=false;
	    	}
	    	
	    	if (ControlSaisie.validId(Integer.parseInt(idac.getText()))==false) {
	    		idcor.setText("Id n existe pas");
	    		ChampValid=false;
	    	}
	    	
	    	
	    	if (ControlSaisie.validMdp(mdpac.getText())==false) {
	    		mdpcor.setText("password invalide : champ obligatoire doit contenir au moins 8 symbols");
	    		ChampValid=false;
	    	}
	    	if (ControlSaisie.validAncienMdp(Integer.parseInt(idac.getText()),mdpac.getText())==false) {
	    		mdpcor.setText("password invalide : mdp incorrecte");
	    		ChampValid=false;
	    	}
		*/
		//if (ChampValid==true)
			if(ControlSaisie.validAncienMdpAdmin(Integer.parseInt(idac.getText()),mdpac.getText())) {
			AdminDao.supprimerAdministrateur(Integer.parseInt(idac.getText()));
			App.setRoot("InscriptionAdmin");}
			else
				mdpcor.setText("password invalide : mdp incorrecte");
			
	    }

	    
	    public void setId(String id) {
	        idac.setText(id);
	    }	    
	    

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			setId(String.valueOf(pu.a.getId_ad()));
			
		}
}
