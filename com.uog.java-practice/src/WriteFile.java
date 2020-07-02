import java.io.FileWriter; //import the file class.
import java.io.IOException; // to handle the errors.

public class WriteFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileWriter myWriter = new FileWriter("Usama's 1st file.txt");
			myWriter.write("This is my Very First attempt to make files and also Write in files.");
			myWriter.close();
			System.out.println("Hurrah Successfully Wrote in my 1st ever file in JAVA.");
		} catch (IOException e) {
			System.out.println("An Unaccepted error has been occured!");
			e.printStackTrace();
		}

	}

}
