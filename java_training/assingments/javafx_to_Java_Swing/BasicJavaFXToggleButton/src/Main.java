// Toggle Button

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*; 
import javafx.stage.*; 
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.geometry.*; 
import javafx.scene.image.*; 

public class Main extends Application { 

	// global to the class
	ToggleButton tbOnOff;
 	Label response;
	
	public static void main (String[] args) { 
		// Start the JavaFX application by calling launch(). 
		launch(args);	
	}

	public void myHandle(ToggleButton tgBtn) {
		if(tgBtn.isSelected()) {
			response.setText("Button is On");
		} else {
			response.setText("Button is Off");
		}
	}
	
	public void start(Stage myStage) {
		// Give the stage a title. 
		myStage.setTitle("Toggle Button Demo"); 
		// Use a FlowPane for the root node and set HGap and VHGap to 10, 10
		FlowPane rootNode = new FlowPane(10, 10); 
		// Use center alignment. 
		rootNode.setAlignment(Pos.CENTER); 
		// Create a scene. 
		Scene myScene = new Scene(rootNode, 300, 220);
		// Set the scene on the stage
		myStage.setScene(myScene);
		// load an image and size it correctly
		Label title = new Label("Push a Button");
 		// setting some styling for the label
		title.setFont(new Font("Arial", 20));
		title.setStyle("-fx-font-weight: bold");
		title.setAlignment(Pos.CENTER);
		
		// response when buttons are clicked
		response = new Label("");
 		// setting some styling for the label
		response.setFont(new Font("Arial", 14));
		response.setStyle("-fx-font-weight: bold");
		response.setAlignment(Pos.CENTER);
		
		// Create a toggle button
		tbOnOff = new ToggleButton("On/Off");
		
		// setting a default eventHandler
		EventHandler myEv = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				myHandle((ToggleButton) ae.getSource());
			}
		};
		
		// setting the action on the buttons
		tbOnOff.setOnAction(myEv);
		
		// default font
		Font defFont = new Font("Arial", 32);  
		
		// assigning font
		tbOnOff.setFont(defFont);

		// making sure my controls width all match
		title.setMaxWidth(Double.MAX_VALUE);
		tbOnOff.setMaxWidth(Double.MAX_VALUE);
		response.setMaxWidth(Double.MAX_VALUE);
		
		// setting up a vbox layout with controls
		VBox vbox = new VBox(title, tbOnOff, response);
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(0, 20, 10, 20)); 

		// adding vbox
		rootNode.getChildren().add(vbox);
		// show the stage
		myStage.show();
	}
}