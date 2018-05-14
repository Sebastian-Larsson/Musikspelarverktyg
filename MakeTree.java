public class MakeTree {

	Node root;
	int size = 0;

	public void addNode(Item name) {
		size++;
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

	public void makeEmpty() {
		root.leftChild = null;
		root.rightChild = null;
		root = null;
	}

	public void iterator(Node focusNode) {

		if (focusNode != null) {
			iterator(focusNode.leftChild);
			System.out.println(focusNode.element);
			iterator(focusNode.rightChild);
		}
	}
	
	public int getSize() {
		return size;
	}
}
