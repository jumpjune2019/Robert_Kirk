package main;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		TreeView list = new TreeView("Name List");

		list.setPreferredSize(new Dimension(500,500));
		list.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		list.addComponentsToPane();
		list.pack();
		list.setVisible(true);

	}

}
