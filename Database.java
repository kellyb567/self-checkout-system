package application;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.nio.*;

public class Database{
	// this is used so the items added to the cart can persist for the entire runtime of the application
	// this will be filled not with IDs, but the name of the item
	private static ObservableList<String> currentlyInCart = FXCollections.observableArrayList();
	private static ArrayList<Integer> currentlyInCartID = new ArrayList<>();
	
	private static final DecimalFormat formatting  = new DecimalFormat("0.00");
	
	public static Double round(Double number) {
		double newNum = number.doubleValue();
		
		/*double scaledValue = newNum * 100;
		int roundedInt = (int) Math.round(scaledValue);
		double finalNum = (double) roundedInt / 100;
		*/
		
		double finalNum = Double.parseDouble(formatting.format(newNum));
		Double finalNumDouble = finalNum;
		return finalNumDouble;
	}
	
	// tax rate
	static Double taxRate = (Double) 0.08;
	
	
	// values set to update total(s) labels in state 2
	// first set in Main
	private static StringProperty curr_subtotal = new SimpleStringProperty();
	private static StringProperty curr_tax = new SimpleStringProperty();
	private static StringProperty curr_total = new SimpleStringProperty();
	
	
	// getter methods
	public static ObservableList<String> getCurrentlyInCart() {
		return currentlyInCart;
	}
	
	public static StringProperty getCurrSubtotal(){
		return curr_subtotal;
	}
	
	public static StringProperty getCurrTax(){
		return curr_tax;
	}
	
	public static StringProperty getCurrTotal(){
		return curr_total;
	}
	
	public static Double getTaxRate() {
		return taxRate;
	}
	
	
	public static Double stringPropertyToDouble(StringProperty value) {
		String tempString = value.get();
		Double tempFloat = Double.parseDouble(tempString);
		
		return tempFloat;
	}
	
	// setter methods
	public static void updateCurrentlyInCart(String nameOfItem) {
		currentlyInCart.add(nameOfItem);
	}
	
	public static void updateCurrentlyInCart(int id) {
		currentlyInCartID.add(id);
		
	}
	
	public static void setCurrSubtotal(String val) {
		curr_subtotal.setValue(val);
		// System.out.println("after set: " + stringPropertyToFloat(curr_tax));
	}
	
	public static void setCurrTax(String val) {
		curr_tax.setValue(val);
	}
	
	public static void setCurrTotal(String val) {
		curr_total.setValue(val);
	}
	
	
	// update methods
	public static void addToCurrSubtotal(Double val) {
		Double currSubtotal = stringPropertyToDouble(getCurrSubtotal());
		
		currSubtotal = round(currSubtotal+val);
		String newSubtotal = Double.toString(currSubtotal);
		
		setCurrSubtotal(newSubtotal);
	}
	
	public static void addToCurrTax(Double val) {
		Double currTax = stringPropertyToDouble(getCurrTax());
		
		currTax = round(currTax+val);
		String newTax = Double.toString(currTax);
		
		setCurrTax(newTax);
	}
	
	public static void addToCurrTotal(Double val) {
		Double currTotal = stringPropertyToDouble(getCurrTotal());
		
		currTotal = round(currTotal+val);
		String newTotal = Double.toString(currTotal);

		// curr_total.setValue(tempString);
		setCurrTotal(newTotal);
	}
	

	// database generation
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
