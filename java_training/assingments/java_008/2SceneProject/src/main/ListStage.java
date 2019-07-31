package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListStage {
	
	Scene publishedScene;
	Stage stLeft;
	Stage stRight;
	ScrollPane scroller;
	ListView<String> list;
	ObservableList<String> listObserved;
	
	Button addButton;
	Button deleteButton;
	
	TextField field;
	
	HBox buttonArea;
	
	public  ListStage(String[] existingList) {
		this.list = new ListView<String>();
		this.listObserved = FXCollections.observableArrayList (existingList);
		list.setItems(this.listObserved);		
	}

	public Scene createScene(Stage primaryStage) {
		
		this.generateScene();
		
		return this.publishedScene;
	}

	private void generateScene() {
		BorderPane sceneSet = new BorderPane();
		publishedScene = new Scene(sceneSet, 600, 600);
		
		BorderPane titlePane = new BorderPane();
		
		Label title = new Label();
		title.setText("ListView Example");
		
		titlePane.setCenter(title);
		
		sceneSet.setTop(titlePane);
		
		this.scroller = new ScrollPane();
		
		scroller.setContent(list);
		sceneSet.setLeft(this.scroller);
		
		this.scroller.setPrefHeight(this.publishedScene.getHeight()-titlePane.getHeight());
		
		this.scroller.setHbarPolicy(ScrollBarPolicy.NEVER);
		this.scroller.setVbarPolicy(ScrollBarPolicy.NEVER);
		
		VBox centerCont = new VBox();
		
		centerCont.setPadding(new Insets(20));
		
		this.buttonArea = new HBox();
		this.buttonArea.setPadding(new Insets(10));
		
		this.genButtons();
		
		this.buttonArea.getChildren().addAll(this.addButton, this.deleteButton);
		
		this.field = new TextField();
		this.field.setPrefSize(publishedScene.getWidth(), 50);
		this.field.setOnKeyPressed(new EventHandler<KeyEvent>() {
			 
		    @Override
		    public void handle(KeyEvent event) {
		        if(event.getCode().equals(KeyCode.ENTER)) {
		             tryToAddText();
		        }
		    }
		});
		
		centerCont.getChildren().addAll(this.field, this.buttonArea);
		
		sceneSet.setCenter(centerCont);
		
	}

	private void genButtons() {
		this.addButton = new Button();
		this.addButton.setText("Add Astartes Chapter");
		this.addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				tryToAddText();
			}
		});
		
		this.deleteButton = new Button();
		this.deleteButton.setText("Delete Traitors");
		this.deleteButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				listObserved.remove(list.getSelectionModel().getSelectedIndex());
			}
		});
		
	}
	protected void tryToAddText() {
		if(!field.getText().equals("")) {
			listObserved.add(field.getText());
			field.setText("");
		}
	}

}
