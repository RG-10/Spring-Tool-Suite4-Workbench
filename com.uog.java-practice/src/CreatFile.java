import java.io.File;  //here we import the file.
import java.io.IOException; //here we import IOException for error handling.

public class CreatFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			File f11 = new File ("Usama's 1st file.txt");
			if (f11.createNewFile()) {
				System.out.println("File is Created successfully:"+f11.getName());
			}
			else {
				System.out.println("file is already exists.");
			}
			}
		catch(IOException e)
		{
			System.out.println("An error has been occured!");
			e.printStackTrace();
		}
		

	}

}



