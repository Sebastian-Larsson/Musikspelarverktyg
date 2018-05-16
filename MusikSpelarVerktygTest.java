import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MusikSpelarVerktygTest {

	@Test
	public void findSongTest() {

		String name = "Drake";
		String song = "One_Dance";
		String time = "04:40";
		String file = "Drake - One Dance.wav";

		Item itm = new Item(name, song, time, file);

		MusikSpelarVerktyg.theFunc.addHash(MusikSpelarVerktyg.theFunc.theForest, itm);
		String found;
		found = MusikSpelarVerktyg.findSong(song);
		
		assertEquals(file, found);
	}
	
	@Test
	public void findArtistTest() {

		String name = "Drake";
		String song = "One_Dance";
		String time = "04:40";
		String file = "Drake - One Dance.wav";

		Item itm = new Item(name, song, time, file);

		MusikSpelarVerktyg.theFunc.addHash(MusikSpelarVerktyg.theFunc.theForest, itm);
		String[] found2;
		found2 = MusikSpelarVerktyg.findArtist(name);
	
		assertEquals(song, found2[0]);
	}

}
