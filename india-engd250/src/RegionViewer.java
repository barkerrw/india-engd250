import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


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
		cityFrame.setLayout(null);
		
		JPanel cityPanel = new JPanel();
//		cityPanel.setBorder(new EmptyBorder(100,100,100,100));
		cityPanel.setBounds(100, 100, 600, 400);
		cityPanel.setLayout(new GridLayout(0,2, 100,100));
		
		for (int i = 0; i < cities.size(); i++) {
			JButton cityButton = new JButton(cities.get(i).getName(), cities.get(i).getImage());
			cityButton.setHorizontalTextPosition(SwingConstants.CENTER);
			cityButton.setVerticalTextPosition(SwingConstants.BOTTOM);
			
			
			
			
			cityPanel.add(cityButton);  
				
			
//			cityFrame.add(cityLabel);
		}
		
		
		cityFrame.add(cityPanel);
		cityFrame.repaint();
		
		cityFrame.setLocationRelativeTo(null);
		cityFrame.setVisible(true);
		cityFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
} // end CityViewer
