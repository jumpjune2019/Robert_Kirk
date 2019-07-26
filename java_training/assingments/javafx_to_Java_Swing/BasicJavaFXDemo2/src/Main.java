// A JavaFX application with a label

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
 
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    public void init() {
    	System.out.println("init() method called first.");
    }
    
    public void start(Stage primaryStage) {
    	System.out.println("start() method called second.");
    	primaryStage.setTitle("2 Buttons and a Label");
    	Label myLabel = new Label("");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        Button btn2 = new Button();
        btn2.setText("Reset");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	myLabel.setText("hello world!");            	
            }
        });

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	myLabel.setText("");
            }
        });
        
        VBox vbox = new VBox(btn, myLabel, btn2);
        Scene scene = new Scene(vbox, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void stop() {
    	System.out.println("stop() method called last when app is closed.");
    }

}