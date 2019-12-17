import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class MovieGUI {

	private JFrame frame;
	private JTable moviesList;
	private JLabel mainTitle;
	private JLabel generalInfo;
	private JLabel genre;
	private JLabel releaseDate;
	private JLabel runtime;
	private JLabel summary;
	private JLabel suggestions;
	private JTable suggestionList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieGUI window = new MovieGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MovieGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void homeScreen() {
		mainTitle = new JLabel("Recent Movies ");
		mainTitle.setHorizontalAlignment(SwingConstants.CENTER);
		mainTitle.setFont(new Font("Yu Gothic", Font.PLAIN, 44));
		mainTitle.setBounds(353, 43, 349, 84);
		frame.getContentPane().add(mainTitle);
		
		moviesList = new JTable();
		moviesList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		moviesList.setBounds(52, 154, 878, 603);
		frame.getContentPane().add(moviesList);
		
		JButton temp = new JButton("See More...");
		temp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				if (moviesList.getSelectedRowCount() != 0) {
					selectedMovieInfo();
//				}
			}
		});
		temp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		temp.setBounds(423, 120, 160, 25);
		frame.getContentPane().add(temp);
	}
	
	private void selectedMovieInfo() {
		mainTitle.setText("Movie Name");
		
		moviesList.setVisible(false);
		generalInfo = new JLabel("Genre: " + " | Release Date: " + " | Movie Length: ;;");
		generalInfo.setHorizontalAlignment(SwingConstants.CENTER);
		generalInfo.setFont(new Font("Yu Gothic", Font.PLAIN, 25));
		generalInfo.setBounds(100, 43, 800, 250);
		frame.getContentPane().add(generalInfo);
		
//		genre = new JLabel("Genre: ");
//		genre.setHorizontalAlignment(SwingConstants.LEFT);
//		genre.setFont(new Font("Yu Gothic", Font.PLAIN, 25));
//		genre.setBounds(100, 43, 349, 250);
//		frame.getContentPane().add(genre);
//		
//		releaseDate = new JLabel("Release Date: ");
//		releaseDate.setHorizontalAlignment(SwingConstants.LEFT);
//		releaseDate.setFont(new Font("Yu Gothic", Font.PLAIN, 25));
//		releaseDate.setBounds(353, 43, 349, 250);
//		frame.getContentPane().add(releaseDate);
//		
//		runtime = new JLabel("Movie Length: ");
//		runtime.setHorizontalAlignment(SwingConstants.LEFT);
//		runtime.setFont(new Font("Yu Gothic", Font.PLAIN, 25));
//		runtime.setBounds(353, 43, 349, 250);
//		frame.getContentPane().add(runtime);
		
		summary = new JLabel("Summary: ");
		summary.setHorizontalAlignment(SwingConstants.LEFT);
		summary.setFont(new Font("Yu Gothic", Font.PLAIN, 25));
		summary.setBounds(100, 80, 800, 400);
		frame.getContentPane().add(summary);
		
		int bounds = summary.getBounds().height + summary.getBounds().y;
		
		suggestions = new JLabel("Similar Movies by Genre:  ");
		suggestions.setHorizontalAlignment(SwingConstants.LEFT);
		suggestions.setFont(new Font("Yu Gothic", Font.PLAIN, 25));
		suggestions.setBounds(100, 350, 349, 500);
		frame.getContentPane().add(suggestions);
		
		suggestionList = new JTable();
		suggestionList.setBounds(100, 525, 349, 250);		
		
		JButton home = new JButton("<-");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				homeScreen();
			}
		});
		home.setFont(new Font("Tahoma", Font.PLAIN, 20));
		home.setBounds(423, 120, 160, 25);
		frame.getContentPane().add(home);
		
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		homeScreen();
		
	}
}
