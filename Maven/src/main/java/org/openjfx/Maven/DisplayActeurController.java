package org.openjfx.Maven;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Dao.RolePrincipaleDAO;
import Dao.RoleSecondaireDAO;
import Models.RolePrincipale;
import Models.RoleSecondaire;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class DisplayActeurController implements Initializable {
	
	
	
	@FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private TextField idActeur;
	
	private String[] Role = {"Role Principale","Role Secondaire"};
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		AjoutActeurController aj = new AjoutActeurController();
		
		choiceBox.getItems().addAll(Role);
		System.out.println(choiceBox.getItems()+"******************");
	    choiceBox.setOnAction((e)-> {try {
			Test(choiceBox.getValue());
			//aj.role=choiceBox.getValue();
	    } catch (NumberFormatException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      });
		
	}
  
	public void Test(String e) throws SQLException {
		AjoutActeurController aj = new AjoutActeurController();
		if (e.equals("Role Principale")) {
			RolePrincipale rp = new RolePrincipale(aj.s.getId_show(),Integer.parseInt(idActeur.getText()),aj.ep.getNum_saison());
			System.out.println(rp+"///////////////");
			RolePrincipaleDAO.ajouterRole(rp);
		}
		else {
			if (e.equals("Role Secondaire")) {
				RoleSecondaire rs = new RoleSecondaire(aj.s.getId_show(),Integer.parseInt(idActeur.getText()),aj.ep.getNum_saison());
				System.out.println(rs+"**********");
				RoleSecondaireDAO.ajouterRole(rs);
			}
			
		}
	}
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
