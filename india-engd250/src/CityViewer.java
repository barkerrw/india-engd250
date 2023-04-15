import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;


public class CityViewer {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private String cityInfo;
	private String cityName;
	
	public CityViewer(String name, String info) {
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

	    Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
	    StyleConstants.setAlignment(style, StyleConstants.ALIGN_LEFT);
	    StyleConstants.setFontSize(style, 14);
	    StyleConstants.setSpaceAbove(style, 4);
	    StyleConstants.setSpaceBelow(style, 4);
		
	    try {
	        document.insertString(document.getLength(), this.cityInfo, style);
	      } catch (BadLocationException badLocationException) {
	        System.err.println("Oops");
	      }
		
		
		
		
		
		
		
		
		
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
