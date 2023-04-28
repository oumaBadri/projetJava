package Dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Models.Acteur;
import Models.Show;
import utile.conxBD;


public class ShowDAO {
	
	private static Connection conn = conxBD.getInstance();


//****************************Ajouter Show************************************
			public static int ajouterShow(Show Show) {
				int ShowId = 0;
				System.out.println("-------connexion is "+conn);
				PreparedStatement pstmt = null;
			    ResultSet rs = null;
		        
		        try {
		        	String sql = "INSERT INTO Show VALUES (?,?,?,?,?,?,?,?,?)";
	        		pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		        	System.out.println("coonexion is---------------------- "+conn);
		        	pstmt.setInt(1, Show.getId_show());
		        	pstmt.setString(2, Show.getTitre_show());
		        	pstmt.setObject(3, Show.getDate_difussion_show());
		        	pstmt.setString(4, Show.getPays());
		        	pstmt.setString(5, Show.getLangue());
		        	pstmt.setInt(6,Show.isIs_a_film());
		            pstmt.setString(7, Show.getGenre_show());
		            pstmt.setString(8, Show.getAffiche());
		            pstmt.setInt(9, Show.getNb_Saison());
		        	pstmt.executeUpdate();
		        	
		            // 4- Recupérer l'Id généré par le SGBD
		        	rs = pstmt.getGeneratedKeys();
		            
		            if(rs.next())
		            	ShowId = rs.getInt(1);
		            
		        }catch (SQLException ex) {
		            System.out.println(ex.getMessage());
		            
		        }
				return ShowId;
			}
//*****************************Modification Show***********************************************
			
			public static int modifShow(int id_show,String titre,LocalDate date, String genre,String langue,String pays,int isAFilm,String affiche) {
			
				PreparedStatement pstmt = null;
			    ResultSet rs = null;
			    try {
		            String sql = "UPDATE Show SET titre_show=?,date_diff=? ,pays_show=? ,langue_show=? ,is_film=?,genre=?, image=? WHERE ID_show=?";
		            pstmt = conn.prepareStatement(sql);
		            pstmt.setString(1, titre);
		            pstmt.setObject(2, date);
		        	pstmt.setString(3, pays);
		        	pstmt.setString(4, langue);
		        	pstmt.setInt(5, isAFilm);
		        	pstmt.setString(6, genre);
		        	pstmt.setString(7, affiche);
		        	pstmt.setInt(8, id_show);
		        	pstmt.executeUpdate();
		            // 4- Recupérer l'Id généré par le SGBD
		        	rs = pstmt.getGeneratedKeys();

		        }catch (SQLException ex) {
		            System.out.println(ex.getMessage());
		        }
				return id_show;
			}
			
	  //**********************************************************************************
			public static int modifPaysShow(int id_show,String pays) {
			
				PreparedStatement pstmt = null;
			    ResultSet rs = null;
			    try {
		            String sql = "UPDATE Show SET pays_show=? WHERE ID_show=?";
		            pstmt = conn.prepareStatement(sql);
		            pstmt.setString(1, pays);
		        	pstmt.setInt(2, id_show);
		        	pstmt.executeUpdate();
		            // 4- Recupérer l'Id généré par le SGBD
		        	rs = pstmt.getGeneratedKeys();

		        }catch (SQLException ex) {
		            System.out.println(ex.getMessage());
		        }
				return id_show;
			}
	
       //**************************************************************************************
    	public static int modifLangueShow(int id_show,String langue) {
		
		PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
            String sql = "UPDATE Show SET langue_show=? WHERE ID_show=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,langue);
        	pstmt.setInt(2,id_show);
        	pstmt.executeUpdate();
            // 4- Recupérer l'Id généré par le SGBD
        	rs = pstmt.getGeneratedKeys();

        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
		return id_show;
	}
	
	//*******************************************************************
	public static int modifdateShow(int id_show,LocalDate annif) {
	
		PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
            String sql = "UPDATE Show SET DATE_DIFF=? WHERE ID_show=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1, annif);
        	pstmt.setInt(2, id_show);
        	pstmt.executeUpdate();
            // 4- Recupérer l'Id généré par le SGBD
        	rs = pstmt.getGeneratedKeys();

        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
		return id_show;
	    }
	//*********************************************************************
	public static int modifGenreShow(int id_show ,String genre) {
		PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
            String sql = "UPDATE Show SET GENRE=? WHERE ID_show=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, genre);
        	pstmt.setInt(2, id_show);
        	pstmt.executeUpdate();
            // 4- Recupérer l'Id généré par le SGBD
        	rs = pstmt.getGeneratedKeys();

        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
		return id_show;
	    }
	//**********************************************************************************
	public static int modifIsFilm(int id_show,int is_film) {
		
		PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
            String sql = "UPDATE Show SET is_film=? WHERE ID_show=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, is_film);
        	pstmt.setInt(2, id_show);
        	pstmt.executeUpdate();
            // 4- Recupérer l'Id généré par le SGBD
        	rs = pstmt.getGeneratedKeys();

        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
		return id_show;
	}
	
//**************************************FindALL************************************
	public static List<Show> findAll() throws SQLException{
		
		Statement stmt = null;
	    ResultSet rs = null;
	    
		List<Show> Shows = new ArrayList<>();

        String SQL = "SELECT * FROM Show ";
        try {
        	stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {

            	int id_show = rs.getInt(1);
                String titre_show = rs.getString(2);
                LocalDate annif_show=rs.getObject(3,LocalDate.class);
                String Pays_show = rs.getString(4);
                String langue_show = rs.getString(5);
                int is_film = rs.getInt(6);
                String genre_show= rs.getString(7);
                String affiche_show=rs.getString(8);
               

                Show act = new Show(id_show, titre_show, annif_show, Pays_show, langue_show, genre_show, is_film,affiche_show);
                Shows.add(act);
            }
        } catch (Exception e ) {};
        
        return Shows;
	}
//************************************Suppression Show*************************************
	/*public static int supprimerShow(int id_show) {
		int showId = 0;
		PreparedStatement pstmt = null;
	    ResultSet rs = null;
        
        try {
            String sql = "DELETE FROM Show WHERE ID_show=?";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1,id_show );
            rs = pstmt.getGeneratedKeys();
            
            pstmt.executeUpdate();
            
            if(rs.next())
            	showId = rs.getInt(1);
            	int d=getNombreSaisons(id_show);
            for(int i=0;i<d;i++) {
            	SaisonDao.supprimerSaison(id_show, i);
            }
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
		return id_show;
	}*/
	
	
	
	public static int supprimerShow(int id_show) {
	    int showId = 0;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        String sql = "DELETE FROM Show WHERE ID_show=?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, id_show);
	        pstmt.executeUpdate();

	        int d = getNombreSaisons(id_show);
	        for (int i = 0; i < d; i++) {
	            SaisonDao.supprimerSaison(id_show, i);
	        }

	    } catch (SQLException ex) {
	        System.out.println(ex.getMessage());
	    } 

	    return id_show;
	}

	
	
	//***********************************************
		public static int findIdShow(String titre) {
			PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    int id=0;
		    try {
	            String sql = "SELECT ID_show FROM Show WHERE titre_show=?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, titre);
	            rs = pstmt.executeQuery();
	            // 4- RecupÃƒÂ©rer l'Id gÃƒÂ©nÃƒÂ©rÃƒÂ© par le SGBD
	            while (rs.next()) {
	            	 id = rs.getInt(1);
	            	}
	        }catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
		    return id;
		}
//******************************************************* 
 
 public static List<Show> findAll2() throws SQLException{
		
		Statement stmt = null;
	    ResultSet rs = null;
	    
		List<Show> Shows = new ArrayList<>();

     String SQL = " SELECT Titre_show,image FROM Show ";
     try {
     	stmt = conn.createStatement();
         rs = stmt.executeQuery(SQL);

         while (rs.next()){
        	 String titre_show = rs.getString(1);
             String image= rs.getString(2);
             Show act = new Show(titre_show,image);
             Shows.add(act);
         }
     } catch (Exception e ) {};
     
     return Shows;
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



//***************************retourne l id d un show a partir de son nom *************************************

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
 
 

 //---------------------------------------------------
 public static Show findShowParID(Integer identifiant) {
		PreparedStatement pstmt = null;
		Show s=null;
	    ResultSet rs = null;
	    int id=identifiant;
	    try {
         String sql = "SELECT Titre_show,Date_diff,Pays_show,langue_show,Is_film,Genre,Image,nb_saison FROM Show WHERE Id_show=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, id);
         rs = pstmt.executeQuery();
         while (rs.next()) {
         	 String titre_show = rs.getString(1);
         	 Object date_diff=rs.getObject(2);
         	 String Pays_Show=rs.getString(3);
         	 String Langue_show=rs.getString(4);
        	 int is_Film=rs.getInt(5);
        	 String genre=rs.getString(6);
        	 String image=rs.getString(7);
        	 int nb_saison=rs.getInt(8);
        	 s=new Show(identifiant,titre_show,date_diff,Pays_Show,Langue_show,genre,is_Film,image,nb_saison);
         	}
     }catch (SQLException ex) {
         System.out.println(ex.getMessage());
     }
	    return s;
	}
 
 
//----------Compter nbre de saison d'une serie----------------------------------- 
 public static int getNombreSaisons(int idShow) throws SQLException {
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    int nombreSaisons = 0;

	    try {
	        String sql = "SELECT nb_saison FROM  Show  WHERE Show.id_show = ?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, idShow);
	        rs = stmt.executeQuery();

	        if (rs.next()) {
	            nombreSaisons = rs.getInt(1);
	        }

	    } catch (SQLException e) {
	        throw e;
	    }
	    return nombreSaisons;
	}
 //*********************************************************************************

public static String ShowTitre() {
	
	
	
	PreparedStatement pstmt = null;
	   ResultSet rs = null;
	   String titre="";
	  // List<Show> show = new ArrayList<>();
	   String SQL = "SELECT Titre_show FROM show where is_film=1 " ;
	   try {
	   	pstmt = conn.prepareStatement(SQL);
	    
	       rs = pstmt.executeQuery();

	       while (rs.next()) {
	       		 titre= rs.getString(1);
	       }
	   } 
	   catch (Exception e ) {};
	   return titre;
}
 
 //*************************************************************************************
public static List<Show> findAllMovie() throws SQLException{
    Statement stmt = null;
    ResultSet rs = null;
    List<Show> Shows = new ArrayList<>();
    String SQL = "SELECT * FROM Show where is_film=1";
   
    try {
    	stmt = conn.createStatement();
        rs = stmt.executeQuery(SQL);

        while (rs.next()) {

        	int id_show = rs.getInt(1);
            String titre_show = rs.getString(2);
            LocalDate annif_show=rs.getObject(3,LocalDate.class);
            String Pays_show = rs.getString(4);
            String langue_show = rs.getString(5);
            int is_film = rs.getInt(6);
            String genre_show= rs.getString(7);
            String affiche_show=rs.getString(8);
           

            Show act = new Show(id_show, titre_show, annif_show, Pays_show, langue_show, genre_show, is_film,affiche_show);
            Shows.add(act);
        }
    } catch (Exception e ) {};
    
    return Shows;
}

//********************************************************************************
public static List<Show> findShowParTitre( String identifiant) {
	PreparedStatement pstmt = null;
	Show s=new Show();
	List<Show> Shows = new ArrayList<>();
    ResultSet rs = null;
    String id=identifiant;
    try {
     String sql = "SELECT * FROM Show WHERE titre_show=?";
     pstmt = conn.prepareStatement(sql);
     pstmt.setString(1, id);
     rs = pstmt.executeQuery();
     while (rs.next()) {
     	

     	int id_show = rs.getInt(1);
         String titre_show = rs.getString(2);
         LocalDate annif_show=rs.getObject(3,LocalDate.class);
         String Pays_show = rs.getString(4);
         String langue_show = rs.getString(5);
         int is_film = rs.getInt(6);
         String genre_show= rs.getString(7);
         String affiche_show=rs.getString(8);
        

         Show act = new Show(id_show, titre_show, annif_show, Pays_show, langue_show, genre_show, is_film,affiche_show);
         Shows.add(act);
     }
 }catch (SQLException ex) {
     System.out.println(ex.getMessage());
 }
    return Shows;
}
    

//***********retourne la date diff de show*******************


public static String getDateOnly(Object object) {
   /* SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    return formatter.format(object);*/
	
	 /*   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    if (object instanceof Date) {
	        return formatter.format(object);
	    } else {
	        try {
	            Date date = (Date) Date.from(Instant.parse(object.toString()));
	            return formatter.format(date);
	        } catch (DateTimeParseException e) {
	            throw new IllegalArgumentException("Invalid date object: " + object, e);
	        }
	    }*/
	
	    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate date;

	    if (object instanceof String) {
	        date = LocalDate.parse((String)object, inputFormatter);
	    } else if (object instanceof LocalDate) {
	        date = (LocalDate)object;
	    } else {
	        throw new IllegalArgumentException("Object must be a String or a LocalDate");
	    }

	    return outputFormatter.format(date);
	
 
}


//******date only localdate***************
public static LocalDate getDateOnly2(Object object) {
  /*  DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate date;*/

    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
    LocalDate date = LocalDate.parse("2023-04-22 00:00:00.0", inputFormatter);

    
    
    if (object instanceof String) {
        date = LocalDate.parse((String)object, inputFormatter);
    } else if (object instanceof LocalDate) {
        date = (LocalDate)object;
    } else {
        throw new IllegalArgumentException("Object must be a String or a LocalDate");
    }

    return date;
}








//*******************recupere liste d acteur**************

public static List<Acteur> findActeursByShow(int idShow) {
    List<Acteur> acteurs = new ArrayList<>();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        // Requête SQL pour récupérer les acteurs principaux
        String sql = "SELECT acteur.Id_acteur, acteur.Nom_ac,acteur.Prenom_ac FROM acteur "
                + "JOIN roleprincipal ON acteur.Id_acteur = roleprincipal.Id_acteur "
                + "WHERE roleprincipal.Id_show = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, idShow);
        rs = pstmt.executeQuery();

        // Parcourir les résultats et ajouter chaque acteur à la liste
        while (rs.next()) {
            int idActeur = rs.getInt(1);
            String nomActeur = rs.getString(2);
            String prenomActeur = rs.getString(3);

            Acteur acteur = new Acteur(idActeur, nomActeur,prenomActeur);
            acteurs.add(acteur);
        }

        // Requête SQL pour récupérer les acteurs secondaires
        sql = "SELECT acteur.Id_acteur, acteur.Nom_ac, acteur.Prenom_ac FROM acteur "
                + "JOIN rolesecondaire ON acteur.Id_acteur = rolesecondaire.Id_acteur "
                + "WHERE rolesecondaire.Id_show = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, idShow);
        rs = pstmt.executeQuery();

        // Parcourir les résultats et ajouter chaque acteur à la liste (s'il n'est pas déjà dans la liste)
        while (rs.next()) {
            int idActeur = rs.getInt(1);
            String nomActeur = rs.getString(2);
            String prenomActeur = rs.getString(3);

           Acteur acteur = new Acteur(idActeur, nomActeur,prenomActeur);
            if (!acteurs.contains(acteur)) {
                acteurs.add(acteur);
            }
        }

    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return acteurs;
}

//**************************************************************************************
public static void Addview() {
	
	
	
}





}
	