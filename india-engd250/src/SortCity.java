import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

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

		this.north = nCities;
		this.south = sCities;
		this.east = eCities;
		this.west = wCities;
		this.central = cCities;
		this.northeast = neCities;

		this.allCities.addAll(north);
		this.allCities.addAll(south);
		this.allCities.addAll(east);
		this.allCities.addAll(west);
		this.allCities.addAll(central);
		this.allCities.addAll(northeast);
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
		return this.north;
	}

	/**
	 * ensures: getter for southern cities
	 * 
	 * @return array list of southern cities
	 */
	public ArrayList<City> getSouth() {
		return this.south;
	} // getSouth

	/**
	 * ensures: getter for eastern cities
	 * 
	 * @return array list of eastern cities
	 */
	public ArrayList<City> getEast() {
		return this.east;
	} // getEast

	/**
	 * ensures: getter for western cities
	 * 
	 * @return array list of western cities
	 */
	public ArrayList<City> getWest() {
		return this.west;
	} // getWest

	/**
	 * ensures: getter for central cities
	 * 
	 * @return array list of central cities
	 */
	public ArrayList<City> getCentral() {
		return this.central;
	} // getCentral

	/**
	 * ensures: getter for northeastern cities
	 * 
	 * @return array list of northeastern cities
	 */
	public ArrayList<City> getNortheast() {
		return this.northeast;
	} // getNortheast

	/**
	 * ensures: getter for full list of cities
	 * 
	 * @return array list of all cities
	 */
	public ArrayList<City> getFullList() {
		return this.allCities;
	} // getFullList
} // end SortCity
