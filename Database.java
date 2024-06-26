package application;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.nio.*;

public class Database{
	// this is used so the items added to the cart can persist for the entire runtime of the application
	// this will be filled not with IDs, but the name of the item
	static ObservableList<String> currentlyInCart = FXCollections.observableArrayList();
	
	
	// the current running subtotal (total but without tax)
	static ObservableValue<Integer> curr_subtotal;
	
	// getters method
	public static ObservableList<String> getCurrentlyInCart() {
		return currentlyInCart;
	}
	
	public static ObservableValue<Integer> getCurrSubotal(){
		return curr_subtotal;
	}
	
	
	// setter methods
	public static void updateCurrentlyInCart(String nameOfItem) {
		currentlyInCart.add(nameOfItem);
	}
	
	public static void addToCurrSubtotal(int val) {
		return;
	}
	

	public static Hashtable<String, Object[]> generateDatabase() throws Exception {
		
		// first, create a hash table
		Hashtable<String, Object[]> database = new Hashtable<String, Object[]>();
		
		
		//second, populate the hashtable with values from groceryitem.txt 
		File file = new File("src\\application\\database.txt");
		
		Scanner scanner = new Scanner(file);
		
		while (scanner.hasNextLine()) {
			String nextLine = scanner.nextLine(); // get next line in database.txt
			String[] splitLine = nextLine.trim().split("\\s+"); // trim it so there aren't blank entries
			
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
