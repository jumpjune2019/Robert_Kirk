// A simple Swing Program
import javax.swing.SwingUtilities;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;
public class Main {

	public static void centerAndSizeJFrameOnScreen(JFrame frm) {
	    /*
			Dimension class is a part of Java AWT. 
	    	It contains the height and width of a 
	    	component in integer as well as double precision. 
	    	The use of Dimension class is that many functions of 
			Java AWT and Swing return dimension object.
	    */
		// get the size of the screen
		// Toolkit class is the abstract superclass of every implementation 
		// in the Abstract Window Toolkit (AWT). 
		// Subclasses of Toolkit are used to bind various components.
		// getDefaultToolkit() returns an instance
		// getScreenSize() is one of the many methods available
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		// set the size of the frame to half in width and height
		frm.setSize(width/2, height/2);
		// here's the part where the JFrame gets actually centered
		frm.setLocationRelativeTo(null);
	}
	
	public static JFrame setFrameStuff(JFrame frm, int onExit, String label) {
		// this will center and size the JFrame on screen
		// it will have a height and width of half the screen
		centerAndSizeJFrameOnScreen(frm);
		frm.setDefaultCloseOperation(onExit);
		JLabel lab = new JLabel(label);
		frm.add(lab);
		return frm;
	}
	
	public static void main(String args[]) {
		
		SwingUtilities.invokeLater(new Runnable() {
			SwingDemo demo;
			JFrame frm;
			public void run() {
				demo = new SwingDemo("Centered JFrame");
				frm = demo.getFrame();
				frm = setFrameStuff(frm, JFrame.EXIT_ON_CLOSE, "My label in a centered JFrame");
				frm.setVisible(true);
			}
		});
	}
}