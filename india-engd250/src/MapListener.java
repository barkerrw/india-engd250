import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * 
 * @author barkerrw & altschmn <br>
 * 		   Purpose: Used to track button inputs from user
 *
 */
public class MapListener implements ActionListener {
	ArrayList<City> cityInfo;
	
	/**
	 * ensures: new MapListener is created
	 * 
	 * @param cities the region's cities
	 */
	public MapListener(ArrayList<City> cities) {
		this.cityInfo = cities;
	} // MapListener
	
	/**
	 * ensures: the user input makes a new Page
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(cityInfo);
		
	} // actionPerformed

} // end MapListener
