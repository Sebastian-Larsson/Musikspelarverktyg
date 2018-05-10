import java.io.File;

public class MusikSpelarVerktyg {
	public static void main(String[] cmdLn) {
		readAllFiles();
	}
	
	public static void readAllFiles() {
		File folder = new File("D:\\skola\\Algoritmer&data\\Musikspelarverktyg\\src\\songLibrary");
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        System.out.println("File " + listOfFiles[i].getName());
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		    }
	}
}
