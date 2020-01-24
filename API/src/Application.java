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
					
					List<Movie> movies = controller.fetchMovieList();
					
					MovieGUI window = new MovieGUI(movies);
					window.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
