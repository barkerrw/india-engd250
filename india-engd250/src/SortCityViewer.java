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
 *         Purpose: Used to display cities in All Cities Page
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

	/**
	 * ensures: Displays
	 * 
	 * @param nCities
	 * @param sCities
	 * @param eCities
	 * @param wCities
	 * @param cCities
	 * @param neCities
	 */
	public SortCityViewer(ArrayList<City> nCities, ArrayList<City> sCities, ArrayList<City> eCities,
			ArrayList<City> wCities, ArrayList<City> cCities, ArrayList<City> neCities) {

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

		// unit test to ensures cities are sorted alphabetically
		System.out.println("All Cities:  ");
		for (City entry : allCitiesList) {
			System.out.println(entry.getName());
		} // for

		System.out.println("\n\n By Region:  ");
		for (City entry : northCities) {
			System.out.println(entry.getName());
		} // for
		System.out.println();

		for (City entry : southCities) {
			System.out.println(entry.getName());
		} // for
		System.out.println();
		System.out.println();

		for (City entry : this.eastCities) {
			System.out.println(entry.getName());
		} // for
		System.out.println();
		System.out.println();

		for (City entry : westCities) {
			System.out.println(entry.getName());
		} // for
		System.out.println();
		System.out.println();

		for (City entry : centralCities) {
			System.out.println(entry.getName());
		} // for
		System.out.println();
		System.out.println();

		for (City entry : northeastCities) {
			System.out.println(entry.getName());
		} // for
		System.out.println();
		System.out.println();

		// make frame for new screen
		JFrame cityFrame = new JFrame("All Cities Screen");
		cityFrame.setSize(WIDTH, HEIGHT);
		cityFrame.setLayout(null);
		cityFrame.getContentPane().setBackground(Color.WHITE);

		// make panel on new frame
		JPanel cityPanel = new JPanel();
		cityPanel.setBounds(MAX_SPACE / 8, MAX_SPACE, WIDTH - MAX_SPACE / 3, HEIGHT);
		cityPanel.add(alphabetizedList());
		cityPanel.setVisible(true);
		cityPanel.setBackground(Color.WHITE);

		cityFrame.add(cityPanel);

		// implement back button from previous classes
		JButton back = new JButton("Back");
		back.setBounds(700, 20, 75, 20);
		cityFrame.add(back);
		back.addActionListener(new ActionListener() {
			// on click of back button, close frame
			@Override
			public void actionPerformed(ActionEvent e) {
				cityFrame.dispose();
			} // actionPerformed
		}); // ActionListener

		// make button to sort by region
		JButton region = new JButton("Sort by Region");
		region.setBounds(400, 20, 125, 20);
		cityFrame.add(region);
		region.addActionListener(new ActionListener() {
			// removes current buttons and replaces with buttons sorted by region
			@Override
			public void actionPerformed(ActionEvent e) {
				cityPanel.removeAll();
				cityPanel.add(regionGroup());
				cityFrame.revalidate();
				cityFrame.repaint();
			} // actionPerformed
		}); // ActionListener

		// make new button to sort alphabetically
		JButton alphabet = new JButton("Sort by Alphabetical");
		alphabet.setBounds(200, 20, 150, 20);
		cityFrame.add(alphabet);
		alphabet.addActionListener(new ActionListener() {
			// removes current buttons and replaces with buttons sorted alphabetically
			@Override
			public void actionPerformed(ActionEvent e) {
				cityPanel.removeAll();
				cityPanel.add(alphabetizedList());
				cityFrame.revalidate();
				cityFrame.repaint();
			} // actionPerformed
		}); // ActionListener

		cityFrame.revalidate();
		cityFrame.repaint();

		cityFrame.setLocationRelativeTo(null);
		cityFrame.setVisible(true);
		cityFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	} // SortCityViewer

	/**
	 * ensures: a new alphabetically sorted panel can be created
	 * 
	 * @return alphabetically sorted panel
	 */
	public JPanel alphabetizedList() {
		// make new panel for alphabetically sorted buttons
		JPanel alphabetPanel = new JPanel();
		int gap = MAX_SPACE / (2 * this.allCitiesList.size() / ROWS);

		alphabetPanel.setLayout(new GridLayout(0, ROWS / 2, gap, 10));
		alphabetPanel.setBackground(Color.WHITE);

		// iterates through all of the cities and adds to panel
		for (int i = 0; i < allCitiesList.size(); i++) {
			JButton cityButton = new JButton(allCitiesList.get(i).getName(), allCitiesList.get(i).getSmallImage());

			cityButton.setHorizontalTextPosition(SwingConstants.RIGHT);
			cityButton.setVerticalTextPosition(SwingConstants.CENTER);
			cityButton.setBackground(new Color(245, 245, 245));

			try { // check if city with that name exists
				cityButton.addActionListener(new RegionListener(cityButton.getText()));
			} catch (IOException e) { // throw error
				e.printStackTrace();
			} // catch

			alphabetPanel.add(cityButton);
		}

		return alphabetPanel;
	} // alphabetizedList

	/**
	 * ensures: a new panel sorted by region can be created
	 * 
	 * @return region sorted panel of buttons
	 */
	public JPanel regionGroup() {
		// make new panel for region sorted buttons
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

		// add north buttons with style
		northLabel.setFont(new Font(northLabel.getText(), Font.BOLD, 20));
		regionPanel.add(northLabel);
		for (int i = 0; i < this.northCities.size(); i++) {
			JButton cityButton = new JButton(northCities.get(i).getName(), northCities.get(i).getSmallImage());
			cityButton.setHorizontalTextPosition(SwingConstants.RIGHT);
			cityButton.setVerticalTextPosition(SwingConstants.CENTER);
			cityButton.setBackground(new Color(245, 245, 245));

			try { // check if city exists
				cityButton.addActionListener(new RegionListener(cityButton.getText()));
			} catch (IOException e) { // throw error
				e.printStackTrace();
			} // catch

			regionPanel.add(cityButton);
		} // for

		// add south buttons with style
		southLabel.setFont(new Font(southLabel.getText(), Font.BOLD, 20));
		regionPanel.add(southLabel);
		for (int i = 0; i < this.southCities.size(); i++) {
			JButton cityButton = new JButton(southCities.get(i).getName(), southCities.get(i).getSmallImage());
			cityButton.setHorizontalTextPosition(SwingConstants.RIGHT);
			cityButton.setVerticalTextPosition(SwingConstants.CENTER);
			cityButton.setBackground(new Color(245, 245, 245));

			try { // check if city exists
				cityButton.addActionListener(new RegionListener(cityButton.getText()));
			} catch (IOException e) { // throw error
				e.printStackTrace();
			} // catch

			regionPanel.add(cityButton);
		} // for

		// add east buttons with style
		eastLabel.setFont(new Font(eastLabel.getText(), Font.BOLD, 20));
		regionPanel.add(eastLabel);
		for (int i = 0; i < this.eastCities.size(); i++) {
			JButton cityButton = new JButton(eastCities.get(i).getName(), eastCities.get(i).getSmallImage());
			cityButton.setHorizontalTextPosition(SwingConstants.RIGHT);
			cityButton.setVerticalTextPosition(SwingConstants.CENTER);
			cityButton.setBackground(new Color(245, 245, 245));

			try { // check if city exists
				cityButton.addActionListener(new RegionListener(cityButton.getText()));
			} catch (IOException e) { // throw error
				e.printStackTrace();
			} // catch

			regionPanel.add(cityButton);
		} // for

		// add west buttons with style
		westLabel.setFont(new Font(westLabel.getText(), Font.BOLD, 20));
		regionPanel.add(westLabel);
		for (int i = 0; i < this.westCities.size(); i++) {
			JButton cityButton = new JButton(westCities.get(i).getName(), westCities.get(i).getSmallImage());
			cityButton.setHorizontalTextPosition(SwingConstants.RIGHT);
			cityButton.setVerticalTextPosition(SwingConstants.CENTER);
			cityButton.setBackground(new Color(245, 245, 245));

			try { // check if city exists
				cityButton.addActionListener(new RegionListener(cityButton.getText()));
			} catch (IOException e) { // throw error
				e.printStackTrace();
			} // catch

			regionPanel.add(cityButton);
		} // for

		// add central buttons with style
		centralLabel.setFont(new Font(centralLabel.getText(), Font.BOLD, 20));
		regionPanel.add(centralLabel);
		for (int i = 0; i < this.centralCities.size(); i++) {
			JButton cityButton = new JButton(centralCities.get(i).getName(), centralCities.get(i).getSmallImage());
			cityButton.setHorizontalTextPosition(SwingConstants.RIGHT);
			cityButton.setVerticalTextPosition(SwingConstants.CENTER);
			cityButton.setBackground(new Color(245, 245, 245));

			try { // check if city exists
				cityButton.addActionListener(new RegionListener(cityButton.getText()));
			} catch (IOException e) { // throw error
				e.printStackTrace();
			} // catch

			regionPanel.add(cityButton);
		} // for

		// add northeast buttons with style
		northeastLabel.setFont(new Font(northeastLabel.getText(), Font.BOLD, 20));
		regionPanel.add(northeastLabel);
		for (int i = 0; i < this.northeastCities.size(); i++) {
			JButton cityButton = new JButton(northeastCities.get(i).getName(), northeastCities.get(i).getSmallImage());
			cityButton.setHorizontalTextPosition(SwingConstants.RIGHT);
			cityButton.setVerticalTextPosition(SwingConstants.CENTER);
			cityButton.setBackground(new Color(245, 245, 245));

			try { // check if city exists
				cityButton.addActionListener(new RegionListener(cityButton.getText()));
			} catch (IOException e) { // throw error
				e.printStackTrace();
			} // catch
			regionPanel.add(cityButton);
		} // for

		return regionPanel; // region sorted panel
	} // regionGroup

} // end SortCityViewer
