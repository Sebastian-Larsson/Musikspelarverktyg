import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MakeTree implements Comparable {

	Node root;

	public void addNode(Item name) {
		Node newNode = new Node(name);
		if (root == null) {
			root = newNode;
		} 
		else {
			Node focusNode = root;
			Node parent;
			while (true) {
				parent = focusNode;
				if (name.songName.compareTo(focusNode.element.songName) < 0) {

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
			System.out.println(focusNode);
			iterator(focusNode.rightChild);
		}
	}

	public static void main(String[] args) {

		MakeTree theTree = new MakeTree();

		File file = new File("D:\\skola\\Algoritmer & data\\Uppgift5_SebastianLarsson\\src\\words.txt");
		Scanner reader = null;
		try {
			reader = new Scanner(file);
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(reader.hasNext()) {	
				theTree.addNode(new Item(reader.next(),reader.next(),reader.next(),reader.next()));
			}
		}

		//theTree.makeEmpty();
		theTree.iterator(theTree.root);
		System.out.println(theTree.getMaxFrek());

	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
