package main;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	GameWindow gameWindow;

	public static void main(String[] args) {

		System.out.println("Launching JavaFX application");
		launch(args);
	}

	public void init() {
		System.out.println("init() method");
	}

	@Override
	public void start(Stage primaryStage) {
		gameWindow = new GameWindow();
		try {
			primaryStage.setScene(gameWindow.createScene(primaryStage));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		primaryStage.setTitle("Two Scenes in JavaFX");
		System.out.println("start() method");
		primaryStage.show();
	}

	public void stop() {
		System.out.println("stop() method");
	}

}