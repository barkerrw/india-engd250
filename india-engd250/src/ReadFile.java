import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * This program shows how to read files a line at a time.  In this case, the whole file is read
 * at one time.  And it creates a table with the data in it.  The files all come from
 * a local (to this project) directory called "datafiles".
 * 
 * The "main" routine for this class has some examples at the end.
 */
public class ReadFile {
	
	private String slashCharacter = "/"; // May need to be "\" for Windows.

	public String directoryName = "datafiles";
	public String fileName;
	public ArrayList<String> inputRows = new ArrayList<String>();

	// First create an object for this particular file, supplying its fileName and any subdirectory name before that.
	// Note that, unlike for WriteFile, the whole file name must be provided here.
	public ReadFile(String fileID) {
		if (fileID.indexOf(slashCharacter) != -1) { //  No slash here, which would have said it has a subdirectory name first.  For Windows this may be a back-slash (\) instead.
			int locOfSlash = fileID.indexOf(slashCharacter);
			String subDirectory = fileID.substring(0, locOfSlash);
			fileID = fileID.substring(locOfSlash+1);
			directoryName += slashCharacter+subDirectory;
		}
		this.fileName = fileID;
	}
	
	// Call this after creating the object, to read all the file data into the public "inputRows".
	// The method removes blank lines but otherwise doesn't edit the data.
	public boolean readThisEntireFile() throws IOException {
		BufferedReader br = null;
		inputRows.clear();
		try {
			br = new BufferedReader(new FileReader(directoryName+"/"+fileName));
//			System.out.println("DB: Reading file "+directoryName+"/"+fileName);
		} catch (FileNotFoundException e) {
			System.out.println("File "+directoryName+"/"+fileName+" does not exist.");
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
	
	// Main is to show examples of using the code above.
	public static void main(String[] args) throws IOException {
		System.out.println("ReadFile tests:");

		ReadFile myFile = new ReadFile("TypeOfFileTestAppendFile-0.txt");
		System.out.println("Data in TypeOfFileTestAppendFile-0.txt:");
		myFile.readThisEntireFile();
		for (String nextLine : myFile.inputRows) {
			System.out.println(" "+nextLine);
		}
		
		ReadFile mySubFile = new ReadFile("subDirectory/TypeOfFileTestSubFile-1.txt");
		System.out.println("Data in subDirectory/TypeOfFileTestSubFile-1.txt:");
		mySubFile.readThisEntireFile();
		for (String nextLine : mySubFile.inputRows) {
			System.out.println(" "+nextLine);
		}
	}
	
}
