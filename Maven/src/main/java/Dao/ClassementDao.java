package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utile.conxBD;

public class ClassementDao {

	

private static Connection conn = conxBD.getInstance();
	public static void save_view(int id_show ,int nb_vue,int month) {
		
		PreparedStatement pstmt = null; 
	    ResultSet rs = null;
	    int code=0;
	    try {
        String query = "INSERT INTO classement (id_show, m" + month + ") VALUES (?, ?) ON DUPLICATE KEY UPDATE m" + month + " = m" + month + " + ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1,id_show);
        pstmt.setInt(2,nb_vue);
        pstmt.setInt(3,nb_vue);
        pstmt.executeUpdate();
     

        rs = pstmt.getGeneratedKeys();

        if (rs.next()) {
            code = rs.getInt(1);
        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	    public static void CalculView(int id_show ) {
			
			PreparedStatement pstmt = null; 
		    ResultSet rs = null;
		    int code=0;
		    try {
		    	String query = "SELECT SUM(m1+m2+m3+m4+m5+m6+m7+m8+m9+m10+m11+m12) AS total_views FROM classement WHERE id_show=?";
	        pstmt = conn.prepareStatement(query);
	        pstmt.setInt(1,id_show);
	        rs = pstmt.getGeneratedKeys();

	        int totalViews = 0;
	        if (rs.next()) {
	            totalViews = rs.getInt("total_views");
	        }
	        
	        // Mettre à jour le nombre total de vues dans la base de données
	        String updateQuery = "UPDATE shows SET nb_view=? WHERE id=?";
	        pstmt.setInt(1, totalViews);
	        pstmt.setInt(2, id_show);
	        pstmt.executeUpdate();

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	    }
	    
 public static List<Integer> IdByVue() {
			
			PreparedStatement pstmt = null; 
		    ResultSet rs = null;
		    int code=0;
		    List<Integer> classement = new  ArrayList<>();
		    try {
		    	String query = "SELECT id_show from classement order by nb_vue";
	        pstmt = conn.prepareStatement(query);
	        rs = pstmt.getGeneratedKeys();

	      
	        if (rs.next()) {
	        	int id = rs.getInt(1);
	        	classement.add(id);
	            
	        }
	        

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
			return classement;
	    }   
		  
	    
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

