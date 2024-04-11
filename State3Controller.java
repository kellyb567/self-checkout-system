package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class State3Controller implements Initializable{
	
	// import methods from GlobalController as global
	GlobalController global = new GlobalController();
	
	
	@FXML private Text dateTime;
	@FXML private Button logoutButton;
	@FXML private AnchorPane anchorPane;
	@FXML private Button greenpep;
	@FXML private ListView<String> ListView;

	Stage stage;

	
	
	
	public void addFromButton(ActionEvent e) throws Exception {
	 /* must figure out how to get this to add text from button on screen3 to screen 2 list*/
		
		String ID = greenpep.getText();  // retrieving the text from the textbox
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
		
		global.switchToState2(e);
		
	}
	  
	
	

	
	public void logout(ActionEvent e){
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("You're about to logout!");
		alert.setContentText("Are you sure you want to leave?");
		
		if (alert.showAndWait().get() == ButtonType.OK) {
			stage = (Stage) anchorPane.getScene().getWindow();
			System.out.println("logged out");
			stage.close();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// start the animation timer so the date will be dynamically updated every second
		timer.start();
		
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
