package Models;

import java.time.LocalDate;

public class Utilisateur {

	private int id_user;
	private String nom_user;
    private String prenom_user;
    private LocalDate date_naissance_user;
    private String email_user;
    private String mdp_user;
	
    public Utilisateur() {
		super();
	}
	
	public Utilisateur(int id_user, String nom_user, String prenom_user, LocalDate date_naissance_user, String email_user, String mdp_user) {
		super();
		this.id_user = id_user;
		this.nom_user = nom_user;
		this.prenom_user = prenom_user;
		this.date_naissance_user = date_naissance_user;
		this.email_user = email_user;
		this.mdp_user = mdp_user;
	}





	public Utilisateur(String text, String text2) {
		// TODO Auto-generated constructor stub
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getNom_user() {
		return nom_user;
	}

	public void setNom_user(String nom_user) {
		this.nom_user = nom_user;
	}

	public String getPrenom_user() {
		return prenom_user;
	}

	public void setPrenom_user(String prenom_user) {
		this.prenom_user = prenom_user;
	}

	public LocalDate getDate_naissance_user() {
		return date_naissance_user;
	}

	public void setDate_naissance_user(LocalDate date_naissance_user) {
		this.date_naissance_user = date_naissance_user;
	}

	public String getEmail_user() {
		return email_user;
	}

	public void setEmail_user(String email_user) {
		this.email_user = email_user;
	}

	public String getMdp_user() {
		return mdp_user;
	}

	public void setMdp_user(String mdp_user) {
		this.mdp_user = mdp_user;
	}

	@Override
	public String toString() {
		return "Utilisateur [id_user=" + id_user + ", nom_user=" + nom_user + ", prenom_user=" + prenom_user + ", date_naissance_user="
				+ date_naissance_user + ", email_user=" + email_user + ", mdp_user=" + mdp_user + "]";
	}
    
    
    
    
}
