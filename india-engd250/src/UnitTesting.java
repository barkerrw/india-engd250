import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Comparator;
import org.junit.Before;
import org.junit.Test;

public class UnitTesting {
	// set instance variables
	private ArrayList<City> northCities = new ArrayList<City>();
	private ArrayList<City> westCities = new ArrayList<City>();
	private ArrayList<City> southCities = new ArrayList<City>();
	private ArrayList<City> eastCities = new ArrayList<City>();
	private ArrayList<City> centralCities = new ArrayList<City>();
	private ArrayList<City> northeastCities = new ArrayList<City>();

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
	 * ensures: array lists are created for each region to test
	 * 
	 * @throws Exception can catch errors
	 */
	@Before
	public void setUp() throws Exception {
		northCities.add(new City("Agra", "src/pictures/AgraFort.jpg"));
		westCities.add(new City("Mumbai", "src/pictures/MumbaiHarbor.jpg"));
		southCities.add(new City("Bengaluru", "src/pictures/BangalorePalace.jpg"));
		eastCities.add(new City("Kolkata", "src/pictures/Kolkata.jpg"));
		centralCities.add(new City("Indore", "src/pictures/IndoreRajwada.jpg"));
		northeastCities.add(new City("Guwahati", "src/pictures/KamakhyaTemple.jpeg"));

		northCities.add(new City("Delhi", "src/pictures/NewDelhi.jpg"));
		westCities.add(new City("Ahmedabad", "/src/pictures/BasirMosqueAhmedabad.jpg"));
		southCities.add(new City("Hyderabad", "/src/pictures/HyderabadCharminar.jpg"));
		eastCities.add(new City("Patna", "/src/pictures/PatnaGandhiMuseum.jpeg"));
		centralCities.add(new City("Nagpur", "/src/pictures/NagpurZeroMarker.jpg"));
		northeastCities.add(new City("Agartala", "src/pictures/AgartalaRavindraKanan.jpg"));
	}

	/**
	 * ensures: tests sortList & alphabetize methods to ensure cities can be ordered
	 * correctly
	 */
	@Test
	public void testNorth() {
		ArrayList<City> cityList = sortList(northCities);
		String list = new String();
		for (City city : cityList) {
			list = list + city.getName();
		} // for
		assertEquals("AgraDelhi", list);
	} // testNorth

	@Test
	public void testSouth() {
		ArrayList<City> cityList = sortList(southCities);
		String list = new String();
		for (City city : cityList) {
			list = list + city.getName();
		} // for
		assertEquals("BengaluruHyderabad", list);
	} // testSouth

	@Test
	public void testEast() {
		ArrayList<City> cityList = sortList(eastCities);
		String list = new String();
		for (City city : cityList) {
			list = list + city.getName();
		} // for
		assertEquals("KolkataPatna", list);
	} // testEast

	@Test
	public void testWest() {
		ArrayList<City> cityList = sortList(westCities);
		String list = new String();
		for (City city : cityList) {
			list = list + city.getName();
		} // for
		assertEquals("AhmedabadMumbai", list);
	} // testWest

	@Test
	public void testCentral() {
		ArrayList<City> cityList = sortList(centralCities);
		String list = new String();
		for (City city : cityList) {
			list = list + city.getName();
		} // for
		assertEquals("IndoreNagpur", list);
	} // testCentral

	@Test
	public void testNortheast() {
		ArrayList<City> cityList = sortList(northeastCities);
		String list = new String();
		for (City city : cityList) {
			list = list + city.getName();
		} // for
		assertEquals("AgartalaGuwahati", list);
	} // testNorthEast
} // end UnitTesting
