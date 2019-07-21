// A simple Swing Program
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;
public class Main {
	public static void centerAndSizeJFrameOnScreen(JFrame frm, int width, int height) {
		// set the size of the frame to half in width and height
		frm.setSize(width/2, height/2);
		// here's the part where the JFrame gets actually centered
		frm.setLocationRelativeTo(null);
	}
	// this is how we can create a pseudo-dynamic array
	// at run time based on enums
	public static void setLabelsToFrame(JFrame frm) {
		int labelsEnumLength = LabelsEnum.values().length;
		int count = 0;
		JLabel myLabels[] = new JLabel[labelsEnumLength];
		MyLabel tempLabel;
		for(LabelsEnum le : LabelsEnum.values()) {
			tempLabel = new MyLabel();
			myLabels[count] = tempLabel.labelAdding.addLabel(le.returnLabel.stringTransfer(), le.returnPosition.stringTransfer(), frm);
			count++;
		}
	}
	
	public static JFrame setFrameStuff(JFrame frm, int onExit, int width, int height) {
		// this will center and size the JFrame on screen
		// it will have a height and width of half the screen
		centerAndSizeJFrameOnScreen(frm, 400, 400);
		frm.setDefaultCloseOperation(onExit);
		setLabelsToFrame(frm);
		return frm;
	}
	
	public static void main(String args[]) {

		SwingUtilities.invokeLater(new Runnable() {
			SwingDemo demo;
			JFrame frm;
			
			public void run() {
				demo = new SwingDemo("Centered JFrame 400 by 200 with 5 labels");
				frm = demo.distributing.getJFrame();
				frm = setFrameStuff(frm, JFrame.EXIT_ON_CLOSE, 400, 200);
				frm.setVisible(true);
			}
		});
	}
}