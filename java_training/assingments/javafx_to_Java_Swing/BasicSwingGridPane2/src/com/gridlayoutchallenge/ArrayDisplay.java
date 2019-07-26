package com.gridlayoutchallenge;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class ArrayDisplay extends JFrame implements ActionListener {

	 JPanel displayArea;
	 
	 JPanel titleArea;

	 JLabel title;
	 
	 JPanel broadcastingArea;
	
	 JLabel broadcaster;
	
	 final String newline = System.getProperty("line.separator");

	// public DiceRoller diceRoller = new DiceRoller();
	public ArrayDisplay(String title) {
		// Create a new JFrame container.
		super(title);

	}

//	public JFrame getFrame() {
//		return jfrm;
//	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		broadcaster.setText(s);
		
	}

	public void addComponentsToPane() {

		int rows = 2;
		int cols = 6;

		displayArea = new JPanel();
		//displayArea.setLayout();
		displayArea.setLayout(new GridLayout(rows,cols));
		this.addContent(rows, cols);
		
		
		title = new JLabel("Basic Matrix Demo");
		
		titleArea = new JPanel();
		
		titleArea.add(title, BorderLayout.CENTER);
		titleArea.setPreferredSize(new Dimension(rows*50,40));
		//titleArea.setLayout(BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane(displayArea);
		
		broadcaster = new JLabel("No seat selected");
		
		broadcastingArea = new JPanel();
		broadcastingArea.add(broadcaster, BorderLayout.CENTER);
		broadcastingArea.setPreferredSize(new Dimension(rows*50,40));
		
		getContentPane().add(titleArea, BorderLayout.NORTH);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(broadcastingArea, BorderLayout.SOUTH);
		// getContentPane().add(grid, BorderLayout.CENTER);
		
	}

	private JPanel constructCell(int rowNum, int col) {
		String labelText = (char)(65+rowNum) + "-" + (col+1);
		JPanel pan = new JPanel();
		
		JPanel labelContainer = new JPanel();
		JPanel buttonContainer = new JPanel();
		
		JLabel label = new JLabel(labelText);
		labelContainer.add(label, BorderLayout.CENTER);
		
		JButton button = this.cellButton(labelText);
		buttonContainer.add(button, BorderLayout.CENTER);
		
		pan.setPreferredSize(new Dimension(100,100));
		
		
		pan.add(labelContainer);
		pan.add(buttonContainer, BorderLayout.CENTER);
		pan.setLayout(new BoxLayout(pan, 1));
		return pan;
	}

	public void displayInfo(String message) {

		//displayArea.append(message + "\n");

		//displayArea.setCaretPosition(displayArea.getDocument().getLength());
	}

	private void addContent(int rows, int cols) {
		for(int i = 0; i<rows; i++) {
			//Title JPanel
			for(int j = 0; j<cols; j++) {
				JPanel cell = constructCell(i, j);
				String labelText = (char)(65+i) + "-" + j+1;
				displayArea.add(labelText, cell);
			}
		}
	}
	public JButton cellButton(String label) {
		JButton jbtn = new JButton(label);
		// Add action listeners.
		jbtn.addActionListener(this);
		// Add the buttons to the content pane.
		return jbtn;
	}

}
