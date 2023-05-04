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
	private ArrayList<City> allCities = new ArrayList<City>();
	private int[] regionSize = new int[6];
	
//	private HashMap<City,String> allCities = new HashMap<City,String>();
	
	
	/**
	 * ensures: new MapListener is created
	 * 
	 * @param cities the region's cities
	 */
	public MapListener2(ArrayList<City> cities, int[] sizes) {
		this.allCities = cities;
		this.regionSize = sizes;
	} 
	
	// MapListener
	
	/**
	 * ensures: the user input makes a new Page
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		SortCityViewer allCitiesPage = new SortCityViewer(this.allCities, regionSize);
	} // actionPerformed

} // end MapListener
