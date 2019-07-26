import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.text.*;

public class Main extends Application {

	// global to the class
	TextField tf;
	Label response;
	Separator sp = new Separator();
	
	public static void main(String[] args) {
		launch(args);
	}

	public void myHandle() {
		response.setText("Search String: " + tf.getText());		
	}
	
	public void start(Stage myStage) {
		myStage.setTitle("TextField Demo");
		FlowPane rootNode = new FlowPane();
		rootNode.setAlignment(Pos.CENTER);
		Scene myScene = new Scene(rootNode, 350, 180);
		myStage.setScene(myScene);
		response = new Label();
		
		// load an image and size it correctly
		Label title = new Label("TextField Demo");
 		// setting some styling for the label
		title.setFont(new Font("Arial", 20));
		title.setStyle("-fx-font-weight: bold");
		title.setAlignment(Pos.CENTER);
		
		// response when buttons are clicked
		response = new Label("Search String: ");
 		// setting some styling for the label
		response.setFont(new Font("Arial", 20));
		response.setStyle("-fx-font-weight: bold");
		response.setAlignment(Pos.CENTER);

		// Button
		Button btnGetText = new Button("Get Search String");
		
		// textfield
		tf = new TextField();
		tf.setPromptText("Enter Search String...");
		tf.setPrefColumnCount(15);
		
		// default font
		Font defFont = new Font("Arial", 16);  

		// event handler for button
		EventHandler ev = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				myHandle();
			}
		};
		
		btnGetText.setOnAction(ev);
		
		// event for textfield
		tf.setOnKeyPressed(new EventHandler<KeyEvent>() {
	        @Override
	        public void handle(KeyEvent ke) {
	            if (ke.getCode().equals(KeyCode.ENTER)) {
	            	myHandle();	
	            }
	        }
	    });
		
		// making sure my controls width all match
		title.setMaxWidth(Double.MAX_VALUE);
		tf.setMaxWidth(Double.MAX_VALUE);
		btnGetText.setMaxWidth(Double.MAX_VALUE);
		response.setPrefSize(320, 30);
		sp.setMaxWidth(Double.MAX_VALUE);
		
		
		// setting up a vbox layout with controls
		VBox vbox = new VBox(title, sp, tf, btnGetText, response);
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(0, 20, 10, 20)); 
		
		rootNode.getChildren().addAll(vbox);
		myStage.show();
	}
}
