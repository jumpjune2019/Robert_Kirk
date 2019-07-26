// Radio Button

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*; 
import javafx.stage.*; 
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.geometry.*; 

public class Main extends Application { 

	// global to the class
	Label response;
	
	public static void main (String[] args) { 
		// Start the JavaFX application by calling launch(). 
		launch(args);	
	}

	public void myHandle(RadioButton rgBtn) {
		response.setText(rgBtn.getId());
	}
	
	public void start(Stage myStage) {
		// Give the stage a title. 
		myStage.setTitle("Radio Buttons Demo"); 
		// Use a FlowPane for the root node and set HGap and VHGap to 10, 10
		FlowPane rootNode = new FlowPane(10, 10); 
		// Use center alignment. 
		rootNode.setAlignment(Pos.CENTER); 
		// Create a scene. 
		Scene myScene = new Scene(rootNode, 300, 200);
		// Set the scene on the stage
		myStage.setScene(myScene);
		// load an image and size it correctly
		Label title = new Label("Radio Buttons");
 		// setting some styling for the label
		title.setFont(new Font("Arial", 20));
		title.setStyle("-fx-font-weight: bold");
		title.setAlignment(Pos.CENTER);
		
		// response when buttons are clicked
		response = new Label("");
 		// setting some styling for the label
		response.setFont(new Font("Arial", 20));
		response.setStyle("-fx-font-weight: bold");
		response.setAlignment(Pos.CENTER);

		// Create radio buttons and add ids
		RadioButton rbTrain = new RadioButton("Train");
		rbTrain.setId("train");
		RadioButton rbCar = new RadioButton("Car");
		rbCar.setId("car");
		RadioButton rbPlane = new RadioButton("Plane");
		rbPlane.setId("plane");
		RadioButton rbBoat = new RadioButton("Boat");
		rbBoat.setId("boat");
		
		// Create a toggle Group to host the radio buttons
		
		ToggleGroup tg = new ToggleGroup();
		
		// Associate each button to the toggle group
		
		rbTrain.setToggleGroup(tg);
		rbCar.setToggleGroup(tg);
		rbPlane.setToggleGroup(tg);
		rbBoat.setToggleGroup(tg);
		
		// setting a default eventHandler
		EventHandler myEv = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				myHandle((RadioButton) ae.getSource());
			}
		};
		
		// setting the action on the radio buttons
		
		rbTrain.setOnAction(myEv);
		rbCar.setOnAction(myEv);
		rbPlane.setOnAction(myEv);
		rbBoat.setOnAction(myEv);

		// default font
		Font defFont = new Font("Arial", 16);  
		
		// assigning font

		rbTrain.setFont(defFont);
		rbCar.setFont(defFont);
		rbPlane.setFont(defFont);
		rbBoat.setFont(defFont);
		
		// making sure my controls width all match
		title.setMaxWidth(Double.MAX_VALUE);
		rbTrain.setMaxWidth(Double.MAX_VALUE);
		rbCar.setMaxWidth(Double.MAX_VALUE);
		rbPlane.setMaxWidth(Double.MAX_VALUE);
		rbBoat.setMaxWidth(Double.MAX_VALUE);
		response.setMaxWidth(Double.MAX_VALUE);
		
		// setting up a vbox layout with controls
		VBox vbox = new VBox(title, rbTrain, rbCar, rbPlane, rbBoat, response);
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(0, 20, 10, 20)); 

		// adding vbox
		rootNode.getChildren().add(vbox);
		// show the stage
		myStage.show();
	}
}