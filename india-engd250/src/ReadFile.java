import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This code is modified from the example readfile code provided in class. 
 * It takes in button's name and reads the corresponding text file with info
 * 
 * Modified by @author altschmn
 */
public class ReadFile {
	
	private String slashCharacter = "/"; 

	public String fileID;
	public ArrayList<String> inputRows = new ArrayList<String>();
	public String outputInfo;

	// First create an object for this particular file, supplying its fileName and any subdirectory name before that.
	// Note that, unlike for WriteFile, the whole file name must be provided here.
	public ReadFile(String buttonName) {
		String file = "src/CityInfo/" + buttonName + ".txt";
		this.fileID = file;
		this.outputInfo = null;
	}
	
	// Call this after creating the object, to read all the file data into the public "inputRows".
	// The method removes blank lines but otherwise doesn't edit the data.
	public boolean readThisEntireFile() throws IOException {
		BufferedReader br = null;
		inputRows.clear();
		try {
			br = new BufferedReader(new FileReader(this.fileID));
//			System.out.println("DB: Reading file "+directoryName+"/"+fileName);
		} catch (FileNotFoundException e) {
			System.out.println("File "+ this.fileID + " does not exist.");
			System.exit(1); // file does not exist - we quit the program
		} 
		String st;
		while ((st = br.readLine()) != null) {
			if (st != "") { // takes out blank lines, in particular a blank last line
//				System.out.println(st);
				inputRows.add(st);
			}
		}
		br.close();
		return true;
	}
	
	/**
	 *  turns the information arraylist into one massive string
	 * @return one single gigantic string
	 */
	public String singleOutput() {
		String massiveString = String.join("\n", inputRows);
		
		return massiveString;
	}
	
	// Main is to show examples of using the code above.
//	public static void main(String[] args) throws IOException {
//		System.out.println("ReadFile tests:");
//
//		ReadFile myFile = new ReadFile("Agra");
//		System.out.println("Data in Agra:");
//		myFile.readThisEntireFile();
//		
//		System.out.print(myFile.singleOutput());
//		
//		
//		
////		for (String nextLine : myFile.inputRows) {
////			System.out.println(" "+nextLine);
////		}
//	
//		
////		ReadFile mySubFile = new ReadFile("subDirectory/TypeOfFileTestSubFile-1.txt");
////		System.out.println("Data in subDirectory/TypeOfFileTestSubFile-1.txt:");
////		mySubFile.readThisEntireFile();
////		for (String nextLine : mySubFile.inputRows) {
////			System.out.println(" "+nextLine);
////		}
//	}
//	
}
