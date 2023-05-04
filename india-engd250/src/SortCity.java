import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

public class SortCity {
	
	private static HashMap<City,String> allCitiesMap;
	
	public SortCity(HashMap<City,String> cities) {
		this.allCitiesMap = cities;
	}
	
	
	private static ArrayList<City> north;
	private static ArrayList<City> south;
	private static ArrayList<City> east;
	private static ArrayList<City> west;
	private static ArrayList<City> central;
	private static ArrayList<City> northeast;
	private static ArrayList<City> allCities;
	
	
	public SortCity(ArrayList<City> fullCityList, int[] regionSize) {
		
		this.allCities = fullCityList;
		
		
		this.north = (ArrayList<City>) fullCityList.subList(0, regionSize[0]);
		this.south = (ArrayList<City>) fullCityList.subList(regionSize[0], regionSize[1]);
		this.east = (ArrayList<City>) fullCityList.subList(regionSize[1], regionSize[2]);
		this.west = (ArrayList<City>) fullCityList.subList(regionSize[2], regionSize[3]);
		this.central = (ArrayList<City>) fullCityList.subList(regionSize[3], regionSize[4]);
		this.northeast = (ArrayList<City>) fullCityList.subList(regionSize[4], regionSize[5]);
		
//		this.allCities.addAll(northCities);
//		this.allCities.addAll(southCities);
//		this.allCities.addAll(eastCities);
//		this.allCities.addAll(westCities);
//		this.allCities.addAll(centralCities);
//		this.allCities.addAll(northeastCities);

		
	}

	
	
	class alphabetical implements Comparator<City>{

		@Override
		public int compare(City o1, City o2) {
			// TODO Auto-generated method stub
			return o1.getName().compareTo(o2.getName());
		}
		
	}
	
	
	
	
//	public ArrayList<City> sortEachRegion(HashMap<City,String> cities, String targetRegion) {
//		ArrayList<City> sortedRegion = new ArrayList<City>();
//		
//		for(Entry<City, String> place: cities.entrySet()) {
//			if(place.getValue().equals(targetRegion)) {
//				sortedRegion.add(place.getKey());
//			}
//		}
//		
//		sortedRegion.sort(new alphabetical());
//		
//		return sortedRegion;
//	}
//	
//	
	public ArrayList<City> sortAll(HashMap<City,String> cities) {
		ArrayList<City> sortedCities = new ArrayList<City>();
		
		for(Entry<City, String> place: cities.entrySet()) {
			sortedCities.add(place.getKey());
		}
		
		
		sortedCities.sort(new alphabetical());
		
		
		return sortedCities;
	}
	
	
//	public ArrayList<City> sortAll(ArrayList<City> cities){
//		ArrayList<City> sortedCities = cities;
//		sortedCities.sort(new alphabetical());
//
//		return sortedCities;
//	}
	
	

}
