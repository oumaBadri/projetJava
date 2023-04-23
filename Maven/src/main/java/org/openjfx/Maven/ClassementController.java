package org.openjfx.Maven;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Dao.ClassementDao;
import Dao.ShowDAO;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class ClassementController {
	
	 @FXML
	    private Label Hbox;

	    @FXML
	    private ChoiceBox<Integer> choicebox;

	
	
	
	
	
	
	
	
	
	public static List<String> ShowTitreByvue() throws SQLException{
	    List<String> titre = new ArrayList<>();
		List<Integer> id= ClassementDao.IdByVue();
		for(Integer id_show:id) {
	    titre.add(ShowDAO.ShowTitre(id_show));
		}
		return titre;
	
		}
	
	
	
	
	
	
	
	
	
	
	
	
}
	

	
	
	
	

