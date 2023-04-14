import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.*;


/**
 * 
 * @author barkerrw & altschmn <br>
 *
 */
public class RegionViewer {
	// set instance variables of screen size
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final int BUTTON_WIDTH = 100;
	private static final int BUTTON_HEIGHT = 120;
	
	Dimension buttonSize = new Dimension(BUTTON_WIDTH,BUTTON_HEIGHT);

	private ArrayList<City> cities = new ArrayList<City>();

	public RegionViewer(ArrayList<City> cities) {
		this.cities = cities;
		
		JFrame cityFrame = new JFrame("City Selection Screen");
		cityFrame.setSize(WIDTH, HEIGHT);
//		cityFrame.setLayout(Borde);;
		
		for (int i = 0; i < cities.size(); i++) {
			JLabel cityLabel = new JLabel(cities.get(i).getName(), cities.get(i).getImage(), 0);
			cityLabel.setHorizontalAlignment(JLabel.CENTER);
			cityLabel.setHorizontalTextPosition(JLabel.CENTER);
			cityLabel.setVerticalTextPosition(JLabel.BOTTOM);
			
			JButton cityButton = new JButton(cities.get(i).getName(), cities.get(i).getImage());
			cityButton.setSize(buttonSize);
//			cityButton.set
			cityButton.setHorizontalTextPosition(SwingConstants.CENTER);
			cityButton.setVerticalTextPosition(SwingConstants.BOTTOM);
			
			cityFrame.add(cityButton);
			
//			cityFrame.repaint();
			
//			cityFrame.add(cityLabel);
		}
		
		cityFrame.setLocationRelativeTo(null);
		cityFrame.setVisible(true);
		cityFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
} // end CityViewer
