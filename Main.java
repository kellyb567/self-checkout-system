package application;


import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Main extends Application{
	@Override
	public void start(Stage stage) {
		try {
			
			// open State1 as the root node and set it as the scene
			Parent root = FXMLLoader.load(getClass().getResource("State1.fxml"));
			Scene scene = new Scene(root);
			stage.setTitle("Self checkout machine");
			
			
			// css styling
			String style = this.getClass().getResource("application.css").toExternalForm();
			scene.getStylesheets().add(style);
			
			
			// set C--.png as icon for the  stage
			Image icon = new Image("/C--.png");
			stage.getIcons().add(icon);
			
			
			// set a title for the stage
			stage.setTitle("Self checkout machine");
			
			
			// initialize the stage, scene->stage, and show
			
			stage.setScene(scene);
			stage.show();
			
			
			// when closing out this program..... logout prompt is showed
			stage.setOnCloseRequest(event -> 
			{
				event.consume();  // so when cancel is pressed, the program doesn't close
				logout(stage);  // logout prompt via method down below
			});
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void logout(Stage stage){
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("You're about to logout!");
		alert.setContentText("Are you sure you want to leave?");
		
		if (alert.showAndWait().get() == ButtonType.OK) {
			System.out.println("logged out");
			stage.close();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
