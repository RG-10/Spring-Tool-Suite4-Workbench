import java.io.File;
public class DeleteFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f11 = new File("Usama's 1st file.txt");
		if(f11.delete()) {
			System.out.println("Please Delete the file:"+f11.getName());
		} else {
			System.out.println("Failed to delete the file particularly");
		}
	}
}
