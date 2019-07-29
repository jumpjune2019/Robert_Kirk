package main;

import gameofdice.DiceRoller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameWindow {
		
	protected DiceRoller roller = new DiceRoller();
	protected double count = 0.0;
	ScrollPane broadcastPanel;
	public Scene createScene(Stage primaryStage) throws Exception {
		
		BorderPane scenePane = new BorderPane();
		Scene scene = new Scene(scenePane, 400, 400);
		
		HBox titlePane = new HBox();
		Label title = new Label();
		title.setWrapText(true);
		
		title.setPrefWidth(scenePane.getWidth());
		title.setText(roller.gameStart());
		titlePane.getChildren().add(title);
		
		ScrollPane broadcastPanel = new ScrollPane();
		VBox broadCastContainer = new VBox();
		Label broadcaster = new Label();
		broadcaster.setWrapText(true);
		
		broadCastContainer.setPrefWidth(scenePane.getWidth());
		broadcaster.setText("waiting...");
		
		//broadcastPanel.getChildren().add(broadcaster);	
		broadCastContainer.getChildren().add(broadcaster);
		broadcastPanel.setContent(broadCastContainer);
//		broadcaster.setOnInputMethodTextChanged(new EventHandler<InputMethodEvent>() {
//
//			@Override
//			public void handle(InputMethodEvent arg0) {
//				broadcastPanel.setVvalue(1);
//				
//			}
//			
//		});
//		broadcastPanel.setOnInputMethodTextChanged(new EventHandler<InputMethodEvent>() {
//
//			@Override
//			public void handle(InputMethodEvent arg0) {
//				broadcastPanel.setVvalue(1);
//				
//			}
//			
//		});
		
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
		
		
		BorderPane rollerButtonPanel = new BorderPane();
		Button rollerButton = new Button();
		rollerButton.setText("Go dice roll!");
		rollerButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	
		    	broadcaster.setText(broadcaster.getText() + "\n" + roller.playDiceGame()+ "\nWaiting...\n");
		    	
		    	
		    	
		    	
		    }
		    
		    
		});
		
		
		
		rollerButtonPanel.setCenter(rollerButton);
		
		
		scenePane.setTop(titlePane);
		scenePane.setCenter(broadcastPanel);
		scenePane.setBottom(resetPanel);
		scenePane.setRight(rollerButtonPanel);
		

		
		
		return scene;
		
	}

}
