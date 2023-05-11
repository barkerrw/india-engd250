import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class: AllCitiesListener
 * 
 * @author barkerrw & altschmn <br>
 *         Purpose: Used to track button inputs from user specifically for the
 *         all city button.
 *
 */
public class AllCitiesListener implements ActionListener {
	private ArrayList<City> north = new ArrayList<City>();
	private ArrayList<City> south = new ArrayList<City>();
	private ArrayList<City> east = new ArrayList<City>();
	private ArrayList<City> west = new ArrayList<City>();
	private ArrayList<City> central = new ArrayList<City>();
	private ArrayList<City> northeast = new ArrayList<City>();
	private ArrayList<City> allCities = new ArrayList<City>();

	/**
	 * ensures: a new AllCitiesListener can be created
	 * 
	 * @param cities the region's cities
	 */
	public AllCitiesListener(ArrayList<City> nCities, ArrayList<City> sCities, ArrayList<City> eCities,
			ArrayList<City> wCities, ArrayList<City> cCities, ArrayList<City> neCities) {
		this.north = nCities;
		this.south = sCities;
		this.east = eCities;
		this.west = wCities;
		this.central = cCities;
		this.northeast = neCities;

	}// AllCitiesListener

	/**
	 * ensures: the user input makes a new Page
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		SortCityViewer allCitiesPage = new SortCityViewer(north, south, east, west, central, northeast);
	} // actionPerformed

} // end AllCitiesListener
