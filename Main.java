package application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			
			// open State1 as the root node and set it as the scene
			Parent root = FXMLLoader.load(getClass().getResource("State1.fxml"));
			Scene scene = new Scene(root);
			stage.setTitle("Self checkout machine");
			
			// set C--.png as icon
			Image icon = new Image("/C--.png");
			stage.getIcons().add(icon);
			
			
			// css styling
			String style = this.getClass().getResource("application.css").toExternalForm();
			scene.getStylesheets().add(style);
			
			
			// initialize the stage, scene->stage, and show
			stage.setScene(scene);
			stage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
