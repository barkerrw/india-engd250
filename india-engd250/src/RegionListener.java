import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * 
 * @author barkerrw & altschmn <br>
 *         Purpose: Used to track button inputs from user
 *
 */
public class RegionListener implements ActionListener {
	// set instance variables
	private String cityName;
	private ReadCityFile cityFile;

	/**
	 * ensures: a new RegionListener can be created
	 * 
	 * @param buttonName is the name of the button
	 * @throws IOException from ReadCityFile
	 */
	public RegionListener(String buttonName) throws IOException {
		this.cityName = buttonName;
		this.cityFile = new ReadCityFile(this.cityName);
		this.cityFile.readThisEntireFile();
	} // RegionListener

	/**
	 * ensures: a new CityViewer is made on click of button
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		CityViewer cityInfo = new CityViewer(this.cityName, this.cityFile.inputRows);
	} // actionPerformed
} // end RegionListener
