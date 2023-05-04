import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author barkerrw & altschmn <br>
 *         Purpose: to take information from text files
 *
 */
public class ReadCityFile {
	public String fileID;
	public ArrayList<String> inputRows = new ArrayList<String>();
	public String outputInfo;

	/**
	 * ensures: the file name is found from package explorer
	 * 
	 * @param buttonName shares the name of the file
	 */
	public ReadCityFile(String buttonName) {
		String file = "src/CityInfo/" + buttonName + ".txt";
		this.fileID = file;
		this.outputInfo = null;
	} // ReadCityFile

	/**
	 * ensures: file information is imported into inputRow
	 * 
	 * @return true if reader is done
	 * @throws IOException throws exception if file is not found
	 */
	public boolean readThisEntireFile() throws IOException {
		// make sure reader is empty before importing information
		BufferedReader br = null;
		inputRows.clear();
		try { // if file is not found with reader
			br = new BufferedReader(new FileReader(this.fileID));
		} catch (FileNotFoundException e) { // throw error statement
			System.out.println("File " + this.fileID + " does not exist.");
		} // catch

		String st; // is the current line
		while ((st = br.readLine()) != null) {
			if (st != "") { // takes out blank lines
				inputRows.add(st);
			} // if
		} // while
		br.close();
		return true; // when file reader is done porting file into inputRows
	} // readThisEntireFile
} // end ReadCityFile