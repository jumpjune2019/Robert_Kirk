// ListView

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*; 
import javafx.stage.*; 
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.geometry.*; 
import javafx.beans.value.*;
import javafx.collections.*;

public class Main extends Application { 

	// global to the class
	Label response;
	Separator sp = new Separator();
	
	public static void main (String[] args) { 
		// Start the JavaFX application by calling launch(). 
		launch(args);	
	}
	
	public void start(Stage myStage) {
		// Give the stage a title. 
		myStage.setTitle("ListView Demo"); 
		// Use a FlowPane for the root node and set HGap and VHGap to 10, 10
		FlowPane rootNode = new FlowPane(10, 10); 
		// Use center alignment. 
		rootNode.setAlignment(Pos.CENTER); 
		// Create a scene. 
		Scene myScene = new Scene(rootNode, 400, 300);
		// Set the scene on the stage
		myStage.setScene(myScene);
		// load an image and size it correctly
		Label title = new Label("Select Transport Type");
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

		// Definition of Observable List
		// https://dzone.com/articles/javafx-collections-observablelist-and-observablema
		ObservableList<String> transportTypes = FXCollections.observableArrayList("Train", "Car", "Airplane");

		// ListView using transportTypes to be pass into the ListView
		ListView<String> lvTransport = new ListView<String>(transportTypes);

		// set the size
		lvTransport.setPrefSize(80, 80);
		
		// the selection model from the listview
		MultipleSelectionModel<String> lvSelModel = lvTransport.getSelectionModel();
		
		// assigning the event 
		lvSelModel.selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> changed, String oldVal, String newVal) {
				System.out.println("What used to be selected was " + oldVal);
				response.setText("Transport selected is " + newVal);
			}
		});
		
		// default font
		Font defFont = new Font("Arial", 16);  
		

		EventHandler addEv = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				int idx = lvSelModel.getSelectedIndex();
				transportTypes.add("Test");
			}
		};
		
		// adding 2 buttons
		MyButton myBtn1 = new MyButton("Add an Item", "add", addEv);
		Button btn1 = myBtn1.getButton();

		EventHandler removeEv = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				// -1 when nothing is selected
				// System.out.println("Selected Index: " + idx); 
				if(!transportTypes.isEmpty()) {
					transportTypes.remove(0);
				}
			}
		};
		
		// adding 2 buttons
		MyButton myBtn2 = new MyButton("Remove First Item", "remove", removeEv);
		Button btn2 = myBtn2.getButton();

		// making sure my controls width all match
		title.setMaxWidth(Double.MAX_VALUE);
		response.setPrefSize(320, 30);
		btn1.setMaxWidth(Double.MAX_VALUE);
		btn2.setMaxWidth(Double.MAX_VALUE);
		sp.setMaxWidth(Double.MAX_VALUE);
		
		
		// setting up a vbox layout with controls
		VBox vbox = new VBox(title, sp, lvTransport, response, btn1, btn2);
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(0, 20, 10, 20)); 

		// adding vbox
		rootNode.getChildren().add(vbox);
		// show the stage
		myStage.show();
	}
}