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
	
	
	
	
	
	
}
