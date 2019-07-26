package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.FlowPane;
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
		TextField textArea = new TextField();
		Label broadcaster = new Label();
		FlowPane flow = new FlowPane();
		flow.getChildren().addAll(textArea, broadcaster);
		Group texty = new Group(flow);

		Scene sc2 = new Scene(texty, 200, 100);
		sc2.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				String text = reverse(textArea.getText());
				broadcaster.setText(text);
				textArea.setText("");
			}
		});

		primaryStage.setTitle("Shapes");
		primaryStage.setScene(sc2);
		System.out.println("start() method");
		primaryStage.show();
	}

	private String reverse(String text) {
		String reverse = "";

		for (int i = text.length() - 1; i >= 0; i--) {
			reverse = reverse + text.charAt(i);
		}
		return reverse;
	}

	public void stop() {
		System.out.println("stop() method");
	}
}
