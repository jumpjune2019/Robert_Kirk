// A JavaFX application with a label

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.Scene;
import javafx.geometry.*;

public class Main extends Application {
	Label response;
	
	public static void main(String[] args) {
		launch(args);
	}

	public void init() {
		System.out.println("init() method");
	}
	
	public void start(Stage myStage) {
		myStage.setTitle("JavaFX Buttons, Events and Alignment");
		FlowPane rootNode = new FlowPane(10, 10);
		rootNode.setAlignment(Pos.CENTER);
		Scene myScene = new Scene(rootNode, 300, 100);
		myStage.setScene(myScene);
		response = new Label("Push a Button!");
		Button btnAlpha = new Button("Alpha");
		Button btnBeta = new Button("Beta");
		Button btnDorn = new Button("Dorn");
		btnAlpha.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				response.setText("Alpha was pressed.");
			}
		});
		
		btnBeta.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				response.setText("Beta was pressed.");
			}
		});
		btnDorn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				response.setText("Papa Dorn is here!");
			}
		});

		rootNode.getChildren().addAll(btnAlpha, btnBeta, btnDorn,response);
		myStage.show();
	
	}
}
