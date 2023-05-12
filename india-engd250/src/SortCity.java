import java.util.ArrayList;
import java.util.Comparator;

/**
 * Class: SortCity
 * 
 * @author barkerrw & altschmn <br>
 *         Purpose: Used to sort cities alphabetically and by region
 *
 */
public class SortCity {
	// set instance variables
	private ArrayList<City> north = new ArrayList<City>();
	private ArrayList<City> south = new ArrayList<City>();
	private ArrayList<City> east = new ArrayList<City>();
	private ArrayList<City> west = new ArrayList<City>();
	private ArrayList<City> central = new ArrayList<City>();
	private ArrayList<City> northeast = new ArrayList<City>();
	private ArrayList<City> allCities = new ArrayList<City>();

	/**
	 * ensures: Cities are placed in new array lists
	 * 
	 * @param nCities  contains north cities
	 * @param sCities  contains south cities
	 * @param eCities  contains east cities
	 * @param wCities  contains west cities
	 * @param cCities  contains central cities
	 * @param neCities contains northeast cities
	 */
	public SortCity(ArrayList<City> nCities, ArrayList<City> sCities, ArrayList<City> eCities, ArrayList<City> wCities,
			ArrayList<City> cCities, ArrayList<City> neCities) {

		north = nCities;
		south = sCities;
		east = eCities;
		west = wCities;
		central = cCities;
		northeast = neCities;

		allCities.addAll(north);
		allCities.addAll(south);
		allCities.addAll(east);
		allCities.addAll(west);
		allCities.addAll(central);
		allCities.addAll(northeast);
	} // end SortCity

	/**
	 * Class: Alphabetize
	 * 
	 * @author barkerrw & altschmn <br>
	 *         Purpose: Used to alphabetize cities with a comparator
	 *
	 */
	class Alphabetize implements Comparator<City> {

		@Override
		public int compare(City o1, City o2) {
			return o1.getName().compareTo(o2.getName());
		} // compare
	} // Alphabetize

	/**
	 * ensures: Used to make the list of sorted cities
	 * 
	 * @param cities is an array list of cities
	 * @return the array list of cities in alphabetical order
	 */
	public ArrayList<City> sortList(ArrayList<City> cities) {
		ArrayList<City> sortedCities = cities;
		sortedCities.sort(new Alphabetize());

		return sortedCities;
	} // sortList

	/**
	 * ensures: getter for northern cities
	 * 
	 * @return array list of northern cities
	 */
	public ArrayList<City> getNorth() {
		return north;
	}

	/**
	 * ensures: getter for southern cities
	 * 
	 * @return array list of southern cities
	 */
	public ArrayList<City> getSouth() {
		return south;
	} // getSouth

	/**
	 * ensures: getter for eastern cities
	 * 
	 * @return array list of eastern cities
	 */
	public ArrayList<City> getEast() {
		return east;
	} // getEast

	/**
	 * ensures: getter for western cities
	 * 
	 * @return array list of western cities
	 */
	public ArrayList<City> getWest() {
		return west;
	} // getWest

	/**
	 * ensures: getter for central cities
	 * 
	 * @return array list of central cities
	 */
	public ArrayList<City> getCentral() {
		return central;
	} // getCentral

	/**
	 * ensures: getter for northeastern cities
	 * 
	 * @return array list of northeastern cities
	 */
	public ArrayList<City> getNortheast() {
		return northeast;
	} // getNortheast

	/**
	 * ensures: getter for full list of cities
	 * 
	 * @return array list of all cities
	 */
	public ArrayList<City> getFullList() {
		return allCities;
	} // getFullList
} // end SortCity
