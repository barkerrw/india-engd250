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
 * Class: SortCityViewer
 * 
 * @author barkerrw & altschmn <br>
 * 		   Purpose: Used to display cities in All Cities Page
 *
 */
public class SortCityViewer extends SortCity {
	// set instance variables of screen size
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final int MAX_SPACE = 100;
	private static final int ROWS = 6;

	private int maxSize;

	private ArrayList<City> allCitiesList = new ArrayList<City>();
	private ArrayList<City> northCities = new ArrayList<City>();
	private ArrayList<City> westCities = new ArrayList<City>();
	private ArrayList<City> southCities = new ArrayList<City>();
	private ArrayList<City> eastCities = new ArrayList<City>();
	private ArrayList<City> centralCities = new ArrayList<City>();
	private ArrayList<City> northeastCities = new ArrayList<City>();

	public SortCityViewer(ArrayList<City> nCities, ArrayList<City> sCities, ArrayList<City> eCities,
			ArrayList<City> wCities, ArrayList<City> cCities, ArrayList<City> neCities) { // HashMap<City,String>

		super(nCities, sCities, eCities, wCities, cCities, neCities);

		this.allCitiesList = super.getFullList();
		this.northCities = super.sortList(nCities);
		this.southCities = super.sortList(sCities);
		this.eastCities = super.sortList(eCities);
		this.westCities = super.sortList(wCities);
		this.centralCities = super.sortList(cCities);
		this.northeastCities = super.sortList(neCities);
		this.allCitiesList = super.sortList(allCitiesList);

		this.maxSize = 3;

		System.out.println("All Cities:  ");
		for (City entry : allCitiesList) {
			System.out.println(entry.getName());
		}

		System.out.println("\n\n By Region:  ");
		for (City entry : northCities) {
			System.out.println(entry.getName());
		}
		System.out.println();

		for (City entry : southCities) {
			System.out.println(entry.getName());
		}
		System.out.println();
		System.out.println();

		for (City entry : this.eastCities) {
			System.out.println(entry.getName());
		}
		System.out.println();
		System.out.println();

		for (City entry : westCities) {
			System.out.println(entry.getName());
		}
		System.out.println();
		System.out.println();

		for (City entry : centralCities) {
			System.out.println(entry.getName());
		}
		System.out.println();
		System.out.println();

		for (City entry : northeastCities) {
			System.out.println(entry.getName());
		}
		System.out.println();
		System.out.println();

		JFrame cityFrame = new JFrame("All Cities Screen");
		cityFrame.setSize(WIDTH, HEIGHT);
		cityFrame.setLayout(null);
		cityFrame.getContentPane().setBackground(Color.WHITE);

		JPanel cityPanel = new JPanel();
		cityPanel.setBounds(MAX_SPACE / 8, MAX_SPACE, WIDTH - MAX_SPACE / 3, HEIGHT);
		cityPanel.add(alphabetizedList());
		cityPanel.setVisible(true);
		cityPanel.setBackground(Color.WHITE);

		cityFrame.add(cityPanel);

		JButton back = new JButton("Back");
		back.setBounds(700, 20, 75, 20);
		cityFrame.add(back);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cityFrame.dispose();
			}
		});

		JButton region = new JButton("Sort by Region");
		region.setBounds(400, 20, 125, 20);
		cityFrame.add(region);
		region.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cityPanel.removeAll();
				cityPanel.add(regionGroup());
				cityFrame.revalidate();
				cityFrame.repaint();
			}
		});

		JButton alphabet = new JButton("Sort by Alphabetical");
		alphabet.setBounds(200, 20, 150, 20);
		cityFrame.add(alphabet);
		alphabet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cityPanel.removeAll();
				cityPanel.add(alphabetizedList());
				cityFrame.revalidate();
				cityFrame.repaint();
			}
		});
		cityFrame.revalidate();
		cityFrame.repaint();

		cityFrame.setLocationRelativeTo(null);
		cityFrame.setVisible(true);
		cityFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public JPanel alphabetizedList() {
		JPanel alphabetPanel = new JPanel();
		int gap = MAX_SPACE / (2 * this.allCitiesList.size() / ROWS);

		alphabetPanel.setLayout(new GridLayout(0, ROWS / 2, gap, 10));
		alphabetPanel.setBackground(Color.WHITE);

		for (int i = 0; i < allCitiesList.size(); i++) {
			JButton cityButton = new JButton(allCitiesList.get(i).getName(), allCitiesList.get(i).getSmallImage());

			cityButton.setHorizontalTextPosition(SwingConstants.RIGHT);
			cityButton.setVerticalTextPosition(SwingConstants.CENTER);
			cityButton.setBackground(new Color(245, 245, 245));

			try {
				cityButton.addActionListener(new RegionListener(cityButton.getText()));
			} catch (IOException e) {
				e.printStackTrace();
			}

			alphabetPanel.add(cityButton);

		}

		return alphabetPanel;
	}

	public JPanel regionGroup() {
		JPanel regionPanel = new JPanel();

		regionPanel.setLayout(new GridLayout(ROWS, maxSize + 1, 10, 10));
		regionPanel.setBackground(Color.WHITE);

		JLabel northLabel = new JLabel("North");
		JLabel southLabel = new JLabel("South");
		JLabel eastLabel = new JLabel("East");
		JLabel westLabel = new JLabel("West");
		JLabel centralLabel = new JLabel("Central");
		JLabel northeastLabel = new JLabel("Northeast");
		JLabel blank = new JLabel();

		// loading region buttons one region at a time

		northLabel.setFont(new Font(northLabel.getText(), Font.BOLD, 20));
		regionPanel.add(northLabel);
		for (int i = 0; i < this.northCities.size(); i++) {
			JButton cityButton = new JButton(northCities.get(i).getName(), northCities.get(i).getSmallImage());
			cityButton.setHorizontalTextPosition(SwingConstants.RIGHT);
			cityButton.setVerticalTextPosition(SwingConstants.CENTER);
			cityButton.setBackground(new Color(245, 245, 245));

			try {
				cityButton.addActionListener(new RegionListener(cityButton.getText()));
			} catch (IOException e) {
				e.printStackTrace();
			}

			regionPanel.add(cityButton);
		}

		southLabel.setFont(new Font(southLabel.getText(), Font.BOLD, 20));
		regionPanel.add(southLabel);
		for (int i = 0; i < this.southCities.size(); i++) {
			JButton cityButton = new JButton(southCities.get(i).getName(), southCities.get(i).getSmallImage());
			cityButton.setHorizontalTextPosition(SwingConstants.RIGHT);
			cityButton.setVerticalTextPosition(SwingConstants.CENTER);
			cityButton.setBackground(new Color(245, 245, 245));

			try {
				cityButton.addActionListener(new RegionListener(cityButton.getText()));
			} catch (IOException e) {
				e.printStackTrace();
			}

			regionPanel.add(cityButton);
		}

		eastLabel.setFont(new Font(eastLabel.getText(), Font.BOLD, 20));
		regionPanel.add(eastLabel);
		for (int i = 0; i < this.eastCities.size(); i++) {
			JButton cityButton = new JButton(eastCities.get(i).getName(), eastCities.get(i).getSmallImage());
			cityButton.setHorizontalTextPosition(SwingConstants.RIGHT);
			cityButton.setVerticalTextPosition(SwingConstants.CENTER);
			cityButton.setBackground(new Color(245, 245, 245));

			try {
				cityButton.addActionListener(new RegionListener(cityButton.getText()));
			} catch (IOException e) {
				e.printStackTrace();
			}

			regionPanel.add(cityButton);
		}

		westLabel.setFont(new Font(westLabel.getText(), Font.BOLD, 20));
		regionPanel.add(westLabel);
		for (int i = 0; i < this.westCities.size(); i++) {
			JButton cityButton = new JButton(westCities.get(i).getName(), westCities.get(i).getSmallImage());
			cityButton.setHorizontalTextPosition(SwingConstants.RIGHT);
			cityButton.setVerticalTextPosition(SwingConstants.CENTER);
			cityButton.setBackground(new Color(245, 245, 245));

			try {
				cityButton.addActionListener(new RegionListener(cityButton.getText()));
			} catch (IOException e) {
				e.printStackTrace();
			}

			regionPanel.add(cityButton);
		}

		centralLabel.setFont(new Font(centralLabel.getText(), Font.BOLD, 20));
		regionPanel.add(centralLabel);
		for (int i = 0; i < this.centralCities.size(); i++) {
			JButton cityButton = new JButton(centralCities.get(i).getName(), centralCities.get(i).getSmallImage());
			cityButton.setHorizontalTextPosition(SwingConstants.RIGHT);
			cityButton.setVerticalTextPosition(SwingConstants.CENTER);
			cityButton.setBackground(new Color(245, 245, 245));

			try {
				cityButton.addActionListener(new RegionListener(cityButton.getText()));
			} catch (IOException e) {
				e.printStackTrace();
			}

			regionPanel.add(cityButton);
		}

		northeastLabel.setFont(new Font(northeastLabel.getText(), Font.BOLD, 20));
		regionPanel.add(northeastLabel);
		for (int i = 0; i < this.northeastCities.size(); i++) {
			JButton cityButton = new JButton(northeastCities.get(i).getName(), northeastCities.get(i).getSmallImage());
			cityButton.setHorizontalTextPosition(SwingConstants.RIGHT);
			cityButton.setVerticalTextPosition(SwingConstants.CENTER);
			cityButton.setBackground(new Color(245, 245, 245));

			try {
				cityButton.addActionListener(new RegionListener(cityButton.getText()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			regionPanel.add(cityButton);
		}
		return regionPanel;
	}

} // end SortCityViewer
