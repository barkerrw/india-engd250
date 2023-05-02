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
	private static final int MAX_SPACE = 100;
	private static final int COLUMNS = 2;
	
	Dimension buttonSize = new Dimension(BUTTON_WIDTH,BUTTON_HEIGHT);

	private ArrayList<City> cities = new ArrayList<City>();

	public RegionViewer(ArrayList<City> cities){
		this.cities = cities;
		
		int gap = MAX_SPACE / (this.cities.size() / COLUMNS);
		
		JFrame cityFrame = new JFrame("City Selection Screen");
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
		cityPanel.setBounds(MAX_SPACE,MAX_SPACE, WIDTH - (2*MAX_SPACE), HEIGHT - (3*MAX_SPACE) );
		cityPanel.setLayout(new GridLayout(0,COLUMNS, MAX_SPACE,MAX_SPACE));
		cityPanel.setBackground(Color.WHITE);
		
		for (int i = 0; i < cities.size(); i++) {
			JButton cityButton = new JButton(cities.get(i).getName(), cities.get(i).getImage());
			cityButton.setFont(new Font (cities.get(i).getName(), Font.BOLD, 20));
			cityButton.setHorizontalTextPosition(SwingConstants.CENTER);
			cityButton.setVerticalTextPosition(SwingConstants.BOTTOM);
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
