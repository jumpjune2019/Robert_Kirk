package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameWindow {

	protected double count = 0.0;
	Scene scene;
	Scene scene2;
	Scene temp;

	public Scene createScene(Stage primaryStage) throws Exception {

		BorderPane scenePane = new BorderPane();
		this.scene = createScene("Scene One", scenePane, "I'm the first scene!\nFirst is the best!");
		
		
		BorderPane scenePane2 = new BorderPane();
		this.scene2 = createScene("Scene Two", scenePane2, "I'm the second and last scene!\nAlways save the best for last!");
		
		BorderPane tempPane = new BorderPane();
		this.temp = createScene("TEMP", tempPane, "You won't see me :(");
		
		
		

		return scene;

	}

	private Button cellButton(String label) {
		Button jbtn = new Button(label);
		jbtn.setText(label);
		// Add action listeners.
		jbtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
					temp = scene;
					scene = scene2;
					scene2 = scene;
			}
		});

		return jbtn;
	}
	private Scene createScene(String sceneName, BorderPane scenePane, String message) {
		Scene scene = new Scene(scenePane, 500, 500);
		Label title = new Label();
		title.setWrapText(true);
		title.setText(sceneName);

		BorderPane titlePane = new BorderPane();
		titlePane.setCenter(title);
		titlePane.setPrefWidth(scenePane.getWidth());

		Pane controllerPaneContainer = new Pane();
		
		Button btn = this.cellButton(sceneName);
		
		controllerPaneContainer.getChildren().add(btn);

		scenePane.setTop(titlePane);
		scenePane.setCenter(controllerPaneContainer);
		
		return scene;
	}

}
