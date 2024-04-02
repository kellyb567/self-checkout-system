package application;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import java.nio.*;

public class Database{
	static ArrayList<String> currentlyInCart = new ArrayList<String>();
	
	
	public static ArrayList<String> getCurrentlyInCart() {
		return currentlyInCart;
	}
	
	public static void updateCurrentlyInCart(String id) {
		currentlyInCart.add(id);
	}
	

	public static Hashtable<String, Object[]> generateDatabase() throws Exception {
		
		// first, create a hash table
		Hashtable<String, Object[]> database = new Hashtable<String, Object[]>();
		
		
		//second, populate the hashmap with values from groceryitem.txt 
		File file = new File("src\\application\\database.txt");
		
		Scanner scanner = new Scanner(file);
		
		while (scanner.hasNextLine()) {
			String nextLine = scanner.nextLine();
			String[] splitLine = nextLine.trim().split("\\s+");
			
			// the key for the hash which is the ID of the groceryitem
			String itemID = splitLine[2];
			
			// creating the value (a list) for the hash; made up of name of item and cost
			Object[] value = new Object[2];
			value[0] = splitLine[0]; // first value is the name of the groceryitem
			value[1] = splitLine[1]; // second value is the cost of the groceryitem
			
			// putting a key value into the hash table
			database.put(itemID, value);
		}
		
		/*Enumeration<String> keys = database.keys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			System.out.println("Key: " + key + ", Value: [" + database.get(key)[0] + ", " + database.get(key)[1] + "]");
		}
		*/
		
		scanner.close();
		return database;
		
	}
	
}
