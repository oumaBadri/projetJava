package Models;

import java.sql.Date;
import java.time.LocalDate;

public class Acteur {
	private int id_acteur;
	private String nom_ac;
	private String prenom_ac;
	private String mail_ac;
	private String mdp_ac;
	private LocalDate date_naissance_ac;
	
	public int getId_acteur() {
		return id_acteur;
	}
	
	 
	public LocalDate getDate_naissance_ac() {
		return date_naissance_ac;
	}



	public void setDate_naissance_ac(LocalDate date_naissance_ac) {
		this.date_naissance_ac = date_naissance_ac;
	}


	public void setId_acteur(int id_acteur) {
		this.id_acteur = id_acteur;
	}
	public String getNom_ac() {
		return nom_ac;
	}
	public void setNom_ac(String nom_ac) {
		this.nom_ac = nom_ac;
	}
	public String getPrenom_ac() {
		return prenom_ac;
	}
	public void setPrenom_ac(String prenom_ac) {
		this.prenom_ac = prenom_ac;
	}
	public String getMail_ac() {
		return mail_ac;
	}
	public void setMail_ac(String mail_ac) {
		this.mail_ac = mail_ac;
	}
	public String getMdp_ac() {
		return mdp_ac;
	}
	public void setMdp_ac(String mdp_ac) {
		this.mdp_ac = mdp_ac;
	}
	
	public Acteur(int id_acteur, String nom_ac, String prenom_ac, String mail_ac, String mdp_ac,
		LocalDate dateNaissance) {
		super();
		this.id_acteur = id_acteur;
		this.nom_ac = nom_ac;
		this.prenom_ac = prenom_ac;
		this.mail_ac = mail_ac;
		this.mdp_ac = mdp_ac;
		this.date_naissance_ac = dateNaissance;
	}

	
	@Override
	public String toString() {
		return "Acteur [id_acteur=" + id_acteur + ", nom_ac=" + nom_ac + ", prenom_ac=" + prenom_ac + ", mail_ac="
				+ mail_ac + ", mdp_ac=" + mdp_ac + ", date_naissance_ac=" + date_naissance_ac + "]";
	}


	public Acteur() {
		super();
	}


	public Acteur(String mail_ac) {
		super();
		this.mail_ac = mail_ac;
	
	}


	public Acteur(String nom_ac2, String prenom_ac2, LocalDate annif_ac) {
		// TODO Auto-generated constructor stub
	}

	
	public Acteur(int idActeur, String nomActeur,String prenomActeur) {
		this.id_acteur = idActeur;
		this.nom_ac = nomActeur;
		this.prenom_ac=prenomActeur;
		}


	public String toString2() {
		return "Acteur ["+" nom_ac=" + nom_ac + ", prenom_ac=" + prenom_ac 
				 + ", date_naissance_ac=" + date_naissance_ac + "]";
	}
	public String toString3() {
		return "Acteur [" + ", id_ac=" + id_acteur+" nom_ac=" + nom_ac + ", prenom_ac=" + prenom_ac 
				  + "]";
	}
	
	

}

