package Models;

import java.time.LocalDate;

import javafx.scene.image.Image;

public class Show {
	
	private int id_show;
	private String titre_show;
    private LocalDate Date_difussion_show;
    private String pays;
    private String langue;
    private String genre_show;
    private int is_a_film;
    private String affiche;
	

	public Show(int id_show, String titre_show, LocalDate Date_difussion_show, String pays, String langue,String genre_show,int is_a_film) {
		
		this.id_show = id_show;
		this.titre_show = titre_show;
		this.Date_difussion_show = Date_difussion_show;
		this.pays = pays;
		this.langue = langue;
		this.genre_show = genre_show;
		this.is_a_film = is_a_film;
	}

	public Show(String titre_show, String affiche) {
		super();
		this.titre_show = titre_show;
		this.affiche = affiche;
	}


	public Show(int id_show, String titre_show, LocalDate date_difussion_show, String pays, String langue,
			String genre_show, int is_a_film, String affiche) {
		super();
		this.id_show = id_show;
		this.titre_show = titre_show;
		Date_difussion_show = date_difussion_show;
		this.pays = pays;
		this.langue = langue;
		this.genre_show = genre_show;
		this.is_a_film = is_a_film;
		this.affiche = affiche;
	}

	public Show() {
		
	}

	public Show(int id_p) {
		// TODO Auto-generated constructor stub
	}

	public String getTitre_show() {
		return titre_show;
	}

	public void setTitre_show(String titre_show) {
		this.titre_show = titre_show;
	}

	public LocalDate getDate_difussion_show() {
		return Date_difussion_show;
	}

	public void setDate_difussion_show(LocalDate Date_difussion_show) {
		this.Date_difussion_show = Date_difussion_show;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public String getGenre_show() {
		return genre_show;
	}

	public void setGenre_show(String genre_show) {
		this.genre_show = genre_show;
	}

	public int isIs_a_film() {
		return is_a_film;
	}

	public void setIs_a_film(int is_a_film) {
		this.is_a_film = is_a_film;
	}
	public int getId_show() {
		return id_show;
	}
	public void setId_show(int id_show) {
		this.id_show = id_show;
	}

	public String getAffiche() {
		return affiche;
	}
	public void setAffiche(String affiche) {
		this.affiche = affiche;
	}






	public int getIs_a_film() {
		return is_a_film;
	}







	@Override
	public String toString() {
		return "Show [titre_show=" + titre_show + ", affiche=" + affiche + "]";
	}
	
	


	
    
    
   
    
	
	
	
	
	
}
