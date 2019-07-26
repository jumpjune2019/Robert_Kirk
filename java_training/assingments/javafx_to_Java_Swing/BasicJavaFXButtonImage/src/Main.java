// Button and Image

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
 	Label response;
	
	public static void main (String[] args) { 
		// Start the JavaFX application by calling launch(). 
		launch(args);	
	}

	public void myHandle(Button btn) {
	 	String id = btn.getId();
	 	if(id.equals("reset")) {
	 		response.setText("");
	 	} else {
	 		response.setText(id);
	 	}
	}
	
	public void start(Stage myStage) {
		// Give the stage a title. 
		myStage.setTitle("Using Images with Buttons"); 
		// Use a FlowPane for the root node and set HGap and VHGap to 10, 10
		FlowPane rootNode = new FlowPane(10, 10); 
		// Use center alignment. 
		rootNode.setAlignment(Pos.CENTER); 
		// Create a scene. 
		Scene myScene = new Scene(rootNode, 250, 350);
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
		
		// setting up 2 images
		Image fungiImg = new Image("fungi.png", 28, 28, false, false);
		Image dairyImg = new Image("dairy.png", 28, 28, false, false);

		// creating 2 image views
		ImageView fungiImgView = new ImageView(fungiImg);
		ImageView dairyImgView = new ImageView(dairyImg);
		
		// associating imageviews to buttons
		Button btn1 = new Button("Fungi", fungiImgView);
		Button btn2 = new Button("Dairy", dairyImgView);
		Button resetBtn = new Button("Reset");

		// adding Ids
		btn1.setId("fungi");
		btn2.setId("dairy");
		resetBtn.setId("reset");
		
		// setting a default eventHandler
		EventHandler myEv = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				myHandle((Button) ae.getSource());
			}
		};
		
		// setting the action on the buttons
		btn1.setOnAction(myEv);
		btn2.setOnAction(myEv);
		resetBtn.setOnAction(myEv);
		
		// default font
		Font defFont = new Font("Arial", 32);  
		
		// assigning font
		btn1.setFont(defFont);
		btn2.setFont(defFont);
		resetBtn.setFont(new Font("Arial", 24));

		// setting the label to the button text display 
		btn1.setContentDisplay(ContentDisplay.RIGHT);
		btn2.setContentDisplay(ContentDisplay.LEFT);
		
		// making sure my controls width all match
		title.setMaxWidth(Double.MAX_VALUE);
		btn1.setMaxWidth(Double.MAX_VALUE);
		btn2.setMaxWidth(Double.MAX_VALUE);
		resetBtn.setMaxWidth(Double.MAX_VALUE);
		response.setMaxWidth(Double.MAX_VALUE);
		
		// setting up a vbox layout with controls
		VBox vbox = new VBox(title, btn1, btn2, response, resetBtn);
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(0, 20, 10, 20)); 

		// adding vbox
		rootNode.getChildren().add(vbox);
		// show the stage
		myStage.show();
	}
}