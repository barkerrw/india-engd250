import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class UnitTesting {
	
	private ArrayList<City> north = new ArrayList<City>();
	private ArrayList<City> south = new ArrayList<City>();
	private ArrayList<City> east = new ArrayList<City>();
	private ArrayList<City> west = new ArrayList<City>();
	private ArrayList<City> central = new ArrayList<City>();
	private ArrayList<City> northeast = new ArrayList<City>();
	
	/*
	 * test goals:
	 *   - sort cities in one big list
	 *   - sort individual regions
	 *   - check that it actually reads files
	 */
	
	
	
	
	@Before
	public void setUp() {
		north.add(new City("Agra", "src/pictures/AgraFort.jpg"));
		west.add(new City("Mumbai", "src/pictures/MumbaiHarbor.jpg"));
		south.add(new City("Bengaluru", "src/pictures/BangalorePalace.jpg"));
		east.add(new City("Kolkata", "src/pictures/Kolkata.jpg"));
		central.add(new City("Indore", "src/pictures/IndoreRajwada.jpg"));
		northeast.add(new City("Guwahati", "src/pictures/KamakhyaTemple.jpeg"));

		north.add(new City("Mumbai", "src/pictures/MumbaiHarbor.jpg"));
		west.add(new City("Bengaluru", "src/pictures/BangalorePalace.jpg"));
		south.add(new City("Kolkata", "src/pictures/Kolkata.jpg"));
		east.add(new City("Indore", "src/pictures/IndoreRajwada.jpg"));
		central.add(new City("Guwahati", "src/pictures/KamakhyaTemple.jpeg"));
		northeast.add(new City("Agra", "src/pictures/AgraFort.jpg"));

		north.add(new City("Bengaluru", "src/pictures/BangalorePalace.jpg"));
		west.add(new City("Kolkata", "src/pictures/Kolkata.jpg"));
		south.add(new City("Indore", "src/pictures/IndoreRajwada.jpg"));
		east.add(new City("Guwahati", "src/pictures/KamakhyaTemple.jpeg"));
		central.add(new City("Agra", "src/pictures/AgraFort.jpg"));
		northeast.add(new City("Mumbai", "src/pictures/MumbaiHarbor.jpg"));

	}
		
		
	
	private ArrayList<City> makeTestAllCitiesSorted(){
		ArrayList<City> testList = new ArrayList<City>();
		
		testList.add(new City("Agra", "src/pictures/AgraFort.jpg"));
		testList.add(new City("Agra", "src/pictures/AgraFort.jpg"));
		testList.add(new City("Agra", "src/pictures/AgraFort.jpg"));
		
		testList.add(new City("Bengaluru", "src/pictures/BangalorePalace.jpg"));
		testList.add(new City("Bengaluru", "src/pictures/BangalorePalace.jpg"));
		testList.add(new City("Bengaluru", "src/pictures/BangalorePalace.jpg"));
		
		testList.add(new City("Guwahati", "src/pictures/KamakhyaTemple.jpeg"));
		testList.add(new City("Guwahati", "src/pictures/KamakhyaTemple.jpeg"));
		testList.add(new City("Guwahati", "src/pictures/KamakhyaTemple.jpeg"));

		testList.add(new City("Indore", "src/pictures/IndoreRajwada.jpg"));
		testList.add(new City("Indore", "src/pictures/IndoreRajwada.jpg"));
		testList.add(new City("Indore", "src/pictures/IndoreRajwada.jpg"));
				
		testList.add(new City("Kolkata", "src/pictures/Kolkata.jpg"));
		testList.add(new City("Kolkata", "src/pictures/Kolkata.jpg"));
		testList.add(new City("Kolkata", "src/pictures/Kolkata.jpg"));
		
		testList.add(new City("Mumbai", "src/pictures/MumbaiHarbor.jpg"));
		testList.add(new City("Mumbai", "src/pictures/MumbaiHarbor.jpg"));
		testList.add(new City("Mumbai", "src/pictures/MumbaiHarbor.jpg"));
		
		return testList;
		
	}
	
	
	
	
	
	
	
	
	

//	@Test
//	public void testReadCityFile() {
//		String[] 
//		fail("Not yet implemented");
//	}

}
