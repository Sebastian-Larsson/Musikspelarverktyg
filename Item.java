import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;


public class Item implements Comparable <Item>{
	public String songName;
	public String artist;
	public String fileName;
	public String songDuration;

	//constructor
	public Item(String theSongName, String theArtist, String theFileName, String theSongDuration) {
		songName = theSongName;
		artist = theArtist;
		fileName = theFileName;
		songDuration = theSongDuration;
	}

	//returns item name
	public String getSongName() {
		return songName;
	}

	//compare names
	public int compareTo( Item other)

	{
		return getSongName().compareTo(other.getSongName());
	}


	//print out as string
	public String toString() {
		return artist + " - "+ songName + "(" + songDuration + ")";
	}

	public static void main (String [] arg)
	{
		Item itm= new Item ("One Dance" , "Drake", "drake.mp3", "3:15");

		System.out.println( itm);    

	}   
}
