import javafx.scene.control.*;
import javafx.event.*;

public class MyButton extends Button {
	private Button myButton;
	
	MyButton(String l, String id, EventHandler ev) {
		myButton = new Button(l);
		myButton.setId(id);
		myButton.setOnAction(ev);
	}
	
	Button getButton() {
		return myButton;
	}
}
