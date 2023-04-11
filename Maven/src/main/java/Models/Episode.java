package Models;

import java.time.LocalDate;

public class Episode {

	private int id_show;
	private int num_saison;
	private String titre_ep;
	private int num_ep;
	private String desc_ep ;
	private LocalDate date_diff;
	
	public Episode() {
		super();
	}
	public Episode(int id_show, int num_saison, String titre_ep, int num_ep, String desc_ep, LocalDate date_diff) {
		super();
		this.id_show = id_show;
		this.num_saison = num_saison;
		this.titre_ep = titre_ep;
		this.num_ep = num_ep;
		this.desc_ep = desc_ep;
		this.date_diff = date_diff;
	}
	public int getId_show() {
		return id_show;
	}
	public void setId_show(int id_show) {
		this.id_show = id_show;
	}
	public int getNum_saison() {
		return num_saison;
	}
	public void setNum_saison(int num_saison) {
		this.num_saison = num_saison;
	}
	public String getTitre_ep() {
		return titre_ep;
	}
	public void setTitre_ep(String titre_ep) {
		this.titre_ep = titre_ep;
	}
	public int getNum_ep() {
		return num_ep;
	}
	public void setNum_ep(int num_ep) {
		this.num_ep = num_ep;
	}
	public String getDesc_ep() {
		return desc_ep;
	}
	public void setDesc_ep(String desc_ep) {
		this.desc_ep = desc_ep;
	}
	public LocalDate getDate_diff() {
		return date_diff;
	}
	public void setDate_diff(LocalDate date_diff) {
		this.date_diff = date_diff;
	}
	@Override
	public String toString() {
		return "Episode [id_show=" + id_show + ", num_saison=" + num_saison + ", titre_ep=" + titre_ep + ", num_ep="
				+ num_ep + ", desc_ep=" + desc_ep + ", date_diff=" + date_diff + "]";
	}
	
}
