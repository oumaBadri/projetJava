package Models;

public class classement {
	private int nb_votant;
	private int nb_vues;
	private String titre;
	private int id_show;
	
	
	public classement(int nb_vues, String titre, int id_show) {
		super();
		this.nb_vues = nb_vues;
		this.titre = titre;
		this.id_show = id_show;
	}
	
	
	
	
	
	public classement() {
		super();
	}
	
	
	public classement(String key, Integer value,int h) {
		// TODO Auto-generated constructor stub
		this.titre=key;
		this.nb_vues=value;
		this.nb_votant=h;
	}
	public int getNb_vues() {
		return nb_vues;
	}
	public void setNb_vues(int nb_vues) {
		this.nb_vues = nb_vues;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getId_show() {
		return id_show;
	}
	public void setId_show(int id_show) {
		this.id_show = id_show;
	}
	@Override
	public String toString() {
		return titre + " / " + nb_vues;
	}





	public int getNb_votant() {
		return nb_votant;
	}





	public void setNb_votant(int nb_votant) {
		this.nb_votant = nb_votant;
	}
	
	
	
	
	

}
