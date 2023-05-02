import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Class: AppViewer
 * 
 * @author barkerrw & altschmn <br>
 *         Purpose: Used to display starting map screen and buttons
 *
 */
public class AppViewer {

	// set instance variables of screen size
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	// set map image
	private ImageIcon map;
	// set instance variables for easier use
	private int mapX;
	private int mapY;
	// create ArrayList<City> for each region
	private ArrayList<City> northCities = new ArrayList<City>();
	private ArrayList<City> westCities = new ArrayList<City>();
	private ArrayList<City> southCities = new ArrayList<City>();
	private ArrayList<City> eastCities = new ArrayList<City>();
	private ArrayList<City> centralCities = new ArrayList<City>();
	private ArrayList<City> northeastCities = new ArrayList<City>();

	/**
	 * ensures: a new AppViewer is created
	 */
	public AppViewer() {

		// instantiate frame with dimensions and features
		JFrame frame = new JFrame("Region Selection Screen");
		frame.setSize(WIDTH, HEIGHT);
		frame.getContentPane().setBackground(Color.WHITE);

		JLayeredPane panel = frame.getLayeredPane();

		JLabel label = new JLabel("Hello Traveler, where do you want to go?");
		label.setFont(new Font (label.getText(), Font.BOLD, 20));
		label.setHorizontalAlignment(JLabel.CENTER);

		map = new ImageIcon("src/pictures/RegionMap.jpg");

		JLabel mapHolder = new JLabel(map);

		frame.add(mapHolder, BorderLayout.CENTER);
		frame.add(label, BorderLayout.NORTH);
		// create buttons for each region with locations
		JButton north = new JButton("North");
		JButton west = new JButton("West");
		JButton south = new JButton("South");
		JButton east = new JButton("East");
		JButton northeast = new JButton("NorthEast");
		JButton central = new JButton("Central");
		// set bounds of map for button access
		mapX = WIDTH / 2;
		mapY = HEIGHT / 2;
		// set button dimensions and location
		north.setBounds(mapX - 95, mapY - 90, 75, 20);
		west.setBounds(mapX - 110, mapY + 40, 75, 20);
		east.setBounds(mapX + 35, mapY+10, 75, 20);
		south.setBounds(mapX - 90, mapY + 130, 75, 20);
		northeast.setBounds(mapX + 120, mapY - 50, 100, 20);
		central.setBounds(mapX - 65, mapY, 85, 20);
		// add buttons to panel
		panel.add(north, 1);
		panel.add(south, 1);
		panel.add(east, 1);
		panel.add(west, 1);
		panel.add(northeast, 1);
		panel.add(central, 1);
		// re-instantiate panel on top, make it visible
		panel.repaint();
		panel.setOpaque(true);
		frame.repaint();
		
		// add new City with name and image (from source)
		northCities.add(new City("Agra", "src/pictures/AgraFort.jpg"));
		westCities.add(new City("Mumbai", "src/pictures/MumbaiHarbor.jpg"));
		southCities.add(new City("Bengaluru", "src/pictures/LalbaghGlasshouse.jpg"));
		eastCities.add(new City("Kolkata", "src/pictures/Kolkata.jpg"));
		centralCities.add(new City("Indore", "src/pictures/IndoreRajwada.jpg"));
		northeastCities.add(new City("Guahati", "src/pictures/KamakhyaTemple.jpeg"));
		
		northCities.add(new City("Agra", "src/pictures/AgraFort.jpg"));
		westCities.add(new City("Mumbai", "src/pictures/MumbaiHarbor.jpg"));
		southCities.add(new City("Bengaluru", "src/pictures/LalbaghGlasshouse.jpg"));
		eastCities.add(new City("Kolkata", "src/pictures/Kolkata.jpg"));
		centralCities.add(new City("Indore", "src/pictures/IndoreRajwada.jpg"));
		northeastCities.add(new City("Guahati", "src/pictures/KamakhyaTemple.jpeg"));
		
		// add MapListener to region buttons
		north.addActionListener(new MapListener(northCities));
		west.addActionListener(new MapListener(westCities));
		south.addActionListener(new MapListener(southCities));
		east.addActionListener(new MapListener(eastCities));
		central.addActionListener(new MapListener(centralCities));
		northeast.addActionListener(new MapListener(northeastCities));
		// set close operation for frame
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} // AppViewer
} // end AppViewer
