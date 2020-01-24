import java.awt.Color;
import java.util.List;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.DefaultTableCellRenderer;


public class MovieGUI {

	private JFrame frame;
	private DefaultTableModel tableModel; 
	private String [] movieNames = {"Scooby-Doo", "The 3 Stooges", "Romeo & Juliet", "It", "Terminator"};
	private String [] releaseDates = {"2005", "2009", "1996", "2018", "1984"};
	private String [] genres = {"Mystery", "Comedy", "Romance", "Horror", "Sci-fi"};
	private String [] runtimes = {"Short", "Too long", "2 hours", "2.5 hours", "Moderate"};
	private String [] summaries = {"4 kids and dog solving mysteries", "3 stupid people", "Sad love", "Scary clown", "Cyborg assassin"};
	//recommended list
	
	private JTable moviesList;
	private JLabel mainTitle;
	private JLabel generalInfo;
	private JLabel genre;
	private JLabel releaseDate;
	private JLabel runtime;
	private JLabel summary;
	private JTextArea summaryInfo;
	private JLabel suggestions;
	private JTable suggestionList;
	private JButton temp;
	private JButton back;
	private JLabel background;
	private static MovieGUI window;
	private JLabel movieTitle;
	private List<Movie> movies;


	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new MovieGUI();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the application.
	 */
	public MovieGUI(List<Movie> movies) {
		this.movies = movies;
		initialize();
	}

	public void start() {
		this.frame.setVisible(true);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void homeScreen() {
		mainTitle = new JLabel();
		mainTitle.setBackground(Color.LIGHT_GRAY);
		temp = new JButton();
		
		tableModel = new DefaultTableModel();
		moviesList = new JTable(tableModel);
		moviesList.setFont(new Font("Yu Gothic", Font.PLAIN, 25));
		moviesList.setRowHeight(110);
		
		tableModel.addColumn("Movies!");
		tableModel.setRowCount(movieNames.length);
		for (int i = 0; i < movieNames.length; i++) {
			tableModel.setValueAt("   " + movieNames[i] + ", " + genres[i] + ", " + releaseDates[i], i, 0);
		}

		visibleHome();
	}
	
	private void selectedMovieInfo(int rowIndex) {
		temp.disable();
		temp.setVisible(false);
		
		mainTitle.setText(movieNames[rowIndex]);
		frame.getContentPane().add(mainTitle);
		
		moviesList.setVisible(false);
		generalInfo = new JLabel("Genre: " + genres[rowIndex] + " | Release Date: " + releaseDates[rowIndex] + 
				" | Movie Length: " + runtimes[rowIndex]);
		generalInfo.setHorizontalAlignment(SwingConstants.CENTER);
		generalInfo.setFont(new Font("Yu Gothic", Font.PLAIN, 25));
		generalInfo.setBounds(100, 32, 800, 250);
		frame.getContentPane().add(generalInfo);
		generalInfo.setVisible(true);
		
		summary = new JLabel("Summary:");
		summary.setHorizontalAlignment(SwingConstants.LEFT);
		summary.setFont(new Font("Yu Gothic", Font.PLAIN, 25));
		summary.setBounds(100, 60, 800, 400);
		frame.getContentPane().add(summary);
		summary.setVisible(true);
		
		summaryInfo = new JTextArea(summaries[rowIndex] + "kjfsadhfoief fjoewjg something really iii ijforjgrleagoremgoregapomrpoeg   pofjrepog krpgkpoe kpo");
//		summaryInfo.setHorizontalAlignment(SwingConstants.LEFT);
		summaryInfo.setFont(new Font("Yu Gothic", Font.PLAIN, 25));
		summaryInfo.setBounds(100, 290, 800, 200);
		frame.getContentPane().add(summaryInfo);
		summaryInfo.setVisible(true);
		summaryInfo.setWrapStyleWord(true);
		summaryInfo.setLineWrap(true);
		summaryInfo.setBackground(null);
		
		
		suggestions = new JLabel("Similar Movies by Genre:  ");
		suggestions.setHorizontalAlignment(SwingConstants.LEFT);
		suggestions.setFont(new Font("Yu Gothic", Font.PLAIN, 25));
		suggestions.setBounds(100, 300, 349, 500);
		frame.getContentPane().add(suggestions);
		suggestions.setVisible(true);

		
		suggestionList = new JTable();
		suggestionList.setBounds(100, 610, 785, 400);
		frame.getContentPane().add(suggestionList);
		suggestionList.setVisible(true);


		back = new JButton("<--");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().removeAll();
				frame.repaint();
				visibleHome();
			}
		});
		back.setFont(new Font("Tahoma", Font.PLAIN, 20));
		back.setBounds(100, 45, 75, 50);
		frame.getContentPane().add(back);
		
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);		
		
		homeScreen();
		
	}
	
	private void invisibleMovieInfo() {
		back.disable();
		back.setVisible(false);
		
		generalInfo.setVisible(false);
		summary.setVisible(false);
		suggestions.setVisible(false);
		suggestionList.setVisible(false);
	}
	
	private void visibleHome() {
		mainTitle.setText("Recent Movies");
		mainTitle.setHorizontalAlignment(SwingConstants.CENTER);
		mainTitle.setFont(new Font("Yu Gothic", Font.PLAIN, 44));
		mainTitle.setBounds(12, 43, 958, 84);
		frame.getContentPane().add(mainTitle);
		
		temp.setText("See More...");
		temp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (moviesList.getSelectedRowCount() != 0) {
					selectedMovieInfo(moviesList.getSelectedRow());
				}
			}
		});
		temp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		temp.setBounds(52, 43, 160, 25);
		frame.getContentPane().add(temp);
		temp.setVisible(true);
		
		
		moviesList.setVisible(true);
//		moviesList.setEnabled(false);
//		moviesList.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent evt) {
//				if (evt.getClickCount() == 2 && moviesList.getSelectedRowCount() != 0) {
//					selectedMovieInfo(moviesList.getSelectedRow());
//					
//		        }
//			}
//		});
		moviesList.setBounds(52, 154, 878, 745);
		frame.getContentPane().add(moviesList);
	}
	
	
	private String tableInfo() {
		return "name" + "\n" + "Release Date: " + "\n" + "Genre: ";
	}
}
