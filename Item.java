public class Item implements Comparable <Item>{
	public String songName;
	public String artist;
	public String fileName;
	public String songDuration;

	//constructor
	public Item(String theSongName, String theArtist, String theSongDuration, String theFileName) {
		songName = theSongName;
		artist = theArtist;
		songDuration = theSongDuration;
		fileName = theFileName;
	}

	//returns item name
	public String getSongName() {
		return songName;
	}
	
	public String getFileName() {
		return fileName;
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

		System.out.println(itm);    

	}   
}
