import java.util.List;

public class Controller {
	private Main mainCode;
	
	public Controller(Main mainCode) {
		this.mainCode = mainCode;
	}
	
	public List<Movie> fetchMovieList() {
		return mainCode.setupMovieList();		
	}
}
