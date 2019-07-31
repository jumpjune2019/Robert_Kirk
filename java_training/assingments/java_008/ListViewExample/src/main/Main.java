package main;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	ListStage presentingStage;

	public static void main(String[] args) {

		System.out.println("Launching JavaFX application");
		launch(args);
	}

	public void init() {
		System.out.println("init() method");
	}

	@Override
	public void start(Stage primaryStage) {
		String[] existingList = {"White Scars", "Raven Guard", "Iron Hands", "Imperial Fists", "Ultramarines", "Salamanders", "Alpha Legion", "Space Wolves", 
				"Lunar Wolves", "Thousand Sons", "Death Guard", "Dark Angels", "Iron Warriors", "Night Lords", "Wordbearers", "Blood Angels", 
				"Emperor's Children", "World Eaters"
				};
		presentingStage = new ListStage(existingList);
		try {
			primaryStage.setScene(presentingStage.createScene(primaryStage));
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