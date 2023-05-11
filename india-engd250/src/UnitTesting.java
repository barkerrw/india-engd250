import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class UnitTesting {
	//set instance variables
	private ArrayList<City> allCities = new ArrayList<City>();
	private ArrayList<City> northCities = new ArrayList<City>();
	private ArrayList<City> westCities = new ArrayList<City>();
	private ArrayList<City> southCities = new ArrayList<City>();
	private ArrayList<City> eastCities = new ArrayList<City>();
	private ArrayList<City> centralCities = new ArrayList<City>();
	private ArrayList<City> northeastCities = new ArrayList<City>();
	
	private SortCity cityTest;

	@Before
	public void setUp() throws Exception {
//		cityTest = new SortCity(, allCitiesList, allCitiesList, allCitiesList, allCitiesList, allCitiesList);
		
		allCities = cityTest.getFullList();
		northCities = cityTest.getNorth();
		southCities = cityTest.getSouth();
		eastCities = cityTest.getEast();
		westCities = cityTest.getWest();
		centralCities = cityTest.getCentral();
		northeastCities = cityTest.getNortheast();
	}
	
	@Test
	public void testNorth() {
		String list = northCities.toString();
		assertEquals("[Agra]", list);
	}
	
	@Test
	public void testSouth() {
		String list = southCities.toString();
		assertEquals("[Bengaluru]", list);
	}
	
	@Test
	public void testEast() {
		String list = eastCities.toString();
		assertEquals("[Kolkata]", list);
	}
	
	@Test
	public void testWest() {
		String list = westCities.toString();
		assertEquals("[Mumbai]", list);
	}
	
	@Test
	public void testCentral() {
		String list = centralCities.toString();
		assertEquals("[Indore]", list);
	}
	
	@Test
	public void testNortheast() {
		String list = northeastCities.toString();
		assertEquals("[Guwahati]", list);
	}
}
