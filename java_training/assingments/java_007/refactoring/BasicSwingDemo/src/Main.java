// A simple Swing Program
import javax.swing.SwingUtilities;
import javax.swing.*;
public class Main {

	public static JFrame setFrameStuff(JFrame frm, int width, int height, int onExit, String label) {
		// Give the frame an initial size.		
		frm.setSize(width, height);
		// Terminate the program when the user closes the application.
		// Swing has events and as such there are other ways to deal with this
		// Some parameters for setDefaultCloseOperation (all integers)
		// JFrame.EXIT_ON_CLOSE <-- current one being passed
		// JFrame.HIDE_ON_CLOSE
		// JFrame.DO_NOTHING_ON_CLOSE
		frm.setDefaultCloseOperation(onExit);
		// Create a text-based label.
		JLabel lab = new JLabel(label);
		// Add the label to the content pane.
		frm.add(lab);
		return frm;
	}
	
	public static void main(String args[]) {
	
		/*
		- Create the frame on the event dispatching thread.
		- Swing uses concurrency behind the scene.
		- Without the ability to thread Swing and Java could not 
		  create usable applications which uses GUI resources.
		- This is a standard way of ensuring our app works.
		- The “invokeLater” method will ensure the thread is 
		  scheduled at some point in Java’s scheduler.
		- The class Main and its public static void main are 
		  also thread, but a public static void main is an 
		  implicit call the GUI is meant to work another thread(s).
		- The “invokeLater” method ensure this thread is managed 
		  in a way that behind the scene the Java developer is 
		  not burdened with dealing in GUI related operations at
		  the OS level as opposed to using a command prompt 
		  output which is sequential in nature.
		- GUIs are meant to respond to events and as such asynchronous.
		*/
		
		SwingUtilities.invokeLater(new Runnable() {
			SwingDemo demo;
			JFrame frm;
			public void run() {
				demo = new SwingDemo("Demo 1");
				frm = demo.distributing.getJFrame();
				frm = setFrameStuff(frm, 375, 100, JFrame.EXIT_ON_CLOSE, "My label");
				frm.setVisible(true);
			}
		});
	}
}