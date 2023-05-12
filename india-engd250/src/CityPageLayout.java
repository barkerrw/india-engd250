import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

/**
 * Class: CityPageLayout
 * 
 * @author barkerrw & altschmn <br>
 *         Purpose: Class for formatting text file output
 */
public abstract class CityPageLayout {
	// set instance variables
	private ArrayList<String> cityInfo;
	private String cityName;
	private StyleContext context;

	public static final String plainStyleName = "PlainStyle";
	public static final String titleStyleName = "Title";
	public static final String headingStyleName = "HeadingStyle";
	public static final int INDENT = 50;

	/**
	 * ensures: new CityPageLayout can be made
	 * 
	 * @param name is the name of the City
	 * @param info is an array list of information from text file
	 */
	public CityPageLayout(String name, ArrayList<String> info) {
		this.cityName = name;
		this.cityInfo = info;

		// set font style on text file page
		this.context = new StyleContext();
		StyledDocument document = new DefaultStyledDocument(context);
		Style defaultStyle = context.getStyle(StyleContext.DEFAULT_STYLE);

		createDocStyles();
	} // CityPageLayout

	/**
	 * ensures: Paragraph information is added
	 * 
	 * @param document is the imported text file
	 * @param stuff    is the individual string going in
	 */
	public void addPlainInfo(StyledDocument document, String stuff) {
		try { // if there is not enough space to insert the string
			document.insertString(document.getLength(), stuff + "\n", this.context.getStyle(plainStyleName));
		} catch (BadLocationException badLocationException) { // throw the error "Oops"
			System.err.println("Oops");
		} // catch
	} // addPlainInfo

	/**
	 * ensures: Headings with special font can be added
	 * 
	 * @param document is the imported text file
	 * @param stuff    is the individual string going in
	 */
	public void addHeadingInfo(StyledDocument document, String stuff) {
		try { // if there is not enough space to insert the string
			document.insertString(document.getLength(), stuff + "\n", this.context.getStyle(headingStyleName));
		} catch (BadLocationException badLocationException) { // throw the error "Oops"
			System.err.println("Oops");
		} // catch
	} // addHeadingInfo

	/**
	 * ensures: Title with special font can be added
	 * 
	 * @param document is the imported text file
	 * @param stuff    is the individual string going in
	 */
	public void addTitleInfo(StyledDocument document, String stuff) {
		try { // if there is not enough space to insert the string
			document.insertString(document.getLength(), stuff + "\n", this.context.getStyle(titleStyleName));
		} catch (BadLocationException badLocationException) { // throw the error
			System.err.println("Oops");
		} // catch
	} // addTitleInfo

	/**
	 * ensures: Pictures can be implemented form text files (not yet implemented)
	 * 
	 * @param document is the imported text file
	 * @param stuff    is the name of the picture
	 */
	public void addPicInfo(StyledDocument document, String stuff) {
		String picName = stuff.substring(1);
		String file = "src/pictures/" + picName + ".jpg";
		Style labelStyle = context.getStyle(StyleContext.DEFAULT_STYLE);
		Icon icon = new ImageIcon(file);
		JLabel label = new JLabel(icon);
		StyleConstants.setComponent(labelStyle, label);

		try { // if there is not enough space to insert the string
			document.insertString(document.getLength(), "Ignored", labelStyle);
		} catch (BadLocationException badLocationException) { // throw the error
			System.err.println("Oops");
		} // catch
	} // addPicInfo

	/**
	 * ensures: Sets up all components of each font
	 */
	public void createDocStyles() {
		Style defaultStyle = this.context.getStyle(StyleContext.DEFAULT_STYLE);
		Style titleStyle = this.context.addStyle(titleStyleName, defaultStyle);
		// sets components of Title
		StyleConstants.setAlignment(titleStyle, StyleConstants.ALIGN_LEFT);
		StyleConstants.setFontSize(titleStyle, 26);
		StyleConstants.setBold(titleStyle, true);
		StyleConstants.setUnderline(titleStyle, true);
		StyleConstants.setLeftIndent(titleStyle, INDENT);
		StyleConstants.setSpaceAbove(titleStyle, 4);
		StyleConstants.setSpaceBelow(titleStyle, 4);
		// sets components of Headings
		Style headingStyle = this.context.addStyle(headingStyleName, defaultStyle);
		StyleConstants.setAlignment(headingStyle, StyleConstants.ALIGN_LEFT);
		StyleConstants.setFontSize(headingStyle, 18);
		StyleConstants.setLeftIndent(headingStyle, INDENT);
		StyleConstants.setFirstLineIndent(headingStyle, INDENT);
		StyleConstants.setUnderline(headingStyle, true);
		StyleConstants.setSpaceAbove(headingStyle, 4);
		StyleConstants.setSpaceBelow(headingStyle, 4);
		// sets components of bulk text
		Style plainStyle = this.context.addStyle(plainStyleName, defaultStyle);
		StyleConstants.setAlignment(plainStyle, StyleConstants.ALIGN_LEFT);
		StyleConstants.setFontSize(plainStyle, 14);
		StyleConstants.setLeftIndent(plainStyle, INDENT);
		StyleConstants.setRightIndent(plainStyle, INDENT);
		StyleConstants.setFirstLineIndent(plainStyle, INDENT);
		StyleConstants.setSpaceAbove(plainStyle, 4);
		StyleConstants.setSpaceBelow(plainStyle, 4);
	} // createDocStyles
}// end CityPageLayout
