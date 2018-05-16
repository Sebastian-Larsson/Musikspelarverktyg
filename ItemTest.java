import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemTest {

	@Test 
	public void ItemSongTest() {
		String name = "Drake";
		String song = "One_Dance";
		String time = "04:32";
		String file = "Drake - One_Dance.wav";
		
		Item itm = new Item(name, song, time, file);
		
		assertEquals(song, itm.getSongName());
	}
	
	@Test 
	public void ItemFileTest() {
		String name = "Drake";
		String song = "One_Dance";
		String time = "04:32";
		String file = "Drake - One_Dance.wav";
		
		Item itm = new Item(name, song, time, file);
		
		assertEquals(file, itm.getFileName());
	}
}
