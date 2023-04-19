package Models;

public class Avis {

	private int id_user;
	private int id_show;
	private int note;
	private String commantaire;
	private  int favoris_show;
	private  int num_ep;
	private int num_saison;
	
	
      

	public Avis() {
		super();
	}
	
	



	public Avis(int id_user, int id_show, int note, String commantaire, int num_ep, int num_saison) {
		super();
		this.id_user = id_user;
		this.id_show = id_show;
		this.note = note;
		this.commantaire = commantaire;

		this.num_ep = num_ep;
		this.num_saison = num_saison;
	}
	


	public Avis(int id_user, int id_show, int note, String commantaire, int favoris_show, int num_ep, int num_saison) {
		super();
		this.id_user = id_user;
		this.id_show = id_show;
		this.note = note;
		this.commantaire = commantaire;
		this.favoris_show = favoris_show;
		this.num_ep = num_ep;
		this.num_saison = num_saison;
	}





	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public   int getFavoris_show() {
		return favoris_show;
	}
	public void setFavoris_show(int favoris_show) {
		this.favoris_show = favoris_show;
	}
	public  int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public  int getId_show() {
		return id_show;
	}
	public void setId_show(int id_show) {
		this.id_show = id_show;
	}
	public  String getCommantaire() {
		return commantaire;
	}
	public void setCommantaire(String commantaire) {
		this.commantaire = commantaire;
	}
	public  int getNum_ep() {
		return num_ep;
	}
	public void setNum_ep(int num_ep) {
		this.num_ep = num_ep;
	}
	public int getNum_saison() {
		return num_saison;
	}
	public void setNum_saison(int num_saison) {
		this.num_saison = num_saison;
	}


	@Override
	public String toString() {
		return "Avis [id_show=" + id_show + "]";
	}
	
	
	public String toString2() {
		return "Avis [id_user=" + id_user + ", id_show=" + id_show + ", note=" + note + ", commantaire=" + commantaire
				+ ", favoris_show=" + favoris_show + ", num_ep=" + num_ep + ", num_saison=" + num_saison + "]";
	}
	
	
	
	
}