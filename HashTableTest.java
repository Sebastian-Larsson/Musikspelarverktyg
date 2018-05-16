import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HashTableTest {

	@Test 
	public void HashCodeTest() {
		String name = "Drake";
		
		HashTable table = new HashTable(6);
		
		int code = table.hashCode(name);
		
		assertEquals(1638852267, code);	
	}
	
	@Test 
	public void AddHashTest() {
		HashTable table = new HashTable(6);
		
		String name = "Drake";
		String song = "One Dance";
		String time = "04:40";
		String file = "Drake - One Dance.wav";
		
		Item itm = new Item(name, song, time, file);
		
		table.addHash(table.theForest, itm);
		
		assertEquals(3, table.hashCode(itm.artist) % table.arraySize);
		
	}

}
