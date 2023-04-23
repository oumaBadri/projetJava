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


	
public static void save_view(int id_show, int nb_vue, int month) {
    PreparedStatement pstmt = null;
    try {
        String query = "MERGE INTO classement c USING (SELECT ? id_show, ? m" + month + " FROM DUAL) v " +
                       "ON (c.id_show = v.id_show) " +
                       "WHEN MATCHED THEN UPDATE SET c.m" + month + " = c.m" + month + " + v.m" + month + " " +
                       "WHEN NOT MATCHED THEN INSERT (id_show, m" + month + ") VALUES (v.id_show, v.m" + month + ")";
        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, id_show);
        pstmt.setInt(2, nb_vue);
        pstmt.executeUpdate();

        // Update the nb_vues column
        query = "UPDATE classement SET nb_vues = ";
        for (int i = 1; i <= 12; i++) {
            if (i != month) {
                query += "NVL(m" + i + ", 0) + ";
            }
        }
        query += "NVL(m" + month + ", 0) WHERE id_show = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, id_show);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}







 public static List<Integer> IdByVue() {
			
			PreparedStatement pstmt = null; 
		    ResultSet rs = null;
		    int code=0;
		    List<Integer> classement = new  ArrayList<>();
		    try {
		    	String query = "SELECT id_show from classement order by nb_vues DESC";
	        pstmt = conn.prepareStatement(query);
	        rs = pstmt.executeQuery();

	      
	        while (rs.next()) {
	        	int id = rs.getInt(1);
	        	classement.add(id);
	            
	        }
	        

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
			return classement;
	    }   
		  






	    
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

