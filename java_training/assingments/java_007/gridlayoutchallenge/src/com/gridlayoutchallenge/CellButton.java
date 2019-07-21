package com.gridlayoutchallenge;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.*;

public class CellButton  implements ActionListener {
	JLabel jlab;
	String label;
	String message;
	
	public CellButton(JPanel pan, String label) {
		this.label = label;
		this.message = label;
		
		JButton jbtnUp = new JButton(label);
		// Add action listeners.
		jbtnUp.addActionListener(this);
		// Add the buttons to the content pane.
		pan.add(jbtnUp);
	}

	public void actionPerformed(ActionEvent ae) {
			jlab.setText(message);
	}
}
