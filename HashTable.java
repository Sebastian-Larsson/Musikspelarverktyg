import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
		System.out.println("index: " + index);
		System.out.println(newItem);
		System.out.println("adress: " + forest[index]);
		while(forest[index] != null) {
			if(newItem.artist.equals(forest[index].root.element.artist)) {
				forest[index].addNode(newItem);
				System.out.println("Added item to tree");
				System.out.println();
				return;
			}
			else {
				if(index + stepDistance >= arraySize) {
					arraySize = arraySize*2;
					addHash(theForest,newItem);
				}
				else {
					index += stepDistance;
					System.out.println("S");
				}
			}
		}
		System.out.println("Made new tree");
		System.out.println();
		forest[index] = new MakeTree();
		forest[index].addNode(newItem);
	}


	public static void main(String[] args) {

		HashTable theFunc = new HashTable(14);
		/*
		MakeTree theTree = new MakeTree();
		Item itm = new Item("Rihanna","Stay","4:23","stay.mp3");

		theFunc.addHash(theFunc.theForest, itm);
		theTree.iterator(theTree.root);
		 */
		File file = new File("D:\\skola\\Algoritmer&data\\Musikspelarverktyg\\src\\songs.txt");
		Scanner reader = null;
		try {
			reader = new Scanner(file);
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(reader.hasNextLine()) {	
			theFunc.addHash(theFunc.theForest,new Item(reader.next(),reader.next(),reader.next(),reader.next()));
		}
		for(int i = 0;i < theFunc.arraySize;i++) {
			if(theFunc.theForest[i] != null) {
				theFunc.theForest[i].iterator(theFunc.theForest[i].root);
				System.out.println("Printed a tree");
				System.out.println();
			}
		}
	}

}