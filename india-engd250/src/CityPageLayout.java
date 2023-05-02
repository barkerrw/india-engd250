import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

/**
 * 
 * @author barkerrw & altschmn <br>
 *		   Purpose: Class for formatting text file output
 */
public abstract class CityPageLayout{
	// set instance variables
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private ArrayList<String> cityInfo;
	private String cityName;
	private StyleContext context;
	
	public static final String plainStyleName = "PlainStyle";
	public static final String titleStyleName = "Title";
	public static final String headingStyleName = "HeadingStyle";
	public static final int INDENT = 50;
	 
	/**
	 * ensures: new CityPageLayout can be made
	 * @param name is the name of the City
	 * @param info is 
	 */
	public CityPageLayout(String name, ArrayList<String> info) {

	this.cityInfo = info;
	this.cityName = name;
	
	this.context = new StyleContext();
    StyledDocument document = new DefaultStyledDocument(context);
    Style defaultStyle = context.getStyle(StyleContext.DEFAULT_STYLE);
   
	createDocStyles();
	
	
	}
	
	
	
	public void addPlainInfo(StyledDocument document, String stuff) {
	    try {
	        document.insertString(document.getLength(), stuff + "\n", this.context.getStyle(plainStyleName));
	      } catch (BadLocationException badLocationException) {
	        System.err.println("Oops");
	      }
	}
	
	public void addHeadingInfo(StyledDocument document, String stuff) {
	    try {
	        document.insertString(document.getLength(), stuff + "\n", this.context.getStyle(headingStyleName));
	      } catch (BadLocationException badLocationException) {
	        System.err.println("Oops");
	      }
	}	
	
	public void addTitleInfo(StyledDocument document, String stuff) {
	    try {
	        document.insertString(document.getLength(), stuff + "\n", this.context.getStyle(titleStyleName));
	      } catch (BadLocationException badLocationException) {
	        System.err.println("Oops");
	      }
	}
	
	public void addPicInfo(StyledDocument document, String stuff) {
		
		String picName = stuff.substring(1);
		
		String file = "src/pictures/" + picName + ".jpg";
		
		Style labelStyle = context.getStyle(StyleContext.DEFAULT_STYLE);

	    Icon icon = new ImageIcon(file);
	    JLabel label = new JLabel(icon);
	    StyleConstants.setComponent(labelStyle, label);
		
	    try {
	        document.insertString(document.getLength(), "Ignored", labelStyle);
	      } catch (BadLocationException badLocationException) {
	        System.err.println("Oops");
	      }
	}
	
	
	public void createDocStyles() {
		Style defaultStyle = this.context.getStyle(StyleContext.DEFAULT_STYLE);
		    
	    Style titleStyle = this.context.addStyle(titleStyleName, defaultStyle);
	    StyleConstants.setAlignment(titleStyle, StyleConstants.ALIGN_LEFT);
	    StyleConstants.setFontSize(titleStyle, 26);
	    StyleConstants.setBold(titleStyle, true);
	    StyleConstants.setUnderline(titleStyle, true);
	    StyleConstants.setLeftIndent(titleStyle, INDENT);
	    StyleConstants.setSpaceAbove(titleStyle, 4);
	    StyleConstants.setSpaceBelow(titleStyle, 4);
		
	    Style headingStyle = this.context.addStyle(headingStyleName, defaultStyle);
	    StyleConstants.setAlignment(headingStyle, StyleConstants.ALIGN_LEFT);
	    StyleConstants.setFontSize(headingStyle, 18);
	    StyleConstants.setLeftIndent(headingStyle, INDENT);
	    StyleConstants.setFirstLineIndent(headingStyle, INDENT);
	    StyleConstants.setUnderline(headingStyle, true);
	    StyleConstants.setSpaceAbove(headingStyle, 4);
	    StyleConstants.setSpaceBelow(headingStyle, 4);
	  
	    Style plainStyle = this.context.addStyle(plainStyleName, defaultStyle);
	    StyleConstants.setAlignment(plainStyle, StyleConstants.ALIGN_LEFT);
	    StyleConstants.setFontSize(plainStyle, 14);
	    StyleConstants.setLeftIndent(plainStyle, INDENT);
	    StyleConstants.setRightIndent(plainStyle, INDENT);
	    StyleConstants.setFirstLineIndent(plainStyle, INDENT);

	    StyleConstants.setSpaceAbove(plainStyle, 4);
	    StyleConstants.setSpaceBelow(plainStyle, 4);
			
			
	}
	
	
	
	
}
