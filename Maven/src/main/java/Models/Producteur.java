package Models;

import java.time.LocalDate;

public class Producteur {

	
	
	
		 private int id_p;
		 private String nom_p;
		 private String prenom_p;
		 private String email;
		 private String mdp;
		 private LocalDate date_naissance_ac;

		 @Override
		public String toString() {
			return "Producteur [id_p=" + id_p + ", nom_p=" + nom_p + ", prenom_p=" + prenom_p + ", email=" + email + ", mdp="
					+ mdp + ", date_naissance_ac=" + date_naissance_ac + "]";
		}
		 

		public Producteur() {
			super();
		} 

		public Producteur(int id_p, String nom_p, String prenom_p, String email, String mdp, LocalDate date_naissance_ac) {
			super();
			this.id_p = id_p;
			this.nom_p = nom_p;
			this.prenom_p = prenom_p;
			this.email = email;
			this.mdp = mdp;
			this.date_naissance_ac = date_naissance_ac;
		}

		public int getId_p() {
			return id_p;
		}

		public void setId_p(int id_p) {
			this.id_p = id_p;
		}

		public String getNom_p() {
			return nom_p;
		}

		public void setNom_p(String nom_p) {
			this.nom_p = nom_p;
		}

		public String getPrenom_p() {
			return prenom_p;
		}

		public void setPrenom_p(String prenom_p) {
			this.prenom_p = prenom_p;
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

		public LocalDate getDate_naissance_ac() {
			return date_naissance_ac;
		}

		public void setDate_naissance_ac(LocalDate date_naissance_ac) {
			this.date_naissance_ac = date_naissance_ac;
		}
	
	
	}
	
	
	
	
	
	
	
	

