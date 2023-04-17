import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;
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
	private static final int MAX_SPACE = 50;
	private static final int COLUMNS = 3;
	
	Dimension buttonSize = new Dimension(BUTTON_WIDTH,BUTTON_HEIGHT);

	private ArrayList<City> cities = new ArrayList<City>();

	public RegionViewer(ArrayList<City> cities){
		this.cities = cities;
		
		int gap = MAX_SPACE / (this.cities.size() / COLUMNS);
		
		JFrame cityFrame = new JFrame("City Selection Screen");
		cityFrame.setSize(WIDTH, HEIGHT);
		cityFrame.setLayout(null);
		
		JPanel cityPanel = new JPanel();
//		cityPanel.setBorder(new EmptyBorder(100,100,100,100));
		cityPanel.setBounds(MAX_SPACE, MAX_SPACE, WIDTH - (2*MAX_SPACE), HEIGHT - (2*MAX_SPACE) );
		cityPanel.setLayout(new GridLayout(0,COLUMNS, MAX_SPACE,gap));
		
		for (int i = 0; i < cities.size(); i++) {
			JButton cityButton = new JButton(cities.get(i).getName(), cities.get(i).getImage());
			cityButton.setHorizontalTextPosition(SwingConstants.CENTER);
			cityButton.setVerticalTextPosition(SwingConstants.BOTTOM);
			
//			cityButton.addActionListener(new RegionListener(cityButton.getText()));

			
			try {
				cityButton.addActionListener(new RegionListener(cityButton.getText()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
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
