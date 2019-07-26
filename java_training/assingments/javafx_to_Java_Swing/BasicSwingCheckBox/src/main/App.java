package main;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class App extends JFrame implements ItemListener {
	JLabel jlabSelected;
	JLabel jlabChanged;
	JCheckBox jcbAlpha;
	JCheckBox jcbBeta;
	JCheckBox jcbGamma;
	//JPanel boxHolder;

	App() {
		// Create a new JFrame container.
		JFrame jfrm = new JFrame("Demonstrate Check Boxes");
		// Specify FlowLayout for the layout manager.
		jfrm.setLayout(new FlowLayout());
		// Give the frame an initial size.
		jfrm.setSize(400, 400);
		// Terminate the program when the user closes the application.
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Create empty labels.
		jlabSelected = new JLabel("");
		jlabChanged = new JLabel("");
		// Make check boxes.
		jcbAlpha = new JCheckBox("Alpha");
		jcbBeta = new JCheckBox("Beta");
		jcbGamma = new JCheckBox("Gamma");

		jcbAlpha.addItemListener(this);
		jcbBeta.addItemListener(this);
		jcbGamma.addItemListener(this);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, 1));
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, 1));
		
		panel.add(jcbAlpha);
		panel.add(jcbBeta);
		panel.add(jcbGamma);
		
		
		jfrm.add(panel);
		panel2.add(jlabChanged);
		panel2.add(jlabSelected);
		jfrm.add(panel2);
		
		
		jfrm.setVisible(true);
	}
	
	public void itemStateChanged(ItemEvent ie) {
		String str = "";
		
		JCheckBox cb = (JCheckBox) ie.getItem();

		if(cb.isSelected()) {
			jlabChanged.setText(cb.getText() + " was just selected.");
		} else {
			jlabChanged.setText(cb.getText() + " was just cleared.");
		}
		
		if(jcbAlpha.isSelected()) {
			str += "Alpha ";
		}
		if(jcbBeta.isSelected()) {
			str += "Beta ";
		}
		if(jcbGamma.isSelected()) {
			str += "Gamma";
		}
		jlabSelected.setText("Selected check boxes: " + str);
	}

}
