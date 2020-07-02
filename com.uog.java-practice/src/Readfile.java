import java.io.File; // import the file.
import java.io.FileNotFoundException; // used for error handling.
import java.util.Scanner; //used to import the Scanner class to read the desire text.

public class Readfile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File f11 = new File("Usama's 1st file.txt");
			Scanner myReader = new Scanner(f11);
			
			while(myReader.hasNextLine())
			{
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		} catch(FileNotFoundException e) {
			System.out.println("An unexpected error has been occured! :(");
			e.printStackTrace();
		}
		

	}

}
