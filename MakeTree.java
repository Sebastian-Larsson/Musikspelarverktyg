import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MakeTree implements Comparable {

	Node root;

	public void addNode(int key, String name) {
		Node newNode = new Node(key, name);
		if (root == null) {

			root = newNode;

		} else {
			Node focusNode = root;
			Node parent;
			while (true) {
				parent = focusNode;
				if (key < focusNode.key) {
					focusNode = focusNode.leftChild;
					if (focusNode == null) {
						parent.leftChild = newNode;
						return; // All Done
					}
				} else { // If we get here put the node on the right

					focusNode = focusNode.rightChild;
					if (focusNode == null) {
						parent.rightChild = newNode;
						return; // All Done

					}

				}

			}
		}

	}


	public void makeEmpty() {
		root.leftChild = null;
		root.rightChild = null;
		root = null;
		max = null;

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
			String name = reader.next();		
			if(theTree.findWord(name) == null) {
				theTree.addWord(name);
			}
			else {
				theTree.findWord(name).count = theTree.findWord(name).count + 1;
			}
		}

		//theTree.makeEmpty();
		theTree.interator(theTree.root);
		System.out.println(theTree.getMaxFrek());

	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
