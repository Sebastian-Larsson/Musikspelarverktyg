public class HashTable {

	MakeTree[] theForest;
	int arraySize;
	int itemsInArray = 0;

	public HashTable(int size) {
		arraySize = size;
		theForest = new MakeTree[size];
	}

	public int hashCode(String input) {
		int h = 0;
		for(int i = 0; i < input.length()-1;i++) {
			int n = input.charAt(i);
			h += (int)Math.pow((n*7), input.length()-1-i);
		}
		h = Math.abs(h);
		return h;
	}

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