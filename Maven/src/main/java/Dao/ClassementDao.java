package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openjfx.Maven.ClassementController;

import Models.classement;
import javafx.util.Pair;
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



	



public static List<Pair<String,Integer>> getshowVue() throws SQLException {
    String sql = "SELECT s.titre_show, c.nb_vues FROM Show s JOIN classement c ON s.id_show = c.id_show";
    try (Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        List<Pair<String,Integer>> liste = new ArrayList<>();
        while (rs.next()) {
            String titre = rs.getString(1);
            int nb_vue = rs.getInt(2);
            Pair<String,Integer> pair = new Pair<>(titre, nb_vue);
            liste.add(pair);
        }
        return liste;
    } catch (SQLException e) {
        throw new SQLException("Error while fetching show 58694views from the database", e);
    }
}

	

public static List<Pair<String,Integer>> getshowVote() throws SQLException {
    String sql = "SELECT distinct s.titre_show, s.id_show FROM Show s JOIN avis c ON s.id_show = c.id_show";
    try (Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        List<Pair<String,Integer>> liste = new ArrayList<>();
        while (rs.next()) {
            String titre = rs.getString(1);
            int nb_vote = AvisDAO.nbrVotant(rs.getInt(2));
            Pair<String,Integer> pair = new Pair<>(titre, nb_vote);
            liste.add(pair);
        }
        return liste;
    } catch (SQLException e) {
        throw new SQLException("Error while fetching show 58694views from the database", e);
    }
}



///*****vote and vue only on show*********
public static List<Pair<String,Integer>> getshowVueByTitle(String titre) throws SQLException {
    String sql = "SELECT s.titre_show, c.nb_vues FROM Show s JOIN classement c ON s.id_show = c.id_show WHERE s.titre_show=?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, titre);
        try (ResultSet rs = stmt.executeQuery()) {
            List<Pair<String,Integer>> liste = new ArrayList<>();
            while (rs.next()) {
                String titre_show = rs.getString(1);
                int nb_vue = rs.getInt(2);
                Pair<String,Integer> pair = new Pair<>(titre_show, nb_vue);
                liste.add(pair);
            }
            return liste;
        }
    } catch (SQLException e) {
        throw new SQLException("Error while fetching show views from the database", e);
    }
}

public static List<Pair<String,Integer>> getshowVoteByTitle(String titre) throws SQLException {
    String sql = "SELECT distinct s.titre_show, s.id_show FROM Show s JOIN avis c ON s.id_show = c.id_show WHERE s.titre_show=?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, titre);
        try (ResultSet rs = stmt.executeQuery()) {
            List<Pair<String,Integer>> liste = new ArrayList<>();
            while (rs.next()) {
                int id_show = rs.getInt(2);
                int nb_vote = AvisDAO.nbrVotant(id_show);
                Pair<String,Integer> pair = new Pair<>(titre, nb_vote);
                liste.add(pair);
            }
            return liste;
        }
    } catch (SQLException e) {
        throw new SQLException("Error while fetching show votes from the database", e);
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
		  

//**********classement vue par mois 
 public static List<Integer> IdByVueBymois(int mois) {
	 PreparedStatement pstmt = null;
	 ResultSet rs = null;
	 List<Integer> classement = new ArrayList<>();
	 try {
	 String moisColonne = "m" + mois;
	 //String query = "SELECT id_show FROM classement ORDER BY " + moisColonne + " DESC";
	 String query = "SELECT id_show FROM classement WHERE " + moisColonne + " > 0 ORDER BY " + moisColonne + " DESC";
	 pstmt = conn.prepareStatement(query);
	 rs = pstmt.executeQuery();
	 while (rs.next()) {
	 int id = rs.getInt("id_show");
	 classement.add(id);
	 }
	 } catch (SQLException e) {
	 e.printStackTrace();
	 }
	 return classement;
	 }



	    
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

