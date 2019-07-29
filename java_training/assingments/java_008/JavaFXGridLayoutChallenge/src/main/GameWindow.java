package main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.javafx.geom.Dimension2D;
import com.sun.javafx.tk.Toolkit;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameWindow {

	protected double count = 0.0;
	BorderPane broadcastPanel;
	Label broadcaster;

	public Scene createScene(Stage primaryStage) throws Exception {

		BorderPane scenePane = new BorderPane();

		Scene scene = new Scene(scenePane, 500, 500);

		short cols = (short) ((Math.random() * 4) + 2);
		short rows = (short) ((Math.random() * 4) + 2);

		Label title = new Label();
		title.setWrapText(true);
		title.setText("TITLE");

		BorderPane titlePane = new BorderPane();
		titlePane.setCenter(title);
		titlePane.setPrefWidth(scenePane.getWidth());

		GridPane broadcastController = new GridPane();

		broadcastController.setHgap(2);
		broadcastController.setVgap(2);
		broadcastController.setPrefWidth(scenePane.getWidth());
		broadcastController.setPadding(new Insets(0, 10, 0, 10));

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.println(i+", "+j);
				String labelText = (char) (65 + i) + "-" + (j + 1);
				VBox vbo = new VBox();//this.cellPane(i, j);
				Label label = new Label(labelText);
				label.setText(labelText);
				BorderPane labelCon = new BorderPane();
				labelCon.setCenter(label);
				Button btn = cellButton(labelText);
				vbo.getChildren().addAll(label, btn);
				vbo.setPrefSize(50, 50);
				broadcastController.add(vbo, j+1, i);

			}
		}
		broadcastPanel = new BorderPane();
		this.broadcaster = new Label();
		broadcaster.setWrapText(true);

		BorderPane controllerPaneContainer = new BorderPane();
		controllerPaneContainer.setCenter(broadcastController);

		broadcaster.setText("No button selected");
		broadcastPanel.setCenter(broadcaster);

		scenePane.setTop(titlePane);
		scenePane.setCenter(controllerPaneContainer);
		scenePane.setBottom(broadcastPanel);

		return scene;

	}

	public Button cellButton(String label) {
		Button jbtn = new Button(label);
		jbtn.setText(label);
		// Add action listeners.
		jbtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Button source = (Button) e.getSource();
				broadcaster.setText(source.getText());
			}
		});

		return jbtn;
	}

}
