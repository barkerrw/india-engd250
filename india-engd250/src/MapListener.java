import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Class: MapListener
 * 
 * @author barkerrw & altschmn <br>
 *         Purpose: Used to track button inputs from user
 *
 */
public class MapListener implements ActionListener {
	private ArrayList<City> cities = new ArrayList<City>();

	/**
	 * ensures: new MapListener is created
	 * 
	 * @param cities the region's cities
	 */
	public MapListener(ArrayList<City> cities) {
		this.cities = cities;
	} // MapListener

	/**
	 * ensures: the user input makes a new Page
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		RegionViewer cityPage = new RegionViewer(this.cities);
	} // actionPerformed

} // end MapListener
