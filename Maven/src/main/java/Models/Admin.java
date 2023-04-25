package Models;

import java.time.LocalDate;

public class Admin {

	 private int id_ad;
	 private String nom_ad;
	 private String prenom_ad;
	 private String email;
	 private String mdp;
	 private LocalDate date_naissance_ad;
	public Admin() {
		super();
	}
	public Admin(int id_ad, String nom_ad, String prenom_ad, String email, String mdp, LocalDate date_naissance_ad) {
		//super();
		this.id_ad = id_ad;
		this.nom_ad = nom_ad;
		this.prenom_ad = prenom_ad;
		this.email = email;
		this.mdp = mdp;
		this.date_naissance_ad = date_naissance_ad;
	}
	public Admin(int id, String nom, String prenom, LocalDate annif) {
		// TODO Auto-generated constructor stub
		this.date_naissance_ad=annif;
		this.nom_ad=nom;
		this.prenom_ad=prenom;
		this.id_ad=id;
	}
	public int getId_ad() {
		return id_ad;
	}
	public void setId_ad(int id_ad) {
		this.id_ad = id_ad;
	}
	public String getNom_ad() {
		return nom_ad;
	}
	public void setNom_ad(String nom_ad) {
		this.nom_ad = nom_ad;
	}
	public String getPrenom_ad() {
		return prenom_ad;
	}
	public void setPrenom_ad(String prenom_ad) {
		this.prenom_ad = prenom_ad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public LocalDate getDate_naissance_ad() {
		return date_naissance_ad;
	}
	public void setDate_naissance_ad(LocalDate date_naissance_ad) {
		this.date_naissance_ad = date_naissance_ad;
	}
	
	@Override
	public String toString() {
		return "Admin [id_ad=" + id_ad + ", nom_ad=" + nom_ad + ", prenom_ad=" + prenom_ad + ", email=" + email
				+ ", mdp=" + mdp + ", date_naissance_ad=" + date_naissance_ad + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
