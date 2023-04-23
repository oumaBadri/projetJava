package Dao;

import java.time.LocalDate;

	import java.sql.Connection;
	import java.sql.Date;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.time.LocalDate;
	import java.util.ArrayList;
	import java.util.List;

	import Models.Admin;

	import utile.conxBD;

	public class AdminDao {
 private static Connection conn = conxBD.getInstance();
				
				///login
				public static boolean  login(String mail,String mdp) {
					PreparedStatement pstmt = null;
				    ResultSet rs = null;
				    try {
				    	String sql= "SELECT * FROM Administrateur WHERE EMAIL_ad=? AND MDP_ad=?";
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
				
								
				
				
				
				
				////************************Ajouter Administrateur*********************************
				public static int ajouterAdministrateur(Admin Administrateur) {
					int AdministrateurId = 0;
					System.out.println("-------connexion is "+conn);
					PreparedStatement pstmt = null;
				    ResultSet rs = null;
			         
			        try {
			        	String sql = "INSERT INTO Administrateur VALUES (?,?,?,?,?,?)";
		        		pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			        	System.out.println("coonexion is---------------------- "+conn);
			        	pstmt.setInt(1, Administrateur.getId_ad());
			        	pstmt.setString(2, Administrateur.getNom_ad());
			        	pstmt.setString(3, Administrateur.getPrenom_ad());
			        	pstmt.setObject(6, Administrateur.getDate_naissance_ad());
			        	pstmt.setString(4, Administrateur.getEmail());
			        	pstmt.setString(5, Administrateur.getMdp());
			        	pstmt.executeUpdate();
			        	
			            // 4- Recupérer l'Id généré par le SGBD
			        	rs = pstmt.getGeneratedKeys();
			            
			            if(rs.next())
			            	AdministrateurId = rs.getInt(1);
			            
			        }catch (SQLException ex) {
			            System.out.println(ex.getMessage());
			        }
					return AdministrateurId;
				}
				
				
				//****************************************************************************
				//Modification Administrateurr
				public static int modifNomAdministrateur(int id_Ac,String nom) {
					int ActId = 0;
					PreparedStatement pstmt = null;
				    ResultSet rs = null;
				    try {
			            String sql = "UPDATE Administrateur SET NOM_Ad=? WHERE ID_Ad=?";
			            pstmt = conn.prepareStatement(sql);
			            pstmt.setString(1, nom);
			        	pstmt.setInt(2, id_Ac);
			        	pstmt.executeUpdate();
			            // 4- Recupérer l'Id généré par le SGBD
			        	rs = pstmt.getGeneratedKeys();

			        }catch (SQLException ex) {
			            System.out.println(ex.getMessage());
			        }
					return id_Ac;
				}
				
				//****************************************************************
				public static int modifPrenomAdministrateur(int id_Ac,String prenom) {
					int ActId = 0;
					PreparedStatement pstmt = null;
				    ResultSet rs = null;
				    try {
			            String sql = "UPDATE Administrateur SET PRENOM_Ad=? WHERE ID_Ad=?";
			            pstmt = conn.prepareStatement(sql);
			            pstmt.setString(1, prenom);
			        	pstmt.setInt(2, id_Ac);
			        	pstmt.executeUpdate();
			            // 4- Recupérer l'Id généré par le SGBD
			        	rs = pstmt.getGeneratedKeys();

			        }catch (SQLException ex) {
			            System.out.println(ex.getMessage());
			        }
					return id_Ac;
				}
				//**********************************************************
				public static int modifMdpAdministrateur(int id_Ac,String mdp) {
					int ActId = 0;
					PreparedStatement pstmt = null;
				    ResultSet rs = null;
				    try {
			            String sql = "UPDATE Administrateur SET MDP=? WHERE ID_Ad=?";
			            pstmt = conn.prepareStatement(sql);
			            pstmt.setString(1, mdp);
			        	pstmt.setInt(2,id_Ac);
			        	pstmt.executeUpdate();
			            // 4- Recupérer l'Id généré par le SGBD
			        	rs = pstmt.getGeneratedKeys();

			        }catch (SQLException ex) {
			            System.out.println(ex.getMessage());
			        }
					return id_Ac;
				}
				
				//************************************************************
				public static int modifAnnifAdministrateur(int id_Ac,LocalDate annif) {
					int ActId = 0;
					PreparedStatement pstmt = null;
				    ResultSet rs = null;
				    try {
			            String sql = "UPDATE Administrateur SET DATE_NAIS=? WHERE ID_Ad=?";
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
				
				
			
				
				//FindALL
				public static List<Admin> findAll() throws SQLException{
					
					Statement stmt = null;
				    ResultSet rs = null;
				    
					List<Admin> Administrateurs = new ArrayList<>();

			        String SQL = "SELECT * FROM Administrateur";
			        try {
			        	stmt = conn.createStatement();
			            rs = stmt.executeQuery(SQL);

			            while (rs.next()) {

			            	int id_ac = rs.getInt(1);
			                String Nom_ac = rs.getString(2);
			                String Prenom_ac = rs.getString(3);
			                String mail_ac = rs.getString(4);
			                String mdp_ac = rs.getString(5);
			                LocalDate annif_ac=rs.getObject(6,LocalDate.class);
			               

			                Admin act = new Admin(id_ac, Nom_ac, Prenom_ac,mail_ac,mdp_ac,annif_ac);
			                Administrateurs.add(act);
			            }
			        } catch (Exception e ) {};
			        
			        return Administrateurs;
				}
		
				
				
				
				//Suppression Administrateur
				public static int supprimerAdministrateur(int id_ac) {
					int ActId = 0;
					PreparedStatement pstmt = null;
				    ResultSet rs = null;
			        
			        try {
			            String sql = "DELETE FROM Administrateur WHERE ID_Ad=?";
			            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			            pstmt.setInt(1,id_ac );
			            pstmt.executeUpdate();
			         // 4- Recupérer l'Id généré par le SGBD
			        	rs = pstmt.getGeneratedKeys();
			            
			            if(rs.next())
			            	ActId = rs.getInt(1);
			            
			        	

			        }catch (SQLException ex) {
			            System.out.println(ex.getMessage());
			        }
					return id_ac;
				}
				
				
				//******************************ConsulterNB episode********************************
				public static int ConsulterNbEp(String titre, int numS) {
					int id= Dao.ShowDAO.findIdShow(titre);
						int nb=0;
					PreparedStatement pstmt = null;
				    ResultSet rs = null;
				if (id!=0) {
				    try {
			            String sql = "SELECT NB_EP_S FROM SAISON WHERE ID_SHOW=? AND NUM_SAISON=?";
			            pstmt = conn.prepareStatement(sql);
			            pstmt.setInt(1, id);
			            pstmt.setInt(2, numS);
			            rs = pstmt.executeQuery();
			            
			            while (rs.next()) {
			            	 nb = rs.getInt(1);
			            	}
			            if (nb == 0) {
			                System.out.println("Saison invalide");
			            }
			        }catch (SQLException ex) {
			            System.out.println(ex.getMessage());
			        }
				    return nb;
				    }
				else {
					System.out.println("Show n existe pas");
					return nb;
					}
				}
				
				
				
		//*******************rechercher par email****************************
				public static  int RechercherParEmail(String mail) {
					//Statement stmt = null;
					int id=0;
				    ResultSet rs = null;
				    PreparedStatement pstmt = null;

			        String SQL = "SELECT * FROM Administrateur WHERE EMAIL_ad=?";
			        try {
			        	pstmt = conn.prepareStatement(SQL);
				        pstmt.setString(1,mail);
				        rs = pstmt.executeQuery();
				        while (rs.next()) {
				        	 id= rs.getInt(1);
			              
			                }
				      
				    } catch (SQLException ex) {
				        System.out.println(ex.getMessage());
			        }
					return id;
			       }
//********************verifier id**************************
				 public static boolean verifierId(int id) {
				        boolean existe = false;
				        PreparedStatement pstmt = null;
				        ResultSet rs = null;
				        try {
				            String sql = "SELECT * FROM Administrateur WHERE ID_Ad=?";
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
				 
				 
			//*******************************************	 
				 public static  Admin getAdministrateur(String mail) {
						//Statement stmt = null;
						Admin a= new Admin();
						//int id=0;
					    ResultSet rs = null;
					    PreparedStatement pstmt = null;

				        String SQL = "SELECT * FROM Administrateur WHERE EMAIL_ad=?";
				        try {
				        	pstmt = conn.prepareStatement(SQL);
					        pstmt.setString(1,mail);
					        rs = pstmt.executeQuery();
					        while (rs.next()) {
					        	int id = rs.getInt(1);
				                String nom = rs.getString(2);
				                String prenom = rs.getString(3);
				                LocalDate annif=rs.getObject(4,LocalDate.class);

					            //a = new Administrateur(id, nom, prenom,annif);
				              a.setId_ad(id);
				              a.setNom_ad(nom);
				              a.setPrenom_ad(prenom);
				              a.setDate_naissance_ad(annif);
				                }
					        
					      
					    } catch (SQLException ex) {
					        System.out.println(ex.getMessage());
				        }
						return a;
				       }
	}


	

