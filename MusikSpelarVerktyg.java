import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * A tool for playing music. 
 * @version 1.0
 * 
 * @author S. Larsson<br> A. Ebeling<br> M. Tijanic
 */
public class MusikSpelarVerktyg {

	private static HashTable theFunc = new HashTable(60);
	private static String findFile;
	private static int index = 0;
	private static String[] artistSongList;

	/**
	 * The user inputs a song that the user wants to find. The filename is used to play the song.
	 * @param song The song for which the filename is desired.
	 * @return Returns the filename
	 */
	public static String findSong(String song) {
		for(int i = 0; i < theFunc.arraySize; i++) {
			if(theFunc.theForest[i] != null) {
				songIterator(theFunc.theForest[i].root, song);
			}
		}
		return findFile;
	}
	
	/**
	 * Find an artist that the user searches for. Uses hashCode to find it, when the artist hashCode matches the root 
	 * of a Tree the artist name is also compared to see if they match.
	 * @param artist Get all the songs this artist has stored in the Tree.
	 * @return A list with all of the songs that are in the artists Tree.
	 */
	public static String[] findArtist(String artist) {
		int pos = theFunc.hashCode(artist) % theFunc.arraySize ;
		artistSongList = new String[0];
		if(artist.equals(theFunc.theForest[pos].root.element.artist)) {
			artistSongList = new String[theFunc.theForest[pos].getSize()];
			storeInOrder(theFunc.theForest[pos].root);		
		}	
		return artistSongList;
	}

	private static void storeInOrder(Node root) {
		if(root == null)
			return;
		storeInOrder(root.leftChild);
		artistSongList[index++] = root.element.songName;
		storeInOrder(root.rightChild);

	}
	
	private static void songIterator(Node focusNode, String song) {

		if (focusNode != null) {
			songIterator(focusNode.leftChild, song);
			if(song.equals(focusNode.element.songName)) {
				findFile = focusNode.element.fileName;
				return;
			}
			songIterator(focusNode.rightChild, song);
		}
	}
	/**
	 * Read all files from a set directory to get the filename. The other information is stored in a text file. 
	 * Using the filename and information from the text file, Items are created and added to the correct Trees in 
	 * HashTable.
	 */
	public static void readAllFiles() {
		File file = new File("D:\\skola\\Algoritmer&data\\Musikspelarverktyg\\src\\songs.txt");
		File folder = new File("D:\\skola\\Algoritmer&data\\Musikspelarverktyg\\src\\songLibrary");
		Scanner reader = null;
		File[] listOfFiles = folder.listFiles();

		try {
			reader = new Scanner(file);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				if(reader.hasNextLine()) {	
					theFunc.addHash(theFunc.theForest,new Item(reader.next(),reader.next(),reader.next(),listOfFiles[i].getName()));
				}
			} 
			else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}
	}
}
