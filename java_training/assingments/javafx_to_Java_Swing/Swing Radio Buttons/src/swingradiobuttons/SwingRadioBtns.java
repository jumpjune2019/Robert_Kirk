package swingradiobuttons;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import swingradiobuttons.RadioStuff;

public class SwingRadioBtns {
	
	public static void centerAndSizeJFrameOnScreen(JFrame frm, int width, int height) {
		// set the size of the frame to half in width and height
		frm.setSize(width, height);
		// here's the part where the JFrame gets actually centered
		frm.setLocationRelativeTo(null);
}
	
	public static JFrame setFrameStuff(JFrame frm, int onExit, int width, int height) {
		// this will center and size the JFrame on screen
		// it will have a height and width of half the screen
		centerAndSizeJFrameOnScreen(frm, width, height);
		frm.setDefaultCloseOperation(onExit);
		
		return frm;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			RadioStuff demo;
			JFrame frm;
			
			public void run() {
				demo = new RadioStuff("Swing Radio Button Demo");
				frm = demo.getFrame();
				frm = setFrameStuff(frm, JFrame.EXIT_ON_CLOSE, 400, 300);							
				frm.setVisible(true);
			}
		});

	}

}
