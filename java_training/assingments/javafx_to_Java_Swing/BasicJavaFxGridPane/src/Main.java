import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main (String[] args) { 
		// Start the JavaFX application by calling launch(). 
		launch(args);	
	}

    public void start(Stage myStage) throws Exception {
    	// Title
    	myStage.setTitle("GridPane Demo");
		// load an image and size it correctly
		Label title = new Label("Push a Button");
 		// setting some styling for the label
		title.setFont(new Font("Arial", 20));
		title.setStyle("-fx-font-weight: bold");
		title.setAlignment(Pos.CENTER);

    	// FlowPane
		FlowPane rootNode = new FlowPane(10, 10); 
		// Use center alignment. 
		rootNode.setAlignment(Pos.CENTER); 
		// Create a scene. 
		Scene myScene = new Scene(rootNode, 340, 140);
		// Set the scene on the stage
		myStage.setScene(myScene);
        
		// my buttons for testing
		Font defFont = new Font("Arial", 18);  

        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
        Button button4 = new Button("Button 4");
        Button button5 = new Button("Button 5");
        Button button6 = new Button("Button 6");

        button1.setFont(defFont);
        button2.setFont(defFont);
        button3.setFont(defFont);
        button4.setFont(defFont);
        button5.setFont(defFont);
        button6.setFont(defFont);
        
        
        // gridpane
        // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        // adding buttons..
        // see API doc for add method signature...
        gridPane.add(button1, 0, 0, 1, 1);
        gridPane.add(button2, 1, 0, 1, 1);
        gridPane.add(button3, 2, 0, 1, 1);
        gridPane.add(button4, 0, 1, 1, 1);
        gridPane.add(button5, 1, 1, 1, 1);
        gridPane.add(button6, 2, 1, 1, 1);

		title.setMaxWidth(Double.MAX_VALUE);
		gridPane.setMaxWidth(Double.MAX_VALUE);
		
		// setting up a vbox layout with controls
		VBox vbox = new VBox(title, gridPane);
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(0, 20, 10, 20)); 
        
		// adding vbox
		rootNode.getChildren().add(vbox);
        myStage.show();
    }
	
}
