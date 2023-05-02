import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;


public class CityViewer extends CityPageLayout {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private ArrayList<String> cityInfo;
	private String cityName;
	

	public CityViewer(String name, ArrayList<String> info){
		super(name,info);
		
		this.cityInfo = info;
		this.cityName = name;
		
		JFrame cityFrame = new JFrame(this.cityName);
		cityFrame.setSize(WIDTH, HEIGHT);
//		cityFrame.setLayout(null);
//		
//		JPanel cityPanel = new JPanel();
//		cityPanel.setBounds(50, 50, 700, 500);
		

		
		JTextPane textPanel = new JTextPane();
		StyleContext context = new StyleContext();
	    StyledDocument document = new DefaultStyledDocument(context);
	    
//	    System.out.println(this.cityInfo.size());
	    
	    this.createDocStyles();
	    
	    /**
	     * the text file must have the following format or it WILL NOT format correctly on output:
	     * 
	     * Title
	     * (empty line)
	     * population
	     * primary language
	     * (empty line)
	     * Places of Interest 
	     * (empty line)
	     * Place name 1
	     * place info
	     * (empty line)
	     * place name 2
	     * place info 2
	     * (empty line)
	     * Food
	     * food info
	     */
	    this.addTitleInfo(document, cityInfo.get(0)); // title
	    
	    for (int i = 1; i < cityInfo.size(); i ++) { // generic info about the city
	    	if (cityInfo.get(i).equals("Places of Interest") || cityInfo.get(i).equals("Food")) {
	    		this.addHeadingInfo(document, cityInfo.get(i));
	    	}
	    	
//	    	else if (cityInfo.get(i).charAt(0) == '*'){
//	    		System.out.println(cityInfo.get(i));
////	    		this.addPicInfo(document, cityInfo.get(i));
//	    	}
	    	else {
	    		this.addPlainInfo(document, cityInfo.get(i));
	    	}
	    }
	    
//	    this.addPlainInfo(document, cityInfo.get(5)); // places of interest heading
//	    
//	    for (int i = 6; i < 13; i ++) { // generic info about the city
//	    	this.addPlainInfo(document, context.getStyle(plainStyleName), cityInfo.get(i));// places info
//	    }
//	    
//	    this.addPlainInfo(document, context.getStyle(headingStyleName), cityInfo.get(13)); // food heading
//	    this.addPlainInfo(document, context.getStyle(plainStyleName), cityInfo.get(14));
//	    
//	    
//	    this.addPlainInfo(document, context.getStyle(titleStyleName), cityInfo.get(0));
//	    this.addPlainInfo(document, context.getStyle(titleStyleName), cityInfo.get(0));
//	    this.addPlainInfo(document, context.getStyle(titleStyleName), cityInfo.get(0));
//	    this.addPlainInfo(document, context.getStyle(titleStyleName), cityInfo.get(0));
//
//	    

		
/**
 * the stuff below should be inherited from the city page layout class
 */

//	    Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
//	    StyleConstants.setAlignment(style, StyleConstants.ALIGN_LEFT);
//	    StyleConstants.setFontSize(style, 14);
//	    StyleConstants.setSpaceAbove(style, 4);
//	    StyleConstants.setSpaceBelow(style, 4);
//		
//	    for (int i = 0; i < this.cityInfo.size(); i ++) {
//		    try {
//		        document.insertString(document.getLength(), this.cityInfo.get(i) + "\n", style);
//		      } catch (BadLocationException badLocationException) {
//		        System.err.println("Oops");
//		      }
//		
//	    }
//		
//		
	    JButton back = new JButton("Back");
		back.setBounds(700, 20, 75, 20);
		cityFrame.add(back);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cityFrame.dispose();
			}	
		});
		
	    JTextPane textPane = new JTextPane(document);
	    textPane.setEditable(false);
	    JScrollPane scrollPane = new JScrollPane(textPane);
//	    content.add(scrollPane, BorderLayout.CENTER);

		
//		cityPanel.add(scrollPane, BorderLayout.CENTER);
		
	    cityFrame.add(scrollPane, BorderLayout.CENTER);
//		cityFrame.add(cityPanel);
		cityFrame.repaint();
		
		cityFrame.setLocationRelativeTo(null);
		cityFrame.setVisible(true);
		cityFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}
	
	
	
}
