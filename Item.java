/**
 * Creates an item containing a song name, an artist, a filename and the duration 
 * of the song. 
 * @version 1.0
 * 
 * @author S. Larsson<br> A. Ebeling<br> M. Tijanic
 */

public class Item implements Comparable <Item>{
	/**
	 * Name of song.
	 */
	public String songName;
	/**
	 * Name of artist.
	 */
	public String artist;
	/**
	 * Name of file.
	 */
	public String fileName;
	/**
	 * Duration of song.
	 */
	public String songDuration;

	/** 
	 * Class constructor.
	 * @param theArtist The artist who created the song.
	 * @param theSongName The song which is to be added to the Item.
	 * @param theSongDuration The duration of the song.
	 * @param theFileName The filename of the song.
	 * 
	 * @version 1.0
	 * @author S. Larsson<br> A. Ebeling<br> M. Tijanic
	 */
	public Item(String theArtist, String theSongName, String theSongDuration, String theFileName) {
		songName = theSongName;
		artist = theArtist;
		songDuration = theSongDuration;
		fileName = theFileName;
	}

	/** 
	 * Get the song name.
	 * @return Item name.
	 */
	public String getSongName() {
		return songName;
	}
	/** 
	 * Get the filename.
	 * @return Filename.
	 */
	public String getFileName() {
		return fileName;
	}

	/** 
	 * Compare song name, here Comparable is implemented.
	 * @see <a href = https://docs.oracle.com/javase/7/docs/api/java/lang/Comparable.html>Comparable</a>
	 */
	public int compareTo( Item other)

	{
		return getSongName().compareTo(other.getSongName());
	}


	/** 
	 * Print as a string.
	 */
	public String toString() {
		return artist + " - "+ songName + "(" + songDuration + ")";
	}
}
