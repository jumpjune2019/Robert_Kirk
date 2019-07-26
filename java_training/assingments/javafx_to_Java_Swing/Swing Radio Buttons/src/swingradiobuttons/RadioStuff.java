package swingradiobuttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class RadioStuff  {
	
	private static final JRadioButton Train = null;
	private static final JRadioButton Car = null;
	private static final JRadioButton Plane = null;
	private static final JRadioButton Boat = null;
	private JFrame jfrm;

	 RadioStuff(String title) {
		// Create a new JFrame container.
		jfrm = new JFrame(title);
		jfrm.setLayout(new BoxLayout(jfrm.getContentPane(), BoxLayout.Y_AXIS));
		
		// Setting panels for buttons and labels
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		//JPanel panel3 = new JPanel();
		//JPanel panel4 = new JPanel();
		//JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		
		jfrm.add(panel1);
		jfrm.add(panel2);
		jfrm.add(panel6);
		
		// add labels and radio buttons to each panel
		JLabel topLbl = new JLabel("Radio Buttons",  SwingConstants.CENTER);
		JLabel botLbl = new JLabel(" ",  SwingConstants.CENTER);
		
		panel1.add(topLbl);
		panel6.add(botLbl);
		
		// Create button group and add buttons to group
		ButtonGroup group = new ButtonGroup();
		
		// add radio buttons to each panel 2-5
		JRadioButton train = new JRadioButton("Train"); // panel 2
		JRadioButton car = new JRadioButton("Car"); // panel 3
		JRadioButton plane = new JRadioButton("Plane"); // panel 4
		JRadioButton boat = new JRadioButton("Boat"); // panel 5
		

		group.add(train);
		group.add(car);
		group.add(plane);
		group.add(boat);
		
		// add group to panel
		panel2.add(train);
		panel2.add(car);
		panel2.add(plane);
		panel2.add(boat);
		
		// Action listeners
		train.addActionListener(new ActionListener(){			
			public void actionPerformed(ActionEvent e){	
				botLbl.setText("Train");
			}
		});
		
		car.addActionListener(new ActionListener(){			
			public void actionPerformed(ActionEvent e){	
				botLbl.setText("Car");
			}
		});
		
		plane.addActionListener(new ActionListener(){			
			public void actionPerformed(ActionEvent e){	
				botLbl.setText("Plane");
			}
		});
		
		boat.addActionListener(new ActionListener(){			
			public void actionPerformed(ActionEvent e){	
				botLbl.setText("Boat");
			}
		});
		
//	    public void actionPerformed(ActionEvent event) {
//	        JRadioButton button = (JRadioButton) event.getSource();
//	        
//	      
//			// option Train is selected
//	        if (button == Train) {
//	        	botLbl.setText("Train");
//	        	 
//	            // option Car is selected	 
//	        } else if (button == Car) {
//	        	botLbl.setText("Car");
//	 
//	            // option Plane is selected	 
//	        } else if (button == Plane) {
//	        	botLbl.setText("Plane");
//	 
//	            // option Boat is selected
//	        }else if (button == Boat) {
//	        	botLbl.setText("Boat");
//	    }	
						
	}
	 
	 
	 
	public JFrame getFrame() {
		return jfrm;
	}

}
