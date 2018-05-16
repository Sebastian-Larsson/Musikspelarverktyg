/**
 * Creates a HashTable which contains Trees. HashTables use hashCode to decide where in the table a Node belongs.
 * A hashTable is like an array, but new Trees aren't added linearly, instead hashCode is used to decide the position.
 * Therefore finding a specific Tree is very fast because no iterating is needed.
 * @version 1.0
 * 
 * @author S. Larsson<br> A. Ebeling<br> M. Tijanic
 */

public class HashTable {

	MakeTree[] theForest;
	int arraySize;
	int itemsInArray = 0;

	/**
	 * Class constructor.
	 * @param size How large the HashTable is.
	 */
	public HashTable(int size) {
		arraySize = size;
		theForest = new MakeTree[size];
	}
	/**
	 * Create a code for the input. This is used in addHash with the arraySize to decide the index at which an Item should 
	 * be added.
	 * @param input The artist who the hasCode should be created for.
	 * @return A hashCode for the input.
	 * @see addHash
	 */
	public int hashCode(String input) {
		int h = 0;
		for(int i = 0; i < input.length()-1;i++) {
			int n = input.charAt(i);
			h += (int)Math.pow((n*7), input.length()-1-i);
		}
		h = Math.abs(h);
		return h;
	}

	/**
	 * Add an Item to forest. Uses the artist name to find out which Tree it should be added to. If the artist 
	 * already exists the Item will be added to that Tree. If it doesn't exist a new Tree will be created for 
	 * that artist at a new index in the HashTable.
	 * @param forest the MakeTree array to which the Item should be added.
	 * @param newItem The Item that is added.
	 */
	public void addHash(MakeTree[] forest,Item newItem) {
		int index = hashCode(newItem.artist) % arraySize;
		int stepDistance = 3;
		while(forest[index] != null) {
			if(newItem.artist.equals(forest[index].root.element.artist)) {
				forest[index].addNode(newItem);
				return;
			}
			else {
				if(index + stepDistance >= arraySize) {
					arraySize = arraySize*2;
					addHash(theForest,newItem);
				}
				else {
					index += stepDistance;
				}
			}
		}
		forest[index] = new MakeTree();
		forest[index].addNode(newItem);
	}
}