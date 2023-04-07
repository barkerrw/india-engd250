import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author barkerrw & altschmn <br>
 *
 */
public class CityViewer {
	// set instance variables of screen size
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	private ArrayList<City> cities = new ArrayList<City>();

	public CityViewer(ArrayList<City> cities) {
		this.cities = cities;
		
		JFrame cityFrame = new JFrame("City Selection Screen");
		cityFrame.setSize(WIDTH, HEIGHT);
		
		for (int i = 0; i < cities.size(); i++) {
			JLabel cityLabel = new JLabel(cities.get(i).getName(), cities.get(i).getImage(), 0);
			cityLabel.setHorizontalAlignment(JLabel.CENTER);
			cityLabel.setHorizontalTextPosition(JLabel.CENTER);
			cityLabel.setVerticalTextPosition(JLabel.BOTTOM);
			
			cityFrame.add(cityLabel);
		}
		
		cityFrame.setLocationRelativeTo(null);
		cityFrame.setVisible(true);
		cityFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
} // end CityViewer
