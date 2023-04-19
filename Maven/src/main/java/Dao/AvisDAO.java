package Dao;

import java.sql.Connection;
import java.sql.Date;
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
			int code = 0;
			System.out.println("-------connexion is "+conn);
			PreparedStatement pstmt = null; 
		    ResultSet rs = null;
	        
	        try {
	        	String sql = "INSERT INTO  Avis  (id_user,id_show,note,commentaire,num_ep,num_saison) VALUES (?,?,?,?,?,?)";
	    		pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	            pstmt.setInt(1,Avis.getId_user());
	        	pstmt.setInt(2,Avis.getId_show());
	        	pstmt.setInt(3,Avis.getNote());
	        	pstmt.setString(4,Avis.getCommantaire());
	            
	            pstmt.setInt(5, Avis.getNum_ep());
	            pstmt.setInt(6, Avis.getNum_saison());
	        	
	            pstmt.executeUpdate();

	            rs = pstmt.getGeneratedKeys();

	            if (rs.next()) {
	                code = rs.getInt(1);
	            }

	        }catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	            
	        }
			return code;
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

//*****************************************************************************************************			
			
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
		                int favoris_show = rs.getInt(4);
		                int num_ep = rs.getInt(5);
		                int num_saison = rs.getInt(6);
		                int id_user = rs.getInt(7);
		              


		                Avis avis1 = new Avis(id_user, favoris_show, Note, commentaire, favoris_show, num_ep, num_saison);
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
            avis = new Avis(id_user, id_show, Note, commentaire, favoris_show, num_ep, num_saison);
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

///retourne les id des user qu on mis favoris a un show donne//////
public List<Integer> getUsers(int showId) throws SQLException {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    List<Integer> users = new ArrayList<>();

    String SQL = "SELECT id_user FROM avis WHERE id_show = ? AND favoris_show = 1";
    try {
        pstmt = conn.prepareStatement(SQL);
        pstmt.setInt(1, showId);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            int userId = rs.getInt(1);
            users.add(userId);
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

    return users;
}

//*********************************************************************************

public static List<String> envoyerNotif(int id_user_connecte) {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    List<String> notifications = new ArrayList<>();

    LocalDate dateActuelle = LocalDate.now();

    String SQL2 = "SELECT DISTINCT s.id_show, e.nom_ep "
            + "FROM show s, saison sa, episode e, avis a "
            + "WHERE s.id_show = sa.id_show "
            + "AND sa.num_saison = e.num_saison "
            + "AND s.id_show = a.id_show "
            + "AND e.num_ep = a.num_ep "
            + "AND a.id_user = ? "
            + "AND a.favoris_show = 1 "
            + "AND e.date_diff = ?";

    try {
        pstmt = conn.prepareStatement(SQL2);
        pstmt.setInt(1, id_user_connecte);
        pstmt.setDate(2, Date.valueOf(dateActuelle));
        ResultSet rs2 = pstmt.executeQuery();

        while (rs2.next()) {
            int id_show = rs2.getInt(1);
            String nom_episode = rs2.getString(2);

            String notif = "L'épisode " + nom_episode + " du show " + ShowTitre(id_show)  + " est disponible !";
            notifications.add(notif);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    return notifications;
}







}
