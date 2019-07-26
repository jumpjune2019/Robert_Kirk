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
		Scene myScene = new Scene(rootNode, 340, 200);
		// Set the scene on the stage
		myStage.setScene(myScene);
        
		// my buttons for testing

		Font defBFont = new Font("Arial", 16);
		Font defLFont = new Font("Arial", 18);
		
        Cell cell1 = new Cell("Button 1", "Label 1", defBFont, defLFont);
        VBox c1 = cell1.getCell();

        Cell cell2 = new Cell("Button 2", "Label 2", defBFont, defLFont);
        VBox c2 = cell2.getCell();

        Cell cell3 = new Cell("Button 3", "Label 3", defBFont, defLFont);
        VBox c3 = cell3.getCell();

        Cell cell4 = new Cell("Button 4", "Label 4", defBFont, defLFont);
        VBox c4 = cell4.getCell();

        Cell cell5 = new Cell("Button 5", "Label 5", defBFont, defLFont);
        VBox c5 = cell5.getCell();

        Cell cell6 = new Cell("Button 6", "Label 6", defBFont, defLFont);
        VBox c6 = cell6.getCell();

        
        
        // gridpane
        // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        // adding buttons..
        // see API doc for add method signature...
        gridPane.add(c1, 0, 0, 1, 1);
        gridPane.add(c2, 1, 0, 1, 1);
        gridPane.add(c3, 2, 0, 1, 1);
        gridPane.add(c4, 0, 1, 1, 1);
        gridPane.add(c5, 1, 1, 1, 1);
        gridPane.add(c6, 2, 1, 1, 1);

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



