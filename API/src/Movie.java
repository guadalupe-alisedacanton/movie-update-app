
public class Movie {
	private String title;
	private String genre;
	private String summary;
	public Movie(String title, String genre, String summary) {
		this.title = title;
		this.genre = genre;
		this.summary = summary;
	}
	
	public String getTitle() {
		return title;
	}
	public String getGenre() {
		return genre;
	}
	
	public String getSummary() {
		return summary;
	}

}
