import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class SortCity {
	
//	private static HashMap<City,String> allCitiesMap;
//	
//	public SortCity(HashMap<City,String> cities) {
//		this.allCitiesMap = cities;
//	}
//	
	
	private ArrayList<City> north = new ArrayList<City>();
	private ArrayList<City> south = new ArrayList<City>();
	private ArrayList<City> east = new ArrayList<City>();
	private ArrayList<City> west = new ArrayList<City>();
	private ArrayList<City> central = new ArrayList<City>();
	private ArrayList<City> northeast = new ArrayList<City>();
	private ArrayList<City> allCities = new ArrayList<City>();
	
	
	public SortCity(ArrayList<City> nCities, ArrayList<City> sCities, ArrayList<City> eCities, ArrayList<City> wCities, ArrayList<City> cCities, ArrayList<City> neCities) {
		
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
		
		
//		this.allCities = fullCityList;
//		
//		for (int i = 0; i < allCities.size(); i ++) {
//			if(i < regionSize[0]) {
//				this.north.add(allCities.get(i));
//			}
//			else if (i >= regionSize[0] && i < regionSize[1]){
//				this.south.add(allCities.get(i));
//			}
//			else if (i >= regionSize[1] && i < regionSize[2]){
//				this.east.add(allCities.get(i));
//			}
//			else if (i >= regionSize[2] && i < regionSize[3]){
//				this.west.add(allCities.get(i));
//			}
//			else if (i >= regionSize[3] && i < regionSize[4]){
//				this.central.add(allCities.get(i));
//			}
//			else {
//				this.northeast.add(allCities.get(i));
//			}
//		}
//		
		
//		this.north =  fullCityList.subList(0, regionSize[0]);
//		this.south =  fullCityList.subList(regionSize[0], regionSize[1]);
//		this.east = fullCityList.subList(regionSize[1], regionSize[2]);
//		this.west = (ArrayList<City>) fullCityList.subList(regionSize[2], regionSize[3]);
//		this.central = (ArrayList<City>) fullCityList.subList(regionSize[3], regionSize[4]);
//		this.northeast = (ArrayList<City>) fullCityList.subList(regionSize[4], regionSize[5]);
		
		

		
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
	
	
	public ArrayList<City> sortList(ArrayList<City> cities){
		ArrayList<City> sortedCities = cities;
		sortedCities.sort(new alphabetical());

		return sortedCities;
	}
	
	public ArrayList<City> getNorth(){
		return this.north;
	}
	
	public ArrayList<City> getSouth(){
		return this.south;
	}
	
	public ArrayList<City> getEast(){
		return this.east;
	}
	
	public ArrayList<City> getWest(){
		return this.west;
	}
	
	public ArrayList<City> getCentral(){
		return this.central;
	}
	
	public ArrayList<City> getNortheast(){
		return this.northeast;
	}
	
	public ArrayList<City> getFullList(){
		return this.allCities;
	}
	
	
	
	
	
	
	

}
