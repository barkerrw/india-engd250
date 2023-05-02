import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 
 * @author barkerrw & altschmn <br>
 *         Purpose: New class to implement cities
 *
 */
public class City {
	// set instance variables
	private String cityName;
	private String cityImage;
	private static final int PIC_SIZE = 200;

	/**
	 * ensures: new City can be created
	 * 
	 * @param cityName  is the name of the City
	 * @param cityImage is the image of the City from source
	 */
	public City(String cityName, String cityImage) {
		this.cityName = cityName;
		this.cityImage = cityImage;
	} // City

	/**
	 * ensures: getter for cityName
	 * 
	 * @return cityName
	 */
	public String getName() {
		return cityName;
	} // getName

	/**
	 * ensures: getter for cityImage
	 * 
	 * @return cityImage
	 */
	public ImageIcon getImage() {
		return new ImageIcon(new ImageIcon(cityImage).getImage().getScaledInstance(PIC_SIZE, PIC_SIZE, Image.SCALE_DEFAULT));
	} // getImage
	
} // end City
