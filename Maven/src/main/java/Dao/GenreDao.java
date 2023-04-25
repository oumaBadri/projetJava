package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.Genre;
import utile.conxBD;

public class GenreDao {

	private static Connection conn = conxBD.getInstance();
	
	public static int ajouterGenre(int id_user , String genre) {
		int GenreId = 0;
		System.out.println("-------connexion is "+conn);
		PreparedStatement pstmt = null;
	    ResultSet rs = null;
         
        try {
        	String sql = "INSERT INTO Genre VALUES (?,?)";
    		pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        	System.out.println("coonexion is---------------------- "+conn);
        	pstmt.setInt(1,id_user);
        	pstmt.setString(2,genre);
        
        	pstmt.executeUpdate();
        	
            // 4- Recupérer l'Id généré par le SGBD
        	rs = pstmt.getGeneratedKeys();
            
            if(rs.next())
            	GenreId = rs.getInt(1);
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
		return GenreId;
	}
	
	
	
	
	
	
	
	
	
	
	
}
