// Load and display an image. 
import javafx.application.*; 
import javafx.scene.*; 
import javafx.stage.*; 
import javafx.scene.layout.*; 
import javafx.geometry.*; 
import javafx.scene.image.*; 

public class Main extends Application { 
	public static void main (String[] args) { 
		// Start the JavaFX application by calling launch(). 
		launch(args);	
	}
	
	public void start(Stage myStage) {
		// Give the stage a title. 
		myStage.setTitle("Fungi is hilarious!"); 
		// Use a FlowPane for the root node. 
		FlowPane rootNode = new FlowPane(); 
		// Use center alignment. 
		rootNode.setAlignment(Pos.CENTER); 
		// Create a scene. 
		Scene myScene = new Scene(rootNode, 540, 540,true, SceneAntialiasing.BALANCED);
		// Set the scene on the stage
		myStage.setScene(myScene);
		// Create an Image
		Image img = new Image("fungi.png");
		// Create an image view that uses the image
		ImageView imgView = new ImageView(img);
		// add the image to the scene
		rootNode.getChildren().add(imgView);
		// show the stage
		myStage.show();
	}
}
		