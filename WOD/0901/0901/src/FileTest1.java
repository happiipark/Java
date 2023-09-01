import java.io.File;

public class FileTest1 {
	
	
	public static void main(String[] args) {
		File file1 = new File("C:\\happy\\Java_workspace\\0831\\news2.txt");
		File file2 = new File("C:\\happy","Java_workspace\\0831\\news2.txt");
		
		System.out.println(file1.getName());
		System.out.println(file1.getAbsolutePath());
		System.out.println(File.pathSeparator);
		System.out.println(File.pathSeparatorChar);
		System.out.println(File.separator);
		System.out.println(File.separatorChar);
	}
}
