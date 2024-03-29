import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

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

	private ArrayList<City> allCitiesList = new ArrayList<City>();
	private int[] regionListSize = new int[6];

	/**
	 * ensures: a new AppViewer can be created
	 */
	public AppViewer() {

		// instantiate frame with dimensions and features
		JFrame frame = new JFrame("Region Selection Screen");
		frame.setSize(WIDTH, HEIGHT);
		frame.getContentPane().setBackground(Color.WHITE);

		JLayeredPane panel = frame.getLayeredPane();

		JLabel label = new JLabel("Hello Traveler, where do you want to go?");
		label.setFont(new Font(label.getText(), Font.BOLD, 20));
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

		JButton allCities = new JButton("See All Cities");

		// set bounds of map for button access
		mapX = WIDTH / 2;
		mapY = HEIGHT / 2;
		// set button dimensions and location
		north.setBounds(mapX - 95, mapY - 90, 75, 20);
		west.setBounds(mapX - 110, mapY + 40, 75, 20);
		east.setBounds(mapX + 35, mapY + 10, 75, 20);
		south.setBounds(mapX - 90, mapY + 130, 75, 20);
		northeast.setBounds(mapX + 120, mapY - 50, 100, 20);
		central.setBounds(mapX - 65, mapY, 85, 20);

		allCities.setBounds(mapX + 200, mapY + 150, 120, 20);

		// add buttons to panel
		panel.add(north, 1);
		panel.add(south, 1);
		panel.add(east, 1);
		panel.add(west, 1);
		panel.add(northeast, 1);
		panel.add(central, 1);

		panel.add(allCities, 1);

		// re-instantiate panel on top, make it visible
		panel.repaint();
		panel.setOpaque(true);
		frame.repaint();

		// add new City with name and image (from source)
		northCities.add(new City("Agra", "src/pictures/AgraFort.jpg"));
		westCities.add(new City("Mumbai", "src/pictures/MumbaiHarbor.jpg"));
		southCities.add(new City("Bengaluru", "src/pictures/BangalorePalace.jpg"));
		eastCities.add(new City("Kolkata", "src/pictures/Kolkata.jpg"));
		centralCities.add(new City("Indore", "src/pictures/IndoreRajwada.jpg"));
		northeastCities.add(new City("Guwahati", "src/pictures/KamakhyaTemple.jpeg"));

		northCities.add(new City("Delhi", "src/pictures/NewDelhi.jpg"));
		westCities.add(new City("Ahmedabad", "src/pictures/BasirMosqueAhmedabad.jpg"));
		southCities.add(new City("Hyderabad", "src/pictures/HyderabadCharminar.jpg"));
		eastCities.add(new City("Patna", "src/pictures/PatnaGandhiMuseum.jpeg"));
		centralCities.add(new City("Nagpur", "src/pictures/NagpurZeroMarker.jpg"));
		northeastCities.add(new City("Agartala", "src/pictures/AgartalaRavindraKanan.jpg"));

		// make array list for all cities
		this.allCitiesList.addAll(northCities);
		this.regionListSize[0] = northCities.size();
		this.allCitiesList.addAll(southCities);
		this.regionListSize[1] = southCities.size();
		this.allCitiesList.addAll(eastCities);
		this.regionListSize[2] = eastCities.size();
		this.allCitiesList.addAll(westCities);
		this.regionListSize[3] = westCities.size();
		this.allCitiesList.addAll(centralCities);
		this.regionListSize[4] = centralCities.size();
		this.allCitiesList.addAll(northeastCities);
		this.regionListSize[5] = northeastCities.size();

		// add MapListener to region buttons
		north.addActionListener(new MapListener(northCities));
		west.addActionListener(new MapListener(westCities));
		south.addActionListener(new MapListener(southCities));
		east.addActionListener(new MapListener(eastCities));
		central.addActionListener(new MapListener(centralCities));
		northeast.addActionListener(new MapListener(northeastCities));

		allCities.addActionListener(
				new AllCitiesListener(northCities, southCities, eastCities, westCities, centralCities, northeastCities));
		
		// set close operation for frame
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} // AppViewer
	
} // end AppViewer
