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
	private static final int COLUMNS = 6;
	
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
		
		
		
		JFrame cityFrame = new JFrame("All Cities Screen");
		cityFrame.setSize(WIDTH, HEIGHT);
		cityFrame.setLayout(null);
		cityFrame.getContentPane().setBackground(Color.WHITE);
		
		
		JButton back = new JButton("Back");
		back.setBounds(700, 20, 75, 20);
		cityFrame.add(back);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cityFrame.dispose();
			}	
		});
		
		cityFrame.add(alphabetizedList(this.allCitiesList));
		
		
		cityFrame.revalidate();
		cityFrame.repaint();
		
		cityFrame.setLocationRelativeTo(null);
		cityFrame.setVisible(true);
		cityFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	public JPanel alphabetizedList(ArrayList<City> cities) {
		JPanel alphabetPanel = new JPanel();
		int gap = MAX_SPACE / (2* this.allCitiesList.size() / COLUMNS);
		
		alphabetPanel.setBounds(MAX_SPACE/4 ,MAX_SPACE/2, WIDTH - MAX_SPACE/2, HEIGHT - MAX_SPACE);
		alphabetPanel.setLayout(new GridLayout(0,COLUMNS/2, gap,10));
		alphabetPanel.setBackground(Color.WHITE);
		
		for (int i = 0; i < allCitiesList.size(); i++) {
			JButton cityButton = new JButton(allCitiesList.get(i).getName(), allCitiesList.get(i).getSmallImage());
//			cityButton.setFont(new Font (allCitiesList.get(i).getName(), Font.BOLD, 20));
			cityButton.setHorizontalTextPosition(SwingConstants.RIGHT);
			cityButton.setVerticalTextPosition(SwingConstants.CENTER);
			cityButton.setBackground(new Color(245,245,245));
			
			try {
				cityButton.addActionListener(new RegionListener(cityButton.getText()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			alphabetPanel.add(cityButton);  

		}
		
		return alphabetPanel;
	}
	
	
	public JPanel regionGroup() {
		JPanel regionPanel = new JPanel();
		int gap = MAX_SPACE / (2* this.allCitiesList.size() / COLUMNS);
		
		regionPanel.setBounds(MAX_SPACE/4 ,MAX_SPACE/2, WIDTH - MAX_SPACE/2, HEIGHT - MAX_SPACE);
		regionPanel.setLayout(new GridLayout(1,COLUMNS, 10,0));
		regionPanel.setBackground(Color.WHITE);
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(1,0,0,10));
		northPanel.setBackground(Color.WHITE);
		
		
		
		for (int i = 0; i < allCitiesList.size(); i++) {
			JButton cityButton = new JButton(allCitiesList.get(i).getName(), allCitiesList.get(i).getSmallImage());
//			cityButton.setFont(new Font (allCitiesList.get(i).getName(), Font.BOLD, 20));
			cityButton.setHorizontalTextPosition(SwingConstants.CENTER);
			cityButton.setVerticalTextPosition(SwingConstants.BOTTOM);
			cityButton.setBackground(new Color(245,245,245));
			
			try {
				cityButton.addActionListener(new RegionListener(cityButton.getText()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			regionPanel.add(cityButton);  

		}
		
		return regionPanel;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} // end SortCityViewer
