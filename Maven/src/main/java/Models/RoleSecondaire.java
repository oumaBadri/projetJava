package Models;

public class RoleSecondaire {

	
	
	private int id_show;
	private int id_acteur;
	private int num_saison;
	
	
	
	
	public RoleSecondaire(int id_show, int id_acteur, int num_saison) {
		super();
		this.id_show = id_show;
		this.id_acteur = id_acteur;
		this.num_saison = num_saison;
	}


    public RoleSecondaire() {
		super();
	}

    public int getId_show() {
		return id_show;
	}

    public void setId_show(int id_show) {
		this.id_show = id_show;
	}
    public int getId_acteur() {
		return id_acteur;
	}

    public void setId_acteur(int id_acteur) {
		this.id_acteur = id_acteur;
	}
    public int getNum_saison() {
		return num_saison;
	}
    public void setNum_saison(int num_saison) {
		this.num_saison = num_saison;
	}
	@Override
	public String toString() {
		return "RolePrincipale [id_show=" + id_show + ", id_acteur=" + id_acteur + ", num_saison=" + num_saison + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
