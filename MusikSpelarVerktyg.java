import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MusikSpelarVerktyg {
	public static void main(String[] cmdLn) {

		readAllFiles();
	}



	public static void readAllFiles() {
		HashTable theFunc = new HashTable(6);
		File file = new File("D:\\skola\\Algoritmer&data\\Musikspelarverktyg\\src\\songs.txt");
		File folder = new File("D:\\skola\\Algoritmer&data\\Musikspelarverktyg\\src\\songLibrary");
		Scanner reader = null;
		File[] listOfFiles = folder.listFiles();

		try {
			reader = new Scanner(file);
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File " + listOfFiles[i].getName());
				if(reader.hasNextLine()) {	
					theFunc.addHash(theFunc.theForest,new Item(reader.next(),reader.next(),reader.next(),listOfFiles[i].getName()));
				}
			} 
			else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
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
