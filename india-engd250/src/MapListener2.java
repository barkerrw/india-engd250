import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author barkerrw & altschmn <br>
 * 		   Purpose: Used to track button inputs from user specifically for the all city button.
 *
 */
public class MapListener2 implements ActionListener {
//	private ArrayList<City> cities = new ArrayList<City>();
	private HashMap<City,String> allCities = new HashMap<City,String>();
	
	/**
	 * ensures: new MapListener is created
	 * 
	 * @param cities the region's cities
	 */
	public MapListener2(HashMap<City,String> cities) {
		this.allCities = cities;
	} // MapListener
	
	/**
	 * ensures: the user input makes a new Page
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		SortCityViewer allCitiesPage = new SortCityViewer(this.allCities);
	} // actionPerformed

} // end MapListener
