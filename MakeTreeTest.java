import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MakeTreeTest {

	@Test 
	public void AddNodeTest() {
		String name = "Drake";
		String song = "One_Dance";
		String time = "04:32";
		String file = "Drake - One_Dance.wav";
		
		Item itm = new Item(name, song, time, file);
		
		MakeTree tree = new MakeTree();
		tree.addNode(itm);
		
		assertEquals(itm, tree.root.element);
		assertEquals(null, tree.root.leftChild);
		assertEquals(null, tree.root.rightChild);
	}
}
