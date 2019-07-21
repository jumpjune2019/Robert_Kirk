import javax.swing.*;
public class MyLabel {
	private String position;

	MyLabel() {
		
	}
	
	JLableAdder labelAdding = (String l, String p, JFrame jf)->{
		position = p;
		JLabel lb = new JLabel(l);
		setLabelInLayout(jf, lb);
		return lb;
	};
	
//	JLabel setLabel(String l, String p, JFrame jf) {
//		position = p;
//		JLabel lb = new JLabel(l);
//		setLabelInLayout(jf, lb);
//		return lb;
//	}
	
	void setLabelInLayout(JFrame jF, JLabel jl) {
		jl.setHorizontalAlignment(JLabel.CENTER);
		jl.setVerticalAlignment(JLabel.CENTER);
		jF.add(jl, position);
	}
}
