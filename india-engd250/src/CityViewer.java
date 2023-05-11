import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;

/**
 * Class: CityViewer
 * 
 * @author barkerrw & altschmn <br>
 *         Purpose: Used to display city screen with imported text file
 *
 */
public class CityViewer extends CityPageLayout {
	// set instance variables
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private ArrayList<String> cityInfo;
	private String cityName;

	/**
	 * ensures: anew CityViewer can be created
	 * 
	 * @param name is the city name
	 * @param info is an arraylist of information from text file
	 */
	public CityViewer(String name, ArrayList<String> info) {
		super(name, info);
		this.cityInfo = info;
		this.cityName = name;

		// make frame for cities
		JFrame cityFrame = new JFrame(this.cityName);
		cityFrame.setSize(WIDTH, HEIGHT);

		// set font style
		StyleContext context = new StyleContext();
		StyledDocument document = new DefaultStyledDocument(context);
		this.createDocStyles();
		// title style from CityPageLayout
		this.addTitleInfo(document, cityInfo.get(0));

		for (int i = 1; i < cityInfo.size(); i++) { // generic info about the city
			if (cityInfo.get(i).equals("Places of Interest") || cityInfo.get(i).equals("Food")) {
				this.addHeadingInfo(document, cityInfo.get(i));
			} // if

			// adds images (not implemented)
//	    	else if (cityInfo.get(i).charAt(0) == '*'){
//	    		System.out.println(cityInfo.get(i));
////	    		this.addPicInfo(document, cityInfo.get(i));
//	    	}
			else {
				this.addPlainInfo(document, cityInfo.get(i));
			} // else
		} // end for

		// adds back button
		JButton back = new JButton("Back");
		back.setBounds(700, 20, 75, 20);
		cityFrame.add(back);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cityFrame.dispose();
			} // actionPerformed
		}); // ActionListener

		// create panes
		JTextPane textPane = new JTextPane(document);
		textPane.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textPane); // not used
//	    content.add(scrollPane, BorderLayout.CENTER);
//		cityPanel.add(scrollPane, BorderLayout.CENTER);

		// add panes to frame
		cityFrame.add(scrollPane, BorderLayout.CENTER);
//		cityFrame.add(cityPanel);
		cityFrame.repaint();

		cityFrame.setLocationRelativeTo(null);
		cityFrame.setVisible(true);
		cityFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	} // CityViewer
} // end CityViewer
