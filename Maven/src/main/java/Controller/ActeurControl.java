package Controller;

import java.sql.SQLException;


public class ActeurControl {
	
	
//hhh	
	public static boolean verifierMdp(String mdp) throws SQLException{
		if (mdp.length()>=8) {
			return true;
			}
		else
			return false;
	}

	
	
	
	
	
}
