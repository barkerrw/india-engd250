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
	
	private int maxSize;

	private HashMap<City,String> citiesMap = new HashMap<City,String>();
	private ArrayList<City> allCitiesList = new ArrayList<City>();
	private ArrayList<City> northCities = new ArrayList<City>();
	private ArrayList<City> westCities = new ArrayList<City>();
	private ArrayList<City> southCities = new ArrayList<City>();
	private ArrayList<City> eastCities = new ArrayList<City>();
	private ArrayList<City> centralCities = new ArrayList<City>();
	private ArrayList<City> northeastCities = new ArrayList<City>();
	

	public SortCityViewer(ArrayList<City> cities, int[] sizes){   //HashMap<City,String> 
		
		for (int i = 0; i < cities.size(); i ++) {
			if(i < sizes[0]) {
				this.northCities.add(cities.get(i));
			}
			else if (i >= sizes[0] && i < sizes[1]){
				this.southCities.add(cities.get(i));
			}
			else if (i >= sizes[1] && i < sizes[2]){
				this.eastCities.add(cities.get(i));
			}
			else if (i >= sizes[2] && i < sizes[3]){
				this.westCities.add(cities.get(i));
			}
			else if (i >= sizes[3] && i < sizes[4]){
				this.centralCities.add(cities.get(i));
			}
			else {
				this.northeastCities.add(cities.get(i));
			}
		}
		
		
		
		SortCity sorter = new SortCity(cities, sizes);
			
		this.allCitiesList = sorter.sortList(cities);
		
		
		
//		ArrayList<City> north = sorter.getNorth();
//		ArrayList<City> south = sorter.getSouth();
//		ArrayList<City> east = sorter.getEast();
//		ArrayList<City> west = sorter.getWest();
//		ArrayList<City> central = sorter.getCentral();
//		ArrayList<City> northeast = sorter.getNortheast();
//		
//		this.northCities = sorter.sortList(northCities);
//		this.southCities = sorter.sortList(southCities);
//		this.eastCities = sorter.sortList(eastCities);
//		this.westCities = sorter.sortList(westCities);
//		this.centralCities = sorter.sortList(centralCities);
//		this.northeastCities = sorter.sortList(northeastCities);
	
		
		int size = sizes[0];
		for(int i = 1; i < 6; i ++) {
			if (sizes[i] > size) {
				size = sizes[i];
			}
		}
		this.maxSize = size;
		System.out.println("All Cities:  ");
		for(City entry : allCitiesList) {
			System.out.print(entry.getName());
		}
		
		System.out.println("\n\n By Region:  ");
		for(City entry : northCities) {
			System.out.println(entry.getName());
		}
		System.out.println();
		
		for(City entry : southCities) {
			System.out.println(entry.getName());
		}
		System.out.println();
		System.out.println();
	
		for(City entry : this.eastCities) {
			System.out.println(entry.getName());
		}
		System.out.println();
		System.out.println();
		
		for(City entry : westCities) {
			System.out.println(entry.getName());
		}
		System.out.println();
		System.out.println();
		
		for(City entry : centralCities) {
			System.out.println(entry.getName());
		}
		System.out.println();
		System.out.println();
		
		for(City entry : northeastCities) {
			System.out.println(entry.getName());
		}
		System.out.println();
		System.out.println();
		
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
		
//		cityFrame.add(regionGroup());
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
		
		regionPanel.setBounds(MAX_SPACE/4 ,MAX_SPACE/2, WIDTH - MAX_SPACE/2, HEIGHT - MAX_SPACE);
		regionPanel.setLayout(new GridLayout(COLUMNS,maxSize + 1, 10,10));
		regionPanel.setBackground(Color.WHITE);
		
		JLabel northLabel = new JLabel("North");
		JLabel southLabel = new JLabel("South");
		JLabel eastLabel = new JLabel("East");
		JLabel westLabel = new JLabel("West");
		JLabel centralLabel = new JLabel("Central");
		JLabel northeastLabel = new JLabel("Northeast");
		JLabel blank = new JLabel();
		
		
		//loading region buttons one region at a time
		
		northLabel.setFont(new Font (northLabel.getText(), Font.BOLD, 20));
		regionPanel.add(northLabel);	
		for (int i = 0; i < this.northCities.size(); i++) {
			JButton cityButton = new JButton(northCities.get(i).getName(), northCities.get(i).getSmallImage());
			cityButton.setHorizontalTextPosition(SwingConstants.RIGHT);
			cityButton.setVerticalTextPosition(SwingConstants.CENTER);
			cityButton.setBackground(new Color(245,245,245));
			
			try {
				cityButton.addActionListener(new RegionListener(cityButton.getText()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			regionPanel.add(cityButton);  
		}
//		if (this.northCities.size() < maxSize){
//			int needBlanks = maxSize - this.northCities.size();
//			for (int i = 0; i < needBlanks; i ++) {
//				regionPanel.add(blank);
//			}
//		}
		
		southLabel.setFont(new Font (southLabel.getText(), Font.BOLD, 20));
		regionPanel.add(southLabel);	
		for (int i = 0; i < this.southCities.size(); i++) {
			JButton cityButton = new JButton(southCities.get(i).getName(), southCities.get(i).getSmallImage());
			cityButton.setHorizontalTextPosition(SwingConstants.RIGHT);
			cityButton.setVerticalTextPosition(SwingConstants.CENTER);
			cityButton.setBackground(new Color(245,245,245));
			
			try {
				cityButton.addActionListener(new RegionListener(cityButton.getText()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			regionPanel.add(cityButton);  
		}
		
		eastLabel.setFont(new Font (eastLabel.getText(), Font.BOLD, 20));
		regionPanel.add(eastLabel);	
		for (int i = 0; i < this.eastCities.size(); i++) {
			JButton cityButton = new JButton(eastCities.get(i).getName(), eastCities.get(i).getSmallImage());
			cityButton.setHorizontalTextPosition(SwingConstants.RIGHT);
			cityButton.setVerticalTextPosition(SwingConstants.CENTER);
			cityButton.setBackground(new Color(245,245,245));
			
			try {
				cityButton.addActionListener(new RegionListener(cityButton.getText()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			regionPanel.add(cityButton);  
		}
		
		westLabel.setFont(new Font (westLabel.getText(), Font.BOLD, 20));
		regionPanel.add(westLabel);	
		for (int i = 0; i < this.westCities.size(); i++) {
			JButton cityButton = new JButton(westCities.get(i).getName(), westCities.get(i).getSmallImage());
			cityButton.setHorizontalTextPosition(SwingConstants.RIGHT);
			cityButton.setVerticalTextPosition(SwingConstants.CENTER);
			cityButton.setBackground(new Color(245,245,245));
			
			try {
				cityButton.addActionListener(new RegionListener(cityButton.getText()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			regionPanel.add(cityButton);  
		}
		
		centralLabel.setFont(new Font (centralLabel.getText(), Font.BOLD, 20));
		regionPanel.add(centralLabel);	
		for (int i = 0; i < this.centralCities.size(); i++) {
			JButton cityButton = new JButton(centralCities.get(i).getName(), centralCities.get(i).getSmallImage());
			cityButton.setHorizontalTextPosition(SwingConstants.RIGHT);
			cityButton.setVerticalTextPosition(SwingConstants.CENTER);
			cityButton.setBackground(new Color(245,245,245));
			
			try {
				cityButton.addActionListener(new RegionListener(cityButton.getText()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			regionPanel.add(cityButton);  
		}
		
		northeastLabel.setFont(new Font (northeastLabel.getText(), Font.BOLD, 20));
		regionPanel.add(northeastLabel);	
		for (int i = 0; i < this.northeastCities.size(); i++) {
			JButton cityButton = new JButton(northeastCities.get(i).getName(), northeastCities.get(i).getSmallImage());
			cityButton.setHorizontalTextPosition(SwingConstants.RIGHT);
			cityButton.setVerticalTextPosition(SwingConstants.CENTER);
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
