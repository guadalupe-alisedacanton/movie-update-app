import java.awt.EventQueue;
import java.util.List;

public class Application {	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main main = new Main();
					Controller controller = new Controller(main);
					
					List<Movie> nowPlayingMovies = controller.fetchNowPlayingList(); 
					List<Movie> upcomingMovies = controller.fetchUpcomingList();
					//change line above to: List<Movie> nowPlayingMovies = controller.fetchNowPlayingList();
					// List<Movie> upcomingMovies = controller.fetchUpcomingList();
					
					MovieGUI window = new MovieGUI(nowPlayingMovies, upcomingMovies);
					window.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
