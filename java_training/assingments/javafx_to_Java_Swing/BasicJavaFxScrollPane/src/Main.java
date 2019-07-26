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
	ScrollPane scrlPane;
	Label response;
	Separator sp = new Separator();
	
	public static void main(String[] args) {
		launch(args);
	}

	public void myHandle(Button btn) {
	 	scrlPane.setVvalue(0);
	 	scrlPane.setHvalue(0);
	}
	
	public void start(Stage myStage) {
		myStage.setTitle("ScrollPane Demo");
		FlowPane rootNode = new FlowPane();
		rootNode.setAlignment(Pos.CENTER);
		Scene myScene = new Scene(rootNode, 350, 350);
		myStage.setScene(myScene);
 		response = new Label();
		
		// load an image and size it correctly
		Label title = new Label("ScrollPane Demo");
 		// setting some styling for the label
		title.setFont(new Font("Arial", 20));
		title.setStyle("-fx-font-weight: bold");
		title.setAlignment(Pos.CENTER);
		
		// response when buttons are clicked
		String msg = "A ScrollPane streamlines the process \n" + 
		" of adding darn scroll bars to a window whose contents \n" + 
		" exceed the viewing area dimension of the window \n " + 
		" It also enables a control to fit in \n " + 
		" Such as this label control in JavaFX \n " + 
		" Without it, we could not really view well the content \n " + 
		" of a control if it overflowed, so using scrollbars helps lots! \n";
		
		response = new Label(msg);
 		// setting some styling for the label
		response.setFont(new Font("Arial", 18));
		
		// scrollpane
		scrlPane = new ScrollPane(response);
		scrlPane.setPrefViewportWidth(200);
		scrlPane.setPrefViewportHeight(80);
		
		// allow for panning (mouse scroll)
		scrlPane.setPannable(true);
		

		// Add a button that will reset the scroll pane to 0, 0
		Button resetBtn = new Button("Reset Scroll Pane to Top/Left");
		resetBtn.setId("reset");
		// setting a default eventHandler
		EventHandler myEv = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				myHandle((Button) ae.getSource());
			}
		};
		
		// setting the action on the button
		resetBtn.setOnAction(myEv);

		// making sure my controls width all match
		title.setMaxWidth(Double.MAX_VALUE);
		sp.setMaxWidth(Double.MAX_VALUE);
		resetBtn.setMaxWidth(Double.MAX_VALUE);
		
		// setting up a vbox layout with controls
		VBox vbox = new VBox(title, sp, scrlPane, resetBtn);
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(0, 20, 10, 20)); 
		
		rootNode.getChildren().addAll(vbox);
		myStage.show();
	}
}
