// CheckBox

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
	Label allTargets;
	CheckBox cbWeb;
	CheckBox cbDesktop;
	CheckBox cbMobile;
	String noneStr = "<none>";
	Separator sp = new Separator();
	Separator sp1 = new Separator();
	Separator sp2 = new Separator();
	
	public static void main (String[] args) { 
		// Start the JavaFX application by calling launch(). 
		launch(args);	
	}

	public void myHandle(CheckBox chk) {

		response.setText("Clicked: " + chk.getId());
		
		String stuff = "";
		int count = 0;

		if(cbWeb.isSelected()) {
			stuff += cbWeb.getText();
			count++;
		}
		
		if(cbDesktop.isSelected()) {
			if(count > 0) {
				stuff += ", ";
			}
			stuff += cbDesktop.getText();
			count++;
		}
		
		if(cbMobile.isSelected()) {
			if(count > 0) {
				stuff += ", ";
			}
			stuff += cbMobile.getText();
			count++;
		}
		
		if(count > 0) {
			allTargets.setText(stuff);	
		} else {
			allTargets.setText(noneStr);
		}
	}
	
	public void start(Stage myStage) {
		// Give the stage a title. 
		myStage.setTitle("Checkbox Demo"); 
		// Use a FlowPane for the root node and set HGap and VHGap to 10, 10
		FlowPane rootNode = new FlowPane(10, 10); 
		// Use center alignment. 
		rootNode.setAlignment(Pos.CENTER); 
		// Create a scene. 
		Scene myScene = new Scene(rootNode, 600, 300);
		// Set the scene on the stage
		myStage.setScene(myScene);
		// load an image and size it correctly
		Label title = new Label("Select App Deployment Options");
 		// setting some styling for the label
		title.setFont(new Font("Arial", 20));
		title.setStyle("-fx-font-weight: bold");
		title.setAlignment(Pos.CENTER);
		
		// response when buttons are clicked
		response = new Label("Nothing Clicked.");
 		// setting some styling for the label
		response.setFont(new Font("Arial", 20));
		response.setStyle("-fx-font-weight: bold");
		response.setAlignment(Pos.CENTER);

		// Label of Selected Targets
		allTargets = new Label(noneStr);
		allTargets.setFont(new Font("Arial", 20));
		allTargets.setStyle("-fx-font-weight: bold");
		allTargets.setAlignment(Pos.CENTER);
		
		// create the checkboxes
		cbWeb = new CheckBox("Web");
		cbWeb.setId("web");
		cbDesktop = new CheckBox("Desktop");
		cbDesktop.setId("desktop");
		cbMobile = new CheckBox("Mobile");
		cbMobile.setId("mobile");
		
		
		
		// setting a default eventHandler
		EventHandler myEv = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				myHandle((CheckBox) ae.getSource());
			}
		};
		
		// setting the action on the radio buttons
		
		cbWeb.setOnAction(myEv);
		cbDesktop.setOnAction(myEv);
		cbMobile.setOnAction(myEv);

		// default font
		Font defFont = new Font("Arial", 16);  
		
		// assigning font

		cbWeb.setFont(defFont);
		cbDesktop.setFont(defFont);
		cbMobile.setFont(defFont);
		
		// making sure my controls width all match
		title.setMaxWidth(Double.MAX_VALUE);
		cbWeb.setMaxWidth(Double.MAX_VALUE);
		cbDesktop.setMaxWidth(Double.MAX_VALUE);
		cbMobile.setMaxWidth(Double.MAX_VALUE);
		response.setMaxWidth(Double.MAX_VALUE);
		allTargets.setMaxWidth(Double.MAX_VALUE);
		sp.setMaxWidth(Double.MAX_VALUE);
		sp1.setMaxWidth(Double.MAX_VALUE);
		sp2.setMaxWidth(Double.MAX_VALUE);
		
		// setting up a vbox layout with controls
		VBox vbox = new VBox(title, sp, cbWeb, cbDesktop, cbMobile, sp1, response, sp2, allTargets);
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(0, 20, 10, 20)); 

		// adding vbox
		rootNode.getChildren().add(vbox);
		// show the stage
		myStage.show();
	}
}