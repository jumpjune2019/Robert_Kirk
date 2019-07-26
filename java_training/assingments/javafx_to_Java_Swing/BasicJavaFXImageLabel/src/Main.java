// Image and Label

import javafx.application.*; 
import javafx.scene.*; 
import javafx.stage.*; 
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.geometry.*; 
import javafx.scene.image.*; 

public class Main extends Application { 
	public static void main (String[] args) { 
		// Start the JavaFX application by calling launch(). 
		launch(args);	
	}
	
	public void start(Stage myStage) {
		// Give the stage a title. 
		myStage.setTitle("Use an Image in a Label"); 
		// Use a FlowPane for the root node. 
		FlowPane rootNode = new FlowPane(); 
		// Use center alignment. 
		rootNode.setAlignment(Pos.CENTER); 
		// Create a scene. 
		Scene myScene = new Scene(rootNode, 320, 80);
		// Set the scene on the stage
		myStage.setScene(myScene);
		// load an image and size it correctly
		Image img = new Image("fungi.png", 28, 28, false, false);
		// Create an image view that uses the image
		ImageView imgView = new ImageView(img);
		// label using image and text
		Label labImg = new Label ("Fungi", imgView);
		// increase font-size of label and set it to Arial
		labImg.setFont(new Font("Arial", 32));
		// forcing the content of the label (image) to the right
		labImg.setContentDisplay(ContentDisplay.RIGHT);
		// add the label to the scene
		rootNode.getChildren().add(labImg);
		// show the stage
		myStage.show();
	}
}
		