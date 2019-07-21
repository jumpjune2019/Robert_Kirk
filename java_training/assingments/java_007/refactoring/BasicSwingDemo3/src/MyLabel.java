import javax.swing.*;
public class MyLabel {
	private String position;

	MyLabel() {
		
	}
	
	JLabel setLabel(String l, String p, JFrame jf) {
		position = p;
		JLabel lb = new JLabel(l);
		setLabelInLayout(jf, lb);
		return lb;
	}
	
	void setLabelInLayout(JFrame jF, JLabel jl) {
		jF.add(jl, position);
	}
}
