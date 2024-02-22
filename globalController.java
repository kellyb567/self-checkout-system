package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class globalController {
	@FXML
	
	// variables for scene control
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	public void switchToState1(ActionEvent e) throws IOException{
		// initialize State1
		root = FXMLLoader.load(getClass().getResource("State1.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		
		//set State1 as the scene
		scene = new Scene(root);
		
		// style the scene
		String style = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(style);

		// put the scene into the stage and show	
		stage.setScene(scene);
		stage.show();
		
	}
	
	
	public void switchToState2(ActionEvent e) throws IOException{
		// initialize State2
		root = FXMLLoader.load(getClass().getResource("State2.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
					
		//set State1 as the scene
		scene = new Scene(root);
					
		// style the scene
		String style = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(style);

		// put the scene into the stage and show	
		stage.setScene(scene);
		stage.show();
		
	}
		
	
	public void switchToState5(ActionEvent e) throws IOException{
		// initialize State1
		root = FXMLLoader.load(getClass().getResource("State5.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
						
		//set State5 as the scene
		scene = new Scene(root);
						
		// style the scene
		String style = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(style);

		// put the scene into the stage and show	
		stage.setScene(scene);
		stage.show();
		
	}
	

}
