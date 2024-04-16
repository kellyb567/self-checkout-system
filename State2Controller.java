package application;


import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class State2Controller implements Initializable{

	// import methods from GlobalController as global
	GlobalController global = new GlobalController();
	
	@FXML 
	private Text dateTime;
	@FXML 
	private ListView<String> ListView;
	@FXML
	private TextField searchbox;
	@FXML
	private Text subtotalLabel;
	
	
	public void switchToState1(ActionEvent e) throws IOException{
		global.switchToState1(e);
		
	}
	
	public void switchToState5(ActionEvent e) throws IOException{
		global.switchToState5(e);
		
	}
	
	public void switchToState3(ActionEvent e) throws IOException{
		global.switchToState3(e);
		
	}
	
	public void addFromSearch(ActionEvent e) throws Exception {
		String ID = searchbox.getText();  // retrieving the text from the textbox
		Hashtable<String, Object[]> database = Database.generateDatabase(); // instantiating the database
		ObservableList<String> currentlyInCart = Database.getCurrentlyInCart(); // locally updating what's already in the cart
		
		Enumeration<String> keys = database.keys(); // getting a list of the database keys (all of the IDS)
		
		// looping over all of the keys
		while (keys.hasMoreElements()) {
			String key = keys.nextElement(); // current key
			if (key.equals(ID)) { 	  // if the entered in textbox is a hit with one from the database
				
				// add the name of the groceryitem into the ListView
				String nameOfGrocery =  (String) (database.get(key)[0]);
				Database.updateCurrentlyInCart(nameOfGrocery);
				ListView.setItems(currentlyInCart);
				System.out.println("item found");			}
	    }
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// start the animation timer so the date will be dynamically updated every second
		timer.start();
		
		ObservableList<String> currentlyInCart = Database.getCurrentlyInCart();
		ListView.setItems(currentlyInCart);
		
		
	    // detects which item in the ListView is being selected
		ListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				// TODO Auto-generated method stub
			
				// put the selected item on the table into a string for later uses
				String selectedItem = ListView.getSelectionModel().getSelectedItem();
			}
		});	
		}
		
	
	// create an animation object
		AnimationTimer timer = new AnimationTimer() {
			@Override
		    public void handle(long now) {
				// set the dateTime Text to the current time with custom formatting
		        dateTime.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM-dd-yyyy HH:mm:ss")));
		    }
		};
}
