import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.text.*;

public class Main extends Application {

	// global to the class
	ComboBox<String> cbTransport;
	Label response;
	Separator sp = new Separator();
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage myStage) {
		myStage.setTitle("ComboBox Demo");
		FlowPane rootNode = new FlowPane();
		rootNode.setAlignment(Pos.CENTER);
		Scene myScene = new Scene(rootNode, 350, 150);
		myStage.setScene(myScene);
		response = new Label();
		
		// load an image and size it correctly
		Label title = new Label("Select Transport Type");
 		// setting some styling for the label
		title.setFont(new Font("Arial", 20));
		title.setStyle("-fx-font-weight: bold");
		title.setAlignment(Pos.CENTER);
		
		// response when buttons are clicked
		response = new Label("");
 		// setting some styling for the label
		response.setFont(new Font("Arial", 20));
		response.setStyle("-fx-font-weight: bold");
		response.setAlignment(Pos.CENTER);

		// Definition of Observable List
		// https://dzone.com/articles/javafx-collections-observablelist-and-observablema
		ObservableList<String> transportTypes = FXCollections.observableArrayList("Train", "Car", "Airplane");

		// ComboBox using transportTypes
		cbTransport = new ComboBox<String>(transportTypes);

		
		// default font
		Font defFont = new Font("Arial", 16);  

		// event handler for combobox
		EventHandler ev = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				response.setText("Selected: " + cbTransport.getValue());
			}
		};
		
		cbTransport.setOnAction(ev);
		
		// making sure my controls width all match
		title.setMaxWidth(Double.MAX_VALUE);
		cbTransport.setMaxWidth(Double.MAX_VALUE);
		response.setPrefSize(320, 30);
		sp.setMaxWidth(Double.MAX_VALUE);
		
		
		// setting up a vbox layout with controls
		VBox vbox = new VBox(title, sp, cbTransport, response);
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(0, 20, 10, 20)); 
		
		rootNode.getChildren().addAll(vbox);
		myStage.show();
	}
}
