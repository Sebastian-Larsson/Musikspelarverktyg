/**
 * Create a Tree made out of Nodes. Every time a new artist is found it gets its own Tree and every song 
 * made by that artist will be added to that specific Tree.
 * @version 1.0
 * 
 * @author S. Larsson<br> A. Ebeling<br> M. Tijanic
 */
public class MakeTree {

	/**
	 * The start of the Tree.
	 */
	public Node root;
	int size = 0;

	/**
	 * Add a Node to the Tree. 
	 * @param name Name of the artist.
	 */
	public void addNode(Item name) {
		this.size++;
		Node newNode = new Node(name);
		if (root == null) {
			root = newNode;
		} 
		else {
			Node focusNode = root;
			Node parent;
			while (true) {
				parent = focusNode;
				if (name.songName.compareTo(focusNode.element.songName) == 0) {
					return;
				}

				else if (name.songName.compareTo(focusNode.element.songName) < 0) {
					focusNode = focusNode.leftChild;
					if (focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				} 
				else { 
					focusNode = focusNode.rightChild;
					if (focusNode == null) {
						parent.rightChild = newNode;
						return;
					}

				}

			}
		}
	}


	/**
	 * Remove everything in the Tree.
	 */
	public void makeEmpty() {
		root.leftChild = null;
		root.rightChild = null;
		root = null;
	}

	/**
	 * Iterate through the tree. S
	 * tarts at root and goes through the whole Tree.
	 * @param focusNode The Node currently in focus.
	 */
	public void iterator(Node focusNode) {

		if (focusNode != null) {
			iterator(focusNode.leftChild);
			System.out.println(focusNode.element);
			iterator(focusNode.rightChild);
		}
	}
	/**
	 * Get the size of the Tree (the number of Nodes).
	 * @return The Size.
	 */
	public int getSize() {
		return size;
	}
}
