package Models;

public class Genre {

	private int  id_user;
	private String genre;
	public Genre(int id_user, String genre) {
		super();
		this.id_user = id_user;
		this.genre = genre;
	}
	public Genre() {
		super();
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "Genre [id_user=" + id_user + ", genre=" + genre + "]";
	}
	
	
	
	
	
	
}
