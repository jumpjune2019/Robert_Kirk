package swingscrollpanedemo;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class ScrollStuff {
	
	private JFrame jfrm;
	
	ScrollStuff(String title) {
		// Create a new JFrame container.
		jfrm = new JFrame(title);
		jfrm.setLayout(new BoxLayout(jfrm.getContentPane(), BoxLayout.Y_AXIS));
		
		// Setting panels for buttons and labels
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		panel2.setSize(new Dimension(250, 250));
		JPanel panel3 = new JPanel();
		
		// add panels
		jfrm.add(panel1);
		jfrm.add(panel2);
		jfrm.add(panel3);
		
		// Top label		
		JLabel topLbl = new JLabel("Scroll Pane Demo",  SwingConstants.CENTER);
		panel1.add(topLbl);
		
		// add text area
		JTextArea textArea = new JTextArea (10, 30);
		textArea.append("A ScrollPane streamlines the process \n" + 
				" of adding darn scroll bars to a window whose contents \n" + 
				" exceed the viewing area dimension of the window \n " + 
				" It also enables a control to fit in \n " + 
				" Such as this label control in JavaFX \n " + 
				" Without it, we could not really view well the content \n " + 
				" of a control if it overflowed, so using scrollbars helps lots! \n"+
				"A ScrollPane streamlines the process \n" + 
				" of adding darn scroll bars to a window whose contents \n" + 
				" exceed the viewing area dimension of the window \n " + 
				" It also enables a control to fit in \n " + 
				" Such as this label control in JavaFX \n " + 
				" Without it, we could not really view well the content \n " + 
				" of a control if it overflowed, so using scrollbars helps lots! \n");
		// Add scroll pane
		JScrollPane scrollP = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//scrollP.setSize (300,600) ;
		panel2.add(scrollP);
		
		
		// add bottom button
		JButton resetBtn = new JButton("Reset Scroll Pane to Top/Left");
		panel3.add(resetBtn);
		resetBtn.addActionListener(new ActionListener(){			
			public void actionPerformed(ActionEvent e){	
				scrollP.getViewport().setViewPosition(new java.awt.Point(0, 0));
				
			}
		});		
		
	}
	
	public JFrame getFrame() {
		return jfrm;
	}

}
