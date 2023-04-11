package Models;

import java.time.LocalDate;

public class Saison {

	
	 private int id_show;
	 private String titre_saison;
	 private int nbEpisode;
	 private int numSaison;
	 private LocalDate date_diffusion;
	 private String desc_saison;
	public Saison() {
		super();
	}
	public Saison(int id_show, String titre_saison, int nbEpisode, int numSaison, LocalDate date_diffusion,
			String desc_saison) {
		super();
		this.id_show = id_show;
		this.titre_saison = titre_saison;
		this.nbEpisode = nbEpisode;
		this.numSaison = numSaison;
		this.date_diffusion = date_diffusion;
		this.desc_saison = desc_saison;
	}
	public int getId_show() {
		return id_show;
	}
	public void setId_show(int id_show) {
		this.id_show = id_show;
	}
	public String getTitre_saison() {
		return titre_saison;
	}
	public void setTitre_saison(String titre_saison) {
		this.titre_saison = titre_saison;
	}
	public int getNbEpisode() {
		return nbEpisode;
	}
	public void setNbEpisode(int nbEpisode) {
		this.nbEpisode = nbEpisode;
	}
	public int getNumSaison() {
		return numSaison;
	}
	public void setNumSaison(int numSaison) {
		this.numSaison = numSaison;
	}
	public LocalDate getDate_diffusion() {
		return date_diffusion;
	}
	public void setDate_diffusion(LocalDate date_diffusion) {
		this.date_diffusion = date_diffusion;
	}
	public String getDesc_saison() {
		return desc_saison;
	}
	public void setDesc_saison(String desc_saison) {
		this.desc_saison = desc_saison;
	}
	@Override
	public String toString() {
		return "Saison [id_show=" + id_show + ", titre_saison=" + titre_saison + ", nbEpisode=" + nbEpisode
				+ ", numSaison=" + numSaison + ", date_diffusion=" + date_diffusion + ", desc_saison=" + desc_saison
				+ "]";
	}
	 
	 
	 
	 
	 
	
	
	
}
