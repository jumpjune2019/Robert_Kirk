package swingcombobox;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ComboStuff extends JFrame  {
	
	private JFrame jfrm;
	
	ComboStuff(String title) {
		// Create a new JFrame container.
		jfrm = new JFrame(title);
		
		Container con = getContentPane();
		jfrm.add(con);
		
		// labels
		
		JLabel topLbl = new JLabel("Select Transport Type",  SwingConstants.CENTER);	
		JLabel bottomLbl = new JLabel(" ", SwingConstants.CENTER);
		
		con.add(topLbl,BorderLayout.NORTH);
		con.add(bottomLbl, BorderLayout.SOUTH);	
		
		// add combobox
		
		String[]  transStrings = { "Car", "Train", "Airplane" };

		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		JComboBox transports = new JComboBox(transStrings);
		//transports.setSelectedIndex(3);
		transports.setSelectedIndex(2);
		
		transports.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e){	
				bottomLbl.setText("Selected: " + transports.getSelectedItem());
				//Object contents = transports.getName();
				//bottomLbl.setText((String) contents);
		     }
	    });

	   

		con.add(transports, BorderLayout.CENTER);
		
		
		
		
	}
	public JFrame getFrame() {
		return jfrm;
	}

}
