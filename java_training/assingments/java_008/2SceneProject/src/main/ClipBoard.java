package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClipBoard extends Application {

	Scene scene1, scene2;
	/*
	 The left stage contains a quick form with the following combination of labels and fields
		name
 		date of birth
 	Have an add button
	Have a clear button to clear both fields
	Use can use a VBox to control the layout of the fields

	Right Stage has a listview
 		Ensure you have the name and date of birth displaying in the listview (as a single string?)
		If you click in the listview it will populate the left stage with the data 
	*/

	@Override
	public void start(Stage primaryStage) {

		primaryStage.setTitle("My First JavaFX GUI");

		//Scene 1
		Label label1 = new Label("This is the first scene");
		Button button1 = new Button("Go to scene 2");
		button1.setOnAction(e -> primaryStage.setScene(scene2));
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, button1);
		scene1 = new Scene(layout1, 300, 250);

		//Scene 2
		Label label2 = new Label("This is the second scene");
		Button button2 = new Button("Go to scene 1");
		button2.setOnAction(e -> primaryStage.setScene(scene1));
		VBox layout2 = new VBox(20);
		layout2.getChildren().addAll(label2, button2);
		scene2 = new Scene(layout2, 300, 250);

		primaryStage.setScene(scene1);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}