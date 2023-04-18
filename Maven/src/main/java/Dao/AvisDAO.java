package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import Models.Avis;
import Models.Producteur;
import Models.Show;
import utile.conxBD;


public class AvisDAO {

private static Connection conn = conxBD.getInstance();
	


//**********************************Ajouter Avis************************************
	   public static int ajouterAvis(Avis Avis) {
			int AvisId = 0;
			System.out.println("-------connexion is "+conn);
			PreparedStatement pstmt = null; 
		    ResultSet rs = null;
	        
	        try {
	        	String sql = "INSERT INTO Avis (id_user,id_show,note,commentaire,num_ep,num_saison) VALUES (?,?,?,?,?,?)";
	    		pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	        	System.out.println("coonexion is---------------------- "+conn);
	            pstmt.setInt(1,Avis.getId_user());
	        	pstmt.setInt(2,Avis.getId_show());
	        	pstmt.setInt(3,Avis.getNote());
	        	pstmt.setString(4,Avis.getCommantaire());
	            pstmt.setInt(5,Avis.getNum_ep());
	        	pstmt.setInt(6,Avis.getNum_saison());
	        	
	        	
	             int rs1 =pstmt.executeUpdate();
	        	
	            // 4- Recupérer l'Id généré par le SGBD
	        	rs = pstmt.getGeneratedKeys();
	            
	            if(rs.next())
	            	AvisId = rs.getInt(1);
	        } catch (SQLIntegrityConstraintViolationException ex) {
	            System.out.println("Cannot insert duplicate ID.");
	        }catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	            
	        }
			return AvisId;
		}

	 
	   
//******************************Modification******************************
		public static int modifNote(int id_Show,int num_ep,int num_saison,int id_user,int note) {
			
			PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    try {
	            String sql = "UPDATE Avis SET note=? WHERE ID_show=? And num_ep=? and num_saison=? and id_user=?" ;
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1,note);
	        	pstmt.setInt(2, id_Show);
	        	pstmt.setInt(3, num_ep);
	        	pstmt.setInt(4,num_saison);
	        	pstmt.setInt(5,id_user);
	        	pstmt.executeUpdate();
	            // 4- Recupérer l'Id généré par le SGBD
	        	rs = pstmt.getGeneratedKeys();
	        }catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
			return id_Show;
		}
		
	//**********************************************************************************
       public static int modifCom(int id_Show,int num_ep,int num_saison,int id_user,String com) {
			
			PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    try {
	            String sql = "UPDATE Avis SET commentaire=?"
	            		+ " WHERE ID_show=? AND num_ep=? AND num_saison=? AND id_user=? AND commentaire IS NOT NULL" ; 
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1,com);
	        	pstmt.setInt(2, id_Show);
	        	pstmt.setInt(3, num_ep);
	        	pstmt.setInt(4,num_saison);
	        	pstmt.setInt(5,id_user);
	        	pstmt.executeUpdate();
	            // 4- Recupérer l'Id généré par le SGBD
	        	rs = pstmt.getGeneratedKeys();
	        }catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
			return id_Show;
		}
//**************************************************************************************
       public static int modifFavoriShow(int id_Show,int num_ep,int num_saison,int id_user) {
			
			PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    try {
	            String sql = "UPDATE Avis SET favoris_show=1 WHERE ID_show=? And num_ep=? and num_saison=? and id_user=?" ;
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, id_Show);
	        	pstmt.setInt(2, num_ep);
	        	pstmt.setInt(3,num_saison);
	        	pstmt.setInt(4,id_user);
	        	pstmt.executeUpdate();
	            // 4- Recupérer l'Id généré par le SGBD
	        	rs = pstmt.getGeneratedKeys();
	        }catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
			return id_Show;
		}

     //************************************Suppression Show*************************************
			public static int supprimerNote(int id_Show,int num_ep,int num_saison,int id_user) {
				int showId = 0;
				PreparedStatement pstmt = null;
			    ResultSet rs = null;
		        
		        try {
		            String sql = "UPDATE Avis SET note=0 WHERE ID_show=? and Num_ep=? and num_saison=? and id_user=?";
		            pstmt = conn.prepareStatement(sql);
		            pstmt.setInt(1, id_Show);
		        	pstmt.setInt(2, num_ep);
		        	pstmt.setInt(3,num_saison);
		        	pstmt.setInt(4,id_user);
		        	pstmt.executeUpdate();
		            // 4- Recupérer l'Id généré par le SGBD
		        	rs = pstmt.getGeneratedKeys();
		        }catch (SQLException ex) {
		            System.out.println(ex.getMessage());
		        }
				return id_Show;
			}
	//*********************************************************************************************
			public static int supprimerCom(int id_Show,int num_ep,int num_saison,int id_user) {
				int showId = 0;
				PreparedStatement pstmt = null;
			    ResultSet rs = null;
		        
		        try {
		            String sql = "UPDATE Avis SET commentaire=null WHERE ID_show=? and Num_ep=? and num_saison=? and id_user=?";
		            pstmt = conn.prepareStatement(sql);
		        	pstmt.setInt(1, id_Show);
		        	pstmt.setInt(2, num_ep);
		        	pstmt.setInt(3,num_saison);
		        	pstmt.setInt(4,id_user);
		        	pstmt.executeUpdate();
		            // 4- Recupérer l'Id généré par le SGBD
		        	rs = pstmt.getGeneratedKeys();
		        }catch (SQLException ex) {
		            System.out.println(ex.getMessage());
		        }
				return id_Show;
			}
	//************************************************************************************************
			public static List<Avis> findAll() throws SQLException{
				
				Statement stmt = null;
			    ResultSet rs = null;
			    
				List<Avis> avis = new ArrayList<>();

		        String SQL = "SELECT * FROM Avis";
		        try {
		        	stmt = conn.createStatement();
		            rs = stmt.executeQuery(SQL);

		            while (rs.next()) {

		            	int id_p = rs.getInt(1);
		                int Note = rs.getInt(2);
		                String commentaire = rs.getString(3);
		                int favoris_show = rs.getInt(5);
		                int num_ep = rs.getInt(6);
		                int num_saison = rs.getInt(7);
		                int id_user = rs.getInt(8);
		              


		                Avis avis1 = new Avis(id_user, favoris_show, Note, commentaire, num_ep, num_saison);
		                avis.add(avis1);
		            }
		        } catch (Exception e ) {};
		        
		        return avis;
			}
	//**********************retourne  liste des id des shows favoris d un user***************************************
public static List<Integer> findAll2(int id_user) throws SQLException{
				
	PreparedStatement pstmt = null;
    ResultSet rs = null;
			    List<Integer> avis = new ArrayList<>();
			    String SQL = "SELECT id_show FROM Avis where favoris_show=1 and id_user=?";
		        try {
		        	pstmt = conn.prepareStatement(SQL);
		            pstmt.setInt(1, id_user);
		            rs = pstmt.executeQuery();
		            
		            while (rs.next()) {
		                avis.add(rs.getInt(1));
		            }
		            
		        } catch (Exception e ) {};
		        
		        return avis;
			}
//***************************retourne le nom d un show a partir de son id *************************************
	
public static String ShowTitre(int id_show) throws SQLException{
	
	PreparedStatement pstmt = null;
    ResultSet rs = null;
    String titre="";
   // List<Show> show = new ArrayList<>();
    String SQL = "SELECT Titre_show FROM show  where id_show=?";
    try {
    	pstmt = conn.prepareStatement(SQL);
        pstmt.setInt(1, id_show);
        rs = pstmt.executeQuery();

        while (rs.next()) {
        		 titre= rs.getString(1);
        }
    } 
    catch (Exception e ) {};
    return titre;
}




///*********************suppprimer de favoris**********************

public static int suppFavoriShow(int id_Show,int num_ep,int num_saison,int id_user) {
	
	PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
        String sql = "UPDATE Avis SET favoris_show=0 WHERE ID_show=? And num_ep=? and num_saison=? and id_user=?" ;
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id_Show);
    	pstmt.setInt(2, num_ep);
    	pstmt.setInt(3,num_saison);
    	pstmt.setInt(4,id_user);
    	pstmt.executeUpdate();
        // 4- Recupérer l'Id généré par le SGBD
    	rs = pstmt.getGeneratedKeys();
    }catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
	return id_Show;
}


//***************************retourne le nom d un show a partir de son id *************************************

public static int idTitre(String titre) throws SQLException{
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    int id = 0;
    String SQL = "SELECT id_show FROM show WHERE titre_show = ?";
    try {
        pstmt = conn.prepareStatement(SQL);
        pstmt.setString(1, titre);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            id = rs.getInt(1);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (rs != null) {
            rs.close();
        }
        if (pstmt != null) {
            pstmt.close();
        }
    }
    return id;
}




//*************************retourne un avis d un user sur un show *****************

public static Avis findAvis(int idS, int idU) throws SQLException{
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Avis avis = null;

    String SQL = "SELECT * FROM Avis WHERE id_show = ? AND id_user = ?";
    try {
        pstmt = conn.prepareStatement(SQL);
        pstmt.setInt(1, idS);
        pstmt.setInt(2, idU);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            int id_show = rs.getInt(1);
            int Note = rs.getInt(2);
            String commentaire = rs.getString(3);
            int favoris_show = rs.getInt(4);
            int num_ep = rs.getInt(5);
            int num_saison = rs.getInt(6);
            int id_user = rs.getInt(7);
            avis = new Avis(id_user, favoris_show, Note, commentaire, num_ep, num_saison);
            avis.setCommantaire(commentaire);
            avis.setFavoris_show(favoris_show);
            avis.setId_show(id_show);
            avis.setId_user(id_user);
            avis.setNote(Note);
            avis.setNum_ep(num_ep);
            avis.setNum_saison(num_saison);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (rs != null) {
            rs.close();
        }
        if (pstmt != null) {
            pstmt.close();
        }
    }
    return avis;
}








}
