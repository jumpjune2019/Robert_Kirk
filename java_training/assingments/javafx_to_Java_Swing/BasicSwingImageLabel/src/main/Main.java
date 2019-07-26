package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		LabelImage list = new LabelImage("Name List");

		list.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		list.addComponentsToPane();
		list.pack();
		list.setVisible(true);

	}

}
