import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegionListener implements ActionListener{

	private String cityName;
	private ReadCityFile cityFile;
	
	
	public RegionListener(String buttonName) throws IOException {
		this.cityName = buttonName;
		
		this.cityFile = new ReadCityFile(this.cityName);
		this.cityFile.readThisEntireFile();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub

//		System.out.println(this.cityName);
//		System.out.print(this.cityFile.singleOutput());
		
		CityViewer cityInfo = new CityViewer(this.cityName, this.cityFile.singleOutput());
		
	}

}
