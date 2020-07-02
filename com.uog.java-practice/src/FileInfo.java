import java.io.File; //import the desire file.

public class FileInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f11 = new File("Usama's 1st file.txt");
		if(f11.exists()) {
			System.out.println("Usama's 1st file:"+f11.getName());
			System.out.println("Absolute path:"+f11.getAbsolutePath());
			System.out.println("Writeable:"+f11.canWrite());
			System.out.println("Readable:"+f11.canRead());
			System.out.println("File size in bytes:"+f11.length());
			
		} else {
			System.out.println("The Particular file is not found in the records!");
		}
	}
}
