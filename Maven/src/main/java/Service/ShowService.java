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
	
	
	
	
	
	
	
	
}
