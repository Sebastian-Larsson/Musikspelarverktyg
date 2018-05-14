import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MusikSpelarVerktyg {
	public static HashTable theFunc = new HashTable(6);
	public static String findFile;
	public static int index = 0;
	public static String[] artistSongList;

	public static void main(String[] cmdLn) {

		readAllFiles();
		System.out.println(findSong("Hey_Brother"));
		findArtist("Drake");
		for(int i = 0;i < artistSongList.length;i++) {
			System.out.println(artistSongList[i]);
		}
	}

	public static String findSong(String song) {
		for(int i = 0; i < theFunc.arraySize; i++) {
			if(theFunc.theForest[i] != null) {
				songIterator(theFunc.theForest[i].root, song);
			}
		}
		return findFile;
	}

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

	public static void songIterator(Node focusNode, String song) {

		if (focusNode != null) {
			songIterator(focusNode.leftChild, song);
			if(song.equals(focusNode.element.songName)) {
				findFile = focusNode.element.fileName;
			}
			songIterator(focusNode.rightChild, song);
		}
	}

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
