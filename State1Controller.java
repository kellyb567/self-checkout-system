package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class State1Controller implements Initializable{
	
	// import methods from GlobalController as global
	GlobalController global = new GlobalController();
	
	
	@FXML private Text dateTime;
	@FXML private Button logoutButton;
	@FXML private AnchorPane anchorPane;
	Stage stage;

	
	public void switchToState2(ActionEvent e) throws IOException{
		 global.switchToState2(e);
	}
		
	
	public void switchToState5(ActionEvent e) throws IOException{
		global.switchToState5(e);
		
	}
	
	public void logout(ActionEvent e) throws IOException{
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
		timer.start();
		
	}

	AnimationTimer timer = new AnimationTimer() {
		@Override
	    public void handle(long now) {
	        dateTime.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM-dd-yyyy HH:mm:ss")));
	    }
	};
}
