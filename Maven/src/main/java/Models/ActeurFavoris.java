package Models;

public class ActeurFavoris {

	private int  id_user;
	private int id_acteur;
	
	
	public ActeurFavoris() {
		super();
	}


	public ActeurFavoris(int id_user, int id_acteur) {
		super();
		this.id_user = id_user;
		this.id_acteur = id_acteur;
	}


	public int getId_user() {
		return id_user;
	}


	public void setId_user(int id_user) {
		this.id_user = id_user;
	}


	public int getId_acteur() {
		return id_acteur;
	}


	public void setId_acteur(int id_acteur) {
		this.id_acteur = id_acteur;
	}


	@Override
	public String toString() {
		return "ActeurFavoris [id_user=" + id_user + ", id_acteur=" + id_acteur + "]";
	}
	
	
	
	
	
}
