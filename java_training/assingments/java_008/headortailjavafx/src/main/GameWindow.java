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
		
	protected ComputerFlipper flipper = new ComputerFlipper();
	
	public Scene createScene(Stage primaryStage) throws Exception {
		Pane titlePane = new Pane();
		Label title = new Label();
		title.setText(flipper.startGameMessage());
		titlePane.getChildren().add(title);
		
		Pane broadcastPanel = new Pane();
		Label broadcaster = new Label();
		broadcastPanel.getChildren().add(broadcaster);
		
		//broadcaster.setText(flipper.startGameMessage());
		
		
		BorderPane resetPanel = new BorderPane();
		Button resetButton = new Button();
		resetPanel.setCenter(resetButton);
		resetButton.setText("Reset");
		resetButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				broadcaster.setText("waiting...");
			}
		});
		
		BorderPane flipperButtonPanel = new BorderPane();
		Button flipperButton = new Button();
		flipperButton.setText("Press to flip a coin!");
		flipperButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		        broadcaster.setText(broadcaster.getText() + "\n" + flipper.game() + "\nwaiting...");
		    }
		});
		
		
		
		flipperButtonPanel.setCenter(flipperButton);
		
		BorderPane scenePane = new BorderPane();
		scenePane.setTop(titlePane);
		scenePane.setCenter(broadcastPanel);
		scenePane.setBottom(resetPanel);
		scenePane.setRight(flipperButtonPanel);
		

		Scene scene = new Scene(scenePane, 400, 400);
		
		return scene;
		
	}

}
