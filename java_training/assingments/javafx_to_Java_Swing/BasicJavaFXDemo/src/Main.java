/*
 Link to SDKs https://gluonhq.com/products/javafx/
 Download Java FX (SDK) version 11.0.2 (public version)
 Unzip the SDK somewhere you can refer to (notice it will have a javafx-sdk-11.0.2\lib folder
 There are several versions depending on OS. (do not download jmods)
 For those curious about jmods file format: https://stackoverflow.com/questions/44732915/why-did-java-9-introduce-the-jmod-file-format

When ready to use it in any given project
	1) Create a Java Project (STS)
	2) Right-click on project (access Properties)
	3) Locate Java Build Path
	4) Click the Libraries tab, Select the Classpath folder
	5) Click Add external JARs
	6) Locate the javafx-sdk-11.0.2\lib folder
	7) add all JARs from the lib folder
	8) Apply and Close
*/

// Run Configurations - Arguments - VM Options
// For STS in Windows
// --module-path "C:\Program Files\Java\javafx-sdk-11.0.2\lib" --add-modules=javafx.controls

// A JavaFX application skeleton

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.StackPane;
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
    	primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
    
    public void stop() {
    	System.out.println("stop() method called last when app is closed.");
    }

}