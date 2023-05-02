import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

public class SortCity {
	
	
//	private static ArrayList<City> allCities;
	
	private static HashMap<City,String> allCities;
	
	public SortCity(HashMap<City,String> cities) {
		this.allCities = cities;
	}
	
	
	class alphabetical implements Comparator<City>{

		@Override
		public int compare(City o1, City o2) {
			// TODO Auto-generated method stub
			return o1.getName().compareTo(o2.getName());
		}
		
	}
	
	
	
	
	public ArrayList<City> sortEachRegion(HashMap<City,String> cities, String targetRegion) {
		ArrayList<City> sortedRegion = new ArrayList<City>();
		
		for(Entry<City, String> place: cities.entrySet()) {
			if(place.getValue().equals(targetRegion)) {
				sortedRegion.add(place.getKey());
			}
		}
		
		sortedRegion.sort(new alphabetical());
		
		return sortedRegion;
	}
	
	
	public ArrayList<City> sortAll(HashMap<City,String> cities) {
		ArrayList<City> sortedCities = new ArrayList<City>();
		
		for(Entry<City, String> place: cities.entrySet()) {
			sortedCities.add(place.getKey());
		}
		
		
		sortedCities.sort(new alphabetical());
		
		
		return sortedCities;
	}
	
	
	
	
	

}
