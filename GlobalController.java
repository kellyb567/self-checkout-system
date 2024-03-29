package application;

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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GlobalController{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	String currentFile;
	
	@FXML private Text dateTime;
	@FXML private Button logoutButton;
	@FXML private AnchorPane anchorPane;
	
	

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
					
		//set State2 as the scene
		scene = new Scene(root);
		
		
		// style the scene
		String style = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(style);

		// put the scene into the stage and show	
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void switchToState4(ActionEvent e) throws IOException{
		// initialize State2
		root = FXMLLoader.load(getClass().getResource("State4.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
					
		//set State2 as the scene
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
