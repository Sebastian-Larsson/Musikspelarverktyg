import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NodeTest {

	@Test 
	public void NodeElementTest() {
		String name = "Drake";
		String song = "One_Dance";
		String time = "04:32";
		String file = "Drake - One_Dance.wav";

		Item itm = new Item(name, song, time, file);

		Node node = new Node(itm);
		assertEquals(itm, node.element);
	}

}
