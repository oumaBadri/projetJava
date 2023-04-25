 package Dao;
 
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Models.Acteur;
import Models.Show;
import Models.Utilisateur;
import utile.conxBD;



public class UtilisateurDAO {
	
	private static Connection conn = conxBD.getInstance();
	
//******************************Login*********************************************
	public static boolean login(String mail, String mdp) {
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
	        String sql= "SELECT * FROM utilisateur WHERE Mail_user=? AND MDP_user=?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, mail);
	        pstmt.setString(2, mdp);
	        rs = pstmt.executeQuery();                 
	        if (rs.next()) {
	            System.out.println("Login avec succès");
	            return true;
	        } else {
	            System.out.println("Veuillez vérifier vos coordonnées!");
	            return false;
	        }
	    } catch (SQLException ex) {
	        System.out.println(ex.getMessage());
	        return false;
	    }
	}	 
//************************Ajouter Utilisateur*****************************************
	public static int ajouterUtilisateur(Utilisateur Utilisateur) {
				int UtilisateurId = 0;
				System.out.println("-------connexion is "+conn);
				PreparedStatement pstmt = null;
			    ResultSet rs = null;
		        
		        try {
		        	String sql = "INSERT INTO Utilisateur VALUES (?,?,?,?,?,?)";
	        		pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		        	System.out.println("coonexion is---------------------- "+conn);
		        	pstmt.setInt(1, Utilisateur.getId_user());
		        	pstmt.setString(2, Utilisateur.getNom_user());
		        	pstmt.setString(3, Utilisateur.getPrenom_user());
		        	pstmt.setObject(4, Utilisateur.getDate_naissance_user());
		        	pstmt.setString(5, Utilisateur.getEmail_user());
		        	pstmt.setString(6, Utilisateur.getMdp_user());
		        	pstmt.executeUpdate();
		        	
		            // 4- Recupérer l'Id généré par le SGBD
		        	rs = pstmt.getGeneratedKeys();
		            
		            if(rs.next())
		            	UtilisateurId = rs.getInt(1);
		            
		        }catch (SQLException ex) { 
		            System.out.println(ex.getMessage());
		        }
				return UtilisateurId;
			}
//*************************Modification Utilisateur***********************************
	public static int modifNomUtilisateur(int id_u,String nom) {
			
				PreparedStatement pstmt = null;
			    ResultSet rs = null;
			    try {
		            String sql = "UPDATE Utilisateur SET NOM_u=? WHERE ID_User=?";
		            pstmt = conn.prepareStatement(sql);
		            pstmt.setString(1, nom);
		        	pstmt.setInt(2, id_u);
		        	pstmt.executeUpdate();
		            // 4- Recupérer l'Id généré par le SGBD
		        	rs = pstmt.getGeneratedKeys();

		        }catch (SQLException ex) {
		            System.out.println(ex.getMessage());
		        }
				return id_u;
			}
	
	
	
	
	
	
	//************************************************************
	public static int modifAnnifUser(int id_Ac,LocalDate annif) {
		int ActId = 0;
		PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
            String sql = "UPDATE UTILISATEUR SET DATA_NAISSANCE_U=? WHERE ID_USER=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1, annif);
        	pstmt.setInt(2, id_Ac);
        	pstmt.executeUpdate();
            // 4- Recupérer l'Id généré par le SGBD
        	rs = pstmt.getGeneratedKeys();

        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
		return id_Ac;
	    }
	
	
    //*********************************************************************
	public static int modifPrenomUtilisateur(int id_u,String prenom) {
			
				PreparedStatement pstmt = null;
			    ResultSet rs = null;
			    try {
		            String sql = "UPDATE Utilisateur SET PRENOM_u=? WHERE ID_User=?";
		            pstmt = conn.prepareStatement(sql);
		            pstmt.setString(1, prenom);
		        	pstmt.setInt(2, id_u);
		        	pstmt.executeUpdate();
		            // 4- Recupérer l'Id généré par le SGBD
		        	rs = pstmt.getGeneratedKeys();

		        }catch (SQLException ex) {
		            System.out.println(ex.getMessage());
		        }
				return id_u;
			}
	//*********************************************************************
	public static int modifMdpUtilisateur(int id_u,String mdp) {
		
		PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
            String sql = "UPDATE Utilisateur SET MDP_USER=? WHERE ID_User=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, mdp);
        	pstmt.setInt(2,id_u);
        	pstmt.executeUpdate();
            // 4- Recupérer l'Id généré par le SGBD
        	rs = pstmt.getGeneratedKeys();

        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
		return id_u;
	}
	
//********************************FindALL***************************************
	public static List<Utilisateur> findAll() throws SQLException{
		
		Statement stmt = null;
	    ResultSet rs = null;
	    
		List<Utilisateur> Utilisateurs = new ArrayList<>();

        String SQL = "SELECT * FROM Utilisateur";
        try {
        	stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {

            	int id_u = rs.getInt(1);
                String Nom_u = rs.getString(2);
                String Prenom_u = rs.getString(3);
                LocalDate annif_u=rs.getObject(4,LocalDate.class);
                String mail_u = rs.getString(5);
                String mdp_u = rs.getString(6);
                
               

                Utilisateur act = new Utilisateur(id_u, Nom_u, Prenom_u, annif_u, mail_u, mdp_u);
                Utilisateurs.add(act);
            }
        } catch (Exception e ) {};
        
        return Utilisateurs;
	}
//***************************Suppression Utilisateur**********************************
	public static int supprimerUtilisateur(int id_u) {
		int UId = 0;
		PreparedStatement pstmt = null;
	    ResultSet rs = null;
        
        try {
            String sql = "DELETE FROM Utilisateur WHERE ID_user=?";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1,id_u );
            pstmt.executeUpdate();
         // 4- Recupérer l'Id généré par le SGBD
        	rs = pstmt.getGeneratedKeys();
            
            if(rs.next())
            	UId = rs.getInt(1);
    
            }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
		return id_u;
	}
//********************************Recherche*******************************************
	public static  List<Show> RechercherParPays(String pays) {
		//Statement stmt = null;
	    ResultSet rs = null;
	    PreparedStatement pstmt = null;
	    List<Show> Shows = new ArrayList<>();
	    Show s=new Show();
        String SQL = "SELECT titre_show,image FROM Show WHERE pays_show=?";
        try {
        	pstmt = conn.prepareStatement(SQL);
	        pstmt.setString(1,pays);
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	        	String titre_show = rs.getString(1);
	        	String image = rs.getString(2);
	        	s= new Show(titre_show, image);
	        	Shows.add(s);
                }
	      
	    } catch (SQLException ex) {
	        System.out.println(ex.getMessage());
        }
		return Shows;
       }
	//**********************************************************************
	public static  List<Show> RechercherParLangue(String langue) {
		//Statement stmt = null;
	    ResultSet rs = null;
	    PreparedStatement pstmt = null;
	    List<Show> Shows = new ArrayList<>();
	    Show s=new Show();
        String SQL = "SELECT titre_show ,image  FROM Show WHERE langue_show=?";
        try {
        	pstmt = conn.prepareStatement(SQL);
	        pstmt.setString(1,langue);
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	        	String titre_show = rs.getString(1);
	        	String image = rs.getString(2);
	        	s= new Show(titre_show, image);
	        	Shows.add(s);
                }
	      
	    } catch (SQLException ex) {
	        System.out.println(ex.getMessage());
        }
		return Shows;
       }
	//**********************************************************************
	public static  List<Show> RechercherParAnnee(int annee) {
		//Statement stmt = null;
	    ResultSet rs = null;
	    PreparedStatement pstmt = null;
	    List<Show> Shows = new ArrayList<>();
	    Show s=new Show();
        String SQL = "SELECT titre_show ,image  FROM Show WHERE EXTRACT(YEAR FROM date_diff) = ?";
        try {
        	pstmt = conn.prepareStatement(SQL);
	        pstmt.setInt(1,annee);
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	        	String titre_show = rs.getString(1);
	        	String image = rs.getString(2);
	        	s= new Show(titre_show, image);
	        		
                Shows.add(s);
                
                }
	      
	    } catch (SQLException ex) {
	        System.out.println(ex.getMessage());
        }
		return Shows;
       }

	public static  List<Show> RechercherPargenre( String genre) {
		
	    ResultSet rs = null;
	    PreparedStatement pstmt = null;
	    List<Show> Shows = new ArrayList<>();
	    Show s=new Show();
     switch(genre) {
     case "Comédie":
     {
    	 try {
    	 String SQL = "SELECT titre_show ,image FROM Show WHERE genre=?";
         
         	pstmt = conn.prepareStatement(SQL);
 	        pstmt.setString(1,genre);
 	        rs = pstmt.executeQuery();
 	        while (rs.next()) {
 	        	String titre_show = rs.getString(1);
	        	String image = rs.getString(2);
	        	s= new Show(titre_show, image);
	        		
                Shows.add(s);
                 }
 	      
 	    } catch (SQLException ex) {
 	        System.out.println(ex.getMessage());
         }
 		return Shows;
       }
     case"Dramatique":
     {
    	 String SQL = "SELECT titre_show ,image  FROM Show WHERE genre=?";
         try {
         	pstmt = conn.prepareStatement(SQL);
 	        pstmt.setString(1,genre);
 	        rs = pstmt.executeQuery();
 	        while (rs.next()) {
 	        	String titre_show = rs.getString(1);
	        	String image = rs.getString(2);
	        	s= new Show(titre_show, image);
	        		
                Shows.add(s);
                 
                 }
 	      
 	    } catch (SQLException ex) {
 	        System.out.println(ex.getMessage());
         }
 		return Shows;
       } 
     case"Policier":
     {
    	 String SQL = "SELECT titre_show ,image  FROM Show WHERE genre=?";
         try {
         	pstmt = conn.prepareStatement(SQL);
 	        pstmt.setString(1,genre);
 	        rs = pstmt.executeQuery();
 	        while (rs.next()) {
 	        	String titre_show = rs.getString(1);
	        	String image = rs.getString(2);
	        	s= new Show(titre_show, image);
	        		
                Shows.add(s);
                 }
 	      
 	    } catch (SQLException ex) {
 	        System.out.println(ex.getMessage());
         }
 		return Shows; 
    }
     case"Action":
     {
    	 String SQL = "SELECT titre_show ,image  FROM Show WHERE genre=?";
         try {
         	pstmt = conn.prepareStatement(SQL);
 	        pstmt.setString(1,genre);
 	        rs = pstmt.executeQuery();
 	        while (rs.next()) {
 	        	String titre_show = rs.getString(1);
	        	String image = rs.getString(2);
	        	s= new Show(titre_show, image);
	        		
                Shows.add(s);
                 
                 }
 	      
 	    } catch (SQLException ex) {
 	        System.out.println(ex.getMessage());
         }
 		return Shows; 
     }
     case"Historique":
     {
    	 String SQL = "SELECT titre_show ,image  FROM Show WHERE genre=?";
         try {
         	pstmt = conn.prepareStatement(SQL);
 	        pstmt.setString(1,genre);
 	        rs = pstmt.executeQuery();
 	        while (rs.next()) {
 	        	String titre_show = rs.getString(1);
	        	String image = rs.getString(2);
	        	s= new Show(titre_show, image);
	        		
                Shows.add(s);
                 }
 	      
 	    } catch (SQLException ex) {
 	        System.out.println(ex.getMessage());
         }
 		return Shows;
    	 
     }
     case"Science-Fiction":
     {
    	 String SQL = "SELECT titre_show ,image  FROM Show WHERE genre=?";
         try {
         	pstmt = conn.prepareStatement(SQL);
 	        pstmt.setString(1,genre);
 	        rs = pstmt.executeQuery();
 	        while (rs.next()) {
 	        	String titre_show = rs.getString(1);
	        	String image = rs.getString(2);
	        	s= new Show(titre_show, image);
	        		
                Shows.add(s);
                 }
 	      
 	    } catch (SQLException ex) {
 	        System.out.println(ex.getMessage());
         }
 		return Shows;
     }
    	 
     }
	return Shows;
	}
	//**********************************************************************


	public static  List<Acteur> RechercherActeur(String nom) {

		//Statement stmt = null;
	    ResultSet rs = null;
	    PreparedStatement pstmt = null;
	    List<Acteur> acteurs = new ArrayList<>();


        String SQL = "SELECT * FROM Acteur WHERE nom_ac=? ";

      
        try {
        	pstmt = conn.prepareStatement(SQL);
	        pstmt.setString(1,nom);
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	        	int id_ac = rs.getInt(1);
                String Nom_ac = rs.getString(2);
                String Prenom_ac = rs.getString(3);
                String mail_ac = rs.getString(5);
                String mdp_ac = rs.getString(6);
                LocalDate annif_ac=rs.getObject(4,LocalDate.class);
                Acteur act = new Acteur(id_ac, Nom_ac, Prenom_ac, mail_ac, mdp_ac, annif_ac);
                acteurs.add(act);
	        }
	    } catch (SQLException ex) {
	        System.out.println(ex.getMessage());
        }
		return acteurs;
       }
	//**********************************************************************
	public static  Utilisateur getUser(String mail) {
		//Statement stmt = null;
		Utilisateur a= new Utilisateur();
		//int id=0;
	    ResultSet rs = null;
	    PreparedStatement pstmt = null;

        String SQL = "SELECT * FROM utilisateur WHERE MAIL_USER=?";
        try {
        	pstmt = conn.prepareStatement(SQL);
	        pstmt.setString(1,mail);
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	        	int id = rs.getInt(1);
                String nom = rs.getString(2);
                String prenom = rs.getString(3);
                LocalDate annif=rs.getObject(4,LocalDate.class);

	            //a = new Acteur(id, nom, prenom,annif);
              a.setId_user(id);
              a.setNom_user(nom);
              a.setPrenom_user(prenom);
              a.setDate_naissance_user(annif);
         }
	        
	      
	    } catch (SQLException ex) {
	        System.out.println(ex.getMessage());
        }	
		return a;
       }
//*********************************************************************
	
	
	//*************verifier id**************************
	 public static boolean verifierId(int id) {
	        boolean existe = false;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try {
	            String sql = "SELECT * FROM UTILISATEUR WHERE ID_USER=?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, id);
	            rs = pstmt.executeQuery();
	            if (rs.next()) {
	                existe = true;
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        }
	        return existe;
	    }
	
}



	
	
	
	
	
	
	
	


