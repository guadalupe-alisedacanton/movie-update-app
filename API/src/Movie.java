
public class Movie {
	private String title;
	private String genre;
	private String summary;
	private String releaseDate;
	private String runtime;
	private String similarMovie;
	
	public Movie(String title, String genre, String summary, String releaseDate, String runtime, String similarMovie) {
		this.title = title;
		this.genre = genre;
		this.summary = summary;
		this.releaseDate = releaseDate;
		this.runtime = runtime;
		this.similarMovie = similarMovie;
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
	public String getReleaseDate() {
		return releaseDate;
	}
	public String getRuntime() {
		return runtime;
	}
	public String getSimilarMovie() {
		return similarMovie;
	}

}
