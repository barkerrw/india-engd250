import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


/**
 * 
 * @author barkerrw & altschmn <br>
 *
 */
public class SortCityViewer {
	// set instance variables of screen size
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final int BUTTON_WIDTH = 140;
	private static final int BUTTON_HEIGHT = 100;
	private static final int MAX_SPACE = 100;
	private static final int COLUMNS = 3;
	
	Dimension buttonSize = new Dimension(BUTTON_WIDTH,BUTTON_HEIGHT);

	private HashMap<City,String> citiesMap = new HashMap<City,String>();
	private ArrayList<City> allCitiesList = new ArrayList<City>();

	public SortCityViewer(HashMap<City,String> cities){
		this.citiesMap = cities;
		
		SortCity sorter = new SortCity(this.citiesMap);
		this.allCitiesList = sorter.sortAll(citiesMap);
		
		for(City entry : allCitiesList) {
			System.out.println(entry.getName());
		}
		
		
		int gap = MAX_SPACE / (this.allCitiesList.size() / COLUMNS);
		
		JFrame cityFrame = new JFrame("All Cities Screen");
		cityFrame.setSize(WIDTH, HEIGHT);
		cityFrame.setLayout(null);
		cityFrame.getContentPane().setBackground(Color.WHITE);
		
		JLabel label = new JLabel("Hello Traveler, where do you want to go?");
		label.setFont(new Font (label.getText(), Font.BOLD, 20));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setLocation(250, 50);
		
		cityFrame.add(label,BorderLayout.NORTH);
		
		JPanel cityPanel = new JPanel();
//		cityPanel.setBorder(new EmptyBorder(100,100,100,100));
		cityPanel.setBounds(0,MAX_SPACE/2, WIDTH, HEIGHT - MAX_SPACE);
		cityPanel.setLayout(new GridLayout(0,COLUMNS, 30,10));
		cityPanel.setBackground(Color.WHITE);
		
		for (int i = 0; i < allCitiesList.size(); i++) {
			JButton cityButton = new JButton(allCitiesList.get(i).getName(), allCitiesList.get(i).getSmallImage());
//			cityButton.setFont(new Font (allCitiesList.get(i).getName(), Font.BOLD, 20));
			cityButton.setHorizontalTextPosition(SwingConstants.RIGHT);
			cityButton.setVerticalTextPosition(SwingConstants.CENTER);
			cityButton.setBackground(new Color(245,245,245));
			
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
		
		JButton back = new JButton("Back");
		back.setBounds(700, 20, 75, 20);
		cityFrame.add(back);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cityFrame.dispose();
			}	
		});
		
		cityFrame.add(cityPanel);
		
		
		cityFrame.revalidate();
		cityFrame.repaint();
		
		cityFrame.setLocationRelativeTo(null);
		cityFrame.setVisible(true);
		cityFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
} // end CityViewer
