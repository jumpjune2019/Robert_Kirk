import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Cell {
	
	Button btn;
	Label lab;
	
	Cell(String b, String l, Font fb, Font fl) {
        btn = new Button(b);
        lab = new Label(l);
        btn.setFont(fb);
        lab.setFont(fl);
		btn.setMaxWidth(Double.MAX_VALUE);
		lab.setMaxWidth(Double.MAX_VALUE);
		btn.setAlignment(Pos.CENTER);
		lab.setAlignment(Pos.CENTER);
        
	}
	
	VBox getCell() {
		VBox v = new VBox(btn, lab);
		v.setAlignment(Pos.CENTER);
		v.setSpacing(4);
		return v;
	}
	
}
