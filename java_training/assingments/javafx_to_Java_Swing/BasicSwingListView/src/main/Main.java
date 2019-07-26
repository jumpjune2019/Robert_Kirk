package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		ViewableList list = new ViewableList("Name List");
		list.createJList();
		list.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		list.addComponentsToPane();
		list.pack();
		list.setVisible(true);

	}

}
