package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class State4Controller implements Initializable{
	
	// import methods from GlobalController as global
	GlobalController global = new GlobalController();
	
	
	@FXML private Text dateTime;
	@FXML private Button logoutButton;
	@FXML private AnchorPane anchorPane;
	
	@FXML private TextField usernameField;
	@FXML private TextField passwordField;
	
	Stage stage;

	
	public void switchToState2(ActionEvent e) throws IOException{
		 global.switchToState2(e);
	}
		
	
	public void switchToState5(ActionEvent e) throws IOException{
		global.switchToState5(e);
		
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
	
	public void login(ActionEvent e) throws IOException {
		String username = usernameField.getText();
		String password = passwordField.getText();
		
		Boolean usernameIsFound = false;
		
		ArrayList<String> listOfUsernames = new ArrayList<String>();
		ArrayList<String> listOfPasswords = new ArrayList<String>();
		
		listOfUsernames.add("employee");
		listOfPasswords.add("password");
		
		for (int i = 0; i < listOfUsernames.size(); i++) {
			if ( username.equals(listOfUsernames.get(i)) && password.equals(listOfPasswords.get(i))){
				System.out.println("Successful Login");
				// do something; maybe return to the checkout list
				return;
			}
			else if (username.equals(listOfUsernames.get(i))){
				usernameIsFound = true;
			}
		}
		
		if (usernameIsFound) {
			System.out.println("Username found; wrong password entered");
		}
		else {
			System.out.println("Your credentials could not be found");
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
