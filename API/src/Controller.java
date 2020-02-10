import java.util.List;

public class Controller {
	private Main mainCode;
	
	public Controller(Main mainCode) {
		this.mainCode = mainCode;
	}
	
	public List<Movie> fetchNowPlayingList() {
		return mainCode.setupNowPlayingList();		
	}
	
	public List<Movie> fetchUpcomingList() {
		return mainCode.setupUpcomingList();
	}
	
	/*
	 * public List<Movie> fetchUpcomingList() {
	 * 		return mainCode.setupUpcomingList();
	 * }
	 */
}
