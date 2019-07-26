package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		System.out.println("Launching JavaFX application");
		launch(args);
	}

	public void init() {
		System.out.println("init() method");
	}

	@Override
	public void start(Stage primaryStage) {
		Line line = new Line();
		
		line.setStartX(150.0f); 
		line.setStartY(140.0f);         
		line.setEndX(450.0f); 
		line.setEndY(140.0f);
		Group root = new Group(line);
		Scene sc = new Scene(root, 600, 300);
		primaryStage.setTitle("Shapes");
		primaryStage.setScene(sc);
		
		System.out.println("start() method");
		primaryStage.setTitle("Hello World!");
		primaryStage.show();
	}

	public void stop() {
		System.out.println("stop() method");
	}
}
