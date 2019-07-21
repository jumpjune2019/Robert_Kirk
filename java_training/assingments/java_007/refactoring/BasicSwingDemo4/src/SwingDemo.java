// A simple Swing Class
import javax.swing.*;

class SwingDemo {
	private JFrame jfrm;
	SwingDemo(String title) {
		// Create a new JFrame container.
		jfrm = new JFrame(title);
	}
	public JFrame getFrame() {
		return jfrm;
	}
}