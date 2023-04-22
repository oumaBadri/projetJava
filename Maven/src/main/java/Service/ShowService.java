package Service;

import java.sql.SQLException;
import java.util.List;

import Dao.ShowDAO;
import Models.Show;

public class ShowService {

	
	public static List<Show> Findall2() throws SQLException{
		List<Show> show =ShowDAO.findAll2();		
		return show;
		}
	
	
	
	public static int getNombreSaison(int id) {
		int n=0;
		try {
			n=Dao.ShowDAO.getNombreSaisons(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	
	public static int addShow(Show show) {
		int idShow=0;
		idShow=Dao.ShowDAO.ajouterShow(show);
		return idShow;
		
	}
	
	public static boolean exitSerieWithId(int id) {
		Show show=null;
		try {
		show=Dao.ShowDAO.findShowParID(id);
		if (show.getId_show()==id) {
			return true;
		}
		 }catch (Exception e ) {
	     }
		return false;
	}
	
	
	
	
	
	
}
