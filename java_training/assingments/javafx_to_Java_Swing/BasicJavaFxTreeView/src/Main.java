import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.text.*;

public class Main extends Application {

	// global to the class
	Label response;
	Separator sp = new Separator();
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage myStage) {
		myStage.setTitle("TreeView Demo");
		FlowPane rootNode = new FlowPane();
		rootNode.setAlignment(Pos.CENTER);
		Scene myScene = new Scene(rootNode, 850, 600);
		myStage.setScene(myScene);

		response = new Label("No Selection");
		response.setFont(new Font("Arial", 18));
		
		// load an image and size it correctly
		Label title = new Label("TreeView Demo");
 		// setting some styling for the label
		title.setFont(new Font("Arial", 20));
		title.setStyle("-fx-font-weight: bold");
		title.setAlignment(Pos.CENTER);
		
		// TreeItems
		TreeItem<String> t1Root = new TreeItem<String>("Food");
		t1Root.setExpanded(true);
		// Now add sub rees, beginning with fruit. 
		TreeItem<String> t1Fruit = new TreeItem<String> ("Fruits"); 
		t1Fruit.setExpanded(true);
		// Construct the Apple subtree. 
		TreeItem<String> t1Apples = new TreeItem<String>("Apples"); 
		t1Apples.setExpanded(true);
		// Add child nodes to the Apple node. 
		t1Apples.getChildren().add(new TreeItem<String>("Fuji"));
		t1Apples.getChildren().add(new TreeItem<String>("Winesap"));
		t1Apples.getChildren().add(new TreeItem<String>("Clark"));

		// Add child nodes to the Fruit node. 
		t1Fruit.getChildren().add(t1Apples);
		t1Fruit.getChildren().add(new TreeItem<String>("Pears"));
		t1Fruit.getChildren().add(new TreeItem<String>("Oranges"));

		
		// Finally, add the fruit node to the root. 
		t1Root.getChildren().add(t1Fruit); 
		t1Root.setExpanded(true);
		
		// let's get veggies
		TreeItem<String> t1Veggies = new TreeItem<String> ("Vegetables"); 
		t1Veggies.getChildren().add(new TreeItem<String>("Corn"));
		t1Veggies.getChildren().add(new TreeItem<String>("Peas"));
		t1Veggies.getChildren().add(new TreeItem<String>("Broccoli"));
		t1Veggies.getChildren().add(new TreeItem<String>("Beans"));
		t1Veggies.setExpanded(true);
		t1Root.getChildren().add(t1Veggies); 
		
		// let's go nuts!
		TreeItem<String> t1Nuts = new TreeItem<String> ("Nuts"); 
		t1Nuts.getChildren().add(new TreeItem<String>("Walnuts"));
		t1Nuts.getChildren().add(new TreeItem<String>("Almonds"));
		t1Nuts.getChildren().add(new TreeItem<String>("Pistachios"));
		t1Nuts.getChildren().add(new TreeItem<String>("Cashews"));
		t1Nuts.setExpanded(true);
		t1Root.getChildren().add(t1Nuts); 

		TreeView<String> tvFood = new TreeView<String>(t1Root);
		
		// get the tree view selection model
		MultipleSelectionModel<TreeItem<String>> tvSelModel = tvFood.getSelectionModel();
		
		// use a change listener to respond to selection within the tree view
		tvSelModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
	        if (newValue != null) {
	            String path = newValue.getValue();
	            TreeItem<String> tmp = newValue.getParent();
	            while(tmp != null) {
	            	path = tmp.getValue() + " -> " + path;
	            	tmp = tmp.getParent();
	            }
	            
	            response.setText("Selection is: " + newValue.getValue() + "\nComplete Path is: " + path);
	        }
	    });		
		
		
		// toggle Button
		// Create a toggle button
		ToggleButton tbOnOff = new ToggleButton("Collapse All");
		// setting a default eventHandler
		EventHandler myEv = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				if(tbOnOff.getText().equals("Collapse All")) {
					tbOnOff.setText("Expand All");
					t1Root.setExpanded(false);
					t1Fruit.setExpanded(false);
					t1Apples.setExpanded(false);
					t1Root.setExpanded(false);
					t1Veggies.setExpanded(false);
					t1Nuts.setExpanded(false);
				} else {
					tbOnOff.setText("Collapse All");
					t1Root.setExpanded(true);
					t1Fruit.setExpanded(true);
					t1Apples.setExpanded(true);
					t1Root.setExpanded(true);
					t1Veggies.setExpanded(true);
					t1Nuts.setExpanded(true);
				}
			}
		};
		
		// setting the action on the buttons
		tbOnOff.setOnAction(myEv);
		
		// making sure my controls width all match
		title.setMaxWidth(Double.MAX_VALUE);
		sp.setMaxWidth(Double.MAX_VALUE);
		response.setMaxWidth(Double.MAX_VALUE);
		response.setPrefHeight(80);
		tvFood.setPrefWidth(750);
		tvFood.setMaxWidth(Double.MAX_VALUE);
		tbOnOff.setMaxWidth(Double.MAX_VALUE);
		
		// setting up a vbox layout with controls
		VBox vbox = new VBox(title, sp, tvFood, response, tbOnOff);
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(0, 20, 10, 20)); 
		
		rootNode.getChildren().addAll(vbox);
		myStage.show();
	}
}
