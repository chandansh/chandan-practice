package mypack;

public class Song {
	private String title;
	private String genre;

	public Song() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Song(String title, String genre) {
		super();
		this.title = title;
		this.genre = genre;
	}

}
