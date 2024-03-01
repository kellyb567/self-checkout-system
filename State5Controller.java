package application;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
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
import javafx.stage.Stage;

public class State5Controller implements Initializable{

	// import methods from GlobalController as global
	GlobalController global = new GlobalController();
			
	@FXML 
	private Text dateTime;
	
	public void switchToState1(ActionEvent e) throws IOException{
		global.switchToState1(e);
		
	}
	
	
	public void switchToState2(ActionEvent e) throws IOException{
		global.switchToState2(e);
		
	}
		
	
	public void switchToState5(ActionEvent e) throws IOException{
		global.switchToState5(e);
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
