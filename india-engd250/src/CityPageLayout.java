import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public abstract class CityPageLayout{
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private ArrayList<String> cityInfo;
	private String cityName;
	
	public static final String plainStyleName = "PlainStyle";
	public static final String titleStyleName = "Title";
	public static final String headingStyleName = "HeadingStyle";
	public static final int INDENT = 50;
	 
	
	public CityPageLayout(String name, ArrayList<String> info) {

	this.cityInfo = info;
	this.cityName = name;
	
	StyleContext context = new StyleContext();
    StyledDocument document = new DefaultStyledDocument(context);
    Style defaultStyle = context.getStyle(StyleContext.DEFAULT_STYLE);
   
	createDocStyles(context);
	
	
	}
	
	
	
	public void addPlainInfo(StyledDocument document, Style style, String stuff) {
	    try {
	        document.insertString(document.getLength(), stuff + "\n", style);
	      } catch (BadLocationException badLocationException) {
	        System.err.println("Oops");
	      }
	}
	
		
	public void createDocStyles(StyleContext context) {
		Style defaultStyle = context.getStyle(StyleContext.DEFAULT_STYLE);
		    
	    Style titleStyle = context.addStyle(titleStyleName, defaultStyle);
	    StyleConstants.setAlignment(titleStyle, StyleConstants.ALIGN_LEFT);
	    StyleConstants.setFontSize(titleStyle, 20);
	    StyleConstants.setBold(titleStyle, true);
	    StyleConstants.setLeftIndent(titleStyle, INDENT);
	    StyleConstants.setSpaceAbove(titleStyle, 4);
	    StyleConstants.setSpaceBelow(titleStyle, 4);
		
	    Style headingStyle = context.addStyle(headingStyleName, defaultStyle);
	    StyleConstants.setAlignment(headingStyle, StyleConstants.ALIGN_LEFT);
	    StyleConstants.setFontSize(headingStyle, 18);
	    StyleConstants.setLeftIndent(headingStyle, INDENT);
	    StyleConstants.setFirstLineIndent(headingStyle, INDENT);
	    StyleConstants.setUnderline(headingStyle, true);
	    StyleConstants.setSpaceAbove(headingStyle, 4);
	    StyleConstants.setSpaceBelow(headingStyle, 4);
	  
	    Style plainStyle = context.addStyle(plainStyleName, defaultStyle);
	    StyleConstants.setAlignment(plainStyle, StyleConstants.ALIGN_LEFT);
	    StyleConstants.setFontSize(plainStyle, 14);
	    StyleConstants.setLeftIndent(plainStyle, INDENT);
	    StyleConstants.setRightIndent(plainStyle, INDENT);
	    StyleConstants.setFirstLineIndent(plainStyle, INDENT);

	    StyleConstants.setSpaceAbove(plainStyle, 4);
	    StyleConstants.setSpaceBelow(plainStyle, 4);
			
			
	}
	
	
	
	
}
